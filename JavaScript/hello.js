console.log("hello");

const x =13.13;

let x1 ="amzing";


console.log(x1)

let Tarek={
    firstName:"Tarek",
    lastName:"Ajouka",
    user:x1,
    age:13,
    fullName:function (){
        return this.firstName+" "+this.lastName
    }
}

console.log(Tarek.fullName())
console.log(typeof Tarek)


