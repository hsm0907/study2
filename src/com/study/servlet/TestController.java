package com.study.servlet;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.member.web.MemberListController;
import com.study.member.web.MemberViewController;


public class TestController extends HttpServlet{
	
	// url, 컨트롤로 정보를 보관할 맵
	private Map<String, IController> handlerMap = new HashMap<>();
	
	public void init() throws ServletException {
		
		String configFile = getInitParameter("configFile"); // WEB-INF/classes/resource/study_uri.properties
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try(FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
			
		}catch (IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		
		while (keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String handlerClassName = prop.getProperty(command);
			
			try {
				Class<?> handlerClass = Class.forName(handlerClassName); 
				IController controller = (IController) handlerClass.newInstance(); // IController 인터페이스에있는 클래스 생성해서 저장하기위함 
				handlerMap.put(command, controller); // 맵에 저장
			}catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println(command + "를 로드하지 못했습니다." + e.getMessage() );
			}
		}
	}

		@Override
		// 1. 사용자의 요청을 받음
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든페이에 공통적인 부분처리
			request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 요청분석
		// -- 파라미터 : /member?type=list, /member?type=view
		// -- 요청 uri : /member/list , /member/view
		
		String uri = request.getRequestURI();
		// /study/member/memberList.do
		
		uri = uri.substring( request.getContextPath().length()); // 경로와 길이로 자른다..?
		
		String viewPage = null;
		IController controller = null;
		
		if(handlerMap.containsKey(uri)) { // handlerMap.키가 url이면 uri가져와서 컨트롤러에 담음
			controller = handlerMap.get(uri);
			if(controller != null) {
			viewPage = controller.process(request, response); // 컨트롤러 프로세스 요청 ,응답을 viewPage에
				
			// viewPage 가 널이거나, 리다이렉트는 어떻게 처리???
			// 5. 알맞은 뷰로 포워딩
			// 해당 컨트롤러가 직접 출력해야하는 경우(다운로드) 이때 viewPage = null로 
			// 리다이렉트를 한 경우 viewPage 가 "redirect:" 으로 시작할 경우
			
			if(viewPage != null) {
				System.out.println(uri + ", viewPage=" + viewPage);
				if(viewPage.startsWith("redirect:")) {
					response.sendRedirect(request.getContextPath() + viewPage.substring(9));
				}else {
					// 해당 뷰페이지로 이동 (포워드)
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 포워딩은 viewPage로 이동 
					dispatcher.forward(request, response);					
				}
			}
	
			}else {
				// 컨트롤러가 널인경우
				throw new ServletException(uri + "의 컨트롤러가 널입니다.");
			}
		}else {
			// 요청 uri 가 없으므로 404 예외 던짐
			response.sendError(response.SC_NOT_FOUND, "어렵다...어려워...");
		}
	}
}
