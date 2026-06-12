const factorial = (n) => {
    let fact = 1;
    for (let k = 1; k <= n; k++) {
        fact *= k;
    }
    return fact;
}

const n = 5;
console.log(`Factorial de ${n} = ${factorial(n)}`);