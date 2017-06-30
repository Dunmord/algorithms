package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private Set<Integer> usersFollowed;
	private List<Tweet> tweets;
	
	public User(){
		usersFollowed = new HashSet<Integer>();
		tweets = new ArrayList<Tweet>();
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void postTweet(int tweetId){
		Tweet tweet = new Tweet(tweetId);
		tweets.add(tweet);
		
	}
	
	public void follow(int userId){
		if(!usersFollowed.contains(userId)){
			usersFollowed.add(userId);
		}
	}
	
	public void unfollow(int userId){
		if(usersFollowed.contains(userId)){
			usersFollowed.remove(userId);
		}
	}
	
	public List<Tweet> getTweets(){
		return tweets;
	}
	
	public Set<Integer> getUsersFollowed(){
		return usersFollowed;
	}

}
