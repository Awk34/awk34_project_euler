'use strict';
require('babel-register');

// const fs = require('fs');
// const markdownToHtml = require('./js/util/markdownTools').markdownToHtml;

// fs.readFile('./problems/98.md', 'utf8', (err, data) => {
//     markdownToHtml(data).then(console.log);
// });
// return;

global.logLevel = 'info';

// var sieve = require('./js/util/sieve_of_atkin').default;
// console.log(sieve(100));

if(process.argv.indexOf('--verbose') >= 0) global.logLevel = 'verbose';

let problem = parseInt(process.argv[2]) || 1;

if(problem === 83) {
    // require('./data/test');
    const fs = require('fs');
    const path = require('path');
    var Euler83 = require(`./js/83`).default;
    var instance = new Euler83(Euler83.parseMatrix(fs.readFileSync(path.join(__dirname, 'data/matrix5x5.txt'))));
    // var instance = new Euler83(Euler83.parseMatrix(fs.readFileSync(path.join(__dirname, 'data/matrix.txt'))));
    instance.run();
} else {
    var Constructor = require(`./js/${problem}`).default;
    var instance = new Constructor();
    instance.run();
}
