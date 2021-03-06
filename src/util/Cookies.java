package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 쿠키를 처리하기위한 클래스 
 * @author ssam
 * @since 2018.03.14
 * --------------------------------------------
 * 작성자   일자    변경내역 
 * --------------------------------------------
 * ssam    03.14    최초작성 
 */
public class Cookies {

	// 쿠키정보를 저장할 맵 선언 
	private Map<String, Cookie> cookieMap = new HashMap<>();
	
	public Cookies(HttpServletRequest  request) {
		// 현재 사용자의 쿠키정보를 맵에 저장 
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	/**
	 * 이름에 해당하는 쿠키를 리턴
	 * @param name
	 * @return 
	 */
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	/**
	 * 이름에 해당하는 쿠키의 <b>값을 리턴</b>  <br>
	 * 만약 쿠키가 존재하지 않으면 null 리턴 
	 * @param name
	 * @return String
	 * @throws IOException
	 */
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) return null;
		return URLDecoder.decode(cookie.getValue(),"utf-8");
	}	
	
	public boolean exists(String name) {
		return cookieMap.containsKey(name);
	}
	
	/**
	 * 쿠키를 생성 
	 * @param name
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public static Cookie createCookie(String name, String value) throws IOException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	public static Cookie createCookie(String name, String value
			                        , String path, int maxAge) throws IOException {
		Cookie cookie =new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	public static Cookie createCookie(String name, String value
			                        , String domain
			                        , String path, int maxAge) throws IOException {
		Cookie cookie =new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		return cookie;
	}
	
}












