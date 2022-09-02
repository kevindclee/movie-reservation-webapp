package dev.web.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.User;

@RestController
@SessionAttributes("user")
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		ModelAndView modelAndView = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);
		if(user != null)
		{
			if(passwd.equals(user.getPasswd()))
			{
				modelAndView.setViewName("member/loginSuccess.jsp");
				modelAndView.addObject("user", user);
			}
			else
			{
				modelAndView.setViewName("member/passwdNotMatch.jsp");
			}
		}
		else
		{
			modelAndView.setViewName("member/idNotExist.jsp");
		}
		
		return modelAndView;
	}
}