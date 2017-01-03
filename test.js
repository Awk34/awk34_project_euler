import { Converter, extension } from 'showdown';
// import showdownMath from './showdown-math';
const mjAPI = require('mathjax-node/lib/mj-single');
mjAPI.config({
  MathJax: { /* traditional MathJax configuration */ }
});
mjAPI.start();

function mjConvert(math) {
    return new Promise((resolve, reject) => {
        mjAPI.typeset({
            math: math,
            format: "TeX", // "inline-TeX", "MathML"
            svg: true, 
        }, data => {
            if(data.errors) {
                return reject(data.errors);
            }

            resolve(data.svg);
        });
    });
}

// mjConvert('E = mc^2')
//     .then(console.log)
//     .catch(console.log);

function asyncTag(strings, ...keys) {
    var result = [strings[0]];

    keys.forEach((key, i) => {
        result.push(value, strings[i + 1]);
    });

    return Promise.all(result).then(resolved => resolved.join(''));
}

const converter = new Converter({ extensions: [] });

function mathjaxInline(array) {
    // TODO: improve syntax checking
    if(array.length % 2 !== 1) throw new Error('MathJax delimiter mismatch');

    let result = [];

    array.forEach((item, i) => {
        if(i % 2 === 0) {
            result.push(item);
        } else {
            result.push(mjConvert(item));
        }
    });

    return Promise.all(result).then(compiled => compiled.join(''));
}

function mathjaxMultiline(array) {
    // TODO: improve syntax checking
    if(array.length % 2 !== 1) throw new Error('MathJax delimiter mismatch');

    let result = [];

    array.forEach((item, i) => {
        if(i % 2 === 0) {
            result.push(item);
        } else {
            result.push(mjConvert(item).then(converted => `<pre>${converted}</pre>`));
        }
    });

    return Promise.all(result).then(compiled => compiled.join(''));
}

let text = converter.makeHtml(`# Title

This is a \`math\` formula: $$\\pi$$ $$$1234$$$

\`\`\`
asdf
\`\`\`

`);

mathjaxMultiline(text.split(/\$\$\$/))
    .then(text => mathjaxInline(text.split(/\$\$/)))
    .then(console.log);
