import { Injectable } from '@angular/core';
import { Http , Response} from '@angular/http';
import { Observable } from 'rxjs';
import { Menun } from './menun';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MenunService {

  constructor(private _http : Http) { }


  showMenu() : Observable<Menun[]> {
    return this._http.get("http://localhost:8080//showmenu")
    .pipe(map((res: Response) => res.json()));
  }
  searchMenu(vid : number) : Observable<Menun> {
    return this._http.get("http://localhost:8080/menu/"+vid)
    .pipe(map((res: Response) => res.json()));
  }
  addMenu(menun : Menun) : Observable<string> {
    return this._http.post("http://localhost:8080/addmenu/",menun)
    .pipe(map((res : Response) => res.text()));
  }
}
