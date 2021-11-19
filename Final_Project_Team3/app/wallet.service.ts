import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Wallet } from './wallet';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private _http : Http) { }


  showCustomerWallets(oid : number) : Observable<Wallet[]> {
    return this._http.get("http://localhost:8080/customerswallet/"+oid)
    .pipe(map((res: Response) => res.json()));
  }

  
  showCustomerWallet(oid : number,waltype:string) : Observable<Wallet> {
    return this._http.get("http://localhost:8080/customersonewallet/"+oid+"/"+waltype)
    .pipe(map((res: Response) => res.json()));
  }
}
