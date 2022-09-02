package dev.web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.Movie;

@Controller
public class MovieController {

	@RequestMapping("/listMovie")
	public ModelAndView listMovie() {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		
		try {
			String jpql = "select m from Movie as m";
			List<Movie>list = em.createQuery(jpql, Movie.class).getResultList();
			mv.setViewName("movieList.jsp"); 
			mv.addObject("movieList", list);
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
			emf.close();
		}
		
		return mv;
	}	
	
}
