import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Menun } from '../menun';
import { MenunService } from '../menun.service';

@Component({
  selector: 'app-show-menu',
  templateUrl: './show-menu.component.html',
  styleUrls: ['./show-menu.component.css']
})
export class ShowMenuComponent implements OnInit {

  menus : Observable<Menun[]>;
    constructor(private _service : MenunService) { 
      this.menus = this._service.showMenu();
    }

  ngOnInit(): void {
  }

}
