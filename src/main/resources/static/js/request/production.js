$(document).ready(function(){
    $("#produccion").on("click", function(){
      var IdInversion =  $("select[name='inversion']").val();
      if(IdInversion){

        var $tabla = $('#tblData');

        var productList = [];

        $tabla.find('tbody tr').each(function () {
          var $fila = $(this);
          var product = {
            modelo: $fila.find('td:eq(0)').text(),
            cantidad: $fila.find('td:eq(1)').text(),
            precioU: $fila.find('td:eq(2)').text(),
          };
      
          // Agrega el objeto a la lista
          productList.push(product);
        });

        var confeccion = {
          servicePolo: $("#servicePolo").val(),
          serviceCortacinta: $("#cortaCinta").val(),
          serviceBoton: $("#serviceBoton").val(),
          costBoton:$("#costBoton").val()
        }

        var NewProduction = {
          products: productList,
          confeccion: confeccion
        }

        console.log(NewProduction);

        $.ajax({
          url:`/produccion/${IdInversion}/inversion`,
          contentType: "application/json", 
          type: "POST",
          data: JSON.stringify(NewProduction),
          success: function (res){
            //localStorage.setItem("Status", "¡Nueva Produccion Registrada!");
            //window.location.reload();
          }
        })
        
      }
    })
});