# Java Note

## 2. 시작하기 

<details>
<summary>주석, 자료형과 변수</summary>

### [2. 주석](./src/sec02/chap02)

```java
// 식별자 명명 관례
/*
 클래스: 대문자로 시작
 상수: 대문자와 _사용 PI, COMPANY_NAME
 변수나 매서드는 camal case사용 myName, addNewObject
 */
```

### [3. 자료형과 변수](./src/sec02/chap03)

```java
// 상수
// 💡 final 연산자 : 변수의 값을 바꾸지 못하게 만듦
final int INT_NUM = 1;
//INT_NUM = 2; // ⚠ 불가
```
</details>

## 3. 자료형과 연산자

<details>
<summary>정수 자료형들과 관련 연산자</summary>

### [1. 정수 자료형들과 관련 연산자](./src/sec03/chap01)

- long
```java
// ⭐ int의 범위를 벗어나는 수에는 리터럴 끝에 l 또는 L 명시 필요
long _8b_long1 = 123456789123456789L;

// 💡 가독성을 위해 아래와 같이 표현 가능 (자바7부터)
int _4b_int2 = 123_456_789;
long _8b_long2 = 123_456_789_123_456_789L;
```

- 명시적 형변환
```java
int intNum = 12345;
// ⚠ 강제로 범주 외의 값을 넣을 경우 값 손실
byte byteNum = (byte) intNum; // 💡 12345 % 128
```

- 연산
```java
byte b1 = 1;
byte b2 = 2;
short s1 = 1;
short s2 = 2;
// ⭐ byte와 short의 연산들은 int 반환
// ⚠ 아래는 모두 불가
// byte b3 = b1 + b2;
// short s3 = b1 + b2;
// short s4 = b1 + s2;
// short s5 = s1 + s2;
```
```java
long l1 = 1;
long l2 = 2;
// long끼리의 연산은 long 반환
//int l3 = l1 + l2;
```
```java
// ⚠ 정수 자료형의 계산은 소수점 아래를 '버림'
byte int1 = 5/2;
int int2 = 10;
int int3 = 3;
int int4 = int2 / int3;
```
```java
// 💡 자료형의 범위를 넘어가도록 숫자를 더하거나 뺄 경우 오버플로우
byte x = 127;
x += 1; // -128
byte y = -128;
y -= 1; // 127
```
```java
// ⚠ 리터럴에는 단항연산자 사용 불가
// int int5 = 3++;
// int int6 = --3;
```
</details>

<details>
<summary>실수 자료형들</summary>

### [2. 실수 자료형들](./src/sec03/chap02)

```java
// 부동소수점 개념 알기
// 오차
boolean bool = 0.1 + 0.2 == 0.3; // false
```

- double, float
```java
// ⭐ double이 범위도 넓고, 정밀도도 높음 확인
boolean bool1 = Float.MAX_VALUE < Double.MAX_VALUE;
boolean bool2 = Float.MIN_VALUE > Double.MIN_VALUE;

// 최대 정밀도 테스트
double dblNum = 0.123456789123456789;   // 0.12345678912345678
float fltNum = 0.123456789123456789f;   // 0.12345679;
// float은 뒤에 f 또는 F를 붙여 표현
```
```java
// ⭐ 큰 수(정확히 표현가능한 한도를 넘어서는)일 경우
long lng2 = Long.MAX_VALUE; // 9223372036854775807
// 가능한 최대 정확도로
float flt4 = lng2;          // 9.223372E18
double dbl4 = lng2;         // 9.223372036854776E18
```

- 연산
```java
// float끼리의 연산은 float 반환
float flt03 = flt01 + flt02;
// float과 double의 연산은 double 반환
//float flt04 = flt01 + dbl01; // ⚠ 불가
```
```java
// 부동소수점 방식상 오차 자주 있음
// 소수부가 2의 거듭제곱인 숫자간 연산은 오차 없음
double dbl07 = 0.25 * 0.5f;
double dbl08 = 0.5 + 0.25 + 0.125 + 0.0625;
double dbl09 = 0.0625f / 0.125;
```
```java
// 💡 리터럴로 작성시 double임을 명시하려면 .0을 붙여줄 것
double dbl5 = 5 / 2;
double dbl6 = 5.0 / 2;
double dbl7 = (double) 5 / 2;

// 💡 정수 자료형에 강제로 넣으면 소수부를 '버림'
 float fltNum = 4.567f;
double dblNum = 5.678;
int int2 = (int) fltNum;
int int3 = (int) dblNum;
```
</details>

