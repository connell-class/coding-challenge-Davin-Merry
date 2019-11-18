import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

enum types {
  FOOD, ELECTRONICS, CLOTHING, COSMETICS, TOYS, HEALTHCARE
}

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})

export class GroceryListComponent implements OnInit {
  @Input()
  listInfo: any;
  
  editEnabled: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  editMode() {
    this.editEnabled = !this.editEnabled;
  }

  submitItem(form: NgForm) {
    let n = form.value.item;
    let v = form.value.type;
    //console.log(n + ' ' + v);
    this.http.post(environment.mainUrl + "grocery-lists/items/add/" + this.listInfo.id, {
      id: 0,
      name: n,
      type: v
    }).toPromise().then(r => {
      console.log(r);
      this.listInfo.groceries.push({id: -1, name: n, type: types[v]});
    })
  }

}
