import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-insertar',
  templateUrl: './insertar.component.html',
  styleUrls: ['./insertar.component.css']
})
export class InsertarComponent {
  cliente = {
    idCliente: 0,
    idUsuario: 0,
    nombre: '',
    telefono: ''
  };

  constructor(private http: HttpClient) {}

  insertarCliente() {
    this.http.post('http://localhost:8080/clientes/', this.cliente)
      .subscribe(
        (response: any) => {
          console.log('Cliente insertado correctamente');
          // Puedes agregar aquí lógica adicional si deseas mostrar una notificación o redirigir a otra página.
        },
        (error: any) => {
          console.error('Error al insertar el cliente:', error);
        }
      );
  }
}
