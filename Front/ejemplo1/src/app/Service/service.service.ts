import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Logistica } from 'src/app/Modelo/Logistica';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  
  Url='http://localhost:8092/persona';
  
  get(){
    return this.http.get<Logistica[]>(this.Url);
  }
  
  create(logistica:Logistica)
  {
    return this.http.post<Logistica>(this.Url,logistica);
  }

  getId(id:string) {
    return this.http.get<Logistica>(this.Url+"/"+id);
  }

  update(logistica:Logistica) {
    return this.http.put<Logistica>(this.Url+"/"+logistica.id,logistica);
  }
  
  delete(logistica:Logistica)
  {
    return this.http.delete<Logistica>(this.Url+"/"+logistica.id);
  }
}
