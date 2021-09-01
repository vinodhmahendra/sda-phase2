import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StandardTests {
	
	@BeforeAll
	static void initAll() {
		System.out.println("initAll method has to been executed before all the test method");
	}
	
	@BeforeEach
	void init() {
		System.out.println("init method is executed before each test method");
	}
	
	@Test
	@Disabled
	void failingTest() {
		System.out.println("this method always fails");
		fail("always test fails");
	}
	
	@Test
	void succeedingTest(){
		System.out.println("succeeding test");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After Each method is invoked");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("after all method is invoked!");
	}
}
