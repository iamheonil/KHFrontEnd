package singleton;

// 단점
// 1. 인스턴스 생성할 추가 작업을 할 수 없다. -> 예외처리 불가능
// 2. 인스턴스(객체)를 사용하지 않아도 생성해놓는다.

// 단점 보완(해결)
// 1번

public class Singleton_02 {

	public String data = "APPLE"; // DATA

	// private 생성자 - 클래스 외부에서 객체를 생성하지 못하게 막는다.
	private Singleton_02() {

	}

	// 자신 클래스에 대한 객체 생성
	// 여기서 new를 사용하여 새로 만들어주지 않는다.
	private static Singleton_02 instance;

	// 아래와 같은블록을 static 초기화 블록 이라고 한다.
	// 클래스 변수(정적 변수)를 초기화 하는 블록
	// = private static Singleton_02 instance 를 초기화

	static {
		try {
			instance = new Singleton_02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 싱글톤 객체 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}

}
