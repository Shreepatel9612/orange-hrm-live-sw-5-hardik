package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestDataLogin {
    @DataProvider(name = "invalidLoginData")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"", "test123@gmail.com", "Required"},    // Missing username
                {"test123", "", "Required"},                    // Missing password
                {"test123@gmail.com", "test123", "Invalid credentials"}


        };

        return data;




    }
}
