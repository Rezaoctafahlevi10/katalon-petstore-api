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


Random random_number = new Random()
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


// get data 
RequestObject requestPetGetId = findTestObject('API-PET/Get_pet_by_id',[
	('pet_id')     : GlobalVariable.pet_id,
	])
assertThat(requestPetGetId.getRestRequestMethod()).isEqualTo('GET')
assertThat(requestPetGetId.getRestUrl().contains("/pet"))
def ResponseGet = WS.sendRequest(requestPetGetId)
WS.verifyResponseStatusCode(ResponseGet, GlobalVariable.succes_code)
def responseBodyGet = ResponseGet.getResponseBodyContent()
def getJson = new JsonSlurper().parseText(responseBodyGet)
println("id :" +getJson )
assertThat(responseBodyGet).contains('"id":')
assertThat(getJson.id).isEqualTo( GlobalVariable.pet_id)

//Put 
Random put_random = new Random()
int random_put_int= put_random.nextInt(230)+100
String put_random_name_id = 'Updated Pet'+random_put_int
GlobalVariable.pet_id = random_put_int
GlobalVariable.pet_name = put_random_name_id
def status_put = ['available', 'pending', 'sold']
GlobalVariable.pet_status = status[new Random().nextInt(status_put.size())]
println("ID Random yang digunakan: " + GlobalVariable.pet_id)
println ("nama pet : "+ GlobalVariable.pet_name)
println ("nama pet : "+ GlobalVariable.pet_status)

RequestObject requestPut = findTestObject('API-PET/put_create_pet',[
	('pet_id')     : GlobalVariable.pet_id,
	('pet_name')   : GlobalVariable.pet_name,
	('pet_status') : GlobalVariable.pet_status
	])

assertThat(requestPut.getRestRequestMethod()).isEqualTo('PUT')
assertThat(requestPut.getRestUrl().contains("/pet"))

def ResponsePut = WS.sendRequest(requestPut)
WS.verifyResponseStatusCode(ResponsePut, GlobalVariable.succes_code)
def responseBodyPut = ResponsePut.getResponseBodyContent()
println("Response Body: " + responseBodyPut)

def putJson = jsonSluper.parseText(responseBodyPut)
println("parseText : "+ putJson)

assertThat(responseBodyPut).contains('"id":')
assertThat(responseBodyPut).contains('"photoUrls":')
assertThat(responseBodyPut).contains('"name":')
assertThat(responseBodyPut).contains('"status":')

assertThat(putJson.id).isEqualTo(GlobalVariable.pet_id)
assertThat(putJson.name).isEqualTo(GlobalVariable.pet_name)
assertThat(putJson.status).isEqualTo(GlobalVariable.pet_status)

assertThat(putJson.id).isInstanceOf(Integer.class)
assertThat(putJson.name).isInstanceOf(String.class)
assertThat(putJson.status).isInstanceOf(String.class)
assertThat(putJson.photoUrls).isInstanceOf(List.class)


// get data id after put 
RequestObject requestPetGetIdPut = findTestObject('API-PET/Get_pet_by_id',[
	('pet_id')     : GlobalVariable.pet_id,
	])
assertThat(requestPetGetIdPut.getRestRequestMethod()).isEqualTo('GET')
assertThat(requestPetGetIdPut.getRestUrl().contains("/pet"))
def ResponseGetIdPut = WS.sendRequest(requestPetGetIdPut)
WS.verifyResponseStatusCode(ResponseGetIdPut, GlobalVariable.succes_code)
def responseBodyGetIdPut = ResponseGetIdPut.getResponseBodyContent()
def getJsonIDPut = new JsonSlurper().parseText(responseBodyGetIdPut)
println("id :" +getJsonIDPut )
assertThat(responseBodyGetIdPut).contains('"id":')
assertThat(getJsonIDPut.id).isEqualTo( GlobalVariable.pet_id)

// delete id after put
RequestObject requestPetDelete= findTestObject('API-PET/Delete_pet_find_by_id',[
	('pet_id')     : GlobalVariable.pet_id,
	])
assertThat(requestPetDelete.getRestRequestMethod()).isEqualTo('DELETE')
assertThat(requestPetDelete.getRestUrl().contains("/pet"))
def ResponseDelete = WS.sendRequest(requestPetDelete)
WS.verifyResponseStatusCode(ResponseDelete, GlobalVariable.succes_code)
def responseBodyDelete = ResponseDelete.getResponseBodyContent()
def getJsonDelete = new JsonSlurper().parseText(responseBodyDelete)
println("id :" +getJsonDelete )

assertThat(responseBodyDelete).contains('"code":')
assertThat(responseBodyDelete).contains('"type":')
assertThat(responseBodyDelete).contains('"message":')
assertThat(getJsonDelete.message).isEqualTo( GlobalVariable.pet_id.toString())


// after delete get by id
RequestObject requestPetGetIdDelete = findTestObject('API-PET/Get_pet_by_id',[
	('pet_id')     : GlobalVariable.pet_id,
	])
assertThat(requestPetGetIdDelete.getRestRequestMethod()).isEqualTo('GET')
assertThat(requestPetGetIdDelete.getRestUrl().contains("/pet"))
def ResponseGetIdDelete = WS.sendRequest(requestPetGetIdDelete)
WS.verifyResponseStatusCode(ResponseGetIdDelete, GlobalVariable.code_not_found)
def responseBodyGetIdDelete = ResponseGetIdDelete.getResponseBodyContent()
def getJsonIDDelete = new JsonSlurper().parseText(responseBodyGetIdDelete)
println("pet id deleted:" +getJsonIDDelete )
assertThat(responseBodyGetIdDelete).contains('"message":"Pet not found"')