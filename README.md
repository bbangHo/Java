# 김영한 실전 자바 기록용 Git

- 자바 메모리 구조와 static
  - 메모리 구조는 메서드 영역, 스택 영역, 힙 영역으로 나눠짐

  

  - static 변수
    - 접근 방법은 클래스명에 .을 붙여서 사용
    - 메서드 영억에 생성되는 변수이므로 프로그램 실행 중 1개만 생성 된다.



  - 멤버 변수의 종류
    - 인스턴스 변수: static 안 붙은 변수
    - 클래스 변수: static 붙은 정적 변수



  - 변수의 생명주기
    - 지역변수(매개변수): 스택 영역(메서드가 종료될 때까지)
    - 인스턴스 변수: 힙 영역(더 이상 참조되지 않을 때까지)
    - 클래스 변수: 메서드 영역(프로그램 종료될 때까지)
  


  - static 변수를 인스턴스를 통해 접근해도 되지만, 가독성이 떨어지기 때문에 웬만하면 클래스를 통해 접근하기!
  


  - 멤버 함수의 종류
    - 인스턴스 메서드: static 안 붙은 변수 
    - 클래스 메서드: static 붙은 정적 변수

    
  - static 메서드는 클래스 내부의 기능을 사용할 때, static 붙은 또 다른 메서드나 변수만 사용 가능
  - 이와 반대로 인스턴스 메서드는 언제든지 static 메서드 사용 가능(접근 제어자가 허락할 때 기준)
    - 위와 같은 이유: 인스턴스는 사용하려면 참조값을 알아야 하는데 static 메서드는 객체 생성없이 클래스를 통해서 바로 사용 가능하기 때문에 static내부에 인스턴스 사용 불가!
  
    
  - import static 메서드 경로(패키지명.클래스명.메서드명);
    - static import를 통해서 클래스명 생략후 메서드 호출 가능
  
- final
  - 변수에 final 키워드가 붙으면 그 변수에 값을 한 번 할당한 이후에는 더 이상 변경불가능

  - static void method(final int parameter) -> 다음과 같이 매개변수에 final 붙으면
      parameter = 20; 와 같이 메서드 안에서는 저 변수에 값 할당 불가능(final 때문에)

  - 멤버 변수에 final 있고 바로 초기화 되어있으면 저 멤버 변수에 접근 할 때 객체 생성해서 접근해도 어짜피 항상 같은 값이기 때문에 static final을 사용해서 클래스로 접근하는게 메모리 낭비 x
    
  - 자바에서 상수 나타낼 때 static final 사용함
  - 상수의 이름은 대문자만 사용하고 구분은_(언더바) 사용 -> ex) 파이 상수 public static final double PI = 3.14;
  - 위에서 말했듯이 클래스로 직접 접근해서 사용함

- 참조형 변수의 final
  - final이 붙은 참조형 변수에 한 번 참조값 할당하면 다른 인스턴스 생성해서 참조 불가능 하다
  - 하지만 참조하는 대상의 값을 변경하지 못하는 건 아니다. -> 객체의 값들(멤버 변수, 멤버 함수)은 변경가능
  

- 상속(오버라이딩)
  - 부모클래스(슈퍼클래스): 자식에게 자신의 필드, 메서드 제공하는 클래스
  - 자식클래스(서브클래스): 부모 클래스로부터 필드, 메서드 상속 받는 클래스
  

- 단일 상속
  - 자바는 부모를 하나만 선택 가능(다중 상속 지원x) -> 복잡해지기 때문에


- 상속과 메모리 구조
  - 상속 관계의 객체를 생성하면 그 내부에는 부모와 자식(인스턴스) 모두 생성됨
  - 상속 관계 객체 호출할 때, 대상 타입을 정해야 하는데, 이때 호출자의 타입을 통해 대상 타입을 찾음
  - 현재 탑입에서 기능을 찾지 못하면 상위 부모타입으로 찾아 올라가고 그래도 기능이 없으면 컴파일 오류 발생


- 상속과 메서드 오버라이딩
  - 오버라이딩은 재정의 한다는 의미
  - 부모 클래스에서 사용하던 메서드를 자식 클래스에서 재정의 해서 사용하고 싶을때 사용
  - 부모 클래스에서 서용하던 메서드를 자식 클래스에 그대로 붙여넣고 메서드 위에 @Override 를 해준다
  - 어노테이션을 안 붙여도 오버라이딩 되지만 명시적으로 표시해야 실수로 함수 이름을 잘못 적었을 때 컴파일 오류를 통해서 바로 알 수 있다.
  - 메서드 오버라이딩 하기 위한 조건은 메서드 이름, 파라미터, 반환타입이 같아야 하고, 하위 클래스의 접근 제어자가 상위 클래스의 접근 제어자보다 제한적이면 안되고, 생성자는 오버라이딩 할 수 없다.


