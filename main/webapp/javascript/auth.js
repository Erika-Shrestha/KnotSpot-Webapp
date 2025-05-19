/**
 * 
 */

//performs the shift between registration and form page
function formToggle(){
	const container = document.querySelector('.main-container');
	const registerBtn = document.querySelector('.register-btn');
	const loginBtn = document.querySelector('.login-btn');
	
	registerBtn.addEventListener('click',() =>{
		container.classList.add('active');
	});
	
	loginBtn.addEventListener('click',() =>{
		container.classList.remove('active');
	});
}

formToggle()