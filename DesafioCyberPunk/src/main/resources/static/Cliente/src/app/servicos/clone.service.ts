import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {Clone} from '../clone';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class CloneService {

  private urlBase: string = 'http://localhost:8080/rest';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers, });
  private Clone : Clone;

  constructor(private _http:Http) {

  }

  getClones(){
  	return this._http.get(this.urlBase+"/Clones", this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

   deleteclone(id:number){
  	return this._http.delete(this.urlBase+"/Clone/"+id, this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  novoClone(clone:Clone){
  	return this._http.post(this.urlBase+"/Clone",JSON.stringify(clone), this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  updateClone(clone:Clone){
  	return this._http.put(this.urlBase+"/Clone",JSON.stringify(clone), this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  errorHandler(Error:Response){
  	return Observable.throw(Error || "Erro no Servidor");
  }

  getter(){
    return this.Clone;
  }

  setter(clone:Clone){
    this.Clone = clone;
  }

}
