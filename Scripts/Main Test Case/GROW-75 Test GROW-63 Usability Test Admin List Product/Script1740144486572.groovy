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
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/button_Admin'))
WebUI.setText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/input_Email_email'), 'admingrowia@gmail.com', FailureHandling.OPTIONAL)
WebUI.setEncryptedText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/input_Password_password'), 'ifaosMFbSXNHQUAD8d1E6Q==', FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/button_Sign In-'), FailureHandling.OPTIONAL)

// Klik menu List Produk
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/a_List Produk'), FailureHandling.OPTIONAL)

// Verifikasi elemen-elemen di halaman List Produk
WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/img_List Produk_inline transition-all durat_356faf'), 0, FailureHandling.OPTIONAL)
WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/h2_Product'), 'Product', FailureHandling.OPTIONAL)
WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/span_List Produk'), 'List Produk', FailureHandling.OPTIONAL)
WebUI.verifyElementVisible(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/img_List Produk_fill-white'), FailureHandling.OPTIONAL)
WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/div_Product_radix-r0'), 0, FailureHandling.OPTIONAL)

// Klik elemen lain dan verifikasi
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/html_katalonfont-familymonospacefont-size13_0fa88e'), FailureHandling.OPTIONAL)
WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/div_Hi,Admin'), 'Hi,Admin', FailureHandling.OPTIONAL)
WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/button_Keluar'), 'Keluar', FailureHandling.OPTIONAL)

// Klik tombol Keluar
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Admin List Product/Page_Growia Gadget/button_Keluar'))

// Tutup browser
WebUI.closeBrowser()
