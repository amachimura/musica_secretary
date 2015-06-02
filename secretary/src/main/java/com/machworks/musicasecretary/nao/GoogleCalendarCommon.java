package com.machworks.musicasecretary.nao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.CalendarScopes;

public class GoogleCalendarCommon {

	private static final String PRIVATE_KEY_ID = "9a1d97821c536c2a80d1af4838986422eb988f68";
	private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJpmqNyESvCoG0dU\nltyMLJGika7PA/su6SNm2KnwJhrFFtBxjiiKAkBkwBh8gV+W430PIk/MxpOc1PQT\noIoIFZK6pEf0ffIFHhG0KphP5wsN9o6sK6i0QUSQw/Fagn9yHwZ3oIoXiviJ/o8J\niS8YhxiMqvgmFXPyUDmqrxkPWVunAgMBAAECgYAkWr2xxnh6t6pMnk8zONIZrGSO\n+3FdiEseqc2kHcZrETLw+3vUccJb9R0B5vbzUezYemLC1V2ATjIaEjD/ry2c1DJX\nIB6f3cM71oLm+BelPiE3OiPlyapc4ZIxWe/oVGoU6JCVk8vZQspI1yJDN+z88YvB\nfmHzM6/weV4/6XEvIQJBAMjZSSqIDeZn0LT34DC9P8STvztkgS9tBgl1DXUknt1K\nKZbWLc/W1WkaN+2nb67yoJxoRbCMT8YPb5jlmVndovcCQQDEzFEvB+Q2jNGZcIJJ\njpsYtA/nPrP11miRk323U0FYa6kOjdZ9/t/HdoEO22NNPafCMfUITMb58y3A6mAk\nrzDRAkAv8x/ylXSsExDSg3L0b9nvdk5rQX1N8ztDurwxwUJkFjaDmjJpsiJU6zt6\n80RIgggyDvrEQVsyL7E20Wmg+LbVAkEAob1iQ4ryzrpxUPAcxCOF6ImkQGNSOAud\nKXfUbKTqIadp6+I6lJayiBYm/3TjagnwJDQ2tDmVlrt7sP9vQPcS4QJBAIZITSXy\nu2YyT6GPgOhWN+dgRKM3SWks4Zgdu89KhVI9kwxoOxPqmxCJesHbu2QJZJaUcHj4\n3MRClFSVOmAkpkc\u003d";
	
	private static final String CLIENT_ID_WEB = "279702855777-i3263keva3l41c87838n9rvffqds8jkc.apps.googleusercontent.com";
	private static final String AUTH_EMAIL_WEB = "279702855777-i3263keva3l41c87838n9rvffqds8jkc@developer.gserviceaccount.com";
	private static final String CLIENT_SECRET_WEB = "hJooRSbURJjOFHnLinjXdqS4";
	
	private static final String CLIENT_ID = "279702855777-pdaflpgnt3krf1clsd0i11u76udn861m.apps.googleusercontent.com";
	private static final String AUTH_EMAIL = "279702855777-pdaflpgnt3krf1clsd0i11u76udn861m@developer.gserviceaccount.com";
	private static final String PATH_TO_JSON = "C:\\Users\\works\\Documents\\workspaces\\musica\\secretary\\src\\main\\java\\com\\machworks\\musicasecretary\\nao\\musician-secretary-9a1d97821c53.json";
	private File jsonFile = new File(PATH_TO_JSON);
	private static final String CALENDAR_NAME = "笹の葉合唱団";
	
	private static final String PUBLIC_API_KEY = "AIzaSyAb6mRsL9Nsy9QQD4L8qYkQ8B7MdusbKKo";

	private static HttpTransport HTTP_TRANSPORT;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();


	private static final String REDIRECT_URL = "http://localhost:8080/musica-secretary/google/callback/calendar";
	private static final String APPLICATION_NAME = "musician-secretary";

	/**
	 * google flow 認証のためのオブジェクト取得
	 */
	public GoogleAuthorizationCodeFlow getFlow() throws IOException,
	GeneralSecurityException {

		HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

		// スコープの設定
		Set<String> scopes = new HashSet<String>();
		scopes.add(CalendarScopes.CALENDAR);
		scopes.add(CalendarScopes.CALENDAR_READONLY);

		GoogleClientSecrets clientSecrets = getClientSecretsFromVar();

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes)
		.setAccessType("offline").setApprovalPrompt("force").build();

		return flow;
	}

	/**
	 * JSONファイル取得
	 */
	public GoogleClientSecrets getClientSecrets() throws IOException {
		InputStream is = new FileInputStream(jsonFile);
		Reader SECRET_FILE = new InputStreamReader(is);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
				JSON_FACTORY, SECRET_FILE);

		return clientSecrets;
	}
	
	public GoogleClientSecrets getClientSecretsFromVar() {
		GoogleClientSecrets secrets = new GoogleClientSecrets();
		secrets.set("private_key_id", PRIVATE_KEY_ID);
		secrets.set("private_key", PRIVATE_KEY);
		secrets.set("client_email", AUTH_EMAIL_WEB);
		secrets.set("client_id", CLIENT_ID_WEB);
		secrets.set("client_secret", CLIENT_SECRET_WEB);
		secrets.setWeb(new Details().setClientId(CLIENT_ID_WEB).setClientSecret(CLIENT_SECRET_WEB));
		return secrets;
	}

	/**
	 * 認証URL取得
	 */
	public String getGoogleOAuthURL(String additionalUrl) throws IOException,
	GeneralSecurityException {
		GoogleAuthorizationCodeFlow flow = getFlow();
		return flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URL).build();
	}

	/**
	 * コールバック後、レスポンス取得
	 */
	public GoogleTokenResponse getGoogleResponse(String code)
			throws IOException, GeneralSecurityException {
		GoogleAuthorizationCodeFlow flow = getFlow();
		return flow.newTokenRequest(code).setRedirectUri(REDIRECT_URL)
				.execute();
	}

	/**
	 * 認証オブジェクト取得
	 */
	public GoogleCredential getGoogleCredential(String refresh_token)
			throws GeneralSecurityException, IOException {

		if (HTTP_TRANSPORT == null) {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		}

		GoogleClientSecrets secrets = getClientSecretsFromVar();
		GoogleCredential credential = new GoogleCredential.Builder()
		.setClientSecrets(secrets.getDetails().getClientId(),
				secrets.getDetails().getClientSecret())
				.setJsonFactory(JSON_FACTORY).setTransport(HTTP_TRANSPORT)
				.build();

		credential.setRefreshToken(refresh_token);
		credential.refreshToken();

		return credential;
	}

	/**
	 * カレンダーにアクセスするためのオブジェクト取得
	 */
	public com.google.api.services.calendar.Calendar getCalendarClient(
			GoogleCredential credential) throws GeneralSecurityException,
			IOException {
		if (HTTP_TRANSPORT == null) {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		}

		return new com.google.api.services.calendar.Calendar.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
	}



}
