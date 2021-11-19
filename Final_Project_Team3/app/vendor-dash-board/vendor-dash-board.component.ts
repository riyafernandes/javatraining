import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-dash-board',
  templateUrl: './vendor-dash-board.component.html',
  styleUrls: ['./vendor-dash-board.component.css']
})
export class VendorDashBoardComponent implements OnInit {

  user:string
  vendor : Observable<Vendor>
  ven : Vendor
  constructor(private _service : VendorService ) {

    this.user = localStorage.getItem("vendor")
    this._service.showVendorInfo(this.user).subscribe(x=>{
      this.ven=x
      localStorage.setItem('vendordata', JSON.stringify(x));
    })
   // this.vendor = this._service.showVendorInfo(this.user) //to store this in local storage
    
   // localStorage.setItem('vendordata', JSON.stringify(this.vendor));

   }

  ngOnInit(): void {
  }

}
