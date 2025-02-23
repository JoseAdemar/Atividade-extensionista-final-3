import { Injectable } from '@angular/core';
import { Produto } from '../interface/produtoInterface';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private apiUrl = "http://localhost:8080/api/produtos"; 

  constructor(private http: HttpClient) { }

  registrarDoacao(produtos: Produto[]): Observable<Produto[]> {
    return this.http.post<Produto[]>(this.apiUrl, produtos);
  }
}
