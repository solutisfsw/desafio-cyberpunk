import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';

import { environment } from './../../../environments/environment';
import { Clone } from './clone.model';
import { Page } from './../shared/page.model';

@Injectable()
export class ClonesService { 

  constructor(private http: HttpClient) {}

  buscaTodos(numeroDaPagina = 0, busca = ''): Observable<Page> {
    let params = new HttpParams()
      .set('page', numeroDaPagina.toString())
      .set('q', busca);

    return this.http.get<Page>(`${environment.api}/clones`, {params});
  }

  salva(clone: Clone): Observable<Clone> {
    return this.http.post<Clone>(`${environment.api}/clones`, clone);
  }

  buscaPorId(id: number): Observable<Clone> {
    return this.http.get<Clone>(`${environment.api}/clones/${id}`);
  }

  buscaPorNome(nome: string) {
    return this.http.get<Clone>(`${environment.api}/clones/nome/${nome}`);
  }

  edita(clone: Clone, id: number): Observable<any> {
    return this.http.put<any>(`${environment.api}/clones/${id}`, clone);
  }

  remove(id: number): Observable<any> {
    return this.http.delete<any>(`${environment.api}/clones/${id}`);
  }
  
}
