import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Wallet } from '../wallet';

@Component({
  selector: 'app-customer-wallets',
  templateUrl: './customer-wallets.component.html',
  styleUrls: ['./customer-wallets.component.css']
})
export class CustomerWalletsComponent implements OnInit {

  wallet : Observable<Wallet[]>;
  customer1 : Customer
  
  constructor(private _service: CustomerService) {
    this.customer1 = localStorage.getItem('customerdata')? JSON.parse(localStorage.getItem('customerdata')):[];
     //alert(this.customer1.customerid)
   this.wallet = this._service.showCustomerWallets(this.customer1.customerid) 
   }

  ngOnInit(): void {
  }

}
