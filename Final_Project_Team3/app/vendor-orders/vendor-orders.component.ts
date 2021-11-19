import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../orders';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-orders',
  templateUrl: './vendor-orders.component.html',
  styleUrls: ['./vendor-orders.component.css']
})
export class VendorOrdersComponent implements OnInit {

  orders : Observable<Orders[]>;
  vendor1 : Vendor
  
  constructor(private _service: VendorService) {
    this.vendor1 = localStorage.getItem('vendordata')? JSON.parse(localStorage.getItem('vendordata')):[];
     //alert(this.vendor1.vendorid)
   this.orders = this._service.showVendorOrders(this.vendor1.vendorid) 
   }

  ngOnInit(): void {
  }

}
