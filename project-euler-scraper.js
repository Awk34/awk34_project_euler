const fs = require('fs');
const https = require('https');
const cheerio = require('cheerio');

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

function getProblem(n) {
    return get(`https://projecteuler.net/problem=${n}`).then(data => {
        let $ = cheerio.load(data);
 
        let title = $('#content h2').html();

        let content = $('.problem_content');

        let paragraphs = $('p', content);
        console.log(paragraphs)

        {
            let _paragraphs = paragraphs;
            for(let i = 0; i < _paragraphs.length; i++) {
                _paragraphs.push(_paragraphs[i].html() + '\n\n');
            }
            paragraphs = _paragraphs;
        }

        content = content.html();

        let links = $('a', '.problem_content');
        let files = [];
        
        for(let i = 0; i < links.length; i++) {
            if(!links[i].attribs || !links[i].attribs.href) continue;
            files.push(links[i].attribs.href)
        }

        let text = `##${title}
${content}`;

        console.log(text)

        return {
            title: title,
            content: content,
            files
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

    let {title, content, files} = await getProblem(n);

    let promises = [writeFile(`scraped/${n}/${n}.html`, content)];

    files.forEach(file => {
        promises.push(get(`https://projecteuler.net/${file}`)
            .then(text => writeFile(`scraped/${n}/${file.split('/').pop()}`, text)));
    })

    return await promises;
}

mkdir('scraped').then(() => {
    return scrapeProblem(98);
});
