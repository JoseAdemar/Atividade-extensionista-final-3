import { Doacao } from "@app/component/doar/interface/doacaoInterface";
import { Produto } from "@app/component/produto/interface/produtoInterface";

export interface DoacaoProduto {
    id: number;
    doacaoId: number,
    produtoId: number;
    quantidade: number;
  }