package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private Set<Integer> usersFollowed;
	
	public User(){
		usersFollowed = new HashSet<Integer>();
	}
	
	public void setId(int id){
		this.id = id;
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
	
	public Set<Integer> getUsersFollowed(){
		return usersFollowed;
	}

}
