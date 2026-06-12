let a = [6, 12, 18, 4, 10];
let min = a[0], max = a[0];
for (let v of a) {
    if (v < min) min = v;
    if (v > max) max = v;
}
console.log(`Min=${min}, Max=${max}`);