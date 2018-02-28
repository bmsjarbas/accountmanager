package ie.britoj.accountmanager;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenStartingTheApplicationTest extends CommandLineAppBaseTest{


    @Test
    public void TheMainMenuIsPrinted(){
        app = new CommandLineApp(new Scanner("ex"), new PrintStream(outputStream));
        app.run();
        String[] menuLines = getMenuLines();
        assertThat(menuLines).hasSize(3);
        assertThat(menuLines[0]).isEqualTo("Please select a option:");
        assertThat(menuLines[1]).isEqualTo("oa - open an account");
        assertThat(menuLines[2]).isEqualTo("ex - exit");
    }




}
