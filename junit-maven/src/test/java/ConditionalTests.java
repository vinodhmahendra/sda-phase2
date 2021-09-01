import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTests {
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void executeOnWindows() {
		System.out.println("This method executes on windows -OS");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX})
	public void executeOnLinux() {
		System.out.println("This method executes on linux -os");
	}

}
