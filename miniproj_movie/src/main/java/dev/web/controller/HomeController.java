package dev.web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.Auditorium;
import dev.web.model.Movie;
import dev.web.model.Seat;
import dev.web.model.Ticket;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public ModelAndView index() {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		
		try {
			String jpql = "select m from Movie as m";
			List<Movie> movielist = em.createQuery(jpql, Movie.class).getResultList();
			mv.addObject("movieList", movielist);
			String jpql2 = "select a from Auditorium as a";
			List<Auditorium>audlist = em.createQuery(jpql2, Auditorium.class).getResultList();
			mv.addObject("audList", audlist);
			String jpql3 = "select s from Seat as s";
			List<Seat> seatlist = em.createQuery(jpql3, Seat.class).getResultList();
			mv.addObject("seatList", seatlist);
			String jpql4 = "select t from Ticket as t";
			List<Ticket> ticketlist = em.createQuery(jpql4, Ticket.class).getResultList();
			mv.addObject("ticketList", ticketlist);			
			
			
			mv.setViewName("home.jsp"); 
			//System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
			emf.close();
		}
		
		return mv;
	}	
}