const a = [16, 12, 8, 4, 0];
let min = a[0], max = a[0];
for (const v of a) {
    if (v < min) min = v;
    if (v > max) max = v;
}
console.log(`Min=${min}, Max=${max}`);