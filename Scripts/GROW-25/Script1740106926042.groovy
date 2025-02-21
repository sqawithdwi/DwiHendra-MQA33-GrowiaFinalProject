import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://5nags3iycnjh547.growia.education/login/')

WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Admin'))

WebUI.setText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/input_Email_email'), 'admingrowia@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/input_Password_password'), 
    'ifaosMFbSXNHQUAD8d1E6Q==')

WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Sign In-'))

WebUI.openBrowser('')

WebUI.navigateToUrl('https://5nags3iycnjh547.growia.education/login/')

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/button_Admin'))

WebUI.setText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Email_email'), 'admingrowia@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Password_password'), 'ifaosMFbSXNHQUAD8d1E6Q==')

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/button_Sign In-'))

