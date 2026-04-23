# Java Notes

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

---

### [3. 자료형과 변수](./src/sec02/chap03)

```java
// 상수
// 💡 final 연산자 : 변수의 값을 바꾸지 못하게 만듦
final int INT_NUM = 1;
//INT_NUM = 2; // ⚠ 불가
```

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

</details>

<details>
<summary>타입 추론, 비트 연산자</summary>

### [9. 타입 추론](./src/sec03/chap09)

- var

---

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

---

</details>

## 4. 제어문과 메소드

<details>
<summary>if/ese, switch, for & for-each, while & do while</summary>

### [1. if/else](./src/sec04/chap01)

---

### [2. switch](./src/sec04/chap02)

```java
//  💡 break 관련 동작방식을 이용
char yutnori = '윷';

switch (yutnori) {
    case '모': System.out.println("앞으로");
    case '윷': System.out.println("앞으로");
    case '걸': System.out.println("앞으로");
    case '개': System.out.println("앞으로");
    case '도': System.out.println("앞으로"); break;
    default:
System.out.println("무효");
}
```

---

### [3. for / for-each](./src/sec04/chap03)

```java
//  루프 블록 안에서 변수값을 바꾸는 것으로
for (int i = 0; i < 10;) {
    System.out.println(i);
    i += 2;
}
```

```java
//  💡 쉼표로 구분하여 여럿 사용 가능
//  ⚠️ 변수의 자료형은 한 종류만 가능 (혼용 안 됨)
for (byte a = 0, b = 10; a <= b;) {
    System.out.printf("a: %d, b: %d%n", a++, b--);
}
```

```java
 String yuts = "도개걸윷모";
char yut = '윷';

boolean isValid = false;
for (int i = 0; i <= yuts.indexOf(yut); i++) {
    isValid = true;
    System.out.println("앞으로");
}
if (!isValid) System.out.println("무효");
```

- 무한루프
```java
//  종료조건이 없는 for 루프
for (;;) {
    System.out.println("영원히");
}
// System.out.println("닿지 않아"); // ⚠️ 실행되지 않음
```

- for - each
```java
//  💡 for each 문법 - 배열이나 이후 배울 콜랙션 등에 사용
for (String s : "호롤롤로".split("")) {
    System.out.println(s);
}
```
- labe
```java
//  💡 label : 중첩 루프에서 어느쪽을 continue, break 할 지 구분
outer:
for (int i = 0; i < 10; i++) {

    inner:
    for (int j = 0; j < 10; j++) {
        if (j % 2 == 0) continue inner;
        if (i * j >= 30) continue outer;

        if (j > 8) break inner;
        if (i - j > 7) break outer;

        System.out.printf("i: %d, j: %d%n", i, j);
    }
}
```

---

### [4. while & do while](./src/sec04/chap04)

---

</details>

<details>
<summary>메소드, 키보드 입력받기</summary>

### [5. 메서드](./src/sec04/chap05)

```java
//  자바의 메소드는 하나의 값만 반환 가능
//  여러 값을 반환하려면 배열 또는 객체 활용
static int[] getMaxAndMin (int[] nums) {

    int max = nums[0];
    int min = nums[0];
    for (int num : nums) {
        max = max > num ? max : num;
        min = min < num ? min : num;
    }

    return new int[] {max, min};
}
```

- ... 연산자
```java
//  💡 ... 연산자 : 해당 위치 뒤로 오는 연산자들을 배열로 묶음
//  int[] (배열 자체를 받음)과는 다름!
static double getAverage(int... nums) {
    double result = 0.0;
    for (int num : nums) {
        result += num;
    }
    return result / nums.length;
}
```
```java
static void main() {

        double avg = getAverage(3, 91, 14, 27, 4);

        //  💡 배열을 넣으면 자동으로 펼쳐져 인식됨
        int[] numbers = {3, 91, 14, 27, 4};
        double avgOfArr = getAverage(numbers);

        String class3Desc = descClass(3, "목아진", "짱구", "철수", "훈이");

        String[] kids = {"짱구", "철수", "훈이"};
        String class3DescByArr = descClass(3, "목아진", kids);
    }
```

---

### [6. 메서드 더 알아보기](./src/sec04/chap06)

- 오버로딩
```java
static int add(int a, int b) { return a + b; }

//  매개변수의 개수가 다름
static int add(int a, int b, int c) { return a + b + c; }

//  매개변수의 자료형이 다름
static double add(double a, double b) { return a + b; }

//  ⚠️ 반환 자료형이 다른 것은 오버로딩 안 됨 - 다른 함수명 사용
//  static double add(int a, int b) { return (double) (a + b); }
```

