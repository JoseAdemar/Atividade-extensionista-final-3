import { Endereco } from '@app/component/endereco/interface/enderecoInterface';

export interface Doador {
  id: number;
  nome: string;
  email: string;
  telefone: string;
  cpf: string;
  endereco: Endereco;  
}