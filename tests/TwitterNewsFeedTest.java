package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import twitter.Twitter;

public class TwitterNewsFeedTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int userId1 = 1;
		int userId2 = 2;
		int userId3 = 3;
		int userId4 = 4;
		int userId5 = 5;
		int userId6 = 6;
		int userId7 = 7;
		int userId8 = 8;
		int userId9 = 9;
		
		int tweetId1 = 1;
		int tweetId2 = 2;
		int tweetId3 = 3;
		int tweetId4 = 4;
		int tweetId5 = 5;
		int tweetId6 = 6;
		int tweetId7 = 7;
		int tweetId8 = 8;
		int tweetId9 = 9;
		int tweetId10 = 10;
		int tweetId11 = 11;
		int tweetId12 = 12;
		int tweetId13 = 13;
		int tweetId14 = 14;
		int tweetId15 = 15;
		int tweetId16 = 16;
		int tweetId17 = 17;
		int tweetId18 = 18;
		int tweetId19 = 19;
		int tweetId20 = 20;
		int tweetId21 = 21;
		int tweetId22 = 22;
		int tweetId23 = 23;
		int tweetId24 = 24;
		int tweetId25 = 25;
		int tweetId26 = 26;
		int tweetId27 = 27;
		
		Twitter twitter = new Twitter();
		twitter.delayedPostTweet(userId1, tweetId1);
		twitter.delayedPostTweet(userId1, tweetId2);
		twitter.delayedPostTweet(userId1, tweetId3);
		
		twitter.delayedPostTweet(userId2, tweetId4);
		twitter.delayedPostTweet(userId2, tweetId5);
		twitter.delayedPostTweet(userId2, tweetId6);
		
		twitter.delayedPostTweet(userId3, tweetId7);
		twitter.delayedPostTweet(userId3, tweetId8);
		twitter.delayedPostTweet(userId3, tweetId9);
		
		twitter.delayedPostTweet(userId4, tweetId10);
		twitter.delayedPostTweet(userId4, tweetId11);
		twitter.delayedPostTweet(userId4, tweetId12);
		
		twitter.delayedPostTweet(userId5, tweetId13);
		twitter.delayedPostTweet(userId5, tweetId14);
		twitter.delayedPostTweet(userId5, tweetId15);
		
		twitter.delayedPostTweet(userId6, tweetId16);
		twitter.delayedPostTweet(userId6, tweetId17);
		twitter.delayedPostTweet(userId6, tweetId18);
		
		twitter.delayedPostTweet(userId7, tweetId19);
		twitter.delayedPostTweet(userId7, tweetId20);
		twitter.delayedPostTweet(userId7, tweetId21);
		
		twitter.delayedPostTweet(userId8, tweetId22);
		twitter.delayedPostTweet(userId8, tweetId23);
		twitter.delayedPostTweet(userId8, tweetId24);
		
		twitter.delayedPostTweet(userId9, tweetId25);
		twitter.delayedPostTweet(userId9, tweetId26);
		twitter.delayedPostTweet(userId9, tweetId27);
		
		twitter.follow(userId1, userId2);
		twitter.follow(userId1, userId3);
		twitter.follow(userId1, userId4);
		
		twitter.follow(userId5, userId1);
		twitter.follow(userId5, userId7);
		twitter.follow(userId5, userId6);
		
		//Actual testing
		List<Integer> newsFeed1 = twitter.getNewsFeed(userId1);
		List<Integer> newsFeed2 = twitter.getNewsFeed(userId5);

		assertEquals(1, (int)newsFeed1.get(0));
		assertEquals(2, (int)newsFeed1.get(1));
		assertEquals(3, (int)newsFeed1.get(2));
		assertEquals(4, (int)newsFeed1.get(3));
		assertEquals(5, (int)newsFeed1.get(4));
		assertEquals(6, (int)newsFeed1.get(5));
		assertEquals(7, (int)newsFeed1.get(6));
		assertEquals(8, (int)newsFeed1.get(7));
		assertEquals(9, (int)newsFeed1.get(8));

		assertEquals(1, (int)newsFeed2.get(0));
		assertEquals(2, (int)newsFeed2.get(1));
		assertEquals(3, (int)newsFeed2.get(2));
		assertEquals(13, (int)newsFeed2.get(3));
		assertEquals(14, (int)newsFeed2.get(4));
		assertEquals(15, (int)newsFeed2.get(5));
		assertEquals(16, (int)newsFeed2.get(6));
		assertEquals(17, (int)newsFeed2.get(7));
		assertEquals(18, (int)newsFeed2.get(8));
	}

}
