import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Logistica } from 'src/app/Modelo/Logistica';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  id:number=1;

  logistica:Logistica[];

  constructor(private service:ServiceService, private router:Router) 
  { 
    this.logistica=[];

  }

  ngOnInit()
  {
  
 this.service.get()
 .subscribe(data=>{
   this.logistica=data;
   
  })

  }
  
  Delete(logistica:Logistica){
    this.service.delete(logistica)
    .subscribe(data=>{
      this.logistica=this.logistica.filter(p=>p!==logistica);
      alert("Registro Eliminado");
    })
    
    }

}
