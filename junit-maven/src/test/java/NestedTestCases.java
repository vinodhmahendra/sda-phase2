import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTestCases {
	@Test
	void test() {
		System.out.println("outer class test method");
	}
	
	@Nested
	class InnerClass {
		@Test
		void test() {
			System.out.println("inner class test method");
		}
	}
}
