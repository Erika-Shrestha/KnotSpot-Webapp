/**
 * 
 */

/** This function helps to display menu container when user profile is clicked */
function toggleMenu(){
	let menu = document.getElementById("menu");
	menu.classList.toggle("open-menu");
}

/** This function helps to hide the user-menu pop up*/
function hideUserMenu(){
	let menuContainer = document.querySelector(".menu-container");
	if(menuContainer){
		menuContainer.classList.remove("open-menu");
	}
}

/** This function helps to identify whether the clicked element is outside the user profile container */
document.addEventListener('click', function(event){
	let userProfile = document.querySelector(".user-pic");
	if(!userProfile.contains(event.target)){
		hideUserMenu();
	}
});

document.querySelector(".user-pic").addEventListener("click", function(event) {
    toggleMenu();
});
