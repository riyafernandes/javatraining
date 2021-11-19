import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-accept-reject',
  templateUrl: './accept-reject.component.html',
  styleUrls: ['./accept-reject.component.css']
})
export class AcceptRejectComponent implements OnInit {

  ven : Vendor
  oid:number;
  venId:number;
  ordStatus:string;
  result:string;
  constructor(private _orderservice:OrdersService) {
    this.ven = localStorage.getItem('vendordata')?JSON.parse(localStorage.getItem('vendordata')):[]
    this.venId= this.ven.vendorid;
    this.oid= parseInt(localStorage.getItem("oid"));
   }
   acceptReject(){
    this._orderservice.acceptrejectorders(this.oid,this.venId,this.ordStatus).subscribe
    (x=>{
      this.result=x;
    })
   }

  ngOnInit(): void {
  }

}
