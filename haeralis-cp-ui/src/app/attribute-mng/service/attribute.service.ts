import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AttributeService {

  public attributePath = 'http://localhost:8080/attribute';

  constructor(private http: HttpClient) { }

  listAll(){
    return this.http.get<any[]>(this.attributePath+'/list');
  }

  listType(){
    return this.http.get<any[]>(this.attributePath+'/listType');
  }

  addNew(attribute){
    return this.http.post(this.attributePath+'/add', attribute)
  }

  delete(attribute){
    //console.log(attribute);
    return this.http.post(this.attributePath+'/delete', attribute);
  }

}
