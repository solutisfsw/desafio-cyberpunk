import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CyberpunkService {

  public cyberpunkPath = 'http://localhost:8080/cyberpunk';

  constructor(private http: HttpClient) { }

  listAll(){
    return this.http.get<any[]>(this.cyberpunkPath+'/list');
  }

  listModels(){
    return this.http.get<any[]>(this.cyberpunkPath+'/listModels');
  }

  clone(cyberpunk){
    return this.http.post(this.cyberpunkPath+'/clone', cyberpunk)
  } 

  update(cyberpunk){
    return this.http.post(this.cyberpunkPath+'/update', cyberpunk)
  } 

  delete(cyberpunk){
    return this.http.post(this.cyberpunkPath+'/delete', cyberpunk)
  } 
}
