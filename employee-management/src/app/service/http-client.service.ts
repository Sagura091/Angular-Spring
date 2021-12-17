
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

export class Employee{

  constructor(public id: Number, public designation:string, public employeeId: string, public name: string, public salary:Number) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private HttpClient:HttpClient) { }

  getEmployees() {
    console.log("Test Call");
    return this.HttpClient.get<Employee[]>('http://localhost:8080/employees');
  }

   deleteEmployee(employee: Employee) {

    return this.HttpClient.delete<Employee>("http://localhost:8080/employees" + "/delete/" + employee.id);

  }

  createEmployee(employee: Employee)
  {

   console.log(employee);
   return this.HttpClient.post<Employee>("http://localhost:8080/employees/" + "add",employee);
  }

  updateEmployee(employee: Employee)
  {
    return this.HttpClient.put<Employee>("http://localhost:8080/employees" + "/update",employee)

  }
}
