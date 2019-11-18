import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { typeWithParameters } from '@angular/compiler/src/render3/util';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  listAmount: number = 0;
  list: any = null;
  greeting: string = "Loading..."

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(environment.mainUrl + "grocery-lists/get").toPromise().then(r => {
      this.list = r;
      this.listAmount = this.list.length;
      if (this.list == '') {
        this.greeting = "There doesn't appear to be any lists. Create one!"
      } else {
        this.greeting = JSON.stringify(this.list);
      }
    })
  }

}
