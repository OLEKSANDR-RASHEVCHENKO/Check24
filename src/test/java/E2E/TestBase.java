package E2E;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static E2E.ApplicationManager app = new E2E.ApplicationManager();

    @BeforeMethod
    public void setupTest(){
        app.init();
    }
//    @AfterMethod
//    public void tearDown(){
//        app.stop();
//    }
}