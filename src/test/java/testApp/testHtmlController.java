package testApp;

import com.app.controllers.HtmlController;
import org.junit.*;
import java.io.FileReader;
import java.net.URL;
import static junit.framework.TestCase.assertTrue;

public class testHtmlController {

    private HtmlController htmlController;

    @Before
    public void iniTest() throws Exception {
        htmlController = new HtmlController();
        htmlController.downloadHtml(new URL("https://yandex.ru/dev/"));
    }

    @After
    public void afterTest(){
        htmlController = null;
    }

    @Test
    public void testGetHtmlDoc() throws Exception{
        assertTrue(!htmlController.getHtmlDoc().equals(""));
    }

    @Test
    public void testSaveFile() throws Exception{
        htmlController.saveInFile();
        FileReader reader = new FileReader("index.html");
        int c;
        String s="";
        while((c=reader.read())!=-1){
            s+=String.valueOf((char)c);
        }
        assertTrue(s!="");
    }
}
