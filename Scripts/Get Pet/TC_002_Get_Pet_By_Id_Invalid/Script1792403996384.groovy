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
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject
random_number = new Random()
int random_Int= random_number.nextInt(230)+100
//set dynamic data dan global variabel  -> Post 
GlobalVariable.pet_id = random_Int.toString()
println("ID Random yang digunakan: " + GlobalVariable.pet_id)

RequestObject requestPet = findTestObject('API-PET/Get_pet_by_id',[
	('pet_id')     : GlobalVariable.pet_id,
	])
assertThat(requestPet.getRestRequestMethod()).isEqualTo('GET')
assertThat(requestPet.getRestUrl().contains("/pet"))
def ResponsePost = WS.sendRequest(requestPet)
int actualStatusCode = ResponsePost.getStatusCode()
println('status code: ' +actualStatusCode)
WS.verifyResponseStatusCode(ResponsePost,actualStatusCode)
def responseBodyNeg = ResponsePost.getResponseBodyContent()
println("Response Body: " + responseBodyNeg)
def jsonSlurper = new JsonSlurper()
def errorResponse = jsonSlurper.parseText(responseBodyNeg)
assertThat(errorResponse.message).isNotNull()
assertThat(errorResponse.message).isNotEmpty()


