class Programa037 {
  constructor(texto) {
    this.texto = texto;
  }

  contarVocales() {
    let vocales = 0;
    for (let i = 0; i < this.texto.length; i++) {
      const caracter = this.texto[i].toLowerCase();
      if ('aeiou'.includes(caracter)) vocales++;
    }
    return vocales;
  }
}

const programa = new Programa037("Aprendiendo a programar");
console.log(`Texto: ${programa.texto}`);
console.log(`Vocales: ${programa.contarVocales()}`);