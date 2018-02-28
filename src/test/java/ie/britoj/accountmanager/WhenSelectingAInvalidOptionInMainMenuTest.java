package ie.britoj.accountmanager;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenSelectingAInvalidOptionInMainMenuTest extends CommandLineAppBaseTest{


    @Test
    public void AWarningMessageIsDisplayed(){
        app = new CommandLineApp(new Scanner("A ex"), new PrintStream(outputStream));
        app.run();
        String[] menuLines = getMenuLines();
        assertThat(menuLines).hasSize(4);
        assertThat(menuLines[0]).isEqualTo("Please select a option:");
        assertThat(menuLines[1]).isEqualTo("oa - open an account");
        assertThat(menuLines[2]).isEqualTo("ex - exit");
        assertThat(menuLines[3]).isEqualTo("invalid option");
    }

}
