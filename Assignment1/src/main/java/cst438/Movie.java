package cst438;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3, max=25)
	private String title;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 5)
	private int rating;
	
	@NotNull
	@Size(min=3, max=25)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date(System.currentTimeMillis()) ;
	
	public Movie() {
		
	}
	
	public Movie(long id, String title, int rating, String name, Date date) {
		super();
		this.id = id;
		this.title =  title;
		this.rating = rating;
		this.name = name;
		this.date = date;		
	}
	
	public long getId() { 
		return id; 
		}
	
	public void setId(long id) { 
		this.id = id;
		}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	

	
	
}