- 재귀 메소드

```java
static int factorial (int num) {
    return num == 0 ? 1 : num * factorial(--num);
}
```

꼬리 재귀 체적화
- 재귀 코드를 내부적으로 루프 형태로 바꿔서 스택이 쌓이지 않도록 함
- 자바에서는 현재 기본적으로 제공하지 않음.
- 반복 횟수가 너무 많아지는 작업에는 사용하지 말것

---

### [7. 키보드 입력받기](./src/sec04/chap07)

---

</details>

## 5. 객체지향 프로그래밍

<details>
<summary>클래스 기초, 기초 활용 예제들, 클래스(정적)필드와 메소드</summary>

### [1. 클래스 기초](./src/sec05/chap01)

```java
public class YalcoChicken {
    int no;
    String name;

    //  ⭐ 생성자(constructor) : 인스턴스를 만드는 메소드
    //  ⭐ this : 생성될 인스턴스를 가리킴
    public YalcoChicken (int no, String name) {
        this.no = no;
        this.name = name;
    }

    String intro () {
        // String name = "몽고반"; // 주석해제 시 name 대체 
        return "안녕하세요, %d호 %s점입니다."
                .formatted(no, name);
    }
}
```

---

### 2. 기초 활용 예제들(./src/sec05/chap02)

---

### 3. 클래스(정적)필드와 메소드(./src/sec05/chap03)

- 클래스(static)요소: 메모지 중 한곳만 차지
- 인스턴스 요소들: 각각이 메모리에 자리를 차지
  - 각각의 자신만의 프로퍼티 값을 가지고 있음.

`YalcoChicken.java`
```java
public class YalcoChicken {
    //  ⭐️ 클래스/정적 필드와 메소드들 : 본사의 정보와 기능
    //  인스턴스마다 따로 갖고 있을 필요가 없는 것들에 사용
    static String brand = "얄코치킨";
    static String contact () {
        //  ⚠️ 정적 메소드에서는 인스턴스 프로퍼티 사용 불가
        //  System.out.println(name);

        return "%s입니다. 무엇을 도와드릴까요?".formatted(brand);
    }

    int no;
    String name;

    YalcoChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    String intro () {
        //  💡 인스턴스 메소드에서는 정적 프로퍼티 사용 가능
        return "안녕하세요, %s %d호 %s점입니다."
                .formatted(brand, no, name);
    }
}
```

`Main.java`
```java
//  💡 클래스 필드와 메소드는 인스턴스를 생성하지 않고 사용
String ycBrand = YalcoChicken.brand;
String ycContact = YalcoChicken.contact();

// ⚠️ 인스턴스 메소드는 불가
//  String ycName = YalcoChicken.name;
//  String ycIntro = YalcoChicken.intro();

YalcoChicken store1 = new YalcoChicken(3, "판교");
String st1Intro = store1.intro();

//  인스턴스에서는 클래스의 필드와 메소드 사용 가능
//  ⚠️ 편의상 기능일 뿐, 권장하지 않음 (혼란 초래. IDE에서 자동완성 안 됨 주목)
String st1Brand = store1.brand;
String st1Contact = store1.contact();
```

---

</details>

<details>
<summary>접근 제어자 (접근 제한자, access modifier)</summary>

### [4. 접근 제어자 (접근 제한자, access modifier)](./src/sec05/chap04)

| 접근 가능 범위           | public | protected | default | private |
|--------------------|--------|-----------|---------|---------|
| 해당 클래스 안에서         | ✅     | ✅        | ✅      | ✅      |
| 동일 패키지 안에서         | ✅     | ✅        | ✅      | ❌      |
| 다른 패키지의 자손 클래스 안에서 | ✅     | ✅        | ❌      | ❌      |
| 다른 패키지 포함 어느 곳에서든  | ✅     | ❌        | ❌      | ❌      |

- Getter와 Setter
```java
private String name;
private int price;

public String getName() {
    return name;
}

public void setName(String name) {
    if (name.isBlank()) return;
    this.name = name;
}

public int getPrice() {
    return (int) (price * (1 - discount));
}

public void setPrice(int price) {
    //  ⭐ this 사용 주의
    int max = (int) (this.price * increaseLimit);
    this.price = price < max ? price : max;
}
```
</details>

