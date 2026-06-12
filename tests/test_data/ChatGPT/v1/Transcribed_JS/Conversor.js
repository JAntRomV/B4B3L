class Conversor {
  constructor() {
    this.convertirTemperatura();
  }

  async convertirTemperatura() {
    const temperaturaCelsius = await this.ingresarTemperatura();
    const fahrenheit = (temperaturaCelsius * 9/5) + 32;
    console.log(`Equivalente en Fahrenheit: ${fahrenheit}`);
  }

  async ingresarTemperatura() {
    const respuesta = await prompt("Ingrese la temperatura en Celsius: ");
    return parseFloat(respuesta);
  }
}

const conversor = new Conversor();