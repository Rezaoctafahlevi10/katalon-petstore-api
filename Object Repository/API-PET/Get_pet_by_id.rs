<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_pet_by_id</name>
   <tag></tag>
   <elementGuidId>ce7617d6-3f8b-4905-a494-e84ad4cd5268</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
      <webElementGuid>6d9146bf-2374-4a65-843e-12c3a211932f</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.4.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
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
      <defaultValue>667</defaultValue>
      <description></description>
      <id>b5435aed-f137-447e-afab-9dea0a033ced</id>
      <masked>false</masked>
      <name>pet_id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
// MENGAMBIL INFORMASI REQUEST DI KATALON KE API SEPERTI MENGAMBIL HTTP BODYNYA
RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
// MENGAMBIL INFORMASI RESPOND DI KATALON KE API SEPERTI MENGAMBIL HTTP BODYNYA
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def JsonParsing = new JsonSlurper()
def ResponJson = JsonParsing.parseText(response.getResponseBodyContent())
assertThat(request.getRestRequestMethod()).isEqualTo(&quot;GET&quot;)
assertThat(response.getStatusCode()).isEqualTo(200)
assertThat(ResponJson.id).isEqualTo(667)
assertThat(ResponJson.id).isInstanceOf(Number.class)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
