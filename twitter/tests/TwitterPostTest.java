package twitter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twitter.Twitter;

public class TwitterPostTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 2);

		int tweetId = twitter.getUser(1).getTweets().get(0).getId();
		assertEquals(2, tweetId);
		assertEquals(1, twitter.getUser(1).getTweets().size());
	}

}
