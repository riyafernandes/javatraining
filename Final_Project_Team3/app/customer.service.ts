import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Orders } from './orders';
import { map } from 'rxjs/operators';
import { Wallet } from './wallet';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private _http : Http) { }
  searchCustomer(uid : number) : Observable<Customer> {
    return this._http.get("http://localhost:8080/customer/"+uid)
    .pipe(map((res: Response) => res.json()));       
  }
  showCustomers() : Observable<Customer[]> {
    return this._http.get("http://localhost:8080/showcustomer")
    .pipe(map((res: Response) => res.json()));   }

  loginCustomer(cusername: string, cpassword:string) : Observable<String> {
   return this._http.get("http://localhost:8080//customerAuthenticate/"+cusername+"/"+cpassword)
  .pipe(map((res: Response) => res.json()));   }

  showCustomerInfo(cusername : string) : Observable<Customer> {
    return this._http.get("http://localhost:8080//showonecustomer/"+cusername)
    .pipe(map((res: Response) => res.json()));   }

  showCustomerOrders(cid : number) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/customersorder/"+cid)
    .pipe(map((res: Response) => res.json()));   }

  showCustomerPendingOrders(cid : number) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/customerspendingorder/"+cid)
    .pipe(map((res: Response) => res.json()));   }

    showCustomerWallets(cid : number) : Observable<Wallet[]> {
      return this._http.get("http://localhost:8080/customerswallet/"+cid)
      .pipe(map((res: Response) => res.json()));   }
    
  
  showCustomeroneWallets(cid : number, source : string) : Observable<Wallet> {
    return this._http.get("http://localhost:8080//customersonewallet/"+cid+"/"+source)
    .pipe(map((res: Response) => res.json()));   }
   
   
    addCustomer(customer : Customer) : Observable<string> {
      return this._http.post("http://localhost:8080/addcustomer/",customer)
      .pipe(map((res : Response) => res.text()));
    }
  }
  
  