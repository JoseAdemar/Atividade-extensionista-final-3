import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DoacaoRecebida } from '../interface/doacaoRecebida';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoacaorecebidaService {
  private apiUrlGet = 'http://localhost:8080/api/doacoes/recebidas';
  private apiUrlPut = 'http://localhost:8080/api/doacoes/recebidas';
  constructor(private http: HttpClient) {}

  getDoacoesRecebidas(): Observable<DoacaoRecebida[]> {
    return this.http.get<DoacaoRecebida[]>(this.apiUrlGet);
  }

  alteraStatusDoacao(id: number): Observable<any> {
    const url = `${this.apiUrlPut}/${id}`;
    return this.http.put(url, {}).pipe(
      catchError(error => {
        console.error('Erro ao alterar status da doação:', error);
        return throwError(error);
      })
    );
  }
}
