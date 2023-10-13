$(document).ready(function(){
    $("#produccion").on("click", function(){
      var valor =  $("select[name='inversion']").val();
      console.log(valor); 
    })
});