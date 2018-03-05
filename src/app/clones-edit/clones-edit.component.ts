import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-clones-edit',
  templateUrl: './clones-edit.component.html',
  styleUrls: ['./clones-edit.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ClonesEditComponent implements OnInit {

  clones: any = {};

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getClone(this.route.snapshot.params['id']);
  }

  getClone(id) {
    this.http.get('/clone/'+id).subscribe(data => {
      this.clones = data;
    });
  }

  updateClones(id) {
    this.http.put('/clone/'+id, this.clones)
      .subscribe(res => {
          let id = res['_id'];
          this.router.navigate(['/clones-details', id]);
        }, (err) => {
          console.log(err);
        }
      );
  }
}