
let tareas = []
let celdas = Array.from(document.getElementsByClassName('celda'))
const anadirTareaBotonJs = document.getElementById('anadirTareaBoton')
const verTareasBotonJs = document.getElementById('verTareasBoton')
const verTiemposBotonJs = document.getElementById('verTiemposBoton')
const borrarBoton = document.getElementById('deleteButton')
verTareasBotonJs.addEventListener('click', mostrarTareas)
verTiemposBotonJs.addEventListener('click', mostrarTiempos)
borrarBoton.addEventListener('click', borrarTarea)
const jsonUrl = 'https://jsonplaceholder.typicode.com/posts'



celdas.forEach(celda => {
    const optionTable = document.createElement('option')
    optionTable.innerText = "Empty"
    celda.append(optionTable)
})


let form = document.getElementById('form')
form.addEventListener('submit', function(e){
    e.preventDefault()
    var name = document.getElementById('name').value
    fetch(jsonUrl, {
        method:'POST',
        body:JSON.stringify({
            name:name
        }),
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        } 
    })
    .then(function(response){
        return response.json()
    })
    .then(info=>{
        console.log(info)
        tareas.push(name)
        localStorage.setItem("tasks", JSON.stringify(tareas))
            celdas.forEach(celda => {
                const option = document.createElement('option') 
                option.innerText = `${name}`
                celda.append(option)  
            })
            }
        )
        Swal.fire({
            text: 'Tarea agregada con éxito',
            icon: 'success',
            confirmButtonText: 'Ok'
          })
        Toastify({
            text: "Se ha añadido una nueva tarea",
            duration: 3000,
            style: {
                background: "linear-gradient(to right, #151314, #FFFF33)",
              },
        }).showToast()
    })
    




    
// Método para mostrar tiempo usado y libre
function mostrarTiempos(){
    alert("Su cantidad de horas usadas es de: " + " " + horasUsadas)
    alert("Tiene un %" + " " + calcularTiempoLibre(horasUsadas) + " " + "de tiempo libre en el día.")
}
function calcularTiempoLibre(horasUsadas){
    horasLibres = 24 - horasUsadas
    tiempoLibre = (horasUsadas*100)/24
    return tiempoLibre
}

// Método para mostrar tareas agregadas

function mostrarTareas(){
    if(tareas.length !== 0){
        Swal.fire({
            title: 'Tasks: ',
            text: `${tareas.join(', ')}`,
            icon: 'success',
            confirmButtonText: 'Ok'
          })
    } else {
        Swal.fire({
            text: 'No tasks have been added yet.',
            icon: 'error',
            confirmButtonText: 'Ok'
          })
    }
    
}

function borrarTarea(){
    if(tareas.length > 1){
        tareas.pop()
        Swal.fire({
            title: 'Task eliminated succesfully, remaining tasks are: ',
            text: `${tareas.join(', ')}`,
            icon: 'success',
            confirmButtonText: 'Ok'
          })

    } else if(tareas.length === 1){
        tareas.pop()
        Swal.fire({
            text: 'No more tasks remaining.',
            icon: 'success',
            confirmButtonText: 'Ok'
          })
    }
     else {
        Swal.fire({
            text: 'No tasks have been added yet.',
            icon: 'error',
            confirmButtonText: 'Ok'
          })
    }
}









