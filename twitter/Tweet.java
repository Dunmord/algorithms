package twitter;

import java.time.Instant;
import java.util.Date;

public class Tweet {

	private int id;
	private Date datePosted;
	
	public Tweet(int id){
		datePosted = Date.from(Instant.now());
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public Date getDatePosted(){
		return datePosted;
	}
}
