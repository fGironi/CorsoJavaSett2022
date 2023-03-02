import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prova',
  templateUrl: './prova.component.html',
  styleUrls: ['./prova.component.css']
})
export class ProvaComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  persons=[
    {id: 0, firstName: "Mario", lastName: "Rossi", isOnline: true},
    {id: 1,firstName: "Giovanni", lastName: "Bianchi", isOnline: true},
    {id: 2,firstName: "Luigi", lastName: "Verdi", isOnline: true},
    {id: 3,firstName: "Carla", lastName: "Neri", isOnline: true},
    {id: 4,firstName: "Simona", lastName: "De Colori", isOnline: true}
  ]

  changeStatus(id:number){
    this.persons[id].isOnline=!this.persons[id].isOnline;
  }

}
