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
println("Nilai GlobalVariable.pet_id saat ini: " + GlobalVariable.pet_id)
println("ID Pet yang akan dicari: " + GlobalVariable.pet_id)

// Pastikan GlobalVariable.pet_id tidak null/kosong
assertThat(GlobalVariable.pet_id).isNotNull()

// Masukkan GlobalVariable.pet_id ke parameter request 'Get_pet_by_id'
RequestObject requestPetGetId = findTestObject('API-PET/Get_pet_by_id',[
    ('pet_id') : GlobalVariable.pet_id
])

assertThat(requestPetGetId.getRestRequestMethod()).isEqualTo('GET')
assertThat(requestPetGetId.getRestUrl()).contains("/pet")

def ResponseGet = WS.sendRequest(requestPetGetId)

WS.verifyResponseStatusCode(ResponseGet, GlobalVariable.succes_code)
def responseBodyGet = ResponseGet.getResponseBodyContent()
def getJson = new JsonSlurper().parseText(responseBodyGet)
println("Response Get ID :" + getJson)

assertThat(responseBodyGet).contains('"id":')
assertThat(getJson.id).isEqualTo(GlobalVariable.pet_id)