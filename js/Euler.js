import microtime from 'microtime';
import moment from 'moment';
import winston from 'winston';
const Logger = winston.Logger;
const Console = winston.transports.Console;
import chalk from 'chalk';
import t from 'exectimer';
const Tick = t.Tick;

// { error: 0, warn: 1, info: 2, verbose: 3, debug: 4, silly: 5 }
global.logLevel = global.logLevel || 'info';

export default class Euler {
    startTime;
    endTime;
    totalTime;

    constructor() {
        this.solution = undefined;

        const name = this.constructor.name;

        this.logger = new Logger({
            transports: [
                new Console({
                    level: global.logLevel,
                    /**
                     * @returns {String}
                     */
                    timestamp() {
                        return moment(Date.now()).format('MM.DD.YY H:mm:ss');
                    },
                    /**
                     * @param {Object} opts
                     * @param {Function} opts.timestamp
                     * @param {String} opts.level
                     * @param {String} [opts.message]
                     * @param {*} [opts.meta]
                     */
                    formatter(opts) {
                        // Return string will be passed to logger.
                        const time = chalk.blue(opts.timestamp());
                        const level = opts.level.toUpperCase();
                        const coloredLevel =
                            level === 'WARN' ? chalk.yellow('WARN') :
                            level === 'ERROR' ? chalk.red('ERROR') :
                            level;
                        const message = opts.message !== undefined ? opts.message : '';
                        const meta = opts.meta && Object.keys(opts.meta).length ? `\n\t${JSON.stringify(opts.meta)}` : '';
                        return `[${chalk.green(name)}][${time}][${coloredLevel}] ${message}${meta}`;
                    }
                })
            ]
        });
    }

    start() {
        this.startTime = microtime.now();
    }

    *step() {
        throw new Error('You need to override this, doofus');
    }

    end() {
        this.endTime = microtime.now();
        this.totalTime = this.endTime - this.startTime;
    }

    run() {
        this.start();

        const stepper = this.step();

        let step;
        do {
            step = stepper.next();
            this.verbose(`step: ${step.value}`);
        } while(!step.done);

        this.end();

        let stepTimer = t.timers.step;

        this.info(`Solution: ${step.value}`);
        this.info(`Took ${stepTimer.count()} steps`);
        this.info(`Took ${stepTimer.parse(stepTimer.duration())}`);

        return step.value;
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
