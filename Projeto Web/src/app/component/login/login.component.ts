import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  [x: string]: any;
  usuarioLogado = false;
  usuario: string = '';
  senha: string = '';
  usuarioOuSenhaIncorreta: string = '';

  constructor(private router: Router) {}

   validarLogin(): boolean {
    if (this.usuario === process.env.USUARIO && this.senha === process.env.SENHA){
      this.usuarioLogado = true;
      this.router.navigate(['/doacaorecebida']);
    } else {
        this.usuarioOuSenhaIncorreta = "Usuário ou senha incorretos"
    }
    return this.usuarioLogado;
   }
}
