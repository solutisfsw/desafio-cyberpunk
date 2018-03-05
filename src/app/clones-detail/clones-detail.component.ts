import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-clones-detail',
  templateUrl: './clones-detail.component.html',
  styleUrls: ['./clones-detail.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ClonesDetailComponent implements OnInit {

  clones = {};

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.getClonesDetail(this.route.snapshot.params['id']);
  }

  getClonesDetail(id) {
    this.http.get('/clone/'+id).subscribe(data => {
      this.clones = data;
    });
  }

  deleteClone(id) {
  this.http.delete('/clone/'+id)
    .subscribe(res => {
        this.router.navigate(['/clones']);
      }, (err) => {
        console.log(err);
      }
    );
  }
}