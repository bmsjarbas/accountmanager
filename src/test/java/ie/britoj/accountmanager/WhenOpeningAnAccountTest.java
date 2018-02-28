package ie.britoj.accountmanager;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenOpeningAnAccountTest extends CommandLineAppBaseTest{
    @Test
    public void TheAccountMenuIsPrinted(){
        app = new CommandLineApp(new Scanner("oa jarbas"), new PrintStream(outputStream));
        app.run();
        String[] menuLines = getMenuLines();
        assertThat(menuLines[menuLines.length-5]).isEqualTo("Please select a option:");
        assertThat(menuLines[menuLines.length-4]).isEqualTo("de - deposit");
        assertThat(menuLines[menuLines.length-3]).isEqualTo("wi - withdraw");
        assertThat(menuLines[menuLines.length-2]).isEqualTo("st - statement");
        assertThat(menuLines[menuLines.length-1]).isEqualTo("ex - exit");
    }
}
