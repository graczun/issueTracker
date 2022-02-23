import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";

@Component({
  selector: 'project',
  templateUrl: './project.component.html'
})

export class ProjectComponent implements OnInit {

  userName: string;

  constructor(private http: HttpClient) {
    this.userName = "";
  }

  ngOnInit() {
    let url = 'http://localhost:8080/api/project/1';

    let headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Basic ' + sessionStorage.getItem('token')
    });

    let options = {headers: headers};
    this.http.get<Project>(url, options).subscribe(project => {
        this.userName = project.name;
      },
      error => {
        if (error.status == 401)
          alert('Unauthorized');
      }
    );
  }

  logout() {
    sessionStorage.setItem('token', '');
  }
}

export class Project {
  name: string;
  url: string;

  constructor(private name_: string, private url_: string) {
    this.name = name_;
    this.url = url_;
  }

}
