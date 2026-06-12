class Programa092 {
    constructor() {
        this.n = 5;
        this.fact = 1;
        this.calcularFactorial();
    }

    calcularFactorial() {
        for (let k = 1; k <= this.n; k++) {
            this.fact *= k;
        }
        console.log(`Factorial de ${this.n} = ${this.fact}`);
    }
}

const programa = new Programa092();