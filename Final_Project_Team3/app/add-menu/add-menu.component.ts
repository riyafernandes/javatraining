import { Component, OnInit } from '@angular/core';
import { Menun } from '../menun';
import { MenunService } from '../menun.service';

@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {

  menus : Menun;
  addMenu() {
      this._service.addMenu(this.menus).subscribe(x => {
     })
     alert("Added");
   }
      constructor(private _service : MenunService) { 
        this.menus= new Menun();
      }

  ngOnInit(): void {
  }

}
