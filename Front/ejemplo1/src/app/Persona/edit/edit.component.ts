import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';
import { Logistica } from 'src/app/Modelo/Logistica';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  dataLogistica!: Logistica;
  id="";
 
  constructor(private router:Router, private service:ServiceService) {
   }

  ngOnInit(): void {

  }

editar() {
  this.service.update(this.dataLogistica).subscribe(
    (dataActualizada: Logistica) => {
      this.dataLogistica = dataActualizada;
      console.log('Registro actualizado:', dataActualizada.tipoProducto);
      alert("Registro Actualizado");
      this.router.navigate(["listar"]);
    },
    (error) => {
      console.error('Error al actualizar el registro:', error);
      // Manejar el error según sea necesario
    }
  );
}

  buscar() {
    this.service.getId(this.id).subscribe(
      (logistica: Logistica) => {
        this.dataLogistica = logistica;
      },
      (error) => {
        console.error('Error al buscar id:', error);
        // Manejar el error según sea necesario
      }
    );
  }

}

