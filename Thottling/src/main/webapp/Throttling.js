/**
 * 
 */

"use strict";

{
// 1. 기본 동작
const $basicBox = document.querySelector("#basic .scroll-box");
const $count = document.querySelector("#basic .count")
const $chaser = document.querySelector("#basic .chasing-image");
$basicBox.addEventListener("scroll", event => {
   $chaser.style.transform = `translateY(${event.currentTarget.scrollTop + 20}px)`;
  $count.textContent = parseInt($count.textContent)+1;
});
}

{
	
// 2. 쓰로틀링
const $basicBox1 = document.querySelector("#throttle .scroll-box");
const $count1 = document.querySelector("#throttle .count")
const $chaser1 = document.querySelector("#throttle .chasing-image");
  
let timer;
const throttle = (callback, delay) => {
  if(!timer) {
    timer = setTimeout(()=>{
      timer = null;
      callback();
    }, delay);
  }
}
  
$basicBox1.addEventListener("scroll", event => {
  const {currentTarget} = event;
  throttle(()=>{
    $chaser1.style.transform = `translateY(${currentTarget.scrollTop + 20}px)`;
    $count1.textContent = parseInt($count1.textContent)+1;
  }, 200);
});
}

{
// 3. 디바운싱
const $basicBox2 = document.querySelector("#debounce .scroll-box");
const $count2 = document.querySelector("#debounce .count")
const $chaser2 = document.querySelector("#debounce .chasing-image");
  
let timer;
const debounce = (callback, delay) => {
  if(timer){
    clearTimeout(timer);
  }
  timer = setTimeout(callback, delay);
}
  
$basicBox2.addEventListener("scroll", event => {
  const {currentTarget} = event;
  debounce(()=>{
    $chaser2.style.transform = `translateY(${currentTarget.scrollTop + 20}px)`;
    $count2.textContent = parseInt($count2.textContent)+1;
  }, 200);
});
}