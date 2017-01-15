import {
  Component,
} from '@angular/core';

@Component({
  selector: 'about',
  styles: [`
  `],
  template: `
    <md-toolbar class="secondary-toolbar">
      <span class="title">About</span>
    </md-toolbar>

    <div style="padding: 40px;">
      <div style="display: flex; align-items: center; justify-content: space-around;">
        <span>
          <img src="/assets/img/portrait_2014.jpg" alt="Andrew Koroluk portrait" style="border-radius: 50%; width: 15rem; flex-grow: 0;">
        </span>
        <span>
          <img src="https://projecteuler.net/profile/Awk34.png" alt="Awk34 Project Euler badge">
        </span>
      </div>
      
      <br>
      
      <span>Hi, I'm <a href="http://andrewk.me">Andrew Koroluk</a>. This site contains the code for my <a href="https://projecteuler.net">Project Euler</a> solutions.</span>
    </div>
  `
})
export class AboutComponent {}
