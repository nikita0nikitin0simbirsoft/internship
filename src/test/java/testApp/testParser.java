package testApp;

import com.app.logic.Parser;
import com.app.model.ListWord;
import com.app.model.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class testParser {

    private Parser parser;

    @Before
    public void iniTest() throws Exception {
        parser = new Parser();
    }

    @After
    public void afterTest(){
        parser = null;
    }

    @Test
    public void testParser() throws Exception{
        parser.parse("<html>\n" +
                "<header>\n" +
                "</header>\n" +
                "<body>\n" +
                "<div>\n" +
                "fdsf 32324... sda\n" +
                "</div>\n" +
                "</body>");
        ListWord expected = parser.getListWord();
        ListWord actual = new ListWord(); actual.add(new Word(1,"fdsf")); actual.add(new Word(1,"sda"));
        assertTrue(expected.get(0).getWord().equals(actual.get(0).getWord()));
    }
}
