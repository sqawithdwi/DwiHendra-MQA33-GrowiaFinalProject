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

WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/a_Atur Stok'))

WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Edit'))

//
//WebUI.verifyElementText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/p_iPhone 15'), 'iPhone 15')
//
//WebUI.verifyElementText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/p_Capacity 128 Gb'), 'Capacity: 128 Gb')
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_'))
//
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_'))
//
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_'))
//
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_'))
// Tentukan variable untuk target quantity
//int targetQuantity = 2
//
//// Solusi 1: Menggunakan loop untuk mengklik button + sebanyak targetQuantity kali
//for (int i = 0; i < targetQuantity; i++) {
//    WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_'))
//
//    WebUI.delay(0.5 // Delay kecil antara klik untuk memastikan sistem merespon
//        )
//}
// Ambil test data file
def testData = findTestData('Growia Update Stock') // Ganti dengan nama file test data kamu

int rowCount = testData.getRowNumbers()

// Loop melalui setiap baris data
for (int row = 1; row <= rowCount; row++) {
    try {
        // Ambil data dari test data file
        String btnEditLocator = testData.getValue('btnEditLocatorStock', row)
        String productName = testData.getValue('NamaProduk', row)
        String capacity = testData.getValue('Capacity', row)
        int quantityToAdd = Integer.parseInt(testData.getValue('quantityToAdd', row))

        // Log informasi produk yang sedang diproses
        println("Processing product: ${productName} - ${capacity}")
        
        try {
            // Langsung set nilai quantity di input field
            WebUI.setText(findTestObject('Admin Update Stok/Page_Growia Gadget/input_qty_stock'), 
                          quantityToAdd.toString())
            WebUI.delay(1) // Pastikan nilai sudah terinput dengan benar
            
            // Simpan perubahan
            WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Simpan'))
            
            // Verifikasi pesan sukses
            WebUI.waitForElementPresent(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/div_Stock berhasil diubah'), 10)
            WebUI.verifyElementText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/div_Stock berhasil diubah'), 'Stock berhasil diubah')
            
            // Tutup dialog sukses
            WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Stock berhasil diubah_absolute right_1e957b'))
            
            // Delay sebelum lanjut ke item berikutnya
            WebUI.delay(2)
            
            // Log sukses
            println("Successfully updated stock for: ${productName} - Set to ${quantityToAdd} units")
        } catch (Exception inner) {
            println("Failed to process update for: ${productName}. Inner error: ${inner.getMessage()}")
            
            // Coba tutup dialog sukses jika masih terbuka
            try {
                WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Stock berhasil diubah_absolute right_1e957b'))
            } catch (Exception closeError) {
                // Ignore jika button tidak ditemukan
            }
            
            WebUI.delay(2)
        }
    } catch (Exception e) {
        println("Failed to update row ${row}. Error: ${e.getMessage()}")
        WebUI.delay(2)
    }
}

// Ambil screenshot setelah semua selesai
WebUI.takeScreenshot('StockUpdate_Complete.png')

//
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Simpan'))
//
//WebUI.verifyElementText(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/div_Stock berhasil diubah'), 
//    'Stock berhasil diubah')
//
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Stock berhasil diubah_absolute right_1e957b'))
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/html_katalonfont-familymonospacefont-size13_0fa88e'))
//WebUI.click(findTestObject('Object Repository/Admin Update Stok/Page_Growia Gadget/button_Keluar'))
WebUI.closeBrowser()

