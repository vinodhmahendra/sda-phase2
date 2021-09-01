import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

	@RepeatedTest(5)
	void addNumbers(RepetitionInfo repetitionInfo) {
		System.out.println("running addNumbers test --- > " + repetitionInfo.getCurrentRepetition());
		Assertions.assertEquals(2, Calculator.add(1, 1), "1 + 1 should equal 2");
	}
}
