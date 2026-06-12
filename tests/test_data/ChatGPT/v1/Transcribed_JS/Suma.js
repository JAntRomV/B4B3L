const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

class Suma {
  constructor() {
    this.obtenerNumeros();
  }

  async obtenerNumeros() {
    const num1 = await this.leerNumero('Ingrese el primer número: ');
    const num2 = await this.leerNumero('Ingrese el segundo número: ');
    const suma = num1 + num2;
    console.log(`La suma es: ${suma}`);
    readline.close();
  }

  leerNumero(mensaje) {
    return new Promise((resolve) => {
      readline.question(mensaje, (num) => {
        resolve(parseInt(num));
      });
    });
  }
}

new Suma();