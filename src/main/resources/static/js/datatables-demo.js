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
        ]
    });
    
} );