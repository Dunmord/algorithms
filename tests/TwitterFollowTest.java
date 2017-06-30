package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import twitter.Twitter;

public class TwitterFollowTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Twitter twitter = new Twitter();
		twitter.addUser(1);
		twitter.addUser(2);
		twitter.follow(1, 2);

		Set<Integer> usersFollowed = twitter.getUser(1).getUsersFollowed();
		
		assertEquals(true, usersFollowed.contains(2));
		assertEquals(1, usersFollowed.size());
	}

}
