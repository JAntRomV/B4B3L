const leerNumero = async () => {
  const respuesta = await prompt("Ingrese un número: ");
  return parseInt(respuesta);
};

class Factorial {
  constructor(numero) {
    this.numero = numero;
  }

  calcularFactorial() {
    let factorial = 1;
    for (let i = 1; i <= this.numero; i++) {
      factorial *= i;
    }
    return factorial;
  }
}

const main = async () => {
  const numero = await leerNumero();
  const factorial = new Factorial(numero);
  const resultado = factorial.calcularFactorial();
  console.log(`El factorial de ${numero} es: ${resultado}`);
};

main();