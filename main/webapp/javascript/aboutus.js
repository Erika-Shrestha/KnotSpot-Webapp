/**
 * 
 */

const counters = document.querySelectorAll(".span-text");
const container = document.querySelector(".mid-div");

let activated = false;

window.addEventListener("scroll",() => {
	if(
		pageYOffset > container.offsetTop - container.offsetHeight - 450
		&& activated === false
	){
		counters.forEach(counter =>{
			counter.innerText =0;
			
			let count = 0;
			
			function updateCount(){
				
				const target = parseInt(counter.dataset.val);
				
				if(count < target){
					
					count +=5;
					
					counter.innerText = count;
					
					setTimeout(updateCount, 1);
				}
				else{
					
					counter.innerText = target;
				}
			}
			
			updateCount();
			
			activated = true;
		});
	}
	else if(pageYOffset < container.offsetTop - container.offsetHeight - 500
		|| pageYOffset === 0
		&& activated === true
	){
		counters.forEach(counter =>{
			counter.innerText =0;
		});
		
		activated = false;
	}
});