/**
 * 
 */

//performs dashboard charts display for registered date
document.addEventListener("DOMContentLoaded", function () {
      const ctx = document.getElementById('registerChart').getContext('2d');
      new Chart(ctx, {
        type: 'line',
        data: {
          labels: registrationData.labels,
          datasets: [{
            label: 'Registered Users',
            data: registrationData.counts,
            backgroundColor: 'rgba(228, 233, 247, 0.8)',
            borderColor: '#695CFE',
            borderWidth: 2,
            tension: 0.3,
            fill: true,
            pointRadius: 3
          }]
        },
        options: {
          responsive: true,
          plugins: {
            legend: {
              display: true
            }
          },
          scales: {
            y: {
              beginAtZero: false,
			  title: {
			          display: true,
			          text: 'Number of Users'
			   },
			  ticks: { stepSize: 1 }
            },
			x: {
		      title: {
		        display: true,
		        text: 'Date'
		      }
			}
          }
        }
      });
    });