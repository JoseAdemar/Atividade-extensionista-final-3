import { DoacaoProduto } from "@app/component/doacao-produto/interface/doacaoProduto";


export interface Produto {
  id: number;
  nome: string;
  doacaoProduto?: DoacaoProduto[]
}