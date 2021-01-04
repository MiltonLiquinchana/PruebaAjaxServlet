
/* global fetch */
var formulario = document.getElementById("formulario");
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    fetch('Servidor', {
        method: 'POST',
        body: JSON.stringify(datos),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
            .catch(error => console.error('Error:', error))
            .then(response => console.log('Success:', response));

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

