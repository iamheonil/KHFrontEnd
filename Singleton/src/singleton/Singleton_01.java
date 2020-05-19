package singleton;


// 단점
// 1. 인스턴스 생성할 추가 작업을 할 수 없다. -> 예외처리 불가능
// 2. 인스턴스(객체)를 사용하지 않아도 생성해놓는다.
//


public class Singleton_01 {

	public String data = "APPLE"; // DATA
	
	// private 생성자 - 클래스 외부에서 객체를 생성하지 못한다.

	private Singleton_01() {
		
	}
	
	// 자신 클래스에 대한 객체 생성
	private static Singleton_01 instance = new Singleton_01();

	
	// 싱글톤 객체 반환 메소드
	public static Singleton_01 getInstance() {
		return instance;
	}
	
}
