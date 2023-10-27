$(document).ready( function () {

    let minDate, maxDate;
 
// Custom filtering function which will search data in column four between two values
    DataTable.ext.search.push(function (settings, data, dataIndex) {
    let min = minDate.val();
    let max = maxDate.val();
    let date = new Date(data[2]);
 
    if (
        (min === null && max === null) ||
        (min === null && date <= max) ||
        (min <= date && max === null) ||
        (min <= date && date <= max)
    ) {
        return true;
    }
    return false;
    });
 
// Create date inputs
    minDate = new DateTime('#min', {
     format: 'MMMM Do YYYY'
    });
    maxDate = new DateTime('#max', {
     format: 'MMMM Do YYYY'
    });


    let table = $('#MyDataTables').DataTable({
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

    document.querySelectorAll('#min, #max').forEach((el) => {
        el.addEventListener('change', () => table.draw());
    });
    
});