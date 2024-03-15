import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Logistica } from 'src/app/Modelo/Logistica';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserValidator } from 'src/app/Validaciones';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  id="";
  tipoProducto="";
  cantidadProducto:number=0;
  fechaRegistro="";
  fechaEntrega="";
  fecha="";
  puertoEntrega="";
  placaVehiculo="";
  numeroFlota="";
  numeroGuia="";
  precioEnvio:number=0;
  descuentoOtorgado:number=0;


dataFormServer = {};
registered = false;
errorRegistered=false;
channelForm: FormGroup; 

  constructor(private router:Router, private service:ServiceService, public fb:FormBuilder) {
  
this.channelForm=this.fb.group({
id : '',
name: ['',Validators.compose([
  Validators.required,
  Validators.minLength(3),
  UserValidator.verificarDatos
])],
placaVehiculo: ['', Validators.pattern(/[A-Z]{3}\d{3}/)],// Validación con expresión regular
numeroFlota: ['', Validators.pattern(/[A-Z]{3}\d{4}[A-Z]/)], // Validación con expresión regular
numeroGuia: ['', Validators.pattern(/\w{10}/)] // Validación con expresión regular 
})
}

  ngOnInit()  {
  }
  
  Guardar()
  {

    const logistica = new Logistica(
      this.id,
      this.tipoProducto,
      this.cantidadProducto,
      this.fechaRegistro,
      this.fechaEntrega,
      this.fecha,
      this.puertoEntrega,
      this.placaVehiculo,
      this.numeroFlota,
      this.numeroGuia,
      this.precioEnvio,
      this.descuentoOtorgado
    
   
   
      );
  
  
      let descuento = 0;
      let precioNormal = this.precioEnvio;
      if (this.cantidadProducto > 10) {
          if (this.placaVehiculo !== '') {
              // 5% de descuento para logística terrestre
              descuento = 0.05;
          } else if (this.numeroFlota !== '') {
              // 3% de descuento para logística marítima
              descuento = 0.03;
          }
      }

       // Calcular el precio final con descuento
    const precioFinal = precioNormal * (1 - descuento);

    // Asignar precio normal y descuento otorgado a la logística
    logistica.precioEnvio = precioNormal;
    logistica.descuentoOtorgado = descuento * 100; // Convertir a porcentaje para visualización
   
  

    this.service.create(logistica).subscribe(
      data=>{
        alert("se agrego con exito el registro"+this.id);
       this.router.navigate(["listar"]);
      },
      error=>{
             }
    )
}


}