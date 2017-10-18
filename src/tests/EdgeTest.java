package tests;

import static org.junit.Assert.*;
import model.Edge;
import model.Node;

import org.junit.Test;

public class EdgeTest {

	@Test
	public void test() {
		Node n1 = new Node(15);
		Node n2 = new Node(1);
		
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n1, n2, 15.3);
		
		assertTrue(e1.getNode1().equals(n1));
		assertTrue(e1.getNode2().equals(n2));
		assertEquals(1.0, e1.getWeight(), 0.0001);
		assertEquals(15.3, e2.getWeight(), 0.01);
		
		e1.setWeight(23.4);
		assertEquals(23.4, e1.getWeight(), 0.01);
		
		assertTrue(e1.equals(e2));
		assertEquals(n1.getName()+", "+n2.getName()+", 23.4", e1.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExc1() {
		Node n2 = new Node(1);
		@SuppressWarnings("unused")
		Edge e = new Edge(null, n2);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testExc2() {
		Node n1 = new Node(15);
		Edge e = new Edge(n1, null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testExc3() {
		Edge e = new Edge(null, null);
	}
}