<details>
<summary>상속</summary>

### [5. 상속](./src/sec05/chap05)
`extends`키워드

- **메소드 오버라이딩**  
부모가 가진 같은 이름의 메소드를 자식이 다르게 정의
  - **super**
    - `super`: 부모의 클래스의 인스턴스(실존하지 않음 - 자신 안의 부모 유전자)를 가리킴
      - `this` 가 해당 클래스의 인스턴스를 가리키듯…
  - 부모 클래스에 생성자가 작성되었을 시
    - 자식 클래스에도 생성자 작성 필요
    - `super` 를 사용해서 부모의 생성자를 먼저 호출
        - 즉 부모의 인스턴스부터 생성 후 이를 기반으로 자식 인스턴스 생성
        - 자식 클래스의 생성자는 `super` 로 시작해야 함 (순서 바뀌면 안됨)
  - 부모 클래스에 명시된 생서자가 없을 명우 자식 크랠스에서도 작성 필요 없음.

`Button.java`
```java
public class Button {
    private String print;

    public Button(String print) {
        this.print = print;
    }

    public void func () {
        System.out.println(print + " 입력 적용");
    }
}
```

`ShutDownButton.java`
```java
public class ShutDownButton extends Button {
    public ShutDownButton () {
        super("ShutDown"); // 💡 부모의 생성자 호출
    }

    //  💡 부모의 메소드를 override
    @Override
    public void func () {
        System.out.println("프로그램 종료");
    }
}
```

ToggleButton.java
```java
public class ToggleButton extends Button {
    private boolean on;

    public ToggleButton(String print, boolean on) {
        super(print);
        this.on = on;
    }

    @Override
    public void func () {
        super.func(); // 💡 부모에서 정의한 메소드 호출
        this.on = !this.on;
        System.out.println(
                "대문자입력: " + (this.on ? "ON" : "OFF")
        );
    }
}
```

- `@overerride` 어노테이션  
부모의 특정 메소드를 오버라이드함을 명시
  - 없어도 오류나지 않음.
  - 메소드명이 다를 시 오류나타남. (메소드명 실수 방지)

</details>

<details>
<summary>다형성</summary>

### [6. 다형성(Polymorphism)](./src/sec05/chap06)

- 상속
  - 자식 클래스의 인스턴스는 부모 클래스 자료형에 속함


```java
//⭐️ 편의 : 모두 Button이란 범주로 묶어 배열 등에서 사용 가능
Button[] buttons = {
        new Button("Space"),
        new ToggleButton("NumLock", false),
        new ShutDownButton()
};

for (Button button : buttons) {
    //  ⭐️ 모든 Button들은 func 메소드를 가지므로
    button.func();
}
```
⭐️ 이처럼 특정 자료형의 자리에 여러 종류가 들어올 수 있는 것 - 다형성

- `instaneof`연산자  
뒤에 오는 클래스의 자료형에 속하는 인스턴스인지 확인  
상속관계가 아닌 클래스끼리는 컴파일 오류
```java
//  true
        boolean typeCheck1 = button instanceof Button;
        boolean typeCheck2 = toggleButton instanceof Button;
        boolean typeCheck3 = shutDownButton instanceof Button;

        //  false
        boolean typeCheck4 = button instanceof ShutDownButton;
        boolean typeCheck5 = button instanceof ToggleButton;

        //  ⚠️ 컴파일 에러
        // boolean typeCheck6 = toggleButton instanceof ShutDownButton;
        // boolean typeCheck7 = shutDownButton instanceof ToggleButton;
```

- `object` 클래스  
모든 클래스의 최고 조상
```java
Object[] objs = {
        1, false, 3.45, '가', "안녕하세요", new Button("Space")
};
```
</details>

<details>
<summary>클래스의 final</summary>

### [7. 클래스의 final](./src/sec05/chap07)

- `final` 필드
  - 값 변경 불가
  - 필드 선언시 또는 생성자에서 초기화해야 함 (수정이 불가능 하므로)
- `final` 메서드
  - 자식 클래스에서 오버라이드 불가
- `final` 인스턴스
  - 다른 값을 넣는 것은 불가
  - 필드는 변경 가능 (다른 인스턴스(주소)로 바뀌는게 아니라서)
- `final` 클래스
  -  하위 확장 불가 (자식 클래스 만들 수 없음)

