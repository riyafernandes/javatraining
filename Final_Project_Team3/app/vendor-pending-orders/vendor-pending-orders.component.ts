import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-pending-orders',
  templateUrl: './vendor-pending-orders.component.html',
  styleUrls: ['./vendor-pending-orders.component.css']
})
export class VendorPendingOrdersComponent implements OnInit {

  // orders : Observable<Orders[]>;
  // vendor1 : Vendor
  
  // constructor(private _service: VendorService) {
  //   this.vendor1 = localStorage.getItem('vendordata')? JSON.parse(localStorage.getItem('vendordata')):[];
  //    //alert(this.vendor1.vendorid)
  //  this.orders = this._service.showVendorPendingOrders(this.vendor1.vendorid) 
  //  }

   user:string
  vendor : Observable<Vendor>
  ven : Vendor
  orders : Observable<Orders[]>

oid : number;
status(ordId : number) {
this.oid = ordId;
alert(this.oid);
localStorage.setItem("oid",this.oid.toString());
this._router.navigate(['../acceptreject'], {relativeTo: this._route});
}

  
  constructor(private _router:Router,private _route:ActivatedRoute,private _service : VendorService) { 
    this.user = localStorage.getItem("vendor")
    this.ven = localStorage.getItem('vendordata')?JSON.parse(localStorage.getItem('vendordata')):[]
    //alert(this.ven.ven_id)
    this.orders = this._service.showVendorPendingOrders(this.ven.vendorid)

   //this.vendor = this._service.searchVendor(this.ven.ven_id)
    
   

  }
  ngOnInit(): void {
  }

}
