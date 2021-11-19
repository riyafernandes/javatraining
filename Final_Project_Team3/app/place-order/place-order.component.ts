import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { Menun } from '../menun';
import { MenunService } from '../menun.service';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  cus:Customer;
  orderdetails:Orders;
  menu:Observable<Menun[]>;
  menufound:Menun;
  price:number;
  vendor:Observable<Vendor[]>;
  wallet:Observable<Wallet[]>;
  msg:string;
  placeOrder() {
    // alert("hello");
    this.orderdetails.orderbillamount= this.orderdetails.orderquantity*this.price;
    this._orderService.placeOrder(this.orderdetails).subscribe(x => {
     this.msg = x;
 
   })
  //  alert(this.msg);
 }
  constructor(private _menuService:MenunService, private _vendorService:VendorService, private _walletService:WalletService,  private _orderService:OrdersService) { 
    this.orderdetails= new Orders();
   
    this.cus = localStorage.getItem('customerdata')?JSON.parse(localStorage.getItem('customerdata')):[]
    // alert(this.cus.customerid);
    this.orderdetails.customerid=this.cus.customerid;
    this.menu=this._menuService.showMenu();
    this.vendor= this._vendorService.showVendors();
    this.wallet= this._walletService.showCustomerWallets(this.cus.customerid);
  }
  
  showAmount(){
    // alert(this.orderdetails.menuid);
    this._menuService.searchMenu(this.orderdetails.menuid).subscribe(x => {
      this.menufound = x;
      this.price= x.menuprice;

      
    });
   }

  ngOnInit(): void {
  }

}
