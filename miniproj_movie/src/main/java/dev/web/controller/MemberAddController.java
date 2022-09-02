package dev.web.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.User;

@Controller
public class MemberAddController {
	@RequestMapping("/memberAdd")
	public ModelAndView memberAdd(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		ModelAndView modelAndView = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		User user = em.find(User.class, id);
		if(user == null)
		{
			tx.begin();
			
			User newUser = new User(id, passwd);
			em.persist(newUser);
			modelAndView.setViewName("member/memberAddSuccess.jsp");
			modelAndView.addObject("user", newUser);
			
			tx.commit();
		}
		else {
			modelAndView.setViewName("member/idDuplicate.jsp");
		}
		
		return modelAndView;
	}
}
