'use strict';

require('babel-register');

var Euler = require('./js/Euler').default;
var e = new Euler();

var sieve = require('./js/util/sieve_of_atkin').default;
console.log(sieve(100));

// var Euler144 = require('./js/144').default;
// var euler144 = new Euler144();
// console.log(euler144.run());
