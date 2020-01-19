package testApp;

import com.app.controllers.DbController;
import com.app.model.ListWord;
import com.app.model.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testDbController {

    private DbController dbController;

    @Before
    public void iniTest() throws Exception {
        dbController = new DbController();
    }

    @After
    public void afterTest(){
        dbController = null;
    }

    @Test
    public void testInsertInDb() throws Exception{
        ListWord list = new ListWord(); list.add(new Word(1,"fdsf")); list.add(new Word(1,"sda"));
        dbController.saveListWordInDb(list);
    }
}
