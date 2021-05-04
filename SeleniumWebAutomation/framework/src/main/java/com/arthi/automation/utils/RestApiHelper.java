package com.arthi.automation.utils;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arthi.automation.common.TestBase;
import com.arthi.automation.reporters.ExtentTestManager;
import com.google.gson.Gson;

public class RestApiHelper extends TestBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestApiHelper.class);
	
	private static final String PRIVATE_KEY = "<TO_BE_PROVIDED>";
	private static final String PUBLIC_KEY = "<TO_BE_PROVIDED>";
	
	public HashMap<String, Object> replaceAllValuesAs(HashMap<String, Object> hashMap, Object value) {
		HashMap<String, Object> changedMap = null;
		ExtentTestManager.logInfo("The passed arg data is = " + hashMap);
		try {
			for (Entry<String, Object> entry : hashMap.entrySet()) {
				entry.setValue(value);
			}
			changedMap = hashMap;
		} catch (Exception ex) {
			changedMap = null;
			LOGGER.error("Issue while replacing all values with {}", value, ex);
		}
		return changedMap;
	}

	public Map<String, Object> replaceAllValuesAs(Map<String, Object> map, Object value) {
		Map<String, Object> changedMap = null;
		ExtentTestManager.logInfo("The passed arg data are: " + map);
		try {
			for (Entry<String, Object> entry : map.entrySet()) {
				entry.setValue(value);
			}
			changedMap = map;
		} catch (Exception ex) {
			changedMap = null;
			LOGGER.error("Issue while replacing all values with {}", value, ex);
		}
		return changedMap;
	}

	public List<Object> getListFromResponse(Response response, String keyName) {
		List<Object> list = null;
		try {
			JsonPath jsPath = JsonPath.from(response.asString());
			list = jsPath.getList(keyName);
		} catch (Exception ex) {
			LOGGER.error("Issue while getting the list from the response", ex);
		}
		return list;
	}

	public Response get(String bearerToken, String endPoint) {
		ExtentTestManager.logInfo("GET request on : " + endPoint);
		
		RequestSpecification request = given();
		
		if (StringUtils.isNotBlank(bearerToken)) {
			request.auth().oauth2(bearerToken);
			ExtentTestManager.logInfo("GET request call is made with a valid bearer token: " + bearerToken);
		}
		
		Response response = request.get(endPoint).andReturn();		
		//Response response = given().auth().oauth2(bearerToken).request().get(endPoint).andReturn();
		return response;
	}

	public Response getByPathParams(String bearerToken, String endPoint, Map<String, Object> pathParams) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("GET request on :" + endPoint + " with path Params: " + pathParams);
			
			RequestSpecification request = given();
			
			if (StringUtils.isNotBlank(bearerToken)) {
				request.auth().oauth2(bearerToken);
				ExtentTestManager.logInfo("GET request call is made with a valid bearer token: " + bearerToken);
			}
			
			response = request.pathParams(pathParams).get(endPoint).andReturn();
			//response.prettyPeek();
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the GET request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public Response getByQueryParams(String bearerToken, String endPoint, Map<String, Object> parametersMap) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("GET request on :" + endPoint + " with Query Params: " + parametersMap);
			RequestSpecification request = given();
			
			if (StringUtils.isNotBlank(bearerToken)) {
				request.auth().oauth2(bearerToken);
				ExtentTestManager.logInfo("GET request call is made with a valid bearer token: " + bearerToken);
			}
			
			response = request.queryParams(parametersMap).get(endPoint).andReturn();
			//response.prettyPeek();
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the GET request on [" + endPoint + "]", ex);
		}
		return response;
	}	

	public Response getByPathAndQueryParams(String bearerToken, String endPoint, Map<String, Object> pathParams, Map<String, Object> queryParams) {
		Response response = null;
		String message = "GET request on :" + endPoint;
		try {
			RequestSpecification request = given();

			if (StringUtils.isNotBlank(bearerToken)) {
				request.auth().oauth2(bearerToken);
				ExtentTestManager.logInfo("GET request call is made with a valid bearer token: " + bearerToken);
			}
			
			if (pathParams != null && !pathParams.isEmpty()) {
				message += " with Path Params: " + pathParams;
				request = request.pathParams(pathParams);
			}
			
			if (queryParams != null && !queryParams.isEmpty()) {
				message += " and Query Params: " + queryParams;
				request = request.queryParams(queryParams);
			}
			
			ExtentTestManager.logInfo(message);
			response = request.get(endPoint).andReturn();
			//response.prettyPeek();
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the " + message, ex);
		}
		return response;
	}	
	
	