`YalcoChicken.java`
```java
public class YalcoChicken {
    protected static final String CREED = "우리의 튀김옷은 얄팍하다.";

    private final int no;
    public String name;

    //  ⭐️ 필수 - no가 final이고 초기화되지 않았으므로
    public YalcoChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void changeFinalFields () {
        // ⚠️ 불가. final 필드
        // this.no++;
    }

    public final void fryChicken () {
        System.out.println("염지, 반죽입히기, 튀김");
    }
}
```

`YalcoChickenDT.java`
```java
public final class YalcoChickenDT extends YalcoChicken {
    public YalcoChickenDT(int no, String name) {
        super(no, name);
    }

    //  ⚠️ 불가. fryChicken 메서드는 YalcoChicken 클래스의 final 메서드임
    // public void fryChicken () {
    //     System.out.println("염지, 반죽입히기, 미원, 튀김");
    // }

    // 생성자 추가할 것
}
```

`YalcoChickenHighWayDT.java`
```java
// ⚠️ 불가. YalcoChickenDT가 final 클래스임.
public class YalcoChickenHighWayDT extends YalcoChickenDT {
}
```
</details>

<details>
<summary>추상 클래스</summary>

### [8. 추상 클래스](./src/sec05/chap08)

- `abstract` 클래스
  - 자식 클래스로 파생되기 위한 클래스
  - 관련된 여러 클래스들의 공통분모를 정의하기 위한 클래스 (포유류)
  - 그 자체로는 인스턴스 생성 불가
  - 부모 클래스로서는 일반 클래스와 같음
    - 다형성 구현됨
  
- `abstract` 메서드
  - 추상 클래스에서만 사용 가능
  - 스스로는 선언만 하고 구현사지는 않음
    - 자식 클래스에서 반드시 구현. (아니면 컴파일 오류)
    - 접근 제한자 의미 없음(어차피 자식클래스에서 구현해야하므로)
      - 자식 클래스에서 접근 제한자 지정하면 됨
    - 클래스(정적) 메소드는 추상 메소드로 작성할 수 없음
      - 인스턴스를 생성해서 쓰는 것이 아니므로 맞지 않음

`YalcoGroup.java`
```java
public abstract class YalcoGroup {
    protected static final String CREED = "우리의 %s 얄팍하다";

    //  💡 클래스(정적) 메소드는 abstract 불가
    //  abstract static String getCreed ();

    protected final int no;
    protected final String name;

    public YalcoGroup(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String intro () {
        return "%d호 %s점입니다.".formatted(no, name);
    }

    // abstract 메소드 
    public abstract void takeOrder ();
}
```
`YalcoChicken.java`
```java
public class YalcoChicken extends YalcoGroup {
    public static String getCreed () {
        return CREED.formatted("튀김옷은");
    }
    protected static int lastNo = 0;

    public YalcoChicken(String name) {
        super(++lastNo, name);
    }

    //  💡 반드시 구현 - 제거하면 컴파일 오류
    @Override
    public void takeOrder () {
        System.out.printf("얄코치킨 %s 치킨을 주문해주세요.%n", super.intro());
    }
}
```

`YalcoCafe.java`
```java
public class YalcoCafe extends YalcoGroup {
    public static String getCreed () {
        return CREED.formatted("원두향은");
    }
    protected static int lastNo = 0;

    private boolean isTakeout;

    public YalcoCafe(String name, boolean isTakeout) {
        super(++lastNo, name);
        this.isTakeout = isTakeout;
    }

    //  💡 반드시 구현 - 제거하면 컴파일 오류
    @Override 
    public void takeOrder () {
        System.out.printf("얄코카페 %s 음료를 주문해주세요.%n", super.intro());
        if (!isTakeout) System.out.println("매장에서 드시겠어요?");
    }
}
```

`Main.java`
```java
//  ⚠️ abstract 클래스는 인스턴스 생성 불가
// YalcoGroup yalcoGroup = new YalcoGroup(1, "서울");

YalcoChicken ychStore1 = new YalcoChicken("판교");
YalcoChicken ychStore2 = new YalcoChicken("강남");

YalcoCafe ycfStore1 = new YalcoCafe("울릉", true);
YalcoCafe ycfStore2 = new YalcoCafe("강릉", false);

// 다형성 구현
YalcoGroup[] ycStores = {
        ychStore1, ychStore2,
        ycfStore1, ycfStore2
};

for (YalcoGroup ycStore : ycStores) {
    ycStore.takeOrder();
}
```

---

</details>

