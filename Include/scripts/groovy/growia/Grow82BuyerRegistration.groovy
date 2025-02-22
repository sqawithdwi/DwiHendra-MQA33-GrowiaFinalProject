package growia

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Grow82BuyerRegistration {

	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("Buyer sudah berada di halaman Sign up")
	def signupUrl() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.SignupUrl)
	}

	@When("Buyer input Nama (.*)")
	def inputName(String name) {
		WebUI.sendKeys(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Nama_nama'), name)
	}

	@And("input Email (.*)")
	def inputEmail(String email) {
		WebUI.sendKeys(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Email_email'), email)
	}

	@And("input password (.*)")
	def inputPassword(String password) {
		WebUI.setEncryptedText(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Password_password'), password)
	}

	@And("input retype password (.*)")
	def inputRetypePassword(String retypePassword) {
		WebUI.setEncryptedText(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Retype Password_retypePassword'), retypePassword)
	}

	@And("klik tombol Sign up")
	def clickBtnSignup() {
		WebUI.click(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/button_Sign Up'))
	}

	@Then("Buyer berhasil (.*) mendaftar")
	def statusOk(String statusok) {
		WebUI.verifyElementText(findTestObject('GROW-82BuyerRegistration/Page_Growia Gadget/div_Success'), statusok)
	}

	@Then("Buyer gagal mendaftar dengan pesan error (.*)")
	def statusNok(String statusnok) {
		WebUI.verifyElementText(findTestObject('GROW-82BuyerRegistration/Page_Growia Gadget/div_Error'), statusnok)
	}

	@And("input Email salah format (.*)")
	def inputInvalidEmail(String email1) {
		WebUI.sendKeys(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Email_email'), email1)
	}

	@And("input Password tidak mengandung minimal satu huruf besar, satu special karakter dan satu angka (.*)")
	def inputWeakPassword(String password) {
		WebUI.setEncryptedText(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Password_password'), password)
	}

	@And("input Password kurang dari 8 karakter (.*)")
	def inputShortPassword(String password) {
		WebUI.setEncryptedText(findTestObject('Object Repository/GROW-82BuyerRegistration/Page_Growia Gadget/input_Password_password'), password)
	}
}
