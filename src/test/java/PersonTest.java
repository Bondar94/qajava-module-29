import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void BeforeClass() {
        System.out.println("Before Class");
        currentTime();
    }

    @AfterClass
    void AfterClass() {
        System.out.println("After Class");
        currentTime();
    }

    @DataProvider(name = "teenDataProvider")
    Object[][] teenDataProvider() {
        return new Object[][]{
                {0, false},
                {12, false},
                {13, true},
                {15, true},
                {18, true},
                {19, true},
                {20, false},
                {99, false}
        };
    }

    @Test(dataProvider = "teenDataProvider")
    public void Test(int arg1, boolean expectedResult) {
        boolean result = Person.isTeenager(arg1);
        System.out.println(result);
        assertEquals(result, expectedResult);
    }
}

