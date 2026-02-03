package ui.tests;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ui.data.Standard_userData;

public class Standard_userTests extends Standard_userData {
	Random rand = new Random();

	@BeforeTest
	public void SetUp() {
		driver.get(TheWebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	
	
	@Test(priority = 1)
	public void SuccessfullyLogin() throws InterruptedException {
		
		driver.navigate().to(TheWebSite);
		Thread.sleep(3000);
		WebElement UserNameField = driver.findElement(By.id("user-name"));
		WebElement PasswordField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameField.sendKeys(UserName);
		PasswordField.sendKeys(Password);
		LoginButton.click();

		Assert.assertTrue(driver.getPageSource().contains(ExpectedForSuccess), "Successful login message not found");

	}
	
	

	@Test(priority = 2)
	public void AddItemToCart() {

		WebElement AddBackPack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement CartButton = driver.findElement(By.className("shopping_cart_link"));

		AddBackPack.click();
		CartButton.click();

		Assert.assertTrue(driver.getPageSource().contains(ExpectedAddToCart), "Can not add item  to cart");

	}

	
	
	@Test(priority = 3)

	public void Checkout() {

		WebElement CheckoutButton = driver.findElement(By.id("checkout"));
		CheckoutButton.click();

		WebElement TheFirstNameInputField = driver.findElement(By.id("first-name"));
		WebElement TheLastNameInputField = driver.findElement(By.id("last-name"));
		WebElement ThePostalCodeInputField = driver.findElement(By.id("postal-code"));
		WebElement ThecountinueButton = driver.findElement(By.id("continue"));
		TheFirstNameInputField.sendKeys(FirstName);
		TheLastNameInputField.sendKeys(LastName);
		ThePostalCodeInputField.sendKeys(PostalCode);
		ThecountinueButton.click();

		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();

		Assert.assertTrue(driver.getPageSource().contains(ExpectedCheckOut), "Can not checkout successfully");

	}

	
	
	@Test(priority = 4)
	public void AddAllTheProducts() {
		driver.navigate().to(HomePage);

		List<WebElement> AddToCart = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		for (int i = 0; i < 6; i++) {

			AddToCart.get(i).click();

		}

		List<WebElement> NameOfProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		List<WebElement> PriceOfProducts = driver.findElements(By.cssSelector(".inventory_item_price"));
		List<WebElement> DescOfProducts = driver.findElements(By.cssSelector(".inventory_item_desc"));
		List<WebElement> ImagesOfProducts = driver.findElements(By.cssSelector(".inventory_item_img"));

		for (int i = 0; i < 6; i++) {

			System.out.println(NameOfProducts.get(i).getText() + "\t" + PriceOfProducts.get(i).getText() + "\t"
					+ DescOfProducts.get(i).getText() + "\t" + ImagesOfProducts.get(i).getAttribute("src"));
		}

		Assert.assertTrue(driver.getPageSource().contains(ExpectedAddAllToCart), "Can not add all item  to cart");

	}
	
	

	@Test(priority = 5)
	public void DeleteAllProducts() {

		List<WebElement> DeleteCart = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
		for (int i = 0; i < 6; i++) {

			DeleteCart.get(i).click();

			Assert.assertTrue(driver.getPageSource().contains(ExpectedDeleteAllToCart),
					"Can not remove all item  to cart");

		}

	}
	
	
	

	@Test(priority = 6)
	public void sorting() {

		WebElement SortingList = driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(SortingList);
		int indexForSorting = rand.nextInt(0, 4);
		myselect.selectByIndex(indexForSorting);

		List<WebElement> NameOfProducts = driver.findElements(By.cssSelector(".inventory_item_name"));

		if (indexForSorting == 0) {
			String Actual = NameOfProducts.get(0).getText();
			Assert.assertEquals(Actual, ExpectedSortingIndex0, "Products are NOT sorted by Name (A to Z)");

		}

		else if (indexForSorting == 1) {
			String Actual = NameOfProducts.get(0).getText();
			Assert.assertEquals(Actual, ExpectedSortingIndex1, "Products are NOT sorted by Name (Z to A)");

		}

		else if (indexForSorting == 2) {
			String Actual = NameOfProducts.get(0).getText();
			Assert.assertEquals(Actual, ExpectedSortingIndex2, "Products are NOT sorted by Price (Low to High)");

		}

		else if (indexForSorting == 3) {
			String Actual = NameOfProducts.get(0).getText();
			Assert.assertEquals(Actual, ExpectedSortingIndex2, "Products are NOT sorted by Price (High to Low)");

		}
	}

}
