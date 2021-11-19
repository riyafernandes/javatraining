import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  styleUrls: ['./add-vendor.component.css']
})
export class AddVendorComponent implements OnInit {
  vendors : Vendor;
addVendor() {
    this._service.addVendor(this.vendors).subscribe(x => {
   })
   alert("Added");
 }
    constructor(private _service : VendorService) { 
      this.vendors= new Vendor();
    }
  ngOnInit(): void {
  }

}
