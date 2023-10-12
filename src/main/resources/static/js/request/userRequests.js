$(function () {
    $("#Add_user").submit(function (e) {
      //Prevent default submission of form
      e.preventDefault();
      var form = $("#Add_user");
      let inputs = form.find(":input:not(:submit):not(button)");
      
    //   inputs.removeClass("is-valid is-invalid").next(".feedback").remove();
      $("#create_account").prev(".alert.alert-danger").remove();
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

  $(function () {
    $("#update_user").submit(function (e) {
      //Prevent default submission of form
      e.preventDefault();
      var form = $("#update_user");
      console.log(form.serialize());
      //let inputs = form.find(":input:not(:submit):not(button)");
      
    //   inputs.removeClass("is-valid is-invalid").next(".feedback").remove();
      $("#update_account").prev(".alert.alert-danger").remove();
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
        url: form.attr("action"),
        type: "PUT",
        data: form.serialize(),
        success: function (res) {
          Swal.close();
            if (res.exists) {
              $("#update_account").before(
                '<div  class="alert alert-danger" style="grid-column: 1 / -1;">El correo o usuario ya esta registrado</div>'
              );
            } else {
              localStorage.setItem("Status", "¡Usuario Actualizado!");
              window.location.reload();
            }
        },
      });
    });
  });

  function findRecord(id) {
    console.log(id);
    var form = $("#update_user");
    //let inputs = form.find(":input:not(:submit):not(button)");
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
      url: "/usuarios/usuario?user_id=" + id,
      type:"GET",
      success: function (findUser) {
        console.log(findUser);
        form.attr("action",`/usuarios/${findUser.idUser}/usuario`)


        form.find("input[name='username']").val(findUser.username);
        form.find("input[name='firstname']").val(findUser.firstname);
        form.find("input[name='lastname']").val(findUser.lastname);
        form.find("input[name='email']").val(findUser.email);
        
        form.find("input[name='enable']").prop("checked", findUser.enable);

        var valorRol = findUser.roles[0].rolId;
        console.log(valorRol);
        form.find("select[name='idRol']").val(valorRol);

        Swal.close();
        $('#UpdateModal').modal('show');
        // Remove it
        // deleteRowUser2(index);
        //window.location.reload();
        //$("#row-" + id).remove();
      },
      error: function (xhr, status, error) {
        console.error(error);
      },
    });
    //table.refresh();
  }

  $(document).ready(function() {
    // Agregar un manejador de eventos para el evento 'hidden.bs.modal'
    $('#UpdateModal').on('hidden.bs.modal', function () {
      // Obtener el formulario dentro del modal
      var form = $('#update_user');

      form.attr('action', '');
  
      // Limpiar los valores de los campos de entrada
      form.find('input[type="text"]').val('');
      form.find('input[type="email"]').val('');
      form.find('input[type="checkbox"]').prop('checked', false);
  
      // Deseleccionar el select
      form.find('select').prop('selectedIndex', -1);
    });
  });
  
  

  $(document).ready(function () {
    $("table").on("change", ".user-status", function () {
      //var id = $(this).closest("tr").attr("id").split("-")[1];
      var id = $(this).attr("data-id");
      
      console.log("Checkbox Seleccionado")

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