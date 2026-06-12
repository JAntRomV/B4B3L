class Programa093 {
  constructor() {
    const n = 14;
    let a = 0;
    let b = 1;
    console.log(`Fibonacci (${n}): `);
    for (let k = 0; k < n; k++) {
      console.log(a + (k < n-1 ? `, ` : `\n`));
      const c = a + b;
      a = b;
      b = c;
    }
  }
}

const programa = new Programa093();