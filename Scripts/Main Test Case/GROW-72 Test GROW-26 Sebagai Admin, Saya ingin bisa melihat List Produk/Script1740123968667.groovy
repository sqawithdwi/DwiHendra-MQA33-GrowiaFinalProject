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

// Buka browser dan navigasi ke URL
WebUI.openBrowser('')

WebUI.navigateToUrl('https://5nags3iycnjh547.growia.education/login/')

// Login sebagai admin
WebUI.click(findTestObject('Object Repository/AdminListStock/Page_Growia Gadget/button_Admin'))

WebUI.setText(findTestObject('Object Repository/AdminListStock/Page_Growia Gadget/input_Email_email'), 'admingrowia@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/AdminListStock/Page_Growia Gadget/input_Password_password'), 'ifaosMFbSXNHQUAD8d1E6Q==')

WebUI.click(findTestObject('Object Repository/AdminListStock/Page_Growia Gadget/button_Sign In-'))

// Klik menu List Produk
WebUI.click(findTestObject('Object Repository/AdminListStock/Page_Growia Gadget/a_List Produk'))

// Baca data dari file CSV
def testData = findTestData('Growia Update Stock')

// Looping untuk verifikasi setiap produk
for (int i = 1; i <= testData.getRowNumbers(); i++) {
    // Ambil NamaProduk dari file CSV
    def namaProduk = testData.getValue('NamaProduk', i)

    // Buat XPath dinamis berdasarkan NamaProduk
    def xpath = "//th[text()='$namaProduk']"

    // Buat TestObject dari XPath dinamis
    def testObject = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, xpath)

    // Verifikasi teks elemen dengan FailureHandling.OPTIONAL
    WebUI.verifyElementText(testObject, namaProduk, FailureHandling.OPTIONAL)
}

// Tutup browser
WebUI.closeBrowser()

