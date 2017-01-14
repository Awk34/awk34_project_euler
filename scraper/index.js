const fs = require('fs');
const https = require('https');
const cheerio = require('cheerio');
const marky = require('marky');

function get(path) {
    return new Promise((resolve, reject) => {
        https.get(path, res => {
            res.setEncoding('utf8');
            let rawData = '';
            res.on('data', chunk => rawData += chunk);
            res.on('end', () => {
                resolve(rawData);
            });
        }).on('error', reject);
    });
}

/**
 *
 * @param {number} n
 * @returns {Promise}
 */
function getProblem(n) {
    const getMarker = `get ${n}`;
    const parseMarker = `parse ${n}`;
    marky.mark(getMarker);
    return get(`https://projecteuler.net/problem=${n}`).then(data => {
        let getTime = parseInt(marky.stop(getMarker).duration);
        console.log(`${n} | GET | ${getTime}ms`);

        marky.mark(parseMarker);

        let $ = cheerio.load(data);

        let title = $('h2', '#content').html();

        let content = $('.problem_content');

        let paragraphs = Array.from($('p', content))
            .map(paragraph => {
                return $(paragraph).html()
                    .replace(' (right click and &apos;Save Link/Target As...&apos;)', '')
                    .replace('&#xD7;', 'x');
            });
        // console.log(paragraphs);
        // TODO: prob 32, note div
        // TODO: convert <ol> & <ul>
        // TODO: convert notes

        // {
        //     let _paragraphs = paragraphs;
        //     for(let i = 0; i < _paragraphs.length; i++) {
        //         _paragraphs.push(_paragraphs[i].html() + '\n\n');
        //     }
        //     paragraphs = _paragraphs;
        // }
        // console.log(paragraphs);

        // content = content.html();

        let links = $('a', '.problem_content');
        let files = [];

        for(let i = 0; i < links.length; i++) {
            if(!links[i].attribs || !links[i].attribs.href) continue;
            files.push(links[i].attribs.href)
        }

        let parseTime = parseInt(marky.stop(parseMarker).duration);
        console.log(`${n} | Parse | ${parseTime}ms`);

        return {
            title,
            paragraphs,
            files,
        };
    });
}

function mkdir(path) {
    return new Promise((resolve, reject) => {
        fs.mkdir(path, err => {
            if(err && err.code !== 'EEXIST') return reject(err);

            resolve();
        });
    });
}

function writeFile(path, data) {
    return new Promise((resolve, reject) => {
        fs.writeFile(path, data, 'utf8', err => {
            if(err) return reject(err);

            resolve();
        })
    });
}

async function scrapeProblem(n) {
    await mkdir(`scraped/${n}`);

    // console.log('mkdir');

    let {title, paragraphs, files} = await getProblem(n);

    // console.log('getproblem');

    let text = `##${title}

${paragraphs.join('\n\n')}
`;

    let promises = [writeFile(`scraped/${n}/${n}.md`, text)];

    files.forEach(file => {
        promises.push(get(`https://projecteuler.net/${file}`)
            .then(text => writeFile(`scraped/${n}/${file.split('/').pop()}`, text)));
    });

    return await promises;
}

mkdir('scraped').then(() => {
    return Promise.all([scrapeProblem(32), scrapeProblem(99)]);
    // return Promise.all(new Array(50).fill(0).map((val, i) => scrapeProblem(i + 1)));
}).then(() => {
    console.log('Finished Scraping');
});
