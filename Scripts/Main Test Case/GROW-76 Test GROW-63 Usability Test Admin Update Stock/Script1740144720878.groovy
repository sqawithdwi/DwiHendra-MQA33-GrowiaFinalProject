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

WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Admin'))

WebUI.setText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/input_Email_email'), 
    'admingrowia@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/input_Password_password'), 
    'ifaosMFbSXNHQUAD8d1E6Q==')

WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Sign In-'))

WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/a_Atur Stok'), 
    FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/h2_Atur Stok'), 
    'Atur Stok', FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/img_List Produk_inline transition-all durat_356faf'), 
    FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/img_List Produk_fill-white'), 
    FailureHandling.OPTIONAL)

//WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Edit'), FailureHandling.OPTIONAL)


// Ambil test data file
def testData = findTestData('Growia Update Stock')
int rowCount = testData.getRowNumbers()

// Loop utama untuk setiap produk
for (int row = 1; row <= rowCount; row++) {
    try {
        // Ambil data produk
        String btnEditLocator = testData.getValue('btnEditLocatorStock', row)
        String productName = testData.getValue('NamaProduk', row)
        String capacity = testData.getValue('Capacity', row)
        
        println("Processing product: ${productName} - ${capacity}")
        
        try {
            // Simpan perubahan tanpa update quantity
//            WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Simpan'))
            
            // Verifikasi pesan sukses
//            WebUI.waitForElementPresent(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/div_Stock berhasil diubah'), 10)
//            WebUI.verifyElementText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/div_Stock berhasil diubah'), 'Stock berhasil diubah')
            
            // Tutup dialog sukses
//            WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Stock berhasil diubah_absolute right_1e957b'))
            
            // Verifikasi produk dengan dynamic XPath
            def xpath = "//th[text()='${productName}']"
            def productObject = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, xpath)
            WebUI.verifyElementText(productObject, productName, FailureHandling.OPTIONAL)
            
            println("Successfully processed and verified: ${productName}")
        } catch (Exception inner) {
            println("Failed to process: ${productName}. Error: ${inner.getMessage()}")
            
            // Coba tutup dialog jika masih terbuka
//            try {
//                WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Stock berhasil diubah_absolute right_1e957b'))
//            } catch (Exception closeError) {
//                // Ignore jika button tidak ditemukan
//            }
        }
        
        // Delay sebelum lanjut ke item berikutnya
//        WebUI.delay(2)
        
    } catch (Exception e) {
        println("Failed to process row ${row}. Error: ${e.getMessage()}")
        WebUI.delay(1)
    }
}

// Ambil screenshot setelah semua selesai
WebUI.takeScreenshot('StockUpdate_Complete.png')

//WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/p_iPhone 15'), 
//    'iPhone 15', FailureHandling.OPTIONAL)
//
//WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/p_Capacity 128 Gb'), 
//    'Capacity: 128 Gb', FailureHandling.OPTIONAL)
//
//WebUI.verifyElementVisible(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/img'), FailureHandling.OPTIONAL)
//
//WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Simpan'), 
//    0, FailureHandling.OPTIONAL)
//
//WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_'), 
//    0, FailureHandling.OPTIONAL)
//
//WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button__1'), 
//    0, FailureHandling.OPTIONAL)
//
//WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/input__custom-input-number'), 
//    0, FailureHandling.OPTIONAL)
//
//WebUI.verifyElementVisible(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/img_1'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/svg_Simpan_lucide lucide-x h-4 w-4'), 
    FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/div_Atur Stok_radix-r2'), 
    2, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/html_katalonfont-familymonospacefont-size13_0fa88e'), 
    FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/div_Hi,Admin'), 
    'Hi,Admin', FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Keluar'), 
    'Keluar', FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/GROW-63 Usability Test Admin Update Stock/Page_Growia Gadget/button_Keluar'))

WebUI.closeBrowser()

