package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
	private List<Tweet> tweets = new ArrayList<Tweet>();
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.setUserThatPostedId(userId);
        tweets.add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	Set<Integer> userIds = new HashSet<Integer>();
    	userIds.add(userId);
    	userIds.addAll(userMap.get(userId).getUsersFollowed());
    	List<Integer> newsFeed = tweets.stream()
						    			.filter(tweet->userIds.contains(tweet.getUserThatPostedId()))
						    			.limit(10)
						    			.map(Tweet::getId)
						    			.collect(Collectors.toList());
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
    
    public Tweet getTweet(int tweetId){
    	return tweets.stream()
    				.filter(tweet->tweet.getId() == tweetId)
    				.collect(Collectors.toList()).get(0);
    }
}
