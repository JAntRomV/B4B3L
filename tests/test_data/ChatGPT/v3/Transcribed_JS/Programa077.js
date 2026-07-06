class Programa077 {
  constructor() {
    this.texto = "Aprendiendo a programar";
    this.contarVocales();
  }

  contarVocales() {
    const textoMinuscula = this.texto.toLowerCase();
    const vocales = textoMinuscula.split('').filter(letra => 'aeiou'.includes(letra)).length;
    console.log(`Texto: ${this.texto}`);
    console.log(`Vocales: ${vocales}`);
  }
}

const programa = new Programa077();