import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  counter:number=0;

  cani=[
    { nome: 'Doggo',
      razza: 'Razza di cane',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`
    },
    { nome: 'Doggo2',
      razza: 'Razza di cane2',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`
    },
    { nome: 'Doggo3',
      razza: 'Razza di cane3',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`
    }



  ]



}
