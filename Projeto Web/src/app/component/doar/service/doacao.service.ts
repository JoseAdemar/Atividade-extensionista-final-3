import { Doacao } from './../interface/doacaoInterface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoacaoService {

  private apiUrl = "http://localhost:8080/api/doacoes"; 
  constructor(private http: HttpClient) { }

  registrarDoacao(doacao: Doacao): Observable<Doacao> {
    console.log(doacao)
    return this.http.post<Doacao>(this.apiUrl, doacao);
  }
  
}