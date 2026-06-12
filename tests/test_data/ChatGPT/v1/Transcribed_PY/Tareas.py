import sys

def gestor_de_tareas():
    tareas = []
    print("Gestor de Tareas")
    while len(tareas) < 5:
        tarea = input("Ingrese una tarea (o 'salir' para terminar): ")
        if tarea.lower() == "salir":
            break
        tareas.append(tarea)

    print("\nTareas guardadas:")
    for i, tarea in enumerate(tareas, start=1):
        print(f"{i}. {tarea}")

if __name__ == "__main__":
    gestor_de_tareas()