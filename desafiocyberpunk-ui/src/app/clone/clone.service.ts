import { Injectable, Component } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


@Injectable()
export class CloneService {

  cloneUrl = 'http://localhost:8080/clones';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(this.cloneUrl);
  }

  adicionar(clone: any){
    return this.http.post(this.cloneUrl, clone);
  
  }

  atualizar(clone){
    return this.http.put(this.cloneUrl, clone);
  
  }

  deletar(id){
    return this.http.delete<any[]>(this.cloneUrl + "/" + id);
  }
  


}
