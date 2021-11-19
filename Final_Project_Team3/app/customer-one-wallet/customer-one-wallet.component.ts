import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Wallet } from '../wallet';

@Component({
  selector: 'app-customer-one-wallet',
  templateUrl: './customer-one-wallet.component.html',
  styleUrls: ['./customer-one-wallet.component.css']
})
export class CustomerOneWalletComponent implements OnInit {

  wsource:string;
  wallet: Observable<Wallet>;
  customer1 : Customer
  search(){
    this.wallet=this._service.showCustomeroneWallets(this.customer1.customerid,this.wsource)
   
  }
  constructor(private _service: CustomerService) {
    this.customer1 = localStorage.getItem('customerdata')? JSON.parse(localStorage.getItem('customerdata')):[];
   }

  ngOnInit(): void {
  }

}
