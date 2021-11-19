import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-dash-board',
  templateUrl: './customer-dash-board.component.html',
  styleUrls: ['./customer-dash-board.component.css']
})
export class CustomerDashBoardComponent implements OnInit {

  user:string
  vendor : Observable<Customer>
  cus : Customer
  constructor(private _service : CustomerService ) {

    this.user = localStorage.getItem("customer")
    this._service.showCustomerInfo(this.user).subscribe(x=>{
      this.cus=x
      localStorage.setItem('customerdata', JSON.stringify(x));
    })
  }
  ngOnInit(): void {
  }

}
