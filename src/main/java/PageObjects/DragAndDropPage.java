package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class DragAndDropPage extends BasePage {
	@FindBy (id = "column-a")
	WebElement columnA;
	@FindBy (id = "column-b")
	WebElement columnB;
	public DragAndDropPage (Config testConfig) {
		super(testConfig);
	}
	public void drag(String boxToBeDragged) {
		WebElement fromElement = null;
		WebElement toElement = null;
		switch (boxToBeDragged) {
			case "A" :
				fromElement = columnA;
				toElement = columnB;
				break;
			case "B" :
				fromElement = columnB;
				toElement = columnA;
				break;
			default :
				break;
		}
		// TODO
		int offsetX = (toElement.getLocation().getX() - fromElement.getLocation().getX()) / 2;
		int offsetY = toElement.getLocation().getY() - fromElement.getLocation().getY();
		Actions actions = new Actions(testConfig.driver);
		actions.moveToElement(fromElement).clickAndHold(fromElement).moveByOffset(offsetX, offsetY).release().build().perform();
		actions.dragAndDropBy(fromElement, offsetX, offsetY).build().perform();
	}
	public String [] getFinalSequence() {
		return (new String [] {columnA.getText(), columnB.getText()});
	}
}
