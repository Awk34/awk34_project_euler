import { Converter, extension } from 'showdown';

const mjAPI = require('mathjax-node/lib/mj-single');
mjAPI.config({
  MathJax: { /* traditional MathJax configuration */ }
});
mjAPI.start();

const converter = new Converter({
    disableForced4SpacesIndentedSublists: true,
    extensions: [],
});
converter.setFlavor('github');

/**
 * Convert a LaTeX string to SVG
 *
 * mjConvert('E = mc^2')
 *     .then(console.log);
 *
 * @param {string} math
 * @returns {Promise}
 */
export function mjConvert(math) {
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

/**
 * Template string tag function that can resolve keys that return promises
 * @returns {Promise}
 */
export function asyncTag(strings, ...keys) {
    var result = [strings[0]];

    keys.forEach((key, i) => {
        result.push(value, strings[i + 1]);
    });

    return Promise.all(result).then(resolved => resolved.join(''));
}

/**
 * finds '$LaTeX$' or '$$LaTeX$$' format directives, and uses mathjax to convert to SVG
 * @param {string} text - text to look for
 */
export function inlineMathToSVG(text) {
    let array = text.replace(/\$\$/g, '$').split(/\$/);

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

/**
 * finds '$$$LaTeX$$$' format directives, and uses mathjax to convert to SVG (ensures on newline)
 * @param {string} text - text to look for
 */
export function multilineMathToSVG(text) {
    let array = text.split(/\$\$\$/);

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

// TODO: add something like this to a unit test
// let text = converter.makeHtml(`# Title

// This is a \`math\` formula: $$\\pi$$ $$$1234$$$

// \`\`\`
// asdf
// \`\`\`

// `);

/**
 * Converts markdown text to HTML, with math converted to SVG
 * @param {string} text
 * @returns {Promise}
 */
export function markdownToHtml(text) {
    return multilineMathToSVG(converter.makeHtml(text))
        .then(inlineMathToSVG);
}
