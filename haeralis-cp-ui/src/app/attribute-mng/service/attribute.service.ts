import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AttributeService {

  public attributePath = 'http://localhost:8080/attributes';
  public attributeTypePath = 'http://localhost:8080/attribute-types';

  constructor(private http: HttpClient) { }

  listAll(){
    return this.http.get<any[]>(this.attributePath);
  }

  listType(){
    return this.http.get<any[]>(this.attributeTypePath);
  }

  addNew(attribute){
    return this.http.post(this.attributePath, attribute)
  }

  delete(attribute){
    //console.log(attribute);
    return this.http.delete(this.attributePath+"/"+attribute.id);
  }

}
