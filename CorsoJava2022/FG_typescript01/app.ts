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