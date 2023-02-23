var a: string="salutoni"
var b: number=3
var c: any
var d: [number, string]=[1, "tuple!"]
var e: boolean=true


a="una prova"

b=534
//b="non si può fare"

c=3
c="come javascript!"
c=true

d=[2, "sempreTuple!"]

type test={
    numero: number
    descrizione: string
}

var test1:test={
    numero: 1,
    descrizione: "ciao" 
}

test1.descrizione="una prova";

console.log(a,b,c,d,e, test1)

class ClasseTest{

    private valore:number

    constructor(private readonly nome: string, private descrizione: string){
        this.valore=0;
    }

    dichiara(): void{
        console.log('oggetto:'+this.nome+', descrizione:'+this.descrizione+', valore:'+this.valore)
    }

    aumentaVal(): void{
        this.valore=this.valore+1;
        console.log("valore di"+this.nome+"= "+this.valore)
    }
}

class ClasseTestFiglia extends ClasseTest{

    constructor(nome:string, descrizione:string, private stato:string){
        super(nome, descrizione)
    }
}

let prova:ClasseTest

prova = new ClasseTest('prova1', 'oggetto di prova');

prova.dichiara()
prova.aumentaVal()
prova.dichiara()