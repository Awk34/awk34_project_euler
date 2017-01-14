// import microtime from 'microtime';
const marky = require('marky/lib/marky.browser.es');
const moment = require('moment');
const t = require('exectimer');
// const Tick = t.Tick;

// { error: 0, warn: 1, info: 2, verbose: 3, debug: 4, silly: 5 }
global.logLevel = global.logLevel || 'info';

var performance = global.performance || {};
var performanceNow =
    performance.now        ||
    performance.mozNow     ||
    performance.msNow      ||
    performance.oNow       ||
    performance.webkitNow  ||
    function(){ return (new Date()).getTime() };

window.process = global.process = {
    hrtime(previousTimestamp) {
        var clocktime = performanceNow.call(performance)*1e-3;
        var seconds = Math.floor(clocktime);
        var nanoseconds = Math.floor((clocktime%1)*1e9);

        if (previousTimestamp) {
            seconds = seconds - previousTimestamp[0];
            nanoseconds = nanoseconds - previousTimestamp[1];
            if (nanoseconds<0) {
                seconds--;
                nanoseconds += 1e9;
            }
        }

        return [seconds,nanoseconds]
    }
};
// TODO: write own polymorphic exectimer

export default class Euler {
    constructor() {
        this.duration = null;
        this.key = `${Math.random()}`;
        this.solution = undefined;

        const name = this.constructor.name;

        // let isNode;
        // try {
        //     isNode = !!process.release;
        // } catch(e) {
        //     isNode = false;
        // }
        //
        // console.log('isNode', isNode);
        //
        // if(isNode) {
        //     try {
        //         const chalk = require('chalk');
        //         const winston = require('winston');
        //         const Logger = winston.Logger;
        //         const Console = winston.transports.Console;
        //
        //         this.logger = new Logger({
        //             transports: [
        //                 new Console({
        //                     level: global.logLevel,
        //                     /**
        //                      * @returns {String}
        //                      */
        //                     timestamp() {
        //                         return moment(Date.now()).format('MM.DD.YY H:mm:ss');
        //                     },
        //                     /**
        //                      * @param {Object} opts
        //                      * @param {Function} opts.timestamp
        //                      * @param {String} opts.level
        //                      * @param {String} [opts.message]
        //                      * @param {*} [opts.meta]
        //                      */
        //                     formatter(opts) {
        //                         // Return string will be passed to logger.
        //                         const time = chalk.blue(opts.timestamp());
        //                         const level = opts.level.toUpperCase();
        //                         const coloredLevel =
        //                             level === 'WARN' ? chalk.yellow('WARN') :
        //                                 level === 'ERROR' ? chalk.red('ERROR') :
        //                                     level;
        //                         const message = opts.message !== undefined ? opts.message : '';
        //                         const meta = opts.meta && Object.keys(opts.meta).length ? `\n\t${JSON.stringify(opts.meta)}` : '';
        //                         return `[${chalk.green(name)}][${time}][${coloredLevel}] ${message}${meta}`;
        //                     }
        //                 })
        //             ]
        //         });
        //     } catch(e) {
        //         this.logger = console;
        //         this.logger.verbose = console.log;
        //     }
        // } else {
            this.logger = console;
            this.logger.verbose = console.log;
        // }
    }

    start() {
        marky.mark(this.key);
        // this.startTime = microtime.now();
    }

    *step() {
        throw new Error('You need to override this, doofus');
    }

    end() {
        // this.endTime = microtime.now();
        // this.duration = this.endTime - this.startTime;
        this.duration = marky.stop(this.key).duration;
    }

    run() {
        const stepper = this.step();

        this.start();

        let step;
        do {
            step = stepper.next();
            this.verbose(`step: ${step.value}`);
        } while(!step.done);

        this.end();

        let stepTimer = t.timers.step;

        this.info(`Solution: ${step.value}`);
        this.info(`Took ${stepTimer.count()} steps`);
        this.info(`Took ${parseInt(this.duration)}ms`);

        return {
            solution: step.value,
            duration: this.duration,
        };
    }

    error(...args) {
        this.logger.error(...args);
    }
    warn(...args) {
        this.logger.warn(...args);
    }
    info(...args) {
        this.logger.info(...args);
    }
    verbose(...args) {
        this.logger.verbose(...args);
    }
    debug(...args) {
        this.logger.debug(...args);
    }
    silly(...args) {
        this.logger.silly(...args);
    }
    log(...args) {
        this.logger.log(...args);
    }
}
