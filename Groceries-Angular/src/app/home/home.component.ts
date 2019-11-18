import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  alertActive: boolean = false;
  alertText: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  showAlert(text: string) {
    this.alertText = text;
    this.alertActive = true;

    setTimeout(() => this.alertActive = false, 4000);
  }

  createList(form: NgForm) {
    let name: string = form.value.listName;
    if (name.length >= 3) {
      this.http.post(environment.mainUrl + "grocery-lists/create", {
        id: 0,
        name: name
      }).toPromise().then(r => {
        this.showAlert('List successfully created!');
      })
    }
  }
}
