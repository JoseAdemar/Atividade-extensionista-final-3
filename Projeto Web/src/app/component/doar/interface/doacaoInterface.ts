import { Doador } from '@app/component/doador/interface/doadorInterface';
import { DoacaoProduto } from '@app/component/doacao-produto/interface/doacaoProduto';

export interface Doacao {
    id: number;  
    doador: Doador;  
    doacaoRecolhida: boolean; 
    localDate: string; 
    doacaoProduto: DoacaoProduto[];  
  }