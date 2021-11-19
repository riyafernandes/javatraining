import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-login',
  templateUrl: './vendor-login.component.html',
  styleUrls: ['./vendor-login.component.css']
})
export class VendorLoginComponent implements OnInit {

  vendor : string;
  vusername : string;
  vpassword : string;
  status: Observable<string>;
  isFormSubmitted : boolean;
  vendorlogin(vendorloginForm : NgForm){
    if (vendorloginForm.invalid) {
      return;
    }
    this.isFormSubmitted = true;
     this._service.loginVendor(this.vusername, this.vpassword).subscribe( x => {
     
       if(x == "1"){
        
         this._router.navigate(['/VendorDashboard']);
         localStorage.setItem("vendor",this.vusername);
       }

 
 
     })
     
     }
     constructor(private _service: VendorService, private _router : Router) { 
      this.vusername="";
      this.vpassword="";
      this.isFormSubmitted=false;
     }

  ngOnInit(): void {
  }

}
