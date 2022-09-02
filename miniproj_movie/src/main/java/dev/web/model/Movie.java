package dev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@Column(name = "MOVIE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MOVIE_NAME")
	private String name;
	
	@Column(name = "MOVIE_PRICE")
	private int price;
	

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	
	
	
}
