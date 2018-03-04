import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ElementoService {
  elementoUrl = 'http://localhost:8080/elementos';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(this.elementoUrl);
  }
  adicionar(elemento: any){
    return this.http.post(this.elementoUrl, elemento);
  }

  atualizar(elemento){
    return this.http.put(this.elementoUrl, elemento);
  }

  deletar(id){
    return this.http.delete<any[]>(this.elementoUrl + "/" + id);
  }
  
}
