import { remote } from 'webdriverio';
import { expect } from 'chai';

const caps = {
  platformName: "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:appPackage": "com.swaglabsmobileapp",
  "appium:appActivity": "com.swaglabsmobileapp.MainActivity",
  "appium:appWaitActivity": "*",
  "appium:noReset": true,
  "appium:autoGrantPermissions": true
};

async function runTest() {
  const driver = await remote({
    protocol: 'http',
    hostname: '127.0.0.1',
    port: 4723,
    path: '/',
    capabilities: caps
  });

  await driver.setTimeout({ implicit: 15000 });
  await driver.pause(4000);

  try {
    /* ===============================
       TC-MOB-01: Login
       =============================== */

    const username = await driver.$("accessibility id:test-Username");
    await username.waitForDisplayed();
    await username.setValue("standard_user");

    const password = await driver.$("accessibility id:test-Password");
    await password.waitForDisplayed();
    await password.setValue("secret_sauce");

    const loginBtn = await driver.$("accessibility id:test-LOGIN");
    await loginBtn.click();

    const productsTitle = await driver.$("accessibility id:test-PRODUCTS");
    await productsTitle.waitForDisplayed();
    expect(await productsTitle.isDisplayed()).to.equal(true);
    console.log(" PASS: Login successful");

    /* ===============================
       TC-MOB-02: Add Item & View Cart
       =============================== */

    const addToCartBtn = await driver.$("accessibility id:test-ADD TO CART");
    await addToCartBtn.waitForDisplayed();
    await addToCartBtn.click();

    const cartIcon = await driver.$("accessibility id:test-Cart");
    await cartIcon.waitForDisplayed();
    await cartIcon.click();

    const removeBtnsInCart = await driver.$$("accessibility id:test-REMOVE");
    expect(removeBtnsInCart.length).to.be.greaterThan(0);
    console.log(" PASS: Item added to cart");

    /* ===============================
       TC-MOB-03: Remove Item & Verify
       =============================== */

    const continueShoppingBtn = await driver.$("accessibility id:test-CONTINUE SHOPPING");
    await continueShoppingBtn.waitForDisplayed();
    await continueShoppingBtn.click();

    const removeBtnFromProducts = await driver.$("accessibility id:test-REMOVE");
    await removeBtnFromProducts.waitForDisplayed();
    await removeBtnFromProducts.click();

    await cartIcon.click();

    const removeAfterDelete = await driver.$$("accessibility id:test-REMOVE");
    expect(removeAfterDelete.length).to.equal(0);
    console.log(" PASS: Item removed from cart");

    console.log(" ALL TEST CASES PASSED");

  } catch (error) {
    console.error("TEST FAILED");
    console.error(error.message);
  } finally {
    await driver.pause(3000);
    await driver.deleteSession();
  }
}

runTest();