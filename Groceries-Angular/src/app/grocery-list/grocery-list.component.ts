import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {
  @Input()
  listInfo: any;

  constructor() { }

  ngOnInit() {
  }

}
