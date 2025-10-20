// Window 객체
// 1. 브라우저에 의해 자동으로 생성됨.
// 2. 웹 브라우저의 창(Window)을 나타냄.
// 3. Window는 브라우저의 객체 (javascript의 객체 아님)
// 4. 브라우저 창에 대한 정보을 알 수 있고 제어할수 있음.
//5. var키워드로 변수를 선언하고나 함수를 선언하면 이 Window 객체의 프로퍼티가 됨.

// Alert
// alert('Hellow World');

// Prompt
// const input = prompt();
// alert(input);

// Confirm
// if(confirm('Yes or No')) {
//     console.log('Yes');
// } else{
//     console.log('No');
// }

let val;

// outer height and width
val = window.outerHeight;
val = window.outerWidth;
console.log(val);

// inner height and width
val = window.innerHeight;
val = window.innerWidth;
console.log(val);

// Scroll points
val = window.scrollY;
val = window.scrollX;
console.log(val);

// Location Object
val = window.location;
val = window.location.hostname;
val = window.location.port;
val = window.location.href;
val = window.location.search;
console.log(val);

// Redirect
// window.location.href = 'http://google.com';
//Reload
// window.location.reload();

// History object
window.history.go(-2);
val = window.history.length;
console.log(val);

// Navigator Object
val = window.navigator;
val = window.navigator.userAgent;
val = window.navigator.language;

console.log(val);

var greeting = 'hello';
function doGreeting() {
    return greeting;
}

console.log(window.greeting);   // hello
console.log(window.doGreeting());
