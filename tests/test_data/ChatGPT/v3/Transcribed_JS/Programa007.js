class Programa007 {
  constructor() {
    const s = "Aprendiendo a programar";
    let c = 0;
    for (let k = 0; k < s.length; k++) {
      const ch = s.charAt(k).toLowerCase();
      if (['a', 'e', 'i', 'o', 'u'].includes(ch)) c++;
    }
    console.log(`Texto: ${s}`);
    console.log(`Vocales: ${c}`);
  }
}

const programa = new Programa007();