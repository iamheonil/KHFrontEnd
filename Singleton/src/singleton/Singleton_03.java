package singleton;

// 단점

// 1. 인스턴스 생성할 추가 작업을 할 수 없다. -> 예외처리 불가능
// 2. 인스턴스(객체)를 사용하지 않아도 생성해놓는다. -> 최대한 늦게 만들어준다.

// 단점 보완 2개 다
// 1. 예외처리 가능하게 코드를 작성한다. 
// 2. 인스턴스(객체)를 사용하지 않아도 생성해놓는다. -> 최대한 늦게 만들어준다.

public class Singleton_03 {

	public String data = "APPLE"; // DATA

	// private 생성자 - 클래스 외부에서 객체를 생성하지 못한다.

	private Singleton_03() {

	}

	// 자신 클래스에 대한 객체 생성
	private static Singleton_03 instance;

	// 싱글톤 객체 반환 메소드
	public static Singleton_03 getInstance() {
		// getInstance() 객체를 처음 호출할 때까지 생성하지 않고 기다린다.
		// 두번째 호출부터는 만들어져 있는 객체를 반환한다.
		
		// 생성
		if (instance == null) {
			try {
				instance = new Singleton_03();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 반환
		return instance;

	}

}