<details>
<summary>인터페이스</summary>

### [9. 인터페이스](./src/sec05/chap09)

**추상 클래스와의 차이**

*🔴  : 추상 클래스 / 🔷  : 인터페이스*

- 🔴  포유류
    - 북극곰 - 🔷  사냥, 🔷  수영
    - 날다람쥐 - 🔷  비행
- 🔴  파충류
    - 거북 - 🔷  수영
    - 날도마뱀 - 🔷  사냥, 🔷  수영, 🔷  비행
- 🔴  조류
    - 독수리 - 🔷  사냥, 🔷  비행
    - 펭귄 - 🔷  사냥, 🔷  수영

| 구분                     | 추상 클래스                              | 인터페이스                                               |
|--------------------------|-------------------------------------------|-----------------------------------------------------|
| 기본 개념                | 물려 받는 것 (혈통/가문/계열)              | 장착하는 것 (학위/자격증)                                     |
| 다중 적용                | 불가 (모회사는 하나 뿐)                  | 가능 (학위는 여럿 딸 수 있음)                                  |
| 상속관계에 의한 제한     | 있음                                     | 없음                                                  |
| 생성자                   | 가짐                                     | 가지지 않음                                              |
| 메소드                   | 구상, 추상 모두 가능                     | 추상 메소드 (abstract 생략 가능), 구상(default) 메소드, 클래스(static) 메소드 |
| 필드                     | 모두 가능                                | 상수만 가능 (public static final, 생략 가능)                 |
| 적용 연산자              | extends                                  | implements                                          |

`Mammal.java`
```java
public abstract class Mammal {
    public boolean hibernation;

    public Mammal(boolean hibernation) {
        this.hibernation = hibernation;
    }
}
```

`Reptile.java`
```java
public abstract class Reptile {
    public boolean isColdBlooded () {
        return true;
    }
}
```

`Hunter.java`
```java
public interface Hunter {
    String position = "포식자"; // ⭐️ final - 초기화하지 않을 시 오류
    void hunt ();
}
```

`Swimmer.java`
```java
public interface Swimmer {
    void swim();
}
```

`Flyer.java`
```java
public interface Flyer {
    String aka = "날짐승"; // ⭐️ final - 초기화하지 않을 시 오류
    void fly ();
}
```

`PolarBear.java`
```java
public class PolarBear extends Mammal implements Hunter, Swimmer {
    public PolarBear() {
        super(false);
    }

    @Override
    public void hunt() {
        System.out.println(position + ": 물범 사냥");
    }

    @Override
    public void swim() {
        System.out.println("앞발로 수영");
    }
}
```

`GlidingLizard.java`
```java
public class GlidingLizard extends Reptile implements Hunter, Swimmer, Flyer {
    @Override
    public void fly() {
        System.out.println("날개막으로 활강");
    }

    @Override
    public void hunt() {
        System.out.println(position + ": 벌레 사냥");
    }

    @Override
    public void swim() {
        System.out.println("꼬리로 수영");
    }
}
```

`Main.java`
```java
//  ⭐ 다형성
PolarBear polarBear = new PolarBear();
Mammal mammal = polarBear;
Swimmer swimmer = polarBear;

GlidingLizard glidingLizard = new GlidingLizard();
Eagle eagle = new Eagle();

Hunter[] hunters = {
        polarBear, glidingLizard, eagle
};

//  💡 인터페이스 역시 다형성에 의해 자료형으로 작용 가능
for (Hunter hunter : hunters) {
    hunter.hunt();
}
```

---

**자바8에 추가된 기능들**

인터페이스의
- 클래스 메소스
- default 구상 메소드

💡`default`로 구상 메소드를 넣을 수 있도록 한 이유

- 사용되던 인터페이스에 새로운 기능을 추가해야 한다면?
    - 새로운 자바 버전의 라이브러리 인터페이스에 새 기능이 추가되어야 한다면?
    - 이를 적용하여 사용하던 클래스가 매우 많을 경우…
- 해당 인터페이스의 하위 클래스들을 일일이 수정하지 않아도 되도록
    - **하위호환성**

`FoodSafety.java`
```java
public interface FoodSafety {
    //  ⭐️
    //  static 제거하면 컴파일 오류
    //  static abstract는 역시 불가 (추상 클래스처럼)
    static void announcement () {
        System.out.println("식품안전 관련 공지");
    }

    //  ⭐️
    //  default 제거하면 컴파일 오류
    default void regularInspection () {
        System.out.println("정기 체크");
    }

    // 추상 메소드
    void cleanKitchen ();
    void employeeEducation ();
}
```  

