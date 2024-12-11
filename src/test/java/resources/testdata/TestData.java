package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "userData")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Admin", "Admin" , "Paul Collings" , "Enable"},
                {"Cassidy.Hope", "ESS","Cassidy Hope" , "Enable"},
                {"Nina.Patel", "ESS","Nina Patel" , "Enable"},


        };

        return data;




    }
}
