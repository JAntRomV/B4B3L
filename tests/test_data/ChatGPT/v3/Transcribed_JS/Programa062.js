const n = 5;
let fact = 1;
for (let k = 1; k <= n; k++) {
    fact *= k;
}
console.log(`Factorial de ${n} = ${fact}`);