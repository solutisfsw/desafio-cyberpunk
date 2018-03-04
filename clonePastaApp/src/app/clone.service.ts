import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient} from '@angular/common/http'; 

import {Observable} from 'rxjs/Observable';
import { Clone } from '../clone';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CloneService {

private urlClone: string = 'http://localhost:8080/cloneCentral';
private headers = new Headers({'Content-Type':'application.json'}); 

  constructor(private http: HttpClient) {}


getAllClones() : Observable<any>{
  return this.http.get(this.urlClone);
}

postClone(clone:Clone) {
  return this.http.post(this.urlClone,clone);
}

getCloneById(id : number) : Observable<any>{
  return this.http.get(this.urlClone + '/' + id);
}

deleteClone(cloneId: number){ 
 // this.http.delete(this.urlDelete + '/' + cloneId);
}

}
