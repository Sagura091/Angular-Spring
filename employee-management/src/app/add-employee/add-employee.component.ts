
import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from '../service/http-client.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee = new Employee(0,"","","",0);
 //httpClientService!: HttpClientService;
  constructor(private httpClientService: HttpClientService) { }

  ngOnInit(): void {
  }

  CreateEmployee(): void {
    this.httpClientService.createEmployee(this.user)
        .subscribe( data => {
          alert("Employee created successfully.");
        });
  }
}
