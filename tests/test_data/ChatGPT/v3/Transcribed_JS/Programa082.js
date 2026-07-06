const factorial = (n) => {
    let fact = 1;
    for (let k = 1; k <= n; k++) {
        fact *= k;
    }
    return fact;
};

const n = 5;
const fact = factorial(n);
console.log(`Factorial de ${n} = ${fact}`);