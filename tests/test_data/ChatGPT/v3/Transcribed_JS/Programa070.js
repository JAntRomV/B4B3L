class Programa070 {
  constructor() {
    this.a = [40, 43, 46, 49, 2, 5];
    this.ordenar();
    console.log(`Ordenado: ${this.a.join(' ')}`);
  }

  ordenar() {
    for (let i1 = 0; i1 < this.a.length - 1; i1++) {
      for (let j = 0; j < this.a.length - 1 - i1; j++) {
        if (this.a[j] > this.a[j + 1]) {
          [this.a[j], this.a[j + 1]] = [this.a[j + 1], this.a[j]];
        }
      }
    }
  }
}

new Programa070();