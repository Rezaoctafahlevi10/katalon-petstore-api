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
GlobalVariable.pet_id = "invalid_id_" + random_Int
GlobalVariable.pet_name = random_Int
def status = ['available', 'pending', 'sold']
GlobalVariable.pet_status = status[new Random().nextInt(status.size())]
println("ID Random yang digunakan: " + GlobalVariable.pet_id)
println ("nama pet : "+ GlobalVariable.pet_name)

RequestObject requestPet = findTestObject('API-PET/post_create_pet',[
	('pet_id')     : GlobalVariable.pet_id,
	('pet_name')   : GlobalVariable.pet_name,
	('pet_status') : GlobalVariable.pet_status
	])

assertThat(requestPet.getRestRequestMethod()).isEqualTo('POST')
assertThat(requestPet.getRestUrl().contains("/pet"))

def ResponsePost = WS.sendRequest(requestPet)
int actualStatusCode = ResponsePost.getStatusCode()
println('status code: ' +actualStatusCode)
WS.verifyResponseStatusCode(ResponsePost,actualStatusCode)
def responseBodyNeg = ResponsePost.getResponseBodyContent()
println("Response Body Negative POST: " + responseBodyNeg)
def jsonSlurper = new JsonSlurper()
def errorResponse = jsonSlurper.parseText(responseBodyNeg)
assertThat(errorResponse.message).isNotNull()
assertThat(errorResponse.message).isNotEmpty()

