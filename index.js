'use strict';
require('babel-register');

global.logLevel = 'info';

// var sieve = require('./js/util/sieve_of_atkin').default;
// console.log(sieve(100));

var Euler144 = require('./js/144').default;
var euler144 = new Euler144();
euler144.run();
