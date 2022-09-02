package dev.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.User;

@RestController
public class LogoutController {
	@RequestMapping("/logout")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		//EntityManager em = emf.createEntityManager();

		if(user != null) {
			session.invalidate(); //로그아웃 코드
			modelAndView.setViewName("member/logoutSuccess.jsp");
		}
		else {
			modelAndView.setViewName("member/logoutFail.jsp");
		}
		
		return modelAndView;
	}
}