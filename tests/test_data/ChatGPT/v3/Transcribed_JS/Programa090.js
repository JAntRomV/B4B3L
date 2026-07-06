const a = [30, 33, 36, 39, 42, 45];
for (let i1 = 0; i1 < a.length - 1; i1++) {
    for (let j = 0; j < a.length - 1 - i1; j++) {
        if (a[j] > a[j + 1]) {
            [a[j], a[j + 1]] = [a[j + 1], a[j]];
        }
    }
}
console.log(`Ordenado: ${a.join(' ')}`);