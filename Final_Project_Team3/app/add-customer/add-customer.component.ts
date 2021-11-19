import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})


export class AddCustomerComponent implements OnInit {
  msg : string;
  customers : Customer;
addCustomer() {
    this._service.addCustomer(this.customers).subscribe(x => {
      this.msg = x;
   })
   alert("Added");
 }
    constructor(private _service : CustomerService) { 
      this.customers= new Customer();
    }

  ngOnInit(): void {
  }

}
