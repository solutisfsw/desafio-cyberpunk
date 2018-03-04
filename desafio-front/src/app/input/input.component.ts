import { Component, OnInit, Input, ContentChild, AfterContentInit } from '@angular/core';
import { FormControlName } from '@angular/forms';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html'
})
export class InputComponent implements OnInit, AfterContentInit {

  @Input() label: string;
  @ContentChild(FormControlName) control: FormControlName;  

  constructor() { }

  ngOnInit() {
  }

  ngAfterContentInit() {
    if(this.control === undefined)
      throw new Error('Esse componente precisa ser usado com a diretiva formControlName');
  }

}