//	public Response getById(String bearerToken, String endPoint, Object id) {
//		Response response = null;
//		try {
//			ExtentTestManager.logInfo("GET request on :" + endPoint + " with Id : " + id);
//			response = given().auth().oauth2(bearerToken).pathParam("id", id).request().get(endPoint).andReturn();
//			response.prettyPeek();
//		} catch (Exception ex) {
//			ExtentTestManager.logError("Error while making the GET request on [" + endPoint + "]", ex);
//		}
//		return response;
//	}

	public Response post(String bearerToken, ContentType contentType, String endPoint, Object payLoad) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("POST request on : " + endPoint);
			ExtentTestManager.logDebug("Request Payload is : " + payLoad);
			
			RequestSpecification request = given();
			
			if (StringUtils.isNotBlank(bearerToken)) {
				request.auth().oauth2(bearerToken);
			}
			
			if(contentType != null) {
				request.contentType(contentType);
			}
			
			if (payLoad != null) {
				request.body(payLoad);
			}
			response = request.post(endPoint)
					.andReturn();

			if (response != null) {
				LOGGER.info("Finished Http POST: [{}] {}", response.getStatusCode(), response.body().prettyPrint());
			}
			else {
				LOGGER.warn("Finished Http POST and returned null Response");
			}
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public Response post(String bearerToken, String endPoint) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("POST request on : " + endPoint);
			response = given().auth().oauth2(bearerToken).contentType(ContentType.JSON).post(endPoint).andReturn();
			// LOGGER.info("Response body -"
			// +response.body().prettyPrint().trim());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public static String getSignature(final String verb, final String endPoint, final String jsonPayload, final long createdAt) {
		final String message = verb.toLowerCase() + endPoint + StringUtils.trimToEmpty(jsonPayload) + createdAt;

	    SecretKeySpec secret_key = new SecretKeySpec(PRIVATE_KEY.getBytes(), "HmacSHA256");
		Mac sha256HMAC = null;
		try {
			sha256HMAC = Mac.getInstance("HmacSHA256");
			sha256HMAC.init(secret_key);
		     final String signature = Base64.encodeBase64String(sha256HMAC.doFinal(message.getBytes()));
		     LOGGER.info("Signature created: {}", signature);		
		     return signature;
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			LOGGER.error("Failed to Create Secret: {}", jsonPayload, e);
		}
		return null;
	}
	
	public Response post(final String endPoint, Map<String, Object> payLoad) {
		return post(endPoint, payLoad, false);
	}
	
	public Response post(final String endPoint, Map<String, Object> payLoad, boolean ignoreHeaders) {
		Response response = null;
		Map<String, Object> headers = null;
		try {
			final long createdAt = Instant.now().getEpochSecond();
			final String jsonPayload = new Gson().toJson(payLoad);
			ExtentTestManager.logInfo("POST request on: " + endPoint + ", createAt: " + createdAt);
			ExtentTestManager.logInfo("Request Payload: " + jsonPayload);
			
			headers = new HashMap<String, Object>();
			
			RequestSpecification request = given();
			
			if (!ignoreHeaders) {
				headers.put("x-signature", getSignature("post", endPoint, jsonPayload, createdAt));
				headers.put("x-created-at", createdAt);
				headers.put("x-access-id", PUBLIC_KEY);
				request.headers(headers);
			}
			
			response = request.contentType(ContentType.JSON).body(payLoad).post(endPoint)
					.andReturn();
			ExtentTestManager.logInfo("Response Code: " + response.getStatusLine());
			ExtentTestManager.logInfo("Response Body: " + response.body().prettyPrint().trim());
		} catch (Exception ex) {
			LOGGER.error("Error while making the POST request on [{}]", endPoint, ex);
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}
	
	public Response post(String bearerToken, String endPoint, Map<String, Object> payLoad) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("POST request on : " + endPoint);
			ExtentTestManager.logDebug("Request Payload is : " + payLoad);
			response = given().auth().oauth2(bearerToken).contentType(ContentType.JSON).body(payLoad).post(endPoint)
					.andReturn();
			LOGGER.info("Response body -" + response.body().prettyPrint().trim());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	//Map<String, Object> parametersMap
	public Response put(String bearerToken, String endPoint, Map<String, Object> payLoad) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("PUT request on : " + endPoint);
			ExtentTestManager.logDebug("Payload for PUT request = " + payLoad);
			response = given().auth().oauth2(bearerToken).contentType(ContentType.JSON).body(payLoad).put(endPoint)
					.andReturn();
			LOGGER.info("Response body: " + response.body().prettyPrint());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public Response putWithPathParams(String bearerToken, String endPoint, Map<String, Object> pathParams, Map<String, Object> payLoad) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("PUT request on : " + endPoint + ", with Path Params: " + pathParams);
			ExtentTestManager.logDebug("Payload for PUT request = " + payLoad);
			response = given().auth().oauth2(bearerToken).contentType(ContentType.JSON).body(payLoad).pathParams(pathParams).put(endPoint)
					.andReturn();
			LOGGER.info("Response body: " + response.body().prettyPrint());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}
	
	public Response put(String bearerToken, String endPoint) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("PUT request on : " + endPoint);
			ExtentTestManager.logDebug("API Request without Payload for PUT");
			response = given().auth().oauth2(bearerToken).contentType(ContentType.JSON).put(endPoint).andReturn();
			LOGGER.info("Response body - " + response.body().prettyPrint());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public Response delete(String bearerToken, String endPoint) {
		Response response = null;
		try {
			ExtentTestManager.logInfo("DELETE request on : " + endPoint);
			response = given().auth().oauth2(bearerToken).request().delete(endPoint).andReturn();
			ExtentTestManager.logInfo("DELETE request call is made with valid bearer token");
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the POST request on [" + endPoint + "]", ex);
		}
		return response;
	}

	public Response authToken(final String postEndPointUrl, final String userEmail, final String password, final String grantType) {
		Response response = null;

		try {
			response = given().contentType(ContentType.URLENC).formParam("username", userEmail)
					.formParam("password", password).formParam("grant_type", grantType).when().request()
					.post(postEndPointUrl).andReturn();
			LOGGER.info("Response body -" + response.body().prettyPrint().trim());
		} catch (Exception ex) {
			ExtentTestManager.logError("Error while making the auth Token post request", ex);
		}
		return response;
	}

}