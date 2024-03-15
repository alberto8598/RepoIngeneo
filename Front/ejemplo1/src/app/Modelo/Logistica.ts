import { NodeCompatibleEventEmitter } from "rxjs/internal/observable/fromEvent";

export class Logistica {
   id:string;
   tipoProducto:string;
   cantidadProducto:number;
   fechaRegistro: String;
   fechaEntrega: String;
   fecha: String;
   puertoEntrega:String;
   placaVehiculo:String;
   numeroFlota: string;
   numeroGuia: string;
   precioEnvio:number;
   descuentoOtorgado:number;
   /*
   
   
  
   */
   constructor(
    id: string,
    tipoProducto:string,  
    cantidadProducto:number,
    fechaRegistro:String,
    fechaEntrega:String,
    fecha:String,
    puertoEntrega: string,
    placaVehiculo: string,
    numeroFlota: string,
    numeroGuia: string,
    precioEnvio:number,
    descuentoOtorgado:number
    /*
    
    
   
*/
    ) {
        this. id=id; 
        this.tipoProducto=tipoProducto;
        this.cantidadProducto=cantidadProducto;
        this.fechaRegistro=fechaRegistro;
        this.fechaEntrega=fechaEntrega;
        this.fecha=fecha;
        this.puertoEntrega=puertoEntrega;
        this.placaVehiculo=placaVehiculo;
        this.numeroFlota=numeroFlota;
        this.numeroGuia=numeroGuia;
        this.precioEnvio=precioEnvio;
        this.descuentoOtorgado=descuentoOtorgado;
        /*
       
        
        
        */
      }
    }
   