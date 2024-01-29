package e2e;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static e2e.ApplicationManager app = new e2e.ApplicationManager();

    @BeforeMethod
    public void setupTest(){
        app.init();
    }
//    @AfterMethod
//    public void tearDown(){
//        app.stop();
//    }
}