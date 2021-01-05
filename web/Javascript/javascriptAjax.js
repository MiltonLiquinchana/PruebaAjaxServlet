
/* global fetch */
var formulario = document.getElementById("formulario");//obtengo el formulario por su ID
formulario.addEventListener('submit', function (e) {//Agrego un evento submit y ejecuto una funcion
    e.preventDefault();//Ago que el formulario no se envie por el metodo get
    var datos = new FormData(formulario);//obtengo los datos del formulario
    fetch('Servidor', {//defino la url del servidor
        method: 'POST',//defino el nuevo metodo por el cual enviar los datos
        headers: {//defino los header para especificar el tipo de contenido(objeto) a enviar
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)//defino el contenido y lo encodeo a tipo JSON
    }).then(response => response.json())//obtengo la respuesta del servidor
            .catch(error => console.error('Error:', error))//se ejecuta en caso de algun problema con la respuesta del server
            .then(response => console.log('Success:', response));//obtengo los datos del servidor e imprimo

});








































//;
//function enviar(e) {
//    e.preventDefault();
//    fetch('Servidor?id=1',{
//      method: 'POST'
//  })
//  .then(response => response.json())
//  .then(data => console.log(data));
//}
//;
//function imprimir(data) {
//    //console.log(data);
//    //ref_in[1].value = data.codigo;
//    console.log(data);
//}
//;

//function imprimir(data) {
//
//    res.innerHTML = '';
//    res.innerHTML = `<option value="">Seleccione una opcion</option>`;
//    for (let item of data) {
//        console.log(item.pk);
//        res.innerHTML += `<option value="${item.pk}">${item.codigo}</option>`;
//    }
//}
//;

//function rellenar() {
//    ref_in[1].value = res.value;
//}

