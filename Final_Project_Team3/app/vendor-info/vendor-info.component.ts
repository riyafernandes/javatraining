import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-info',
  templateUrl: './vendor-info.component.html',
  styleUrls: ['./vendor-info.component.css']
})
export class VendorInfoComponent implements OnInit {

  user:string
  vendor : Observable<Vendor>
  vendor1 : Vendor
  constructor(private _service : VendorService ) {
    this.user = localStorage.getItem("vendor")
    // this.vendor1 = localStorage.getItem('vendordata')? JSON.parse(localStorage.getItem('vendordata')):[];
    // alert(this.vendor1.vendorid)
    this.vendor = this._service.showVendorInfo(this.user) 
    
   }

  ngOnInit(): void {
  }

}
