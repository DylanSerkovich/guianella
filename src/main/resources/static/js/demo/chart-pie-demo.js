// Set new default font family and font color to mimic Bootstrap's default styling


// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Direct", "Referral", "Social"],
    datasets: [{
      data: [5, 6, 7],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

$.ajax({
  url: "/usuarios/count",
  type: "GET",
  success: function (res) {
    if (res && res.countUserRol) {
      const rol = res.countUserRol.map(item => item.rolName);
      const numero = res.countUserRol.map(item => item.numUser);

      myPieChart.data.labels=rol;
      myPieChart.data.datasets[0].data = numero;
      myPieChart.update();
    }
  },
});

