import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-clones',
  templateUrl: './clones.component.html',
  styleUrls: ['./clones.component.css']
})
export class ClonesComponent implements OnInit {
  clones: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  	this.http.get('/clone').subscribe(data => {
      this.clones = data;
    });
  }

}