- super
  - 원래 부모와 자식의 필드명이 같거나 메서드가 오버라이딩
  되어 있으면 자식에서 부모의필드나 메서드를 호출할 수 없지만 super를 사용하면 부모 클래스에 대한 참조 가능
  - 상속 관계에 있는 클래스면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야함
  - 자식의 생성자에 super()을 해주면 됨 
  - 가장 하위의 클래스를 통해 생성자를 만들어도 상속 관계라면 super()을 통해 가장 최상위 클래스의 생성자부터 순서대로 내려오면서 내가 생성하기 원했던 생성자 클래스의 생성자까지 실행된다
  - this()와 함께 사용할 때, this()를 통해서 넘어가는 생성자들 중에 super()가 반드시 한 번은 있어야함


- 다형적 참조
  - 부모 타입은 자식 타입을 담을 수 있다.
  - 하지만 자식 타입은 부모 타입을 담을 수 없고, 그러한 시도를 하면 컴파일 오류가 발생한다.
  - 부모 타입으로 자식 타입을 담을 수는 있지만, 그렇게 되면 자식 타입에 있는 기능은 호출할 수 없다. -> 메서드를 실행하면 참조값을 통해 인스턴스를 찾고 상속 관계에서 부모 방향으로 찾아 올라갈 수 있지만 자식 쪽으로는 내려올 수 없기 때문에, 이렇게 부모가 자식을 참조한 상황에서 자식의 메서드를 호출 할 수 없는 것이다.

- 다운캐스팅
  - 부모를 자식 타입으로 변경할 때 자식 형의 변수에 담아서 사용할 수 있지만,
  이렇게 하면 번거롭기 때문에 일시적 다운캐스팅을 사용할 수 있다.
  - 일시적 다운캐스팅 형태 ex) 
  ((자식형) 부모형 변수).자식Method()

- instanceof
  - 오른쪽에 있는 타입에 왼쪽에 있는 인스턴스 타입이 들어갈 수 있는지 확인해줌
  - 자바16에서부터는 instanceof를 사용하는 동시에 변수를 선언할 수 있다.
  ex) parent instanceof Child child

- 다형적 참조와 메서드 오버라이딩
  - 멤버 변수는 오버라이딩 되지 않고, 메서드는 오버라이딩 되는데 부모에 자식 인스턴스를 담는 다형적 참조를 할 때 오버라이딩 된 메서드는 항상 우선권을 가진다.

- 오버라이딩 단축키 ctrl +o

- 추상 클래스
  - 추상 클래스는 실체인 인스턴스가 존재하지 않고 상속 목적을 사용된다
  - 부모 클래스 역할을 담당
  - 추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야함
  - 추상 메서드는 상속 받는 자식 클래스가 반드시 오버라이딩 해서 사용해야 한다
  - 만약 자식 클래스가 오버라이딩 하지 않으면 자식도 추상 클래스가 되어야함

- 순수 추상 클래스와 인터페이스
  - 오로지 추상 메서드만 있는 클래스
  - 자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스라는 기능을 제공함
  - 인터페이스의 메서드에서는 public abstract를 생략할 수 있다(생략이 권장 됨)
  - 인터페이스에서 상수 정도는 정의 가능 그 대신 public, static, final 생략 하고 사용 하는 편
  - 인터페이스에서는 상속 받을 때 extends 대신 implements 사용함
  - 순수 추상 클래스에는 다른 곳에서 쓸 수 있는 일반적인 메서드를 끼워 넣을 수 있지만 인터페이스는 그게 불가능하므로 추상메서드만
사용하고 싶다면 인터페이스를 사용하는게 맞다.

- 다중 구현
  - 클래스는 다중 상속을 허용하지 않지만 인터페이스는 자식이 상속받은 메서드를 구현하는 것이기 때문에 다중 구현이 가능
  - 상속(extends), 구현(implements) 두개 동시에 사용 가능
  - extends를 통한 상속은 하나만 할 수 있고 implements를 통한 인터페이스는 다중 구현 할 수 있기 때문에 둘이 함께 나온 경우 extends가 먼저 나와야한다.
  - 