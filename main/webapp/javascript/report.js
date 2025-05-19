/**
 * 
 */

/** sets the line chart report page */
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
	
	/** sets the bar chart report page */
document.addEventListener("DOMContentLoaded", function () {
      const ctx = document.getElementById('registerBar').getContext('2d');
	  const barColors = [
	      '#FF6384', '#36A2EB', '#FFCE56', '#4BC0C0', '#9966FF'
	    ];
      new Chart(ctx, {
        type: 'bar',
        data: {
          labels: registrationData.labels,
          datasets: [{
            label: 'Registered Users',
            data: registrationData.counts,
            backgroundColor: barColors,
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