<details>
<summary>문자 자료형, 불리언 자료형과 관련 연산자</summary>

### [3. 문자 자료형](./src/sec03/chap03)
```java
// 💡 리터럴에 더할 때와 변수에 더할 때 반환 자료형이 다름
char ch_a2 = 'A' + 1;
// char ch_a3 = ch_a1 + 1; // ⚠️ 불가
int int_a4 = ch_a1 + 1;
```
```java
// 💡 아래의 기능으로 문자가 의미하는 정수로 변환
int int_d1 = '1'-'0';
int int_d2 = '5'-'0';
int_d1 = Character.getNumericValue('1');
int_d2 = Character.getNumericValue('2');
```

```java
// 사전순 상 먼저 오는 쪽이 작음
boolean bool6 = 'A' < 'B';
boolean bool7 = '가' > '나';
```

### [4. 불리언 자료형과 관련 연산자](./src/sec03/chap04)
```java
//  💡 &&가 ||보다 우선순위 높음
boolean boolA = (num % 3 == 0) && (num % 2 == 0) || (num > 0) && (num > 10);
boolean boolB = (num % 3 == 0) && ((num % 2 == 0) || (num > 0)) && (num > 10);
```
```java
// 단축평가 short circuit
int a = 1, b = 2, c = 0, d = 0, e = 0, f = 0;

boolean bool1 = a < b && c++ < (d += 3);
boolean bool2 = a < b || e++ < (f += 3);

boolean bool3 = a > b && c++ < (d += 3); 
boolean bool4 = a > b || e++ < (f += 3);
```
```java
//  💡 삼항연산자도 단축평가 적용됨
int changed1 = x < y ? (x += 2) : (y += 2);
```
</details>

<details>
<summary>문자열 자료형과 기초 사용법, 문자열의 메소드들</summary>

### [5. 문자열 자료형과 기초 사용법](./src/sec03/chap05)
```java
// 리터럴로 생성
String hl1 = "Hello";
String hl2 = "Hello";
String wld = "World";

//  리터럴끼리는 == 을 사용하여 비교 가능
boolean bool1 = hl1 == hl2; // true
boolean bool2 = hl1 == wld; // false

// 인스턴스로 생성
String hl3 = new String("Hello");
String hl4 = new String("Hello");
String hl5 = hl4;

//  💡 인스턴스와 비교하려면 .equals 메소드를 사용해야 함
//   특별한 경우가 아니면 문자열은 .equals로 비교할 것
boolean bool3 = hl3 == hl4; // false

boolean bool4 = hl1.equals(hl2);
boolean bool5 = hl1.equals(hl3);
boolean bool6 = hl3.equals(hl4);
boolean bool7 = wld.equals(hl2);

//  같은 곳을 참조하는 인스턴스들
boolean bool8 = hl4 == hl5; // true

//  ⭐️ 각각의 메모리상 주소 식별자 비교
int hl1hash = System.identityHashCode(hl1); // 764308918
int hl2hash = System.identityHashCode(hl2); // 764308918
int hl3hash = System.identityHashCode(hl3); // 598446861
int hl4hash = System.identityHashCode(hl4); // 1161082381
int hl5hash = System.identityHashCode(hl5); // 1161082381
```

### [6. 문자열의 메소드들](./src/sec03/chap06)

- concat
```java
 // concat은 필요시에만 새 인스턴스 생성
String str_b1 = "ABC";
String str_b4 = str_b1 + "";
String str_b5 = str_b1.concat("");

int str_b1Hash = System.identityHashCode(str_b1);   // 1463801669
int str_b4Hash = System.identityHashCode(str_b4);   // 355629945
int str_b5Hash = System.identityHashCode(str_b5);   // 1463801669
```

```java
//  null이 포함될 경우
String str_c1 = null;

//  + 연산자는 null과 이어붙이기 가능
String str_c3 = str_c1 + null + "ABC";

//  ⚠️ concat은 NullPointerException 발생
//String str_c4 = str_c1.concat("ABC");
//String str_c5 = "ABC".concat(str_c1);
```

