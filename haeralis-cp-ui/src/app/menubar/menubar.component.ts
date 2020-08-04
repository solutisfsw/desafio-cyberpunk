import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.css']
})
export class MenubarComponent implements OnInit {

  public menuItens = [
    {name: 'Attribute', uiref: '/attribute'},
    {name: 'Cyberpunk', uiref: '/cyberpunk'}
  ]

  constructor() { }

  ngOnInit() {
  }

}
