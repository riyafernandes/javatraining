import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {

  user:string
  customer : Observable<Customer>
  customer1 : Customer
  constructor(private _service : CustomerService ) {
    this.user = localStorage.getItem("customer")
    
    this.customer = this._service.showCustomerInfo(this.user) 
    
   }

  ngOnInit(): void {
  }

}
