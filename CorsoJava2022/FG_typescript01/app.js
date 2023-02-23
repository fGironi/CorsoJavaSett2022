"use strict";
var a = "salutoni";
var b = 3;
var c;
var d = [1, "tuple!"];
var e = true;
a = "una prova";
b = 534;
//b="non si può fare"
c = 3;
c = "come javascript!";
c = true;
d = [2, "sempreTuple!"];
var test1 = {
    numero: 1,
    descrizione: "ciao"
};
test1.descrizione = "una prova";
console.log(a, b, c, d, e, test1);
class ClasseTest {
    constructor(nome, descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.valore = 0;
    }
    dichiara() {
        console.log('oggetto:' + this.nome + ', descrizione:' + this.descrizione + ', valore:' + this.valore);
    }
    aumentaVal() {
        this.valore = this.valore + 1;
        console.log("valore di" + this.nome + "= " + this.valore);
    }
}
class ClasseTestFiglia extends ClasseTest {
    constructor(nome, descrizione, stato) {
        super(nome, descrizione);
        this.stato = stato;
    }
}
let prova;
prova = new ClasseTest('prova1', 'oggetto di prova');
prova.dichiara();
prova.aumentaVal();
prova.dichiara();
