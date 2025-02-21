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

WebUI.navigateToUrl('https://5nags3iycnjh547.growia.education/')

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/a_iPhone_p-2 hoverbg-green100 rounded-lg'))

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/a_Sign Up'))

WebUI.setText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Nama_nama'), 'Dwi Hendra')

WebUI.setText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Email_email'), 'dwierp@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Password_password'), 'UqLEkDvL5dYU1xkx+eR2zg==')

WebUI.setEncryptedText(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/input_Retype Password_retypePassword'), 
    'UqLEkDvL5dYU1xkx+eR2zg==')

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/button_Sign Up'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/li_SuccessSign up Success'), 
    0)

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/svg_Sign up Success_lucide lucide-x h-4 w-4'))

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/button_Go to Home-'))

WebUI.click(findTestObject('Object Repository/Growia-login/Page_Growia Gadget/a_iPhone_p-2 hoverbg-green100 rounded-lg'))

