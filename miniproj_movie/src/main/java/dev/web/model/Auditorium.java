package dev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Auditorium {
	@Id
	@Column(name = "AUDITORIUM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MAX_SEAT_COUNT")
	private int maxSeatCount;
	
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

	
	public Auditorium() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auditorium(Long id, int maxSeatCount, Movie movie) {
		super();
		this.id = id;
		this.maxSeatCount = maxSeatCount;
		this.movie = movie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMaxSeatCount() {
		return maxSeatCount;
	}

	public void setMaxSeatCount(int maxSeatCount) {
		this.maxSeatCount = maxSeatCount;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", maxSeatCount=" + maxSeatCount + ", movie=" + movie + "]";
	}


}
