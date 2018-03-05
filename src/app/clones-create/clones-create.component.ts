import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-clones-create',
  templateUrl: './clones-create.component.html',
  styleUrls: ['./clones-create.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ClonesCreateComponent implements OnInit {

  clones = {};

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  saveClones() {
    this.http.post('/clone', this.clones)
      .subscribe(res => {
          let id = res['_id'];
          this.router.navigate(['/clones']);
        }, (err) => {
          console.log(err);
        }
      );
  }
}