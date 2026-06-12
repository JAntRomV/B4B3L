const n = 16;
let a = 0, b = 1;
console.log(`Fibonacci (${n}):`);
for (let k = 0; k < n; k++) {
    console.log(`${a}${k < n-1 ? ', ' : '\n'}`);
    let c = a + b;
    a = b;
    b = c;
}