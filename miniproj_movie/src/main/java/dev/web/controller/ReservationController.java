package dev.web.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.web.model.Seat;
import dev.web.model.Ticket;
import dev.web.model.User;

@RestController
public class ReservationController {
	
	@RequestMapping("/reservationCreate")
	public ModelAndView reservationCreate(@RequestParam("seatId") String seatId, @RequestParam("userName") String userName) {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if(userName == null) {
			mv.setViewName("member/loginFail.jsp"); 
		} else {
			try {
				// transaction 시작
				tx.begin();
				
				Ticket ticket = new Ticket();
				ticket.setTimeStamp(new Date());
				Seat seat = em.find(Seat.class, Long.parseLong(seatId));
				ticket.setSeat(seat);
				User user = em.find(User.class, userName);
				ticket.setUser(user);
				
				mv.setViewName("reserve/reservationSuccess.jsp"); 
				
				em.persist(ticket);
				
				// transaction 종료
				tx.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				mv.setViewName("reserve/reservationFail.jsp"); 
				
			} finally {
				em.close();
				emf.close();
			}
		}
		
		return mv;
	}	
	
	@RequestMapping("/reservationCancel")
	public ModelAndView reservationCancel(@RequestParam("tid") String tId) {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// transaction 시작
			tx.begin();
			
			Ticket ticket = em.find(Ticket.class, Long.parseLong(tId));
			
			mv.setViewName("reserve/cancelSuccess.jsp"); 
			
			em.remove(ticket);
			
			// transaction 종료
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("reserve/cancelFail.jsp"); 
			
		} finally {
			em.close();
			emf.close();
		}
		
		return mv;
	}
	
	@RequestMapping("/reservationCheck")
	public ModelAndView reservationCheck(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mv = new ModelAndView();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie01");
		EntityManager em = emf.createEntityManager();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		try {
			String jpql = "select tick from Ticket as tick where USER_ID = '" + user.getId() + "'";
			List<Ticket>list = em.createQuery(jpql, Ticket.class).getResultList();
			mv.setViewName("reserve/reservationCheck.jsp"); 
			mv.addObject("ticketList", list);
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();			
			mv.setViewName("reserve/reservationFail.jsp"); 
			
		} finally {
			em.close();
			emf.close();
		}
		
		return mv;
	}
}
