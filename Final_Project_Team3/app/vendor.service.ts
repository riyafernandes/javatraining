import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import {  Observable } from 'rxjs';
import { Vendor } from './vendor';

import { map } from 'rxjs/operators';
import { Orders } from './orders';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private _http : Http) { }

  showVendors() : Observable<Vendor[]> {
    return this._http.get("http://localhost:8080/showvendor")
    .pipe(map((res: Response) => res.json())); }
    
  searchVendor(uid : number) : Observable<Vendor> {
    return this._http.get("http://localhost:8080/vendor/"+uid)
    .pipe(map((res: Response) => res.json()));  }

  loginVendor(vusername: string, vpassword:string) : Observable<String> {
    return this._http.get("http://localhost:8080/vendorAuthenticate/"+vusername+"/"+vpassword)
    .pipe(map((res: Response) => res.json()));       }

    showVendorInfo(vusername : string) : Observable<Vendor> {
    return this._http.get("http://localhost:8080//showonevendor/"+vusername)
    .pipe(map((res: Response) => res.json()));       }  

    showVendorOrders(vid : number) : Observable<Orders[]> {
      return this._http.get("http://localhost:8080/vendorsorder/"+vid)
      .pipe(map((res: Response) => res.json()));    
    }
  
    showVendorPendingOrders(vid : number) : Observable<Orders[]> {
      return this._http.get("http://localhost:8080/vendorspendingorder/"+vid)
      .pipe(map((res: Response) => res.json()));    
    } 
    addVendor(vendor : Vendor) : Observable<string> {
      return this._http.post("http://localhost:8080/addvendor/",vendor)
      .pipe(map((res : Response) => res.text()));
    }
}
