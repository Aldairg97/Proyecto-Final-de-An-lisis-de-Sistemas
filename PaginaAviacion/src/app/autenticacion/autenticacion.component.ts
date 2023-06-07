import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-autenticacion',
  templateUrl: './autenticacion.component.html',
  styleUrls: ['./autenticacion.component.css']
})
export class AutenticacionComponent {
  email: string='';
  nombre: string='';
  resultado: number | null = null;

  constructor(private http: HttpClient,  private router: Router) {}

  autenticarUsuario() {
    const url = `http://localhost:8080/usuarios/autenticar?email=${this.email}&nombre=${this.nombre}`;
    this.http.get<number>(url).subscribe((res) => {
      this.resultado = res;
  
      if (this.resultado === 1) {
        alert('Inicio de sesión aprobado');
        this.router.navigateByUrl('/menu');
      } else {
        alert('Credenciales inválidas');
      }
    });
  }
}
