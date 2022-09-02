package dev.web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.Auditorium;
import dev.web.model.Movie;
import dev.web.model.Seat;
import dev.web.model.Ticket;

@Controller
public class MovieSeatController {
	@RequestMapping("/movieInfo")
	public ModelAndView movieInfo(@RequestParam("movieid") String movieid) {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		
		try {
			String jpql1 = "select a from Auditorium as a where movie_id in (" + movieid + ")";
			List<Auditorium>audlist = em.createQuery(jpql1, Auditorium.class).getResultList();
			mv.addObject("audList", audlist);
			
			mv.setViewName("movieInfo.jsp"); 
			System.out.println(audlist);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
			emf.close();
		}
		
		return mv;
	}	
}