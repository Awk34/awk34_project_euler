import { ActivatedRoute, Data } from '@angular/router';
// import { Component } from '@angular/core';
import { inject, TestBed } from '@angular/core/testing';

// Load the implementations that should be tested
import { ProblemComponent } from './problem.component';

describe('About', () => {
  // provide our implementations or mocks to the dependency injector
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      // provide a better mock
      {
        provide: ActivatedRoute,
        useValue: {
          data: {
            subscribe: (fn: (value: Data) => void) => fn({
              yourData: 'yolo'
            })
          }
        }
      },
      ProblemComponent
    ]
  }));

  it('should log ngOnInit', inject([ProblemComponent], (problem: ProblemComponent) => {
    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    problem.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  }));

});
