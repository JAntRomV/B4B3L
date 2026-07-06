const datos = [6, 10, 4, 8];
let suma = 0;
for (const x of datos) suma += x;
const prom = suma / datos.length;
console.log(`Promedio = ${prom}`);