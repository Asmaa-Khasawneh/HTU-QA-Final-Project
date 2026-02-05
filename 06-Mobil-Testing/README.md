# Mobile Automation Testing – Appium

## Project Overview
This section covers basic mobile automation testing using Appium on an Android emulator as part of the Software Testing & QA project. The objective is to validate a complete e-commerce user flow including login, add to cart, view cart, return to shopping page, remove item, and verify that the cart is empty.

The automation was implemented using Appium with UiAutomator2, WebdriverIO, and JavaScript on an Android Emulator, using the Sauce Labs Sample Mobile Application.

---

## System Under Test
- Application: Sauce Labs Sample App (Android)
- Platform: Android
- Device: Android Emulator
- Automation Tool: Appium (UiAutomator2)

---

## Test Scenarios Covered

### TC-MOB-01: Login Successfully
- Enter valid username and password
- Click Login button
- Verify successful login by checking that the Products page is displayed

### TC-MOB-02: Add Item to Cart and View Cart
- Add an item from the Products page
- Navigate to the Cart
- Verify that the item exists in the cart

### TC-MOB-03: Remove Item and Verify Cart is Empty
- Navigate back to the Products page
- Remove the item
- Open the Cart again
- Verify that the cart is empty

---

## Automation Details
- Accessibility IDs were used as the primary locators to ensure stable and maintainable automation
- Assertions were implemented using Chai
- Fast-fail assertions were applied to immediately stop execution in case of failure
- The automation validates login, add-to-cart, and remove-from-cart functionalities

---

## Test Execution
The mobile automation test was executed on an Android Emulator with Appium Server running on port 4723. The test execution completed successfully, and all assertions passed without failures.


---

## Evidence
All execution evidence including screenshots, Appium Inspector recordings, emulator execution, and console logs are provided via Google Drive to keep the repository clean and lightweight.

🔗 Evidence link:  
https://drive.google.com/drive/folders/1D-3qzehksHbADO-ayRAKu9kVyD0iG1BA?usp=sharing

---

## Notes
This mobile automation testing section complements the web UI, API testing, and performance testing components of the overall QA project.