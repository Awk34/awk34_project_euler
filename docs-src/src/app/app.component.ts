/*
 * Angular 2 decorators and services
 */
import {
  Component,
  OnInit,
  ViewEncapsulation
} from '@angular/core';
import { AppState } from './app.service';
// import { MdToolbar } from '@angular/material';

/*
 * App Component
 * Top Level Component
 */
@Component({
  selector: 'app',
  encapsulation: ViewEncapsulation.None,
  styleUrls: [
    './app.component.css'
  ],
  template: `
    <md-toolbar [color]="'primary'">
      <span style="padding: 0 16px;">Project Euler</span>
      
      <button md-button [routerLink]=" ['./home'] " routerLinkActive="active">
        Home
      </button>
      <button md-button [routerLink]=" ['./detail'] " routerLinkActive="active">
        Detail
      </button>
      <button md-button [routerLink]=" ['./about'] " routerLinkActive="active">
        About
      </button>
      
      <span style="flex: 1 1 auto;"></span>
      
      <button md-icon-button>
        <md-icon>more_vert</md-icon>
      </button>
    </md-toolbar>

    <main style="padding: 20px;">
      <router-outlet></router-outlet>
    </main>

    <!--<pre class="app-state">this.appState.state = {{ appState.state | json }}</pre>-->

    <footer style="padding: 20px; text-align: right;">
      &copy; Andrew Koroluk. All Rights Reserved.
    </footer>
  `
})
export class AppComponent implements OnInit {
  constructor(
    public appState: AppState,
    // public mdToolbar: MdToolbar
  ) {}

  public ngOnInit() {
    console.log('Initial App State', this.appState.state);
  }

}

/*
 * Please review the https://github.com/AngularClass/angular2-examples/ repo for
 * more angular app examples that you may copy/paste
 * (The examples may not be updated as quickly. Please open an issue on github for us to update it)
 * For help or questions please contact us at @AngularClass on twitter
 * or our chat on Slack at https://AngularClass.com/slack-join
 */
