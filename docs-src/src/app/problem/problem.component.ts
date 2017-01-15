import {
  Component,
  OnInit
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import hljs from 'highlightjs';
import { get } from 'lodash-es';

const availableProblems = require.context('../../../../js', false, /^(.\/)([0-9]+$)/)
  .keys()
  .map(s => parseInt(s.replace('./', '')))
  .sort((a, b) => a - b);

@Component({
  selector: 'about',
  styles: [`
  `],
  template: `
    <md-toolbar class="secondary-toolbar">
      <span class="title">Problem {{n}}</span>
      
      <span style="flex: 1 1 auto;"></span>
      
      <button md-icon-button (click)="run()">
        <md-icon>play_arrow</md-icon>
      </button>
      <!--<button md-icon-button>-->
        <!--<md-icon>skip_next</md-icon>-->
      <!--</button>-->
    </md-toolbar>
    
    <span>{{error}}</span>
    
    <div *ngIf="!error">
      <!--<select name="problem" id="problem" (change)="onChange($event.target.value)">-->
          <!--<option value="{{problem}}" *ngFor="let problem of availableProblems">{{problem}}</option>-->
      <!--</select>-->
      <pre class="hljs" style="margin: 0;"><code [innerHtml]="jsText"></code></pre>

      <br>

      <div>
          <span>Duration: {{duration}}</span>
          <br>
          <span>Solution: <code>{{solution}}</code></span>
      </div>
    </div>

    <!--<span>-->
      <!--<a [routerLink]=" ['./child-detail'] ">-->
        <!--Child Detail-->
      <!--</a>-->
    <!--</span>-->
    <!--<router-outlet></router-outlet>-->
  `,
})
export class ProblemComponent implements OnInit {
  jsText: string;
  problem;
  duration;
  solution;
  availableProblems = availableProblems;
  n;
  error: string;
  running: boolean = false;

  constructor(
    public route: ActivatedRoute
  ) {}

  public ngOnInit() {
    this.n = parseInt(get(this, 'route.params.value.n')) || 1;

    if(this.availableProblems.indexOf(this.n) > -1) {
      this.loadProblem(this.n);
      this.error = '';
    } else {
      this.error = 'Sorry, I don\'t have a JS solution for that one yet!';
    }

    console.log(require(`!!raw-loader!../../../../scraped/${this.n}/${this.n}.md`));

    console.log('hello `Problem` component');
  }

  loadProblem(number) {
    let code = '';

    // import(`!!raw-loader!../../../../js/${4}`).then(module => {}).catch(e => {});
    require.ensure([], require => {
      code = require(`!!raw-loader!../../../../js/${number}`);

      this.jsText = hljs.highlightAuto(code).value;

      const ProblemConstructor = require(`../../../../js/${number}`).default;

      this.problem = new ProblemConstructor();
    });
  }

  run() {
    this.running = true;
    let {duration, solution} = this.problem.run();
    this.duration = `${parseInt(duration)}ms`;
    this.solution = solution;
    this.running = false;
  }
}
