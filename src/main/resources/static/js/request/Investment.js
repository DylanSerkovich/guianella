$(function () {
    $("#crear_inversion").submit(function (e) {
      //Prevent default submission of form
      e.preventDefault();
      var form = $("#crear_inversion");
      let inputs = form.find(":input:not(:submit):not(button)");
      let unidadValor = form.find("select[name='unidad']").val();
      console.log(unidadValor);

      var telasList = [];


      var $tabla = $('#tblData');

      $tabla.find('tbody tr').each(function () {
        var $fila = $(this);
        var tela = {
          tipo: $fila.find('td:eq(0)').text(),
          color: $fila.find('td:eq(1)').text(),
          rendimiento: $fila.find('td:eq(2)').text(),
          cantidad: $fila.find('td:eq(3)').text(),
          costo: $fila.find('td:eq(4)').text(),
        };
    
        // Agrega el objeto a la lista
        telasList.push(tela);
      });

      var inversion = {
        unidad: unidadValor,
        telas:telasList
      }

      console.log(inversion);

      $.ajax({
        url:form.attr("action"),
        contentType: "application/json", 
        type: "POST",
        data: JSON.stringify(inversion),
        success: function (res){
          localStorage.setItem("Status", "¡Nueva Inversion Registrada!");
          window.location.reload();
        }
      })
      
    });
  });

function findIngresosRecord(id){
  Swal.fire({
    title: "Comprobando...",
    html: "Espere un momento",
    icon: "info",
    showCancelButton: false,
    showConfirmButton: false,
    showCloseButton: false,
    allowEscapeKey: false,
    allowOutsideClick: false,
    willOpen: () => {
      Swal.showLoading();
    },
  });

  $.ajax({
    url: `/inversiones/${id}/ingresos`,
    type:"GET",
    success: function (ingresos){
      console.log(ingresos);
      construirTablaPorductos(ingresos);
      Swal.close();
      $('#FindIngresos').modal('show');
    },
    error: function (xhr, status, error) {
      console.error(error);
    },
  })

}

function findCostRecord(id){
  let totalCostTela = 0;
  Swal.fire({
    title: "Comprobando...",
    html: "Espere un momento",
    icon: "info",
    showCancelButton: false,
    showConfirmButton: false,
    showCloseButton: false,
    allowEscapeKey: false,
    allowOutsideClick: false,
    willOpen: () => {
      Swal.showLoading();
    },
  });

  $.ajax({
    url: `/inversiones/${id}/costos`,
    type:"GET",
    success: function (Cost) {
      console.log(Cost);
      totalCostTela = contruirTablaTelas(Cost);
      $('#totalCostTelaTitle').text(`Costo de Inversion: S/${totalCostTela}`);
      $('#totalCostTela').text(` S/${totalCostTela}`);

      if(Cost.confeccion){
        $('#servicioTotalPolo').text(` S/${Cost.confeccion.servicePolo}`);
        $('#servicioCortacinta').text(` S/${Cost.confeccion.serviceCortacinta}`);
        $('#servicioBoton').text(` S/${Cost.confeccion.serviceBoton}`);
        $('#costoBoton').text(` S/${Cost.confeccion.costBoton}`);
        const totalConfeccion = Math.round((Cost.confeccion.servicePolo+Cost.confeccion.serviceCortacinta+Cost.confeccion.serviceBoton+Cost.confeccion.costBoton) * 100) / 100;
        $('#costoTotalConfeccion').text(` S/${totalConfeccion}`);
        $('#totalCostConfeccionTitle').text(`Costo de Confeccion: S/${totalConfeccion}`);
      }
      //costBoton
      //serviceBoton
      //serviceCortacinta
      //servicePolo

      Swal.close();
      $('#FindCost').modal('show');
      
    },
    error: function (xhr, status, error) {
      console.error(error);
    },
  });
}

function contruirTablaTelas(Cost){
  const table = document.getElementById('table-tela');

  const tbody = table.querySelector('tbody');

  let total = 0;


  Cost.telas.forEach((tela) => {
    const row = tbody.insertRow();
    const tipoCell = row.insertCell(0);
    const colorCell = row.insertCell(1);
    const rendimientoCell = row.insertCell(2);
    const cantidadCell = row.insertCell(3);
    const costoCell = row.insertCell(4);
    const SubTotal = row.insertCell(5);
    
    total= total + Math.round((tela.costo*tela.cantidad) * 100) / 100;

    tipoCell.textContent = tela.tipo;
    colorCell.textContent = tela.color;
    rendimientoCell.textContent = tela.rendimiento;
    cantidadCell.textContent = tela.cantidad;
    costoCell.textContent = tela.costo;
    SubTotal.textContent = Math.round((tela.costo*tela.cantidad) * 100) / 100;
  });
  return Math.round(total * 100) / 100;
}

function construirTablaPorductos(ingresos){
  const table = document.getElementById('table-producto');

  const tbody = table.querySelector('tbody');

  ingresos.products.forEach((product) => {
    const row = tbody.insertRow();
    const ModeloCell = row.insertCell(0);
    const CantidadCell = row.insertCell(1);
    const precioUCell = row.insertCell(2);
    const subTotalCell = row.insertCell(3);

    ModeloCell.textContent = product.modelo;
    CantidadCell.textContent = product.cantidad;
    precioUCell.textContent = product.precioU;
    subTotalCell.textContent = Math.round((product.cantidad*product.precioU) * 100) / 100;
  });

  $('#totalIngresos').text(` S/${ingresos.totalIngresos}`);

}

$(document).ready(function() {
  // Agregar un manejador de eventos para el evento 'hidden.bs.modal'
  $('#FindCost').on('hidden.bs.modal', function () {
    $("#table-tela").find("tr:gt(0)").remove();
  });

  $('#FindIngresos').on('hidden.bs.modal', function () {
    $("#table-producto").find("tr:gt(0)").remove();
  });
});