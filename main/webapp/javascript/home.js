/**
 * 
 */

class Card{
	constructor(cardElement){
		this.cardElement = cardElement
		this.imageWrapper = cardElement.querySelector('.image-wrapper')
		const cardHeight = this.cardElement.getBoundingClientRect().height
		const imageWrapperHeight = this.imageWrapper.getBoundingClientRect().height
		this.heightDiff = cardHeight - imageWrapperHeight
		console.log('card created')
	}
	
	update(){
		const topOffsetCard = this.cardElement.getBoundingClientRect().top
		const progress = topOffsetCard / window.innerHeight
		let yPosition = progress * this.heightDiff
		yPosition = Math.min(0, Math.max(yPosition, this.heightDiff));
		this.imageWrapper.style.transform = `translate(0, ${yPosition}px)`
		console.log('update')
			}
		}
		
function initCards(){
	const cardElements = document.querySelectorAll('.card')
	const cards = Array.from(cardElements).map((cardElement) => new Card(cardElement))
	
	function update(){
		cards.forEach(card => card.update())
	}
	
	function onScroll(){
		requestAnimationFrame(() =>{
			update()
		})
	}
	
	requestAnimationFrame(update)
		window.addEventListener('scroll', onScroll)
	}

initCards();
			

function initScrollVideo() {
    const video = document.getElementById('scrollVideo');
    const section = document.querySelector('.video-scroll-section');

	video.addEventListener('loadedmetadata', () => {
		const duration = video.duration;
		const sectionHeight = section.offsetHeight - window.innerHeight;

		function onScroll() {
			const scrollPosition = window.scrollY - section.offsetTop;
			const scrollFraction = Math.min(Math.max(scrollPosition / sectionHeight, 0), 1);
			video.currentTime = scrollFraction * duration;
		}

		window.addEventListener('scroll', onScroll);
		onScroll();
	});
}

document.addEventListener("DOMContentLoaded", function () {
    initScrollVideo();
});


document.addEventListener("DOMContentLoaded", function () {
    const rotatingImage = document.querySelector('.autoRotate');

    rotatingImage.classList.add('rotate');

    const observer = new IntersectionObserver(entries => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          rotatingImage.classList.remove('rotate'); 
        } else {
          rotatingImage.classList.add('rotate');
        }
      });
    }, {
      root: null,
      threshold: 0.98
    });

    observer.observe(rotatingImage);
});


let lastScrollY = window.scrollY;
document.querySelectorAll('.rec-desc').forEach(desc => {
  let rotated = false;
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      const currentScrollY = window.scrollY;
      const scrollingDown = currentScrollY > lastScrollY;
      if (entry.isIntersecting && scrollingDown && !rotated) {
        entry.target.style.transition = 'none';
        entry.target.style.transform = 'rotateX(0deg)';
        void entry.target.offsetWidth;
        entry.target.style.transition = 'transform 1.5s ease';
        entry.target.style.transform = 'rotateX(360deg)';
        rotated = true;
      }
      if (!entry.isIntersecting) {
        rotated = false;
      }
      lastScrollY = currentScrollY;
    });
  }, { threshold: 0.7 });
  observer.observe(desc);
});

//swiper initialize 
const swiper = new Swiper('.slider-wrapper', {
  loop: true,
  grabCursor: true,
  spaceBetween: 80,
  centeredSlides: true,

  pagination: {
    el: '.swiper-pagination',
	clickable: true,
	dynamicBullet: true
  },

  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
  
  //responsive breakpoints
  breakpoints:{
	0:{
		slidesPerView: 1
	},
	620:{
			slidesPerView: 2
	},
	1024:{
			slidesPerView: 3
	}
  }

});

//sticky navbar
const nav_bar = document.querySelector(".header");
const section_hero =  document.querySelector(".recommend-con");
const observer = new IntersectionObserver((entries)=>{
	const ent = entries[0];
	console.log(ent);
	ent.isIntersecting == false ? nav_bar.classList.add("sticky") : nav_bar.classList.remove("sticky");
},{
	root:null,
	rootMargin: "",
	threshold: 0,
	
});

observer.observe(section_hero);