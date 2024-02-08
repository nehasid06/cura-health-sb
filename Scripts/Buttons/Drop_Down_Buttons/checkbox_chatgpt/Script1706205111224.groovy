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
import org.openqa.selenium.Keys as Key

// Open the browser and navigate to the application
WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'),
	'Hongkong CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_hospital_readmission'))

// Verify whether "medicaid" checkbox option is disabled before clicking on the checkbox
boolean isCheckboxDisabled = WebUI.verifyElementAttribute(findTestObject('Page_CuraAppointment/checkbox_Medicaid'), 'disabled', 
    'true', 0)

if (isCheckboxDisabled) {
    println('Verification: "medicaid" checkbox is disabled before clicking')
} else {
    println('Verification Error: "medicaid" checkbox is not disabled before clicking')
}

// Perform click operation on the checkbox and verify whether the test object is checked or not
WebUI.click(findTestObject('checkbox_cura/Page_CURA Healthcare Service/label_Medicaid'))

// If the object is checked, then uncheck it with unCheck() method
boolean isChecked = WebUI.verifyElementChecked(findTestObject('checkbox_cura/Page_CURA Healthcare Service/label_Medicaid'), 
    0)

if (isChecked) {
    WebUI.uncheck(findTestObject('Page_CuraAppointment/checkbox_Medicaid'))

    println('Checkbox is checked. Unchecking it.')
} else {
    println('Checkbox is not checked.')
}

// Delay for visibility of changes (you can adjust the delay time as needed)
WebUI.delay(3)

// Verify whether the checkbox is unchecked
boolean isUnchecked = WebUI.verifyElementNotChecked(findTestObject('checkbox_cura/Page_CURA Healthcare Service/label_Medicaid'), 
    0)

if (isUnchecked) {
    println('Verification: Checkbox is unchecked')
} else {
    println('Verification Error: Checkbox is still checked')
}

// Close the browser
WebUI.closeBrowser()

WebUI.acceptAlert()

