import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class DemoOnDynamicTests {
	
	@TestFactory
	Collection<DynamicTest> test_from_collection(){
		return Arrays.asList(
					dynamicTest("simple test 1", ()->assertTrue(true)),
					dynamicTest("simple test 2", ()->assertFalse(false))
				);
	}

}
