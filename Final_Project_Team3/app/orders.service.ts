import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Orders } from './orders';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private _http : Http) { }

  placeOrder(orders : Orders) : Observable<string> {
    return this._http.post("http://localhost:8080/placeOrder/",orders)
    .pipe(map((res : Response) => res.text()));
  }
  acceptrejectorders(oid:number,vid:number,status:string) : Observable<string> {
    return this._http.post("http://localhost:8080/acceptOrRejectOrder/"+oid+"/"+vid+"/"+status,null)
    .pipe(map((res : Response) => res.text()));
  }
}
