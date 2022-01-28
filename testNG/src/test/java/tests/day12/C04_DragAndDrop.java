package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {

@Test
public void test() throws InterruptedException {
	// go to https://demoqa.com/droppable
	driver.get("https://demoqa.com/droppable");
	
	// Let's hold the "Drag me" button and drop it above the "Drop here" box
	Actions actions=new Actions(driver);
	WebElement dragMeButton=driver.findElement(By.xpath("(//div[@id='draggable'])[1]"));
	WebElement droppable=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
	actions.dragAndDrop(dragMeButton,droppable).perform();
	
	// 3- Instead of “Drop here”, test that is is written “Dropped!”
	WebElement dropedAreatext=driver.findElement(By.xpath("//p[text()='Dropped!']"));
	String actualDroppedText=dropedAreatext.getText();
	String expectedDroppedText="Dropped!";
	
	Assert.assertEquals(actualDroppedText,expectedDroppedText);
	
}
}
