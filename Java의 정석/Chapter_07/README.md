# 상속(Inheritance)

- 기존의 클래스로 새로운 클래스를 작성하는 것. (코드의 재사용)
- 두 클래스를 부모와 자식으로 관계를 맺어주는 것.

```java
class 자식클래스 extends 부모클래스 {
    // ...
}


class Parent{}
class Child extends Parent {
    // ...
}
```

- 자손은 조상의 모든 멤버를 상속받는다 (생성자, 초기화블럭 제외)
- 자손의 멤버 개수는 조상보다 적을 수 없다. (같거나 많다.)
- 자손의 변경은 조상에 영향을 미치지 않는다.

# 포함 관계

## 포함이란?
- 클래스의 멤버로 참조변수를 선언하는 것
- 작은 단위의 클래스를 만들고, 이 들을 조합해서 클래스를 만든다.

# 클래스 간의 관계 결정하기

    상속관계    `~은~이다.(is-a)'
    포함관계    `~은~을 가지고 있다.(has-a)`

# 단일 상속
- Java는 단일 상속만을 허용한다

```java
class TvDVD extends Tv, DVD{    // 에러. 조상은 하나만 허용된다.
    // ...
}
```

- 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다. 

# Object클래스 - 모든 클래스의 조상
- 부모가 없는 클래스는 자동적으로 Object클래스를 상속받게 된다.

```java
class Tv{
    // ...
}

class SmartTv extends Tv{
    // ...
}


// Tv클래스의 부모클래스가 없어서 Object를 컴파일러가 자동으로 추가함
class Tv extends Object {
    //...
}
```
- 모든 클래스는 Object클래스에 정의된 11개의 메서드를 상속받는다.<br>
toString(), equals(Object obj), hashCode(),...

# 오버라이딩(Overriding)
- 상속받은 조상의 메서드를 자신에 맞게 변경하는 것

```java
class Point {
    int x;
    int y;

    String getLocation(){
        return "x :"  + x + ", y :" + y;
    }
}

class Point3D extends Point{
    int z;

    String getLocation(){   // 오버라이딩
        return "x :"  + x + ", y :" + y + ", z :" + z;
    }
}
```

## 오버라이딩의 조건
1. 선언부가 조상클래스의 메서드와 일치해야 한다.
2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.

## 오버로딩 vs 오버라이딩

    오버로딩(overloading)   기존에 없는 새로운 메서드를 정의하는 것(new)
    오버라이딩(overriding)  상속받은 메서드의 내용을 변경하는 것(change, modify)

# 참조변수 super
- 객체 자신을 가리키는 참조변수. 인스턴스 메서드(생성자)내에만 존재
- 조상의 멤버를 자신의 멤버와 구별할 때 사용

# super() - 조상의 생성자
- 조상의 생성자를 호출할 때 사용
- 조상의 멤버는 조상의 생성자를 호출해서 초기화
- 생성자의 첫 줄에 반드시 생성자를 호출해야 한다.

# 패키지(package)
- 서로 관련된 클래스의 묶음
- 클래스는 클래스 파일(*.class), 패키지는 폴더. 하위 패키지는 하위 폴더
- 클래스의 실제 이름(full name)은 패키지를 포함.(java.lang.String)

## 패키지 선언
- 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
- 같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.
- 패키지 선언이 없으면 이름없는(unnamed) 패키지에 속하게 된다.

# import문
- 클래스를 사용할 때 패키지이름을 생략할 수 있다.
- 컴파일러에게 클래스가 속한 패키지를 알려준다.
- java.lang패키지의 클래스는 import하지 않고도 사용할 수 있다.
- import문을 선언하는 방법은 다음과 같다.

```java
import 패키지명.클래스명;
// 또는
import 패키지명.*;
```

- import문은 패키지문과 클래스선언의 사이에 선언한다.
- import문은 컴파일 시에 처리되므로 프로그램의 성능에 영향이 없음
- 이름이 같은 클래스가 속한 두 패키지를 import할 때는 클래스 앞에 패키지명을 붙여줘야 한다.

## static import문
- static멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.

# 제어자(modifier)
- 클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여

> 접근제어자 : public, protected, (default), private <br>
> 그     외 : static, final, abstract, native, transient, synchronized, volatile, strictfp

- 하나의 대상에 여러 제어자를 같이 사용 가능(접근 제어자는 하나만)

# 접근 제어자(access modifier)
- private : 같은 클래스 내에서만 접근이 가능하다.
- (default) : 같은 패키지 내에서만 접근이 가능하다.
- protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
- public : 접근 제한이 없다

|제어자|같은 클래스|같은 패키지|자손 클래스| 전체|
|:---:|:---:|:---:|:---:|:---:|
|public|O|O|O|O|
|Protected|O|O|O||
|(default)|O|O|||
|private|O||||

# 캡슐화와 접근 제어자

## 접근 제어자를 사용하는 이유
- 외부로부터 데이터를 보호하기 위해서
- 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서

# 다형성(polymorphism)
- 여러 가지 형태를 가질 수 있는 능력
- 조상 타입 참조 변수로 자손 타입 객체를 다루는 것
- 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 없다.

## 다형성의 장점
1. 다형적 매개변수
2. 하나의 배열에 여러 종류 객체 저장

# 참조변수의 형변환
- 사용할 수 있는 멤버의 갯수를 조절하는 것
- 조상 자손 관계의 참조변수는 서로 형변환 가능

# instanceof 연산자
- 참조변수의 형변환 가능여부 확인에 사용. 가능하면 true 반환
- 형변환 전에 반드시 instacnof로 확인해야 함

```java
void dowork(Car c){
    if (c instanceof FireEngine){           // 1. 형변환이 가능한지 확인
        FireEngine fe = (FireEngine)c;      // 2. 형변환
        fe.water();
    }
}
```

# 매개변수의 다형성
- 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다.

# 여러 종류의 객체를 배열로 다루기
- 조상 타입의 배열에 자손들의 객체를 담을 수 있다.

# 추상 클래스(abstract class)
- 미완성 설계도. 미완성 메서드를 갖고 있는 클래스

```java
abstract class Player{  // 추상클래스(미완성 클래스)
    abstract void play(int pos);    // 추상메서드(몸통{}이 없는 미완성 메서드)
    abstract void stop();           // 추상메서드
}
```
<br>

- 다른 클래스 작성에 도움을 주기 위한 것. 인스턴스 생성 불가.

```java
Player p = new Player();    // 에러. 추상 클래스의 인스턴스 생성 불가
```
<br>

- 상속을 통해 추상 메서드를 완성해야 인스턴스 생성 가능

```java
class AudioPlayer extends Player{
    void play(int pos) { /* 내용 생략 */ }      // 추상메서드를 구현
    void stop() { /* 내용 생략 */ }             // 추상메서드를 구현
}

AudioPlayer ap = new AudioPlayer();     //OK
```

<br>

- 미완성 메서드. 구현부(몸통, {})가 없는 메서드

```java
abstract 리턴타입 메서드이름();
```

## 추상클래스의 작성

- 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존클래스의 공통 부분을 뽑아서 추상클래스를 만든다.