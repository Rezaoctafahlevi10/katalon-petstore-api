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
String pet_random_name_id = 'Pet'+random_Int
//set dynamic data dan global variabel  -> Post 
GlobalVariable.pet_id = random_Int
GlobalVariable.pet_name = pet_random_name_id
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
WS.verifyResponseStatusCode(ResponsePost, GlobalVariable.succes_code)
def responseBody = ResponsePost.getResponseBodyContent()
println("Response Body: " + responseBody)
def jsonSluper = new JsonSlurper()
def postJson = jsonSluper.parseText(responseBody)
println("parseText : "+ postJson)

assertThat(responseBody).contains('"id":')
assertThat(responseBody).contains('"photoUrls":')
assertThat(responseBody).contains('"name":')
assertThat(responseBody).contains('"status":')

assertThat(postJson.id).isEqualTo(GlobalVariable.pet_id)
assertThat(postJson.name).isEqualTo(GlobalVariable.pet_name)
assertThat(postJson.status).isEqualTo(GlobalVariable.pet_status)

assertThat(postJson.id).isInstanceOf(Integer.class)
assertThat(postJson.name).isInstanceOf(String.class)
assertThat(postJson.status).isInstanceOf(String.class)
assertThat(postJson.photoUrls).isInstanceOf(List.class)
