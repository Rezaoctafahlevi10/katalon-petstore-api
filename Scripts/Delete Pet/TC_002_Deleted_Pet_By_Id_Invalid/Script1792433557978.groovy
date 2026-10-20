import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject

// Menggunakan ID acak atau spesifik untuk pengujian DELETE negatif
random_number = new Random()
int random_Int = random_number.nextInt(230) + 100
GlobalVariable.pet_id = random_Int.toString()

println("ID Pet yang dihapus: " + GlobalVariable.pet_id)


RequestObject requestPet = findTestObject('API-PET/Delete_pet_find_by_id',[
    ('pet_id') : GlobalVariable.pet_id
])

assertThat(requestPet.getRestRequestMethod()).isEqualTo('DELETE')
assertThat(requestPet.getRestUrl().contains("/pet"))

def response = WS.sendRequest(requestPet)
int actualStatusCode = response.getStatusCode()
println('Status Code: ' + actualStatusCode)
assertThat(actualStatusCode).isEqualTo(404)


def responseBody = response.getResponseBodyContent()
println("Response Body: " + responseBody)

if (responseBody != null && !responseBody.isEmpty()) {
   try {
        def jsonSlurper = new JsonSlurper()
        def errorResponse = jsonSlurper.parseText(responseBody)
        println("message error: " + errorResponse)
    } catch (Exception e) {
        println("Response body error: " + responseBody)
    }
} else {
    println("status 404")
}