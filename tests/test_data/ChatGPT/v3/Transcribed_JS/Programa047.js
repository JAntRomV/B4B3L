class Programa047 {
  constructor() {
    const s = "Aprendiendo a programar";
    let c = 0;
    for (const ch of s.toLowerCase()) {
      if ('aeiou'.includes(ch)) c++;
    }
    console.log(`Texto: ${s}`);
    console.log(`Vocales: ${c}`);
  }
}

new Programa047();