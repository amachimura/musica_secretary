package com.machworks.musicasecretary.controller.google;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.services.calendar.Calendar.CalendarList;
import com.google.api.services.calendar.model.Calendar;
import com.machworks.musicasecretary.nao.GoogleCalendarCommon;

@Controller
@RequestMapping(value="/google/callback")
public class GoogleCallbackController {
	
	@RequestMapping(value="/calendar")
	public ModelAndView calendarCallback(HttpServletRequest request) throws GeneralSecurityException, IOException{
		//callbackパラメータ
		String code = request.getParameter("code");

		GoogleCalendarCommon googleCalendar = new GoogleCalendarCommon();
		//レスポンス取得
		GoogleTokenResponse response = googleCalendar.getGoogleResponse(code); 

		//リフレッシュトークンとアクセストークン 
		System.out.println(response.getRefreshToken());
		System.out.println(response.getAccessToken()); 

		//カレンダーにアクセスするためのオブジェクト取得 
		GoogleCredential credential = googleCalendar.getGoogleCredential(response.getRefreshToken()); 
		com.google.api.services.calendar.Calendar client = googleCalendar.getCalendarClient(credential); 

		//カレンダーリスト取得 
		Object calenderList = client.calendarList().list().execute();		
		return new ModelAndView("menu");
	}
	
	@RequestMapping(value="/ctest")
	public String calendarTest(HttpServletRequest request) throws GeneralSecurityException, IOException{
		GoogleCalendarCommon common = new GoogleCalendarCommon();
		String url = common.getGoogleOAuthURL();
		return "redirect:"+url;
	}
}
