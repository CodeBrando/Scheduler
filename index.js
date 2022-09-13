
let tarea
let run = true
let opcion
let opcion2
let opcion3 = 1
let horasUsadas = 0
let horasLibres = 0
let porcentaje
let tiempoLibre = 0
let tareas = []
const selectTag = document.getElementById('listaDeTareas')

class Tarea{
    constructor(nombre, descripcion, recordatorio, hora, duracion){
        this.nombre = nombre
        this.descripcion = descripcion
        this.recordatorio = recordatorio
        this.hora = hora
        this.duracion = duracion

    }   
}

function horaDeTarea(tarea){
    tarea.hora = parseFloat(prompt("Ingrese la hora de la tarea (0.00 - 23.59): "))
    return tarea.hora;
}

function duracionDeTarea(tarea){
    tarea.duracion = parseFloat(prompt("Ingrese la duración de la tarea (0.00 - 23.59): "))
    return tarea.duracion;
}

function calcularTiempoLibre(horasUsadas){
    horasLibres = 24 - horasUsadas
    tiempoLibre = (horasUsadas*100)/24
    return tiempoLibre
}

function agregarTareas(tarea){
    tareas.push(tarea)
    return tareas;
}

// function compare(a, b) {
//     if ( a.hora < b.hora ){
//       return -1;
//     }
//     if ( a.hora > b.hora ){
//       return 1;
//     }
//     return 0;
// }

let tareasOrdenadas = tareas.sort((obj1, obj2)=>obj1.hora - obj2.hora) 






const pasearAlPerro = new Tarea("Pasear al perro", "Pasear al perro por el barrio durante aproximadamente media hora.", "Llevar bolsas de nylon.")
const estudiar = new Tarea("Estudiar", "Ponerse al día con las clases sin ver hasta el momento; practicar al menos una vez lo ya visto.", "Chequear qur no haya desafíos por entregar.")
const ocio = new Tarea("Ocio", "Tiempo de descanso  hasta la próxima tarea", "Ponerse al día con dailies en varios juegos.")
let nuevaTarea = new Tarea()

tareas.push(pasearAlPerro, estudiar, ocio)





// alert("Bienvenido a ScheTool!")
// alert("Aquí podrás crear horarios que se adopten a tu día a día.")


tareas.forEach(tarea=>{
    const option = document.createElement('option')
    option.innerText = `${tarea.nombre}`
    selectTag.append(option)
})


// while(run === true){
//     let tarea = parseInt(prompt("Ingrese la tarea que desea añadir: 1- Pasear al perro, 2- Estudiar, 3- Tiempo libre, 4- Crear una nueva tarea."))
    
    

//     if (tarea === 1){
//         horaDeTarea(pasearAlPerro)
//         if(pasearAlPerro.hora > 23.59){
//             do{
//                 alert("La hora no puede superar las 23.59 hs")
//                 horaDeTarea(pasearAlPerro)
//                 }
//                 while(pasearAlPerro.hora > 23.59)
//                 continue

//         }
//         duracionDeTarea(pasearAlPerro)
//         if(pasearAlPerro.duracion > 23.59){
//             do{
//                 alert("La duración no puede superar las 23.59 hs")
//                 duracionDeTarea(pasearAlPerro)
//                 }
//                 while(pasearAlPerro.duracion > 23.59)
//                 continue
//         }
//         horasUsadas = horasUsadas += pasearAlPerro.duracion
//         agregarTareas(pasearAlPerro);
        
        

//     } else if (tarea === 2){
//         horaDeTarea(estudiar)
//         if(estudiar.hora > 23.59){
//             do{
//                 alert("La hora no puede superar las 23.59 hs")
//                 horaDeTarea(estudiar)
//                 }
//                 while(estudiar.hora > 23.59)
//                 continue

//         }
//         duracionDeTarea(estudiar)
//         if(estudiar.duracion > 23.59){
//             do{
//             alert("La duración no puede superar las 23.59 hs")
//             duracionDeTarea(estudiar)
//             }
//             while(estudiar.duracion > 23.59)
//             continue
//         }
//         horasUsadas = horasUsadas += estudiar.duracion
//         agregarTareas(estudiar);

//     } else if (tarea === 3){
//         horaDeTarea(ocio)
//         if(ocio.hora > 23.59){
//             do{
//                 alert("La hora no puede superar las 23.59 hs")
//                 horaDeTarea(ocio)
//                 }
//                 while(ocio.hora > 23.59)
//                 continue

//         }
//         duracionDeTarea(ocio)
//         if(ocio.duracion > 23.59){
//             do{
//                 alert("La duración no puede superar las 23.59 hs")
//                 duracionDeTarea(ocio)
//                 }
//                 while(ocio.duracion > 23.59)
//                 continue
//         }
//         horasUsadas = horasUsadas += ocio.duracion
//         agregarTareas(ocio);

//     } else if (tarea === 4){
//         let nuevaTarea = new Tarea(prompt("Introduce el nombre de la tarea: "), prompt("Describe la tarea: "), prompt("Añade un recordatorio si fuese necesario: "))  
//         horaDeTarea(nuevaTarea)
//         if(nuevaTarea.hora > 23.59){
//             do{
//                 alert("La hora no puede superar las 23.59 hs")
//                 horaDeTarea(nuevaTarea)
//                 }
//                 while(nuevaTarea.hora > 23.59)
//                 continue

//         }
//         duracionDeTarea(nuevaTarea)
//         if(nuevaTarea.duracion > 23.59){
//             do{
//                 alert("La duración no puede superar las 23.59 hs")
//                 duracionDeTarea(nuevaTarea)
//                 }
//                 while(nuevaTarea.duracion > 23.59)
//                 continue
//         }
//         horasUsadas = horasUsadas += nuevaTarea.duracion
//         agregarTareas(nuevaTarea);

        
//     } else {
//         tarea = parseInt(prompt("Ingrese la tarea que desea añadir: 1- Pasear al perro, 2- Estudiar, 3- Tiempo libre, 4- Crear una nueva tarea."))
//         continue
//     }

//     opcion = parseInt(prompt("Desea ver sus tareas? 1- Si, 2- No"))
//     if(opcion === 1){
//         alert(JSON.stringify(tareasOrdenadas))
//     } 


    

//     opcion2 = parseInt(prompt("Desea seguir añadiendo tareas? 1- Si, 2- No"))
//     if (opcion2 === 2){
//         run = false
//     }

    // if (horasUsadas > 23.59){
    //     alert("Las horas usadas no pueden superar las 23.59")
       

    // }

    // Me gustaría poder limitar las horas del día, pero no sabría cómo hacer para que el usuario decida qué tarea eliminar cuando se pasa de horas
    
// }

// alert("Su cantidad de horas usadas es de: " + " " + horasUsadas)
// alert("Tiene un %" + " " + calcularTiempoLibre(horasUsadas) + " " + "de tiempo libre en el día.")




// En la próxima entrega se completarán las demás opciones de la página, además de profundizar en el horario cuando tenga que poner en práctica eventos. Realmente no tuve tiempo para aplicarle muchas más cosas de las que ya tenía armadas antes de DOM, pero para la próxima entrega planeo tener mucho más implementado.
