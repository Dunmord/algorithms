package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import twitter.Twitter;

public class TwitterUnfollowTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Twitter twitter = new Twitter();
		twitter.addUser(1);
		twitter.addUser(2);
		twitter.follow(1, 2);
		twitter.unfollow(1, 2);
		
		Set<Integer> usersFollowed = twitter.getUser(1).getUsersFollowed();
		
		assertEquals(false, usersFollowed.contains(2));
		assertEquals(0, usersFollowed.size());
	}

}
