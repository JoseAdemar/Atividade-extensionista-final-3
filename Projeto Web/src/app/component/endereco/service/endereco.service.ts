import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endereco } from '../interface/enderecoInterface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

private apiUrl = "http://localhost:8080/api/enderecos"; 
  constructor(private http: HttpClient) { }

  registrarDoacao(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(this.apiUrl, endereco);
  }
  
}