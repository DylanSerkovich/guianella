$(function () {
    $("#Add_user").submit(function (e) {
      //Prevent default submission of form
      e.preventDefault();
      var form = $("#Add_user");
      let inputs = form.find(":input:not(:submit):not(button)");
      
    //   inputs.removeClass("is-valid is-invalid").next(".feedback").remove();
      $("#create_account").prev(".validationLogin-message").remove();
      /**/
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
        url: "/usuarios/usuario",
        type: "POST",
        data: form.serialize(),
        success: function (res) {
          Swal.close();
            if (res.exists) {
              $("#create_account").before(
                '<div  class="alert alert-danger" style="grid-column: 1 / -1;">El correo o usuario ya esta registrado</div>'
              );
            } else {
              localStorage.setItem("Status", "¡Nuevo Usuario Registrado!");
              window.location.reload();
            }
        },
      });
    });
  });
  

  $(document).ready(function () {
    $("table input[type='checkbox']").change(function () {
      //var id = $(this).closest("tr").attr("id").split("-")[1];
      var id = $(this).attr("data-id");
      
      var valor = $(this).is(":checked");
      $.ajax({
        url: `/usuarios/${id}/estado`,
        type: "PATCH",
        data: {enabled:valor},
        success: function (response) {
          // Procesa la respuesta del servidor
        },
        error: function (xhr, status, error) {
          if (xhr.status == 404) {
            Swal.fire({
              icon: "error",
              title: "Error",
              text: "No se ha encontrado el registro",
            }).then(function () {
              window.location.reload();
            });
          }
        },
      });
    });
  });