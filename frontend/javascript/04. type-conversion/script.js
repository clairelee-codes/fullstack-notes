let val;
val = String(111);
val = String(8+4);


val = String(false);

val = String(new Date())

val = String([1,2,3,4,5]);

val = (5).toString();

val = Number('1')
val = Number(true)  // 1
val = Number(false) // 0
val = Number(null)  // 0
val = Number([1,2,3]); // NaN

val = parseInt('111.40');
val = parseFloat('111.40');

console.log(val);
console.log(typeof val);
console.log(val.length);

// 자바스크립트 자동 타입 변환
const val1 = String(2);
const val2=3;
const sum = val1+val2;

console.log(sum);
console.log(typeof sum);