`Main.java`
```java
FoodSafety.announcement();

YalcoChicken store1 = new YalcoChicken();

store1.regularInspection();
store1.cleanKitchen();
store1.employeeEducation();
```

---

</details>

<details>
<summary> 싱클턴</summary>

### [10. 싱글턴](./src/sec05/chap10)

프로그램 상에서 특정 인스턴스가 딱 하나만 있어야 할 때
- 프로그램상 여러 곳에서 공유되는 설정
- 멀티쓰레딩 환경에서 공유되는 리소스
- 기타 전역으로 공유되는 인스턴스가 필요한 경우

`Setting.java`
```java
public class Setting {

    //  ⭐️ 이 클래스를 싱글턴으로 만들기

    // 클래스(정적) 필드
    // - 프로그램에서 메모리에 하나만 존재
    private static Setting setting;

    //  ⭐️ 생성자를 private으로!
    // - 외부에서 생성자로 생성하지 못하도록
    private Setting() {
    }

    //  💡 공유되는 인스턴스를 받아가는 public 클래스 메소드
    public static Setting getInstance() {
        //  ⭐️ 아직 인스턴스가 만들어지지 않았다면 생성
        //  - 프로그램에서 처음 호출시 실행됨
        if (setting == null) {
            setting = new Setting();
        }
        return setting;
    }
}
```

---
</details>

<details>
<summary>더 찾아본 내용</summary>

### 더 찾아본 내용
**클래스(정적) 메소드는 자식 클래스에서 오버라이드 될 수 있을까?**

**✔ 결론**
- ❌ **오버라이드 불가능**
- ⭕ 대신 **메서드 숨김(Method Hiding)** 발생

**🔸 이유**
- `static` 메서드는 **클래스 소속 (정적 바인딩)**
- 호출 시점이 **컴파일 타임**에 결정됨
- 따라서 **동적 바인딩(오버라이딩)**이 적용되지 않음

**🔸 추가 개념**
- `static` 메서드는 **추상 메서드로 선언할 수 없음**
    - 추상 메서드는 **인스턴스를 통해 구현/호출**되어야 함
    - `static`은 인스턴스와 무관 → 개념적으로 맞지 않음

**🔹 예제**

```java
class Parent {
    static void hello() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static void hello() {
        System.out.println("Child");
    }
}

```

```java
Parent p = new Child();
Child c = new Child();

p.hello(); // Parent
c.hello();  // Child
```

---

</details>

## 6. 클래스 더 알아보기

<details>
<summary>블록과 스코프, 패키지</summary>

### [1. 블록과 스코프](./src/sec06/chap01)
```java
public class Ex02 {
    public static void main(String[] args) {
        // System.out.println(a); // ⚠️ 클래스 메소드에서 인스턴스 필드 사용 불가
    }

    // private String y = x; // ⚠️ 클래스 내 필드의 스코프 : 해당 클래스 안
    private int a = 1;
    private int b = a + 1;
    // private int c = d + 1; // ⚠️ 메소드 내 변수의 스코프 : 해당 메소드 안

    public void func1 () {
        System.out.println(a + b);
        int d = 2;
    }

    public void func2 () {
        // System.out.println(d); // ⚠️
    }
}
```

- 바깥의 변수 재선언 불가

`Ex03.java`
```java
 String str = "바깥쪽";
    {
        //String str = "안쪽"; // ⚠️ 불가
    }

    while (true) {
        //String str = "안쪽"; // ⚠️ 불가
    }
```

`Ex04.java`
```java
public class Ex04 {

    public static void main(String[] args) {
        new Ex04().printKings();
    }

    String king = "사자";

    void printKings () {
        String king = "여우"; // 💡 그럼 이건 뭔가요??

        //  ⭐️ 인스턴스의 필드는 다른 영역으로 간주
        System.out.printf(
                "인스턴스의 왕은 %s, 블록의 왕은 %s%n",
                this.king, king
        );
    }
}
```

---

### [2. 패키지](./src/sec06/chap02)

---
</details>

<details>
<summary>내부 클래스</summary>

### [3. 내부 클래스](./src/sec06/chap03)

내부 클래스 종류
- 멤버 인스턴스
- 정적 내부 클래스
- 메소드 안에 정의된 클래스
- 익명 클래스

