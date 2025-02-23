import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CabecalhoComponent } from "./component/cabecalho/cabecalho.component";
import { HomeComponent } from "./component/home/home.component";
import { DoarComponent } from "./component/doar/doar.component";
import { SobrenosComponent } from "./component/sobrenos/sobrenos.component";
import { LoginComponent } from "./component/login/login.component";
import { DoacaoRecebidaComponent } from "./component/doacao-recebida/doacao-recebida.component";

const APP_MINHAS_ROTAS: Routes = [
    { path: '', component: HomeComponent},
    { path: 'cabecalho', component: CabecalhoComponent},
    { path: 'doar', component: DoarComponent},
    { path: 'sobrenos', component: SobrenosComponent},
    { path: 'login', component: LoginComponent},
    { path: 'doacaorecebida', component: DoacaoRecebidaComponent},


];

export const rotas: ModuleWithProviders<RouterModule> = RouterModule.forRoot(APP_MINHAS_ROTAS);
