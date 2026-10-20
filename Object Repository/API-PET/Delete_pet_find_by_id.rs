<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>succes create pet and respond code 200</description>
   <name>Delete_pet_find_by_id</name>
   <tag></tag>
   <elementGuidId>b564cd0e-c837-41f1-8a87-40a206cd3d2a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: ${id},\n  \&quot;category\&quot;: {\n    \&quot;id\&quot;: ${id},\n    \&quot;name\&quot;: \&quot;${name}\&quot;\n  },\n  \&quot;name\&quot;: \&quot;${name}\&quot;,\n  \&quot;photoUrls\&quot;: [\n    \&quot;C:\\\\Users\\\\Reza Octa Fahlevi\\\\Downloads\\\\WhatsApp Image.jpeg\&quot;\n  ],\n  \&quot;tags\&quot;: [\n    {\n      \&quot;id\&quot;: ${id},\n      \&quot;name\&quot;:\&quot;${name}\&quot;\n    }\n  ],\n  \&quot;status\&quot;: \&quot;${status}\&quot;\n}&quot;,
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
   <restRequestMethod>DELETE</restRequestMethod>
   <restUrl>${GlobalVariable.baseURL}/v2/pet/${pet_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>668</defaultValue>
      <description></description>
      <id>5cb61cac-39cf-473a-9edf-bdf30dc094dd</id>
      <masked>false</masked>
      <name>pet_id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as Global_variable
import java.util.Random
RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def json = new JsonSlurper()
def ResponseJson =  json.parseText(response.getResponseBodyContent())
WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)
assertThat(request.getRestRequestMethod()).isEqualTo('DELETE')
assertThat(response.getResponseBodyContent()).contains('&quot;message&quot;:')
assertThat(ResponseJson.message).isEqualTo(&quot;668&quot;)
assertThat(ResponseJson.message).isInstanceOf(String.class)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
