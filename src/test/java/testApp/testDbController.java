package testApp;

import com.app.database.DataBase;
import com.app.model.ListWord;
import com.app.model.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testDbController {

    private DataBase db;

    @Before
    public void iniTest() throws Exception {
        db = new DataBase();
    }

    @After
    public void afterTest(){
        db = null;
    }

    @Test
    public void testInsertInDb() throws Exception{
        ListWord list = new ListWord(); list.add(new Word(1,"fdsf")); list.add(new Word(1,"sda"));
        db.saveListWordInDb(list);
    }
}
