// Set new default font family and font color to mimic Bootstrap's default styling

function number_format(number, decimals, dec_point, thousands_sep) {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}
var ctx = document.getElementById("myAreaChart");

// Area Chart Examplw
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
    datasets: [{
      label: "Ganancias",
      lineTension: 0.3,
      backgroundColor: "rgba(78, 115, 223, 0.05)",
      borderColor: "rgba(78, 115, 223, 1)",
      pointRadius: 3,
      pointBackgroundColor: "rgba(78, 115, 223, 1)",
      pointBorderColor: "rgba(78, 115, 223, 1)",
      pointHoverRadius: 3,
      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
      pointHitRadius: 10,
      pointBorderWidth: 2,
      data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
    }],
  },
  options: {
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0
      }
    },
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false,
          drawBorder: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          maxTicksLimit: 5,
          padding: 10,
          // Include a dollar sign in the ticks
          callback: function(value, index, values) {
            return '$' + number_format(value);
          }
        },
        gridLines: {
          color: "rgb(234, 236, 244)",
          zeroLineColor: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2]
        }
      }],
    },
    legend: {
      display: false
    },
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      intersect: false,
      mode: 'index',
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
          return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
        }
      }
    }
  }
});


$.ajax({
  url: "/inversiones/ganancias",
  type: "GET",
  success: function (res) {
    if (res && res.gananciasPorMes) {
      // Obtener los arrays de meses y ganancias
      const meses = res.gananciasPorMes.map(item => transformarCadena(item.mes));
      const ganancias = res.gananciasPorMes.map(item => item.ganancia);
      dataGanancia(ganancias);
      myLineChart.data.labels=meses;
      myLineChart.data.datasets[0].data = ganancias;
      myLineChart.update();

      console.log("Meses:", meses);
      console.log("Ganancias:", ganancias);
    }
  },
});

function dataGanancia(ganancias){
  const ultimoElemento = ganancias[ganancias.length - 1];
  // Obtener la suma de todos los elementos de ganancias
  const sumaGanancias = ganancias.reduce((total, ganancia) => total + ganancia, 0);

  const sumaRound = Math.round(sumaGanancias * 100) / 100
  $("#ganancias_mes").text(`S/.${ultimoElemento}`);
  $("#ganancias_anual").text(`S/.${sumaRound}`);
}

function transformarCadena(cadena) {
  // Convertir toda la cadena a minúsculas
  let cadenaMinusculas = cadena.toLowerCase();
  // Tomar solo los primeros 3 caracteres
  let primerosTresCaracteres = cadenaMinusculas.substring(0, 3);
  // Convertir la primera letra a mayúscula
  let resultado = primerosTresCaracteres.charAt(0).toUpperCase() + primerosTresCaracteres.slice(1);
  return resultado;
}
