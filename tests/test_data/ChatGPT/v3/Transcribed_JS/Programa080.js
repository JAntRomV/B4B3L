class Programa080 {
  constructor() {
    this.a = [10, 13, 16, 19, 22, 25];
    this.ordena();
    console.log(`Ordenado: ${this.a.join(' ')}`);
  }

  ordena() {
    for (let i1 = 0; i1 < this.a.length - 1; i1++) {
      for (let j = 0; j < this.a.length - 1 - i1; j++) {
        if (this.a[j] > this.a[j + 1]) {
          [this.a[j], this.a[j + 1]] = [this.a[j + 1], this.a[j]];
        }
      }
    }
  }
}

const programa = new Programa080();