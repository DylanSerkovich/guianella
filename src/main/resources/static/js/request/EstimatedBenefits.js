$(document).ready(function(){
    $("#estimacion").on("click", function(){
        const costoKiloInput = $("#costoKilo");
        const rendimientoInput = $("#rendimiento");
        const sizeTrazoInput = $("#sizeTrazo");
        const servicioPoloInput = $("#servicioPolo");
        const colleretaInput = $("#collereta");
        const tabla = $("#tblData");


        let costoKilo = $("#costoKilo").val();
        let rendimiento = $("#rendimiento").val();
        let sizeTrazo = $("#sizeTrazo").val();
        let servicioPolo = $("#servicioPolo").val();
        let collereta = $("#collereta").val();

        // if (isNaN(costoKilo) || isNaN(rendimiento) || isNaN(sizeTrazo) || isNaN(servicioPolo) || isNaN(collereta)) {
        //     alert("Por favor, ingrese valores numéricos válidos.");
        //     return;
        //   }

        const modelos = obtenerObjetosDeTabla()
        console.log(modelos);

        let costoPorMetro = costoKilo/rendimiento;
        console.log("Costo por metro: "+costoPorMetro);

        let costoPorTrazo = costoPorMetro*sizeTrazo;
        console.log("Costo por trazo: "+costoPorTrazo);

        let ventasModelos = 0;
        let cantidadPolos = 0;

        modelos.forEach(function (modelo) {
            var cantidad = modelo.cantidad;
            var precio = modelo.precio;

            ventasModelos += cantidad*precio;
            cantidadPolos += cantidad;
        })

        let servicioTotal = cantidadPolos*servicioPolo;

        console.log("Cantidad: "+cantidadPolos);

        let costos = parseFloat(costoPorTrazo) + parseFloat(servicioTotal) + parseFloat(collereta);

        console.log("Costos: " + costos);
        console.log("Ventas: " + ventasModelos);

        beneficioPolo = (ventasModelos - costos)/cantidadPolos;

        console.log(beneficioPolo);

        $("#costoMetroSpan").text("Costo por Metro: " + costoPorMetro.toFixed(2));
        $("#costoTrazoSpan").text("Costo por Trazo: " + costoPorTrazo.toFixed(2));
        $("#cantidadPolosSpan").text("Cantidad de Polos: " + cantidadPolos.toFixed(2));
        $("#costoEstimadosSpan").text("Costo Estimado: " + parseFloat(costos).toFixed(2));
        $("#ventaEstiamadoSpan").text("Venta Estimado: " + ventasModelos);
        $("#beneficioSpan").text("Beneficio por Polo: " + beneficioPolo.toFixed(2));

    })

    function obtenerObjetosDeTabla() {
        var objetos = [];
    
        $("#tblData tbody tr").each(function () {
          var descripcion = $(this).find("td:eq(0)").text();
          var cantidad = parseFloat($(this).find("td:eq(1)").text());
          var precio = parseFloat($(this).find("td:eq(2)").text());
    
          if (!isNaN(cantidad) && !isNaN(precio)) {
            objetos.push({
              descripcion: descripcion,
              cantidad: cantidad,
              precio: precio,
            });
          }
        });
    
        return objetos;
      }
});