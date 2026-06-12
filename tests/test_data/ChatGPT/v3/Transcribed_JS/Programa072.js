class Programa072 {
  constructor(n) {
    this.n = n;
  }

  calcularFactorial() {
    let fact = 1;
    for (let k = 1; k <= this.n; k++) {
      fact *= k;
    }
    return fact;
  }
}

const n = 5;
const programa = new Programa072(n);
const fact = programa.calcularFactorial();
console.log(`Factorial de ${n} = ${fact}`);