`Outer.java`
```java
public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    //  💡 1. 멤버 인스턴스 클래스
    class InnerInstMember {
        //  ⭐️ 외부 클래스의 필드와 클래스 접근 가능
        private String name = inst + " 필드로서의 클래스";
        private InnerSttcMember innerSttcMember = new InnerSttcMember();

        public void func () {
            System.out.println(name);
        }
    }

    //  💡 2. 정적(클래스) 내부 클래스
    //  ⭐️  내부 클래스에도 접근자 사용 가능. private으로 바꿔 볼 것
    public static class InnerSttcMember {
        //  ⭐️ 외부 클래스의 클래스 필드만 접근 가능
        private String name = sttc + " 필드로서의 클래스";

        //  ⚠️ static이 아닌 멤버 인스턴스 클래스에도 접근 불가!
        //  private InnerInstMember innerInstMember = new InnerInstMember();

        public void func () {
            // ⚠️ 인스턴스 메소드지만 클래스가 정적(클래스의)이므로 인스턴스 필드 접근 불가
            //  name += inst;
            System.out.println(name);
        }
    }

    public void memberFunc () {
        //  💡 3. 메소드 안에 정의된 클래스
        //  스코프가 메소드 내로 제한됨
        class MethodMember {
            //  외부의 필드와 클래스에 접근은 가능
            String instSttc = inst + " " + sttc;
            InnerInstMember innerInstMember = new InnerInstMember();
            InnerSttcMember innerSttcMember = new InnerSttcMember();

            public void func () {
                innerInstMember.func();
                innerSttcMember.func();
                System.out.println("메소드 안의 클래스");

                //  new Outer().memberFunc(); // ⚠️ 스택오버플로우 에러!!
            }
        }

        new MethodMember().func();
    }

    public void innerFuncs () {
        new InnerInstMember().func();
        new InnerSttcMember().func();
    }

    public InnerInstMember getInnerInstMember () {
        return new InnerInstMember();
    }
}
```

`Main.java`
```java
package sec06.chap03.ex01;
// 내부 클래스
public class Main {
    static void main(String[] args) {
        //  ⭐️ 클래스가 클래스 필드인 것 - 아래의 변수는 인스턴스
        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
        staticMember.func();

        System.out.println("\n- - - - -\n");

        Outer outer = new Outer();
        outer.innerFuncs();

        System.out.println("\n- - - - -\n");


        //  ⚠️  아래와 같은 사용은 불가
        // Outer.InnerInstMember innerInstMember = new outer.InnerInstMember();
        // Outer.InnerInstMember innerInstMember = outer.new InnerInstMember(); // 가능(gpt가 알려줌.)

        //  💡 인스턴스 내부 클래스는 이렇게 얻을 수 있음
        Outer.InnerInstMember innerInstMember = outer.getInnerInstMember();
        innerInstMember.func();

        System.out.println("\n- - - - -\n");

        outer.memberFunc();
    }
}
```

---
</details>

<details>
<summary>익명 클래스</summary>

### [4. 익명 클래스](./src/sec06/chap04)

- 다른 클래스나 인터페이스로부터 상속받아 만들어짐
  - 주로 오버라이드한 메소드를 사용
- 한 번만 사용되고 버려질 클래스
  - 따로 클래스명이 부여되지 않음
  - 이후 다시 인스턴스를 생성할 필요가 없으므로
- 람다식이 나오기 전 널리 사용

```java
public interface OnClickListener {
    void onClick ();
}
```

```java
public class Button {
    String name;
    public Button(String name) {
        this.name = name;
    }

    //  ⭐️ 인터페이스를 상속한 클래스 자료형
    private OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void func () {
        onClickListener.onClick();
    }
}
```

`Main.java`
```java
Button button1 = new Button("Enter");
Button button2 = new Button("CapsLock");
Button button3 = new Button("ShutDown");

//  이후 배울 람다로 대체
button1.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick() {
        System.out.println("줄바꿈");
        System.out.println("커서를 다음 줄에 위치");
    }
});

button2.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick() {
        System.out.println("기본입력 대소문자 전환");
    }
});

button3.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick() {
        System.out.println("작업 자동 저장");
        System.out.println("프로그램 종료");
    }
});

for (Button button : new Button[] {button1, button2, button3}) {
    button.func();
}
```

---
</details>

<details>
<summary>메인 메소드, 열거형</summary>

### [5. 메인 메소드](./src/sec06/chap05)

---

