$(document).ready( function () {
    $('#MyDataTables').DataTable({
        responsive:true,
        language: {
            "lengthMenu": "Mostrar _MENU_",
            "zeroRecords": "Nothing found - sorry",
        },
        lengthMenu: [
            [10, 25, 50, -1],
            [10, 25, 50, 'All']
        ],
        dom: "<'row'<'col-sm-12 col-md-6'l B><'col-sm-12 col-md-6'f>>" +
        "<'row'<'col-sm-12'tr>>" +
        "<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>",
        buttons: [
            {
                text: '<i class="fa-solid fa-folder-plus"></i> Registrar',
                titleAttr: "Registrar Inversion",
                className:"btn btn-success ms-2 btn-dataTable",
                action: function ( e, dt, node, config ) {
                    alert( 'Button activated' );
                }
            }
        ]
    });
    
} );