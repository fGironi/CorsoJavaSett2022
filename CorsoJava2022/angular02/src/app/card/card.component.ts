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

  testo:string="prova"

  cani=[
    { nome: 'Doggo0',
      razza: 'Razza di cane1',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`,
      isLiked: false
    },
    { nome: 'Doggo1',
      razza: 'Razza di cane2',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`,
      isLiked: false
    },
    { nome: 'Doggo2',
      razza: 'Razza di cane3',
      descrizione: `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.
                     A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally
                     bred for hunting.`,
      isLiked: false
                    }

  ]

  increaseCounter():void{
    this.counter++
    if (this.counter>=this.cani.length) this.counter=0;
  }

  likeDoggo(event: Event){
    this.cani[this.counter].nome="Doggo"+this.counter+" <3";
    this.cani[this.counter].isLiked=true;


  }

}
