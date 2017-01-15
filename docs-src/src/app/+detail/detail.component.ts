import {
  Component,
  OnInit,
} from '@angular/core';
import hljs from 'highlightjs';
/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */

const availableProblems = require.context('../../../../js', false, /^(.\/)([0-9]+$)/)
  .keys()
  .map(s => parseInt(s.replace('./', '')))
  .sort((a, b) => a - b);

console.log('`Detail` component loaded asynchronously');

@Component({
  selector: 'detail',
  template: `
    <h1>Hello from Detail</h1>
    <select name="problem" id="problem" (change)="onChange($event.target.value)">
        <option value="{{problem}}" *ngFor="let problem of availableProblems">{{problem}}</option>
    </select>
    <pre class="hljs" style="margin: 0;"><code [innerHtml]="jsText"></code></pre>
    <button (click)="run()">Run</button>
    <div>
        <span>Duration: {{duration}}</span>
        <br>
        <span>Solution: <code>{{solution}}</code></span>
    </div>

    <!--<span>-->
      <!--<a [routerLink]=" ['./child-detail'] ">-->
        <!--Child Detail-->
      <!--</a>-->
    <!--</span>-->
    <!--<router-outlet></router-outlet>-->
  `,
})
export class DetailComponent implements OnInit {
  jsText: string;
  problem;
  duration;
  solution;
  availableProblems = availableProblems;
  n;

  public ngOnInit() {
    console.log('hello `Detail` component');

    this.loadProblem(this.availableProblems[0]);
  }

  loadProblem(number) {
    let code = '';

    // import(`!!raw-loader!../../../../js/${4}`).then(module => {
    // }).catch(e => {
    //   console.log(e);
    // });
    require.ensure([], require => {
      code = require(`!!raw-loader!../../../../js/${number}`);

      this.jsText = hljs.highlightAuto(code).value;

      const ProblemConstructor = require(`../../../../js/${number}`).default;

      this.problem = new ProblemConstructor();
    });
  }

  run() {
    let {duration, solution} = this.problem.run();
    this.duration = `${parseInt(duration)}ms`;
    this.solution = solution;
  }

  onChange(number) {
    this.loadProblem(number);
  }
}
