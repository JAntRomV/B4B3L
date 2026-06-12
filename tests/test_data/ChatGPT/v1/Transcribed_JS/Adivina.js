const random = Math.floor(Math.random() * 10) + 1;
let intento = prompt("Adivina el número (entre 1 y 10): ");

if (intento == random) {
    console.log(`¡Correcto! Adivinaste el número.`);
} else {
    console.log(`Incorrecto, el número era: ${random}`);
}