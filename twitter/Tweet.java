package twitter;

import java.time.Instant;
import java.util.Date;

public class Tweet {

	private int id;
	private int userThatPostedId;
	private Date datePosted;
	
	public Tweet(int id){
		datePosted = Date.from(Instant.now());
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setUserThatPostedId(int userThatPostedId){
		this.userThatPostedId = userThatPostedId;
	}
	
	public int getUserThatPostedId(){
		return userThatPostedId;
	}
	
	public Date getDatePosted(){
		return datePosted;
	}
}
