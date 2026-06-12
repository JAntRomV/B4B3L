class Programa057 {
    constructor() {
        this.s = "Aprendiendo a programar";
        this.c = 0;
        this.contarVocales();
        console.log(`Texto: ${this.s}`);
        console.log(`Vocales: ${this.c}`);
    }

    contarVocales() {
        for (let k = 0; k < this.s.length; k++) {
            const ch = this.s.charAt(k).toLowerCase();
            if (ch === 'a' || ch === 'e' || ch === 'i' || ch === 'o' || ch === 'u') this.c++;
        }
    }
}

const programa = new Programa057();