import { HttpClientService, Employee } from '../service/http-client.service';
import { Component, HostListener, Input, OnInit, ViewChild } from '@angular/core';
import {MatListModule} from '@angular/material/list';
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import {take} from 'rxjs/operators';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
  employees!: Employee[];
  sortedColumn$: any;


  constructor(private HttpClientService: HttpClientService) { }

  @Input('sortable-column')
    columnName: string | undefined;

    @Input('sort-direction')
    sortDirection: string = '';

    @HostListener('click')
    sort() {
        this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    }
  ngOnInit(): void {
    this.HttpClientService.getEmployees().subscribe(
      response =>{this.employees = response;}
     );

  }
  sortOn(column: string) {
    this.sortedColumn$.next(column);
  }


  handleSuccessfulResponse(response: Employee[])
  {
    this.employees = response;
  }

  deleteEmployee(employee: Employee): void {
    this.HttpClientService.deleteEmployee(employee)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee);
      })
  };

}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
  { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
  { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
  { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
  { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
  { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
  { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
  { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
  { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
  { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
];
