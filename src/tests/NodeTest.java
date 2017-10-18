package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Node;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test() {
		Node n = new Node(15);
		Integer expected = 15;
		assertEquals(expected, n.getIntValue());
		assertEquals("15", n.getName());
		
		Node otherN = new Node(15);
		assertTrue(n.equals(otherN));
		assertFalse(n.equals(new ArrayList<Node>()));
		
		assertEquals("15,15", n.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExc() {
		@SuppressWarnings("unused")
		Node n = new Node(null);
	}
	

}
