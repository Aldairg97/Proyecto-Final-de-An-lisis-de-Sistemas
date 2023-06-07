import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent {
  clientes: any[] = [];
  nuevoCliente: any = null;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.obtenerClientes();
  }

  obtenerClientes() {
    this.http.get('http://localhost:8080/clientes/').subscribe(
      (response: any) => {
        this.clientes = response;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  agregarCliente() {
    this.router.navigateByUrl('/insertar');
  }

  editarCliente(cliente: any) {
    this.http.put(`http://localhost:8080/clientes/${cliente.id_cliente}`, cliente).subscribe(
      (response: any) => {
        alert('Operación exitosa');
      },
      (error: any) => {
        alert('Error al guardar los cambios:');
      }
    );
  }

  eliminarCliente(cliente: any) {
    this.http.delete(`http://localhost:8080/clientes/${cliente.id_cliente}`).subscribe(
      () => {
        const index = this.clientes.indexOf(cliente);
        if (index !== -1) {
          this.clientes.splice(index, 1);
          alert('Cliente eliminado exitosamente');
        }
      },
      (error: any) => {
        console.error(error);
        alert('Error al eliminar el cliente');
      }
    );
  }
}
