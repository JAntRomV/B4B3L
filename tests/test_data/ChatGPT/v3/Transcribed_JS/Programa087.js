class Programa087 {
  constructor() {
    this.texto = "Aprendiendo a programar";
    this.vocales = this.contarVocales(this.texto);
    console.log(`Texto: ${this.texto}`);
    console.log(`Vocales: ${this.vocales}`);
  }

  contarVocales(s) {
    let c = 0;
    for (let k = 0; k < s.length; k++) {
      const ch = s.charAt(k).toLowerCase();
      if (ch === 'a' || ch === 'e' || ch === 'i' || ch === 'o' || ch === 'u') c++;
    }
    return c;
  }
}

const programa = new Programa087();