import { Endereco } from '@app/component/endereco/interface/enderecoInterface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doador } from '../interface/doadorInterface';

@Injectable({
  providedIn: 'root'
})
export class DoadorService {

 private apiUrl = "http://localhost:8080/api/doadores"; 
   constructor(private http: HttpClient) { }
 
   registrarDoador(doador: Doador): Observable<Doador> {
     return this.http.post<Doador>(this.apiUrl, doador);
   }

   // Método GET que aceita o CPF como parâmetro
  getDoadorByCpf(cpf: string): Observable<any> {
    const url = `${this.apiUrl}?cpf=${cpf}`;
    return this.http.get<any>(url);
  }
   
 }
