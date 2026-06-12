class Programa027 {
  constructor(texto) {
    this.texto = texto;
  }

  async contarVocales() {
    let vocales = 0;
    const textoMinuscula = this.texto.toLowerCase();
    for (let i = 0; i < textoMinuscula.length; i++) {
      const char = textoMinuscula[i];
      if (char === 'a' || char === 'e' || char === 'i' || char === 'o' || char === 'u') {
        vocales++;
      }
    }
    console.log(`Texto: ${this.texto}`);
    console.log(`Vocales: ${vocales}`);
  }
}

const programa = new Programa027('Aprendiendo a programar');
programa.contarVocales();