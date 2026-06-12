class Tareas {
  constructor() {
    this.tareas = [];
  }

  async guardarTareas() {
    const readline = await import('readline').then(m => m.createInterface({
      input: process.stdin,
      output: process.stdout
    }));

    console.log("Gestor de Tareas");
    let contador = 0;

    while (contador < 5) {
      const tarea = await new Promise(resolve => readline.question('Ingrese una tarea (o \'salir\' para terminar): ', resolve));

      if (tarea.toLowerCase() === "salir") {
        break;
      }

      this.tareas.push(tarea);
      contador++;
    }

    readline.close();

    console.log("\nTareas guardadas:");
    this.tareas.forEach((tarea, indice) => {
      console.log(`${indice + 1}. ${tarea}`);
    });
  }
}

const tareas = new Tareas();
tareas.guardarTareas();