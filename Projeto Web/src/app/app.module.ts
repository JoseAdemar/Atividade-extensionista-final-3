import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CabecalhoComponent } from './component/cabecalho/cabecalho.component';
import { RodapeComponent } from './component/rodape/rodape.component';
import { HomeComponent } from './component/home/home.component';
import { DoarComponent } from './component/doar/doar.component';
import { SobrenosComponent } from './component/sobrenos/sobrenos.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { rotas } from './app.rotas';
import { CommonModule, HashLocationStrategy, LocationStrategy } from '@angular/common';
import { DoadorComponent } from './component/doador/doador.component';
import { ProdutoComponent } from './component/produto/produto.component';
import { EnderecoComponent } from './component/endereco/endereco.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './component/login/login.component';
import { DoacaoRecebidaComponent } from './component/doacao-recebida/doacao-recebida.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    CabecalhoComponent,
    RodapeComponent,
    HomeComponent,
    DoarComponent,
    SobrenosComponent,
    DoadorComponent,
    ProdutoComponent,
    EnderecoComponent,
    LoginComponent,
    DoacaoRecebidaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    rotas,
    HttpClientModule,
    FormsModule,
    CommonModule,
    NgxPaginationModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
