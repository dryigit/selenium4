package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_UsinfWrongUser {

@Test
public void test(){
Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
}
}