### [6. 열거형](./src/sec06/chap06)

지정된 선택지 내의 값을 받을 변수 사용시
- 클래스처럼 필드, 생성자, 메소드를 가질 수 있음

```java
public enum YalcoChickenMenu {
    FR("후라이드", 10000, 0),
    YN("양념치킨", 12000, 1),
    GJ("간장치킨", 12000, 0),
    RS("로제치킨", 14000, 0),
    PP("땡초치킨", 13000, 2),
    XX("폭렬치킨", 13000, 3);

    private String name;
    private int price;
    private int spicyLevel;

    YalcoChickenMenu(String name, int price, int spicyLevel) {
        this.name = name;
        this.price = price;
        this.spicyLevel = spicyLevel;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc () {
        String peppers = "";
        if (spicyLevel > 0) {
            peppers = "🌶️".repeat(spicyLevel);
        }

        return "%s %s원 %s"
                .formatted(name, price, peppers);
    }
}
```

---

</details>

<details>
<summary>레코드 (Java 16+)</summary>

### [7. 레코드 (Java 16+)](./src/sec06/chap07)

- 자바 14에서 Preview로 추가, 16에서 정식으로 등록
- 데이터의 묶음을 저장하기 위한, 단순한 형태의 클래스

- 레코드는 final
  - 다른 클래스로 상속되거나 abstract 선언 불가
- 레코드의 각 항목들은 private, final
  - 각각 같은 이름의 getter가 기본으로 만들어짐.
- 인스턴스 필드는 (자동으로 생성되며) 추가로 선언할 수 없음.
- 클래스 필드는 가능 (static)

```java
public record Child(
        String name,
        int birthYear,
        Gender gender
) {}
```

```java
Child[] children = new Child[] {
                new Child("김순이", 2021, Gender.FEMALE),
                new Child("이돌이", 2019, Gender.MALE),
                new Child("박철수", 2020, Gender.MALE),
                new Child("최영희", 2019, Gender.FEMALE),
};

for (Child child : children) {
    System.out.printf(
            "%s %d년생 %s 어린이%n",
            child.gender().getEmoji(),
            child.birthYear(),
            child.name()
    );

```


```java
public class Button {
    public enum ClickedBy {
        LEFT('좌'), RIGHT('우') ;
        private char indicator;
        ClickedBy(char indicator) { this.indicator = indicator; }
        public char getIndicator() { return indicator; }
    }

    //  ⭐️
    //  다른 클래스에 내부로 포함 가능
    //  인터페이스 구현 가능 (클래스 상속은 불가)
    public record ClickInfo(
            int x, int y, ClickedBy clickedBy
    ) implements InfoPrinter {

        //  💡 클래스 필드를 가질 수 있음 (인스턴스 필드는 불가)
        static String desc = "버튼 클릭 정보";
        // string desc = "버튼 클릭 정보"; // 불가

        //  💡 인스턴스/클래스 메소드를 가질 수 있음
        @Override
        public void printInfo() {
            System.out.printf(
                    "%c클릭 (%d, %d)%n",
                    clickedBy.indicator, x, y
            );
        }
    }

    public ClickInfo func (int x, int y, ClickedBy clickedBy) {
        System.out.println("버튼 동작");
        return new ClickInfo(x, y, clickedBy);
    }
}
```

---
</details>

<details>
<summary>유용한 라이브러리 클래스들, 날짜와 시간 관련 클래스들</summary>

### [8. 유용한 라이브러리 클래스들](./src/sec06/chap08)

- 숫자 관련 클래스들 
  1. Math 클래스 
  2. Random 클래스
  3. BigInteger 클래스  
  Long에서 다룰 수 있는 최대 정수 이상의 수를 다름
  4. BigDecimal 클래스  
  부동소수점 오차를 해결


- 문자열 관련 클래스들
  1. StringJoiner  
  받은 문자열들을 모아서 열고 닫는 문자열과 함께 join  
  (String.join 보다 동정이고 강력)
  2. StringBuffer  
  자주 변경해야 하는 문자열이 있을 때 적합 (문자열을 여러 차례 이어붙일 때 등)
  3. StringBuilder  
  StringBuffer에서 멀티쓰레드 관련 안전 기능만 제거한 클래스
  4. CharSequence 인터페이스  
  String, StringBuffer, StringBuilder 모두 이를 구현

---

### [9. 날짜와 시간 관련 클래스들](./src/sec06/chap09)

---
</details>


