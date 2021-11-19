import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  
  cusername : string;
 cpassword : string;
 status: Observable<string>;
 isFormSubmitted : boolean;
 login(loginForm : NgForm) {
  //  this.isFormSubmitted = false;
    if (loginForm.invalid) {
      return;
    }
    this.isFormSubmitted = true;
 
 
    this._service.loginCustomer(this.cusername, this.cpassword).subscribe( x => {
      
      if(x == "1"){
        this._router.navigate(['/CustomerDashboard']);
        localStorage.setItem("customer",this.cusername);
        alert("correct")
      }
      else {
        alert("Invalid Credentials")
      }
    })
  }

  constructor(private _service: CustomerService, private _router : Router) {
    this.cusername="";
    this.cpassword="";
    this.isFormSubmitted=false;
   }

  ngOnInit(): void {
  }

}
