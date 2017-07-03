package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
	Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

	postTweet(userId, tweetId): Compose a new tweet.
	getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
	follow(followerId, followeeId): Follower follows a followee.
	unfollow(followerId, followeeId): Follower unfollows a followee.
	From: https://leetcode.com/problems/design-twitter/#/description
 * */

public class Twitter {

	private Map<Integer, User> userMap = new HashMap<Integer, User>();
	
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        addUser(userId); //Make sure the user exists
        User user = userMap.get(userId);
        if(user != null){
        	user.postTweet(tweetId);
        }
    }
    
    //Added this method because my tests had no date difference and the sorting was not working based on date.
    public void delayedPostTweet(int userId, int tweetId) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        addUser(userId); //Make sure the user exists
        User user = userMap.get(userId);
        if(user != null){
        	user.postTweet(tweetId);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> newsFeed = new ArrayList<Integer>();
        List<Tweet> allTweets = new ArrayList<Tweet>();
        
    	User user = userMap.get(userId);
        if(user != null){
        	allTweets.addAll(getAllTweetsFromUser(userId));
        	//Gather all the tweets from the user and all the users being 
        	//followed by the original user and store them in the list, then sort the list in descending order. Gather the first 10 after that.
        	Set<Integer> allFollowing = user.getUsersFollowed();
        	for(Iterator<Integer> it = allFollowing.iterator(); it.hasNext();){
        		allTweets.addAll(getAllTweetsFromUser(it.next()));
        	}
        	//Sort
        	sortTweetsBasedOnDate(allTweets);
        	//Get the first 10 tweet ids out of the sorted list of tweets
        	newsFeed.addAll(getRangeOfTweetIDs(allTweets, 0, 9));
        }
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	addUser(followerId);
    	User user = userMap.get(followerId);
    	user.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	addUser(followerId);
    	User user = userMap.get(followerId);
    	user.unfollow(followeeId);
        
    }
    
    public void addUser(int userId){
    	if(!userMap.containsKey(userId)){
    		User user = new User();
    		user.setId(userId);
    		userMap.putIfAbsent(userId, user);
    	}
    }
    
    public User getUser(int userId){
    	return userMap.get(userId);
    }
    
    private void sortTweetsBasedOnDate(List<Tweet> tweets){
    	Collections.sort(tweets, new Comparator<Tweet>(){
			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o1.getDatePosted().compareTo(o2.getDatePosted());
			}
    	});
    }
    
    private List<Tweet> getAllTweetsFromUser(int userId){
    	List<Tweet> allTweets = new ArrayList<Tweet>();
    	User user = userMap.get(userId);
    	if(user != null){
    		allTweets = user.getTweets();
    	}
    	return allTweets;
    }

    private List<Integer> getRangeOfTweetIDs(List<Tweet> tweets, int start, int end){
    	List<Integer> finalTweetsList = null;
    	int startSubListIndex = start;
    	int endSubListIndex = (tweets.size() >= end) ? end : tweets.size();
    	
    	List<Integer> finalTweetsIdList = new ArrayList<Integer>();
    	for(Tweet tweet : tweets.subList(startSubListIndex, endSubListIndex)){
    		finalTweetsIdList.add(tweet.getId());
    	}
    	return finalTweetsList;
    }
}
