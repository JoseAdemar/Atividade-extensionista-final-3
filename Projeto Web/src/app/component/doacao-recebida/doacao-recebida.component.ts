import { DoacaoRecebida } from './interface/doacaoRecebida';
import { AfterViewInit, Component, ElementRef, Renderer2 } from '@angular/core';
import { DoacaorecebidaService } from './service/doacaorecebida.service';
declare var bootstrap: any;

@Component({
  selector: 'app-doacao-recebida',
  templateUrl: './doacao-recebida.component.html',
  styleUrls: ['./doacao-recebida.component.css']
})
export class DoacaoRecebidaComponent implements AfterViewInit{
  protected paginator: number = 1;
  modal: any;
  doacoes: DoacaoRecebida[] = [];
  selectedDoacaoId: number = 0;

  doacao: DoacaoRecebida = {
    doacaoId: 0,
    totalItens: 0,
    produtos: '',
    doacaoRecolhida: false,
    nomeDoador:'',
    emailDoador:'',
    telefoneDoador:'',  
    cep:'',
    uf:'',
    localidade:''
  }

  ngAfterViewInit(): void {
    const modalElement = this.el.nativeElement.querySelector('#exampleModal');
    this.modal = new bootstrap.Modal(modalElement);
  }


  constructor(private doacaoRecebidaService: DoacaorecebidaService,private renderer: Renderer2, private el: ElementRef) {
  }

  ngOnInit(): void {
    this.carregaDoacoesRecebidas();
  }

  private carregaDoacoesRecebidas(): void {
    this.doacaoRecebidaService.getDoacoesRecebidas().subscribe({
      next: (data) => {
        this.doacoes = data;
      },
      error: () => {
        
      },
    });
  }

  

  setSelectedDoacaoId(id: number): void {
    this.selectedDoacaoId = id;
  }

  hideModal(): void {
    this.modal.hide();
  }

  public alterarStatusDoacaoRecolhida(id: number): void {
    this.doacaoRecebidaService.alteraStatusDoacao(id).subscribe({
      next: (data) => {
      let modalElement = this.el.nativeElement.querySelector('#exampleModal');
      
      if (modalElement) {
        // Método para esconder o modal
        this.hideModal();
        this.carregaDoacoesRecebidas();
      }
      },
      error: () => {
        
      },
    });
  }

}
