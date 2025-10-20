// 자바스크립트는 동적 타입
// 모든 타입의 값으로 할당 (및 재할당) 가능
let foo = 42;   // number
foo = 'bar';    // string
foo = true;     // boolean
console.log(typeof foo);

// 원시 타입 : Call Stack 메모리에 저장
const name = 'han';
const age = 30;
const hasJob = true;
const car = null;   // null
let anything;   // undefined
const sym = Symbol();   // symbol


// 참조 타입 : Heap 메모리에 저장
const hobbies = ['walking', 'books'];   // Array
const address = {                       // object
    province: '경기도',
    city: '성남시'
}

console.log(typeof hobbies);    // object
console.log(Array.isArray(address)) // 배열 타입 확인법

