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