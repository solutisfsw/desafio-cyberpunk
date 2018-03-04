import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient} from '@angular/common/http'; 

import {Observable} from 'rxjs/Observable';
import { ExtraEquip } from '../extra-equip';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class ExtraEquipService {

private urlExtraEquip:string = 'http://localhost:8080/extraEquip';
private headers = new Headers({'Content-Type': 'application.json'});


  constructor(private http:HttpClient) { }

getAllExtraEquip(): Observable<any>{
  return this.http.get(this.urlExtraEquip);
}

getExtraEquipbyId(extraEquip: number) {
  this.http.get(this.urlExtraEquip + '/'+ extraEquip);
}

}
