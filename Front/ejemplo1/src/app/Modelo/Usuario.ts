import { NodeCompatibleEventEmitter } from "rxjs/internal/observable/fromEvent";

export class User {
   id:string;
   name:string;
   lastName:string;
   email:string;
   password:string;
   confirmPassword:string;
   createdBy:string;
   createdAt:string;
   modifiedAt:string;
   
   constructor(id: string,name:string, lastName:string,
    email:string,password:string,confirmPassword:string,createdBy:string,
    createdAt:string,modifiedAt:string) {
        this. id=id; 
       
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.confirmPassword=confirmPassword;
        this.createdBy=createdBy;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;


      }
    }