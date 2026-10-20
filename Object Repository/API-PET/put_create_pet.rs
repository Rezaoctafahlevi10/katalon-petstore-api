<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>succes create pet and respond code 200</description>
   <name>put_create_pet</name>
   <tag></tag>
   <elementGuidId>cacd612f-9888-4791-b8fc-a51605cabcb2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: ${pet_id},\n  \&quot;category\&quot;: {\n    \&quot;id\&quot;: ${pet_id},\n    \&quot;name\&quot;: \&quot;${pet_name}\&quot;\n  },\n  \&quot;name\&quot;: \&quot;${pet_name}\&quot;,\n  \&quot;photoUrls\&quot;: [\n    \&quot;C:\\\\Users\\\\Reza Octa Fahlevi\\\\Downloads\\\\WhatsApp Image.jpeg\&quot;\n  ],\n  \&quot;tags\&quot;: [\n    {\n      \&quot;id\&quot;: ${pet_id},\n      \&quot;name\&quot;:\&quot;${pet_name}\&quot;\n    }\n  ],\n  \&quot;status\&quot;: \&quot;${pet_status}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>8558fe03-551a-4b3d-b84a-e5ba9eb590e4</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.4.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.baseURL}/v2/pet</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'test_baru122'</defaultValue>
      <description></description>
      <id>c870424d-1fba-4433-ad15-cc925febfd2d</id>
      <masked>false</masked>
      <name>pet_name</name>
   </variables>
   <variables>
      <defaultValue>667</defaultValue>
      <description></description>
      <id>55bcbc88-6c81-42a2-a2a7-e2008461f80a</id>
      <masked>false</masked>
      <name>pet_id</name>
   </variables>
   <variables>
      <defaultValue>'pending'</defaultValue>
      <description></description>
      <id>ff5083fa-a4e9-4f90-8ebd-e76df708b686</id>
      <masked>false</masked>
      <name>pet_status</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as Global_variable
import java.util.Random
def json = new JsonSlurper()

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def ResponseJson =  json.parseText(response.getResponseBodyContent())
WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)
assertThat(request.getRestRequestMethod()).isEqualTo('PUT')
assertThat(response.getResponseBodyContent()).contains('&quot;id&quot;:')
assertThat(response.getResponseBodyContent()).contains('&quot;photoUrls&quot;:')
assertThat(response.getResponseBodyContent()).contains('&quot;name&quot;:')
assertThat(response.getResponseBodyContent()).contains('&quot;status&quot;:')
//WS.verifyElementPropertyValue(response, 'id', 9223372036854394220)
//WS.verifyElementPropertyValue(response, 'name', '')
//WS.verifyElementPropertyValue(response, 'status', '')


assertThat(ResponseJson.id).isEqualTo(667)
assertThat(ResponseJson.name).isEqualTo('test_baru122')
assertThat(ResponseJson.status).isEqualTo('pending')
assertThat(ResponseJson.id).isInstanceOf(Number.class)
assertThat(ResponseJson.name).isInstanceOf(String.class)
assertThat(ResponseJson.status).isInstanceOf(String.class)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
