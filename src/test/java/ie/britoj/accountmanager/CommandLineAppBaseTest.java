package ie.britoj.accountmanager;

import org.junit.Before;

import java.io.ByteArrayOutputStream;

abstract class CommandLineAppBaseTest {
    ByteArrayOutputStream outputStream;
    CommandLineApp app;


    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
    }

    String[] getMenuLines() {
        String printedMenu = new String(outputStream.toByteArray());
        return printedMenu.split("\n");
    }
}
