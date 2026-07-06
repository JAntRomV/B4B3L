class Programa010 {
  constructor() {
    this.a = [20, 23, 26, 29, 32, 35];
    this.burbuja();
    this.imprimir();
  }

  burbuja() {
    for (let i1 = 0; i1 < this.a.length - 1; i1++) {
      for (let j = 0; j < this.a.length - 1 - i1; j++) {
        if (this.a[j] > this.a[j + 1]) {
          [this.a[j], this.a[j + 1]] = [this.a[j + 1], this.a[j]];
        }
      }
    }
  }

  imprimir() {
    console.log(`Ordenado: ${this.a.join(' ')}`);
  }
}

const programa = new Programa010();