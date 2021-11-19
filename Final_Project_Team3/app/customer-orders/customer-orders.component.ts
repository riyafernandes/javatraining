import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Orders } from '../orders';

@Component({
  selector: 'app-customer-orders',
  templateUrl: './customer-orders.component.html',
  styleUrls: ['./customer-orders.component.css']
})
export class CustomerOrdersComponent implements OnInit {

  orders : Observable<Orders[]>;
  customer1 : Customer
  
  constructor(private _service: CustomerService) {
    this.customer1 = localStorage.getItem('customerdata')? JSON.parse(localStorage.getItem('customerdata')):[];
     //alert(this.customer1.customerid)
   this.orders = this._service.showCustomerOrders(this.customer1.customerid) 
   }

  ngOnInit(): void {
  }

}
