import { Doacao } from './interface/doacaoInterface';
import { Endereco } from '@app/component/endereco/interface/enderecoInterface';
import { ProdutoService } from './../produto/service/produto.service';
import { EnderecoService } from './../endereco/service/endereco.service';
import { DoadorService } from './../doador/service/doador.service';
import { Component } from '@angular/core';
import { DoacaoService } from './service/doacao.service';


@Component({
  selector: 'app-doar',
  templateUrl: './doar.component.html',
  styleUrls: ['./doar.component.css'],
})
export class DoarComponent {
  mensagemDoacao: string = '';
  camposObrigatorios: string = '';
  doacao: Doacao = {
    id: 0,
    doador: {
      id: 0,
      nome: '',
      email: '',
      telefone: '',
      cpf: '',
      endereco: {
        id: 0,
        cep: '',
        localidade: '',
        bairro: '',
        uf: ''
      }
    },
    doacaoProduto: [],
    doacaoRecolhida: false,
    localDate: ''
  };

  constructor(private doacaoService: DoacaoService,
              private doadorService: DoadorService,
              private enderecoService: EnderecoService,
              private produtoService: ProdutoService
  ) { }

  salvarDoacao(): void {
    this.itens.forEach(element => {
      if (element.selecionado === true) {
  
          let produto = {
          id: element.id,
          nome: element.nome,
          doacaoProduto: this.doacao.doacaoProduto
        }
      
        let doacaoProduto = {
          id: 0,
          doacaoId: this.doacao.id,
          produtoId: produto.id,
          quantidade: element.quantidade
        }
        this.doacao.doacaoProduto.push(doacaoProduto);
      }
    });

    this.validaCamposObrigatorios();
    if (this.camposObrigatorios === '') {
    this.doacaoService.registrarDoacao(this.doacao).subscribe({
      next: (response) => {
        this.exibirMensagemDoacaoEnviada();
        this.resetaCamposFormularioDoacao();
      },
      error: (error) => {
        let mensagemErroNaDoacao = 'Erro ao registrar a doação' + error;
      },
      complete: () => {
        console.log('Requisição concluída.');
      }
    });
    }
  }

  exibirMensagemDoacaoEnviada () {
    this.mensagemDoacao = 'Doação enviada com sucesso!'; 
  setTimeout(() => {
    this.mensagemDoacao = '';  
  }, 7000);
  }

   validaCamposObrigatorios() {
    if (this.doacao.doador.cpf === '' ||
        this.doacao.doador.nome === '' ||
        this.doacao.doador.email === '' ||
        this.doacao.doador.telefone === ''
    ){
      this.camposObrigatorios = 'Campo obrigatório';
    } else {
      this.camposObrigatorios = '';
    }
  }

  resetaCamposFormularioDoacao() {
    this.doacao.id = 0;
    this.doacao.doacaoProduto[0];
    this.doacao.doacaoRecolhida = false;
    this.doacao.doador.nome = '';
    this.doacao.doador.cpf = '';
    this.doacao.doador.email = '';
    this.doacao.doador.telefone = '';
    this.doacao.doador.endereco.bairro = '';
    this.doacao.doador.endereco.cep = '';
    this.doacao.doador.endereco.localidade = '';
    this.doacao.doador.endereco.uf = '';
    this.itens = [
      { id: 1, nome: 'Arroz', selecionado: false, quantidade: 1 },
      { id: 2, nome: 'Feijão', selecionado: false, quantidade: 1 },
      { id: 3, nome: 'Macarrão', selecionado: false, quantidade: 1 },
      { id: 4, nome: 'Açúcar', selecionado: false, quantidade: 1 },
      { id: 5, nome: 'Farinha de trigo', selecionado: false, quantidade: 1 },
      { id: 6, nome: 'Óleo de soja', selecionado: false, quantidade: 1 },
      { id: 7, nome: 'Milho enlatado', selecionado: false, quantidade: 1 },
      { id: 8, nome: 'Ervilha enlatada', selecionado: false, quantidade: 1 },
      { id: 9, nome: 'Leite em pó', selecionado: false, quantidade: 1 },
      { id: 10, nome: 'Café', selecionado: false, quantidade: 1 },
      { id: 11, nome: 'Sardinha em lata', selecionado: false, quantidade: 1 },
      { id: 12, nome: 'Molho de tomate', selecionado: false, quantidade: 1 },
      { id: 13, nome: 'Sal', selecionado: false, quantidade: 1 },
      { id: 14, nome: 'Farinha de mandioca', selecionado: false, quantidade: 1 },
      { id: 15, nome: 'Macarrão instantâneo', selecionado: false, quantidade: 1 }];
  }
  

  encontrarDoadorPorCpf(cpf: string) {
    this.doadorService.getDoadorByCpf(cpf).subscribe(
      {
        next: (response) =>{
          console.log('Doador encontrado!', response);
        },
        error: (error) => {
          console.error('Erro ao buscar doador', error);
        },
        complete: () => {
          console.log('Requisição concluída.');
        }
      }
    )
  }

  salvarDoador(): void {
    this.doadorService.registrarDoador(this.doacao.doador).subscribe({
      next: (response) => {
        console.log('Doação registrada com sucesso!', response);
      },
      error: (error) => {
        console.error('Erro ao registrar a doação', error);
      },
      complete: () => {
        console.log('Requisição concluída.');
      }
    });
  }

  salvarEndereco(endereco: Endereco): void {
    this.enderecoService.registrarDoacao(endereco).subscribe({
      next: (response) => {
        console.log('Doação registrada com sucesso!', response);
      },
      error: (error) => {
        console.error('Erro ao registrar a doação', error);
      },
      complete: () => {
        console.log('Requisição concluída.');
      }
    });
  }

/*
  salvarProduto(): void {
    this.doacao.produto = this.itens
    this.produtoService.registrarDoacao(this.doacao.produto).subscribe({
      next: (response) => {
        console.log('Doação registrada com sucesso!', response);
      },
      error: (error) => {
        console.error('Erro ao registrar a doação', error);
      },
      complete: () => {
        console.log('Requisição concluída.');
      }
    });
  }*/


  itens = [
    { id: 1, nome: 'Arroz', selecionado: false, quantidade: 1 },
    { id: 2, nome: 'Feijão', selecionado: false, quantidade: 1 },
    { id: 3, nome: 'Macarrão', selecionado: false, quantidade: 1 },
    { id: 4, nome: 'Açúcar', selecionado: false, quantidade: 1 },
    { id: 5, nome: 'Farinha de trigo', selecionado: false, quantidade: 1 },
    { id: 6, nome: 'Óleo de soja', selecionado: false, quantidade: 1 },
    { id: 7, nome: 'Milho enlatado', selecionado: false, quantidade: 1 },
    { id: 8, nome: 'Ervilha enlatada', selecionado: false, quantidade: 1 },
    { id: 9, nome: 'Leite em pó', selecionado: false, quantidade: 1 },
    { id: 10, nome: 'Café', selecionado: false, quantidade: 1 },
    { id: 11, nome: 'Sardinha em lata', selecionado: false, quantidade: 1 },
    { id: 12, nome: 'Molho de tomate', selecionado: false, quantidade: 1 },
    { id: 13, nome: 'Sal', selecionado: false, quantidade: 1 },
    { id: 14, nome: 'Farinha de mandioca', selecionado: false, quantidade: 1 },
    { id: 15, nome: 'Macarrão instantâneo', selecionado: false, quantidade: 1 }
  ];
}
  
