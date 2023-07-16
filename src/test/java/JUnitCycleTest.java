import org.junit.jupiter.api.*;
public class JUnitCycleTest {
	@BeforeAll //전체테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
	static void beforeAll() {
		System.out.println("@BeforeAll");
	}

	@BeforeEach // 테스 트 케 이 스 를 시 작 하 기 전 마 다 실 행
	public void beforeEach() {
		System.out.println("@BeforeEach");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

	@Test
	public void test3() {
		System.out.println("test3");
	}

	@AfterAll // 전체테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로선언
	static void afterAll() {
		System.out.println("@AfterAll");
	}

	@AfterEach //테스트케이스를종료하기전마다실행
	public void afterEach() {
		System.out.println("@AfterEach");
	}
}