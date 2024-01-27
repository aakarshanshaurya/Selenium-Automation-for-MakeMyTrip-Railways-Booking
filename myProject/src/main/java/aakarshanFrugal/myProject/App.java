package aakarshanFrugal.myProject;

/**
 * Hello world!
 *
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	WebDriver driver;

	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/KIIT/Desktop/SELENIUM/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/railways/");
		// Check if you have landed in the correct page
		// Print the URL and Title of the Page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		String url = driver.getCurrentUrl();
		System.out.println("URL of the page is: " + url);

		// click on element using xpath
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
		// click on element using id

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"))
				.sendKeys("Delhi");
		// wait until element is not visible
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// find the len of all the elements find using selector
		int len = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
		System.out.println("len of the list is: " + len);

		// define a loop to iterate through the list
		for (int i = 0; i < len; i++) {
			// find the element using index
			String element = driver.findElements(By.cssSelector(
					"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
					.get(i)
					.getText();
			System.out.println("Element is: " + element);
			// check if the element is equal to the search term
			if (element.equals("Delhi")) {
				// click on the element
				driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).click();
				break;
			}
		}

		// Selecting Destination
		// click on element using xpath
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
		// click on element using id

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"))
				.sendKeys("Lucknow");
		// wait until element is not visible
		Thread.sleep(2000);

		// find the len of all the elements find using selector
		len = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
		System.out.println("len of the list is: " + len);

		// define a loop to iterate through the list
		for (int i = 0; i < len; i++) {
			// find the element using index
			String element = driver.findElements(By.cssSelector(
					"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
					.get(i)
					.getText();
			System.out.println("Element is: " + element);
			// check if the element is equal to the search term
			if (element.equals("Lucknow")) {
				// click on the element
				driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).click();
				break;
			}
		}

		// Selecting Date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/input"))
				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
//				.click();
		int a = 0;
		while(a != 3) {
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")).click();
			a++;
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[2]")).click();
		
		// Selecting Class
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
		len = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
		System.out.println("len of the list is: " + len);
		for (int i = 0; i < len; i++) {
			String element = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).getText();
			System.out.println("Element is: " + element);
			if (element.equals("Third AC")) {
				driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).click();
				break;
			}
		}

		// Clicking Search button
		Thread.sleep(2000);
		driver.findElement(By.xpath("// *[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
//		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		App obj = new App();
		obj.launchBrowser();

	}

}
