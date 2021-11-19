import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {

  uid:number;
  customer: Observable<Customer>;
  search(){
    this.customer=this._service.searchCustomer(this.uid)
  }
  constructor(private _service: CustomerService) { }

  ngOnInit(): void {
  }

}
