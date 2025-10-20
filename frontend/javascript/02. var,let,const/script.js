// var 
// 중복 선언 O, 재할당 O
var greeting1 = 'hello';
console.log(greeting1);

var greeting1 = 'hi';
console.log(greeting1);

greeting1 = 'how are you';
console.log(greeting1);

// 함수 레벨 스코프
function func1() {
    if(true) {
        var a= 'a';
        console.log(a);
    }
    console.log(a)
}

func1();
// console.log(a);
// script.js:55 Uncaught ReferenceError: a is not defined

//  호이스팅 O, undefined 할당 O
console.log(hosting1);  // undefined
var hosting1 = 'hosting';



// let
// 중복 선언 X, 재할당 O
let greeting2 = 'hello';
console.log(greeting2);

// let greeting2 = 'hi';
// console.log(greeting2);
// Uncaught SyntaxError: Identifier 'greeting2' has already been declared

greeting2 = 'how are you?';
console.log(greeting2);

// const
// 중복 선언 X, 재할당 X
const greeting3 = 'hello';
console.log(greeting3);

// const greeting3 = 'hi';
// console.log(greeting);
// Uncaught SyntaxError: Identifier 'greeting3' has already been declared

// greeting = 'how are you?';
// console.log(greeting);
// Uncaught TypeError: Assignment to constant variable


// let, const => block 레벨 스코프
function func2() {
    if(true){
        const a = 'a';
        console.log(a);
    }
    // console.log(a)
    // script.js:64 Uncaught ReferenceError: a is not defined
}
func2();

//  let, const => 호이스팅 O, undefined 할당 X
// console.log(hosting2);
// script.js:87 Uncaught ReferenceError: Cannot access 'hosting2' before initialization
let hosting2 = 'hosting';



// 함수 호이스팅
func3();
function func3() {
    console.log('func3 histing test');
}

