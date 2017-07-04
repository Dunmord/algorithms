package twitter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twitter.Tweet;
import twitter.Twitter;

public class TwitterPostTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 2);
		Tweet expectedTweet = twitter.getTweet(2);
		
		int tweetId = expectedTweet.getId();
		assertEquals(2, tweetId);
	}

}