```java
//  ⭐️ 다중 연산시 생성되는 문자열 인스턴스의 수가 다름
String str_d1 = "a" + "b" + "c" + "d";

// + 연산은 내부적으로 아래와 같이 최적화됨
String str_d2 = new StringBuilder("a")
        .append("b")
        .append("c")
        .append("d")
        .toString(); // "abcd"가 생성됨
// "a", "b", "c", "d", "abcd"가 생성되어 메모리 차지

//  concat은 매 번 문자열을 반환하므로
String str_d3 = "a"
        .concat("b") // "ab"가 생성됨
        .concat("c") // "abc"가 생성됨
        .concat("d"); // "abcd"가 생성됨
// "a", "b", "c", "d", "ab", "abc", "abcd"가 생성되어 메모리 차지
```
</details>

<details>
<summary>문자열의 포매팅과  null</summary>

### [7. 문자열의 포매팅과  null](./src/sec03/chap07)

```java
// 포매팅
/*
%b : 불리언
%d : 10진수 정수
%f : 실수
%c : 문자
%s : 문자열 (및 모든 자료형)
%n : 포맷 문자열 내 줄 바꿈 (os별로 일정하게 줄바꿈)
     윈도우: /r/n , 맥&리눅스 : /n
 */

//  💡 정수 다양하게 포매팅하기
String[] intFormats = {
        "%d",        // 1. 기본
        "%13d",      // 2. n 자리수 확보, 오른쪽 정렬
        "%013d",     // 3. 빈 자리수 0으로 채움
        "%+13d",     // 4. 양수는 앞에 + 붙임
        "%,13d",     // 5. 쉼표 사용
        "%-13d",     // 6. 자리수 확보, 왼쪽 정렬
        "%+,013d"    // 7.
};

//  💡 실수 다양하게 포매팅하기
String[] fltFormats = {
        "%f",       // 1. 기본 (소수점 6자리, 0으로 메움)
        "%.2f",     // 2. 소수점 n자리까지
        "%13.2f",   // 3. 정수자리 확보, 소수자리 제한
        "%,f",      // 4
        "%+013.2f",  // 5
        "%-13.2f",  // 6
};

//  💡 문자열 다양하게 포매팅하기
String[] strFormats = {
        "%s",    // 1. 기본
        "%9s",   // 2. 자리 확보
        "%.2s",  // 3. ~글자만
        "%9.2s", // 4.
        "%-9s",  // 5. 왼쪽 정렬
};
```
</details>

<details>
<summary>배열</summary>

### [8. 배열](./src/sec03/chap08)

```java
//  이중 배열
boolean[][] dblBoolAry = new boolean[3][3];

int[][] dblIntAry = new int[][] {
        //  ⭐️ 요소 배열의 크기가 다를 수 있음 // 배열의 주소가 들어감.
        {1, 2, 3},
        {4, 5},
        {6, 7, 8, 9},
};
```

```java
//  ⭐️ 문자열은 객체(참조형)지만 원시형처럼 다뤄짐
String str1 = "코인 함";
String str2 = "관심 없음";
str2 = str1;

str1 = "고점에 익절";
```

```java
//  상수 배열의 경우
final int[] NUMBERS = {1, 2, 3, 4, 5};

//  ⚠️ 다른 배열을 할당하는 것은 불가
//NUMBERS = new int[] {2, 3, 4, 5, 6};

//  ⭐️ 배열의 요소를 바꾸는 것은 가능
NUMBERS[0] = 11;
```
</details>

<details>
<summary>배열, 타입 추론, 비트 연산자</summary>

### [9. 타입 추론](./src/sec03/chap09)

- var

### [10. 비트 연산자](./src/sec03/chap10)

```java
// & | ^  << ??
// & |는 단축평가를 하지 않는다.

int x = 5;              // 00101
int y = 19;             // 10011

int x_xor_y = 5 ^ 19;   // 10110
int x_or_y = 5 | 19;    // 10111
int x_and_y = 5 & 19;   // 00001

int not_X = ~5;         // 11111111 11111010    // -(5+1)
int not_Y = ~19;        // 11111111 11101100    // -(19+1)

int x_L_1 = 5 << 1;     // 01010    // 5*2
int y_L_1 = 19 << 1;    // 100110   // 19*2

int x_R_1 = 5 >> 1;     // 00010    // 5/2 몫
int y_R_1 = 19 >> 1;    // 001001   // 19/2 몫
```
</details>

## 4. 제어문과 메소드

