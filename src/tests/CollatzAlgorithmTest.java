//package tests;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import model.CollatzAlgorithm;
//import model.Edge;
//import model.Node;
//
//import org.junit.Test;
//
//public class CollatzAlgorithmTest {
//
////	@Test
////	public void testStepSequence() {
////		List<Node> listaArticolo = new ArrayList<Node>();
////		listaArticolo.add(new Node(1));
////		listaArticolo.add(new Node(7));
////		listaArticolo.add(new Node(2));
////		listaArticolo.add(new Node(5));
////		listaArticolo.add(new Node(8));
////		listaArticolo.add(new Node(16));
////		listaArticolo.add(new Node(3));
////		listaArticolo.add(new Node(19));
////		listaArticolo.add(new Node(6));
////		listaArticolo.add(new Node(14));
////		listaArticolo.add(new Node(9));
////		listaArticolo.add(new Node(9));
////		listaArticolo.add(new Node(17));
////		listaArticolo.add(new Node(17));
////		listaArticolo.add(new Node(4));
////		listaArticolo.add(new Node(12));
////		listaArticolo.add(new Node(20));
////		listaArticolo.add(new Node(20));
////		listaArticolo.add(new Node(7));
////		
////		assertTrue(CollatzAlgorithm.stepSequence(20).equals(listaArticolo));
////		
////	}
//	
//	public void testStepSequence2() {
//		List<Node> listaArticolo = new ArrayList<Node>();
//		listaArticolo.add(new Node(1));
//		listaArticolo.add(new Node(7));
//		listaArticolo.add(new Node(2));
//		listaArticolo.add(new Node(5));
//		listaArticolo.add(new Node(8));
//		listaArticolo.add(new Node(16));
//		listaArticolo.add(new Node(3));
//		listaArticolo.add(new Node(19));
//		listaArticolo.add(new Node(6));
//		listaArticolo.add(new Node(14));
//		listaArticolo.add(new Node(9));
//		listaArticolo.add(new Node(9));
//		listaArticolo.add(new Node(17));
//		listaArticolo.add(new Node(17));
//		listaArticolo.add(new Node(4));
//		listaArticolo.add(new Node(12));
//		listaArticolo.add(new Node(20));
//		listaArticolo.add(new Node(20));
//		listaArticolo.add(new Node(7));
//		
////		assertTrue(CollatzAlgorithm.stepSequence(20).equals(listaArticolo));
//		
//	}
//	
//	@SuppressWarnings("unused")
//	@Test(expected=IllegalArgumentException.class) 
//	public void testStepSequenceExceptionNullPointer() {
//		List<Node> lista= CollatzAlgorithm.stepSequence(null);
//	}
//	
//	@SuppressWarnings("unused")
//	@Test(expected=IllegalArgumentException.class) 
//	public void testStepSequenceExceptionValueNotValid() {
//		List<Node> lista= CollatzAlgorithm.stepSequence(1);
//	}
//	
//	@Test 
//	public void testNotWeightedEdges() {
//		List<Edge> lista = new ArrayList<Edge>();
//		lista.add(new Edge(new Node(1), new Node(7)));
//		lista.add(new Edge(new Node(7), new Node(2)));
//		lista.add(new Edge(new Node(2), new Node(5)));
//		lista.add(new Edge(new Node(5), new Node(8)));
//		lista.add(new Edge(new Node(8), new Node(16)));
//		lista.add(new Edge(new Node(16), new Node(3)));
//		lista.add(new Edge(new Node(3), new Node(19)));
//		lista.add(new Edge(new Node(19), new Node(6)));
//		lista.add(new Edge(new Node(6), new Node(14)));
//		lista.add(new Edge(new Node(14), new Node(9)));
//		lista.add(new Edge(new Node(9), new Node(9)));
//		lista.add(new Edge(new Node(9), new Node(17)));
//		lista.add(new Edge(new Node(17), new Node(17)));
//		lista.add(new Edge(new Node(17), new Node(4)));
//		lista.add(new Edge(new Node(4), new Node(12)));
//		lista.add(new Edge(new Node(12), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(7)));
//		
//		List<Edge> listaConfronto = CollatzAlgorithm.getListOfNotWeightedEdges(CollatzAlgorithm.stepSequence(20));
//		
//		for(Edge e: listaConfronto) 
//			assertTrue(lista.contains(e));
//	}
//	
//	@Test
//	public void testWeightedEdgesNoChanges() {
//		List<Edge> lista = new ArrayList<Edge>();
//		lista.add(new Edge(new Node(1), new Node(7)));
//		lista.add(new Edge(new Node(7), new Node(2)));
//		lista.add(new Edge(new Node(2), new Node(5)));
//		lista.add(new Edge(new Node(5), new Node(8)));
//		lista.add(new Edge(new Node(8), new Node(16)));
//		lista.add(new Edge(new Node(16), new Node(3)));
//		lista.add(new Edge(new Node(3), new Node(19)));
//		lista.add(new Edge(new Node(19), new Node(6)));
//		lista.add(new Edge(new Node(6), new Node(14)));
//		lista.add(new Edge(new Node(14), new Node(9)));
//		lista.add(new Edge(new Node(9), new Node(9)));
//		lista.add(new Edge(new Node(9), new Node(17)));
//		lista.add(new Edge(new Node(17), new Node(17)));
//		lista.add(new Edge(new Node(17), new Node(4)));
//		lista.add(new Edge(new Node(4), new Node(12)));
//		lista.add(new Edge(new Node(12), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(7)));
//	
////		Collection<Edge> listaConfronto = CollatzAlgorithm.getListOfWeightedEdges(CollatzAlgorithm.stepSequence(20));
////		
////		for(Edge e: listaConfronto) 
////			assertTrue(lista.contains(e));
//	}
//	
//	@Test
//	public void testWeightedEdgesWithChanges() {
//		List<Node> listaArticoloModificata = new ArrayList<Node>();
//		listaArticoloModificata.add(new Node(1));
//		listaArticoloModificata.add(new Node(7));
//		listaArticoloModificata.add(new Node(2));
//		listaArticoloModificata.add(new Node(5));
//		listaArticoloModificata.add(new Node(8));
//		listaArticoloModificata.add(new Node(16));
//		listaArticoloModificata.add(new Node(3));
//		listaArticoloModificata.add(new Node(19));
//		listaArticoloModificata.add(new Node(6));
//		listaArticoloModificata.add(new Node(14));
//		listaArticoloModificata.add(new Node(9));
//		listaArticoloModificata.add(new Node(9));
//		listaArticoloModificata.add(new Node(9));
//		listaArticoloModificata.add(new Node(17));
//		listaArticoloModificata.add(new Node(4));
//		listaArticoloModificata.add(new Node(12));
//		listaArticoloModificata.add(new Node(20));
//		listaArticoloModificata.add(new Node(20));
//		listaArticoloModificata.add(new Node(7));
//	
//		Collection<Edge> listaConfronto = CollatzAlgorithm.getListOfWeightedEdges(listaArticoloModificata);
//		
//		Set<Edge> lista = new HashSet<Edge>();
//		lista.add(new Edge(new Node(1), new Node(7)));
//		lista.add(new Edge(new Node(7), new Node(2)));
//		lista.add(new Edge(new Node(2), new Node(5)));
//		lista.add(new Edge(new Node(5), new Node(8)));
//		lista.add(new Edge(new Node(8), new Node(16)));
//		lista.add(new Edge(new Node(16), new Node(3)));
//		lista.add(new Edge(new Node(3), new Node(19)));
//		lista.add(new Edge(new Node(19), new Node(6)));
//		lista.add(new Edge(new Node(6), new Node(14)));
//		lista.add(new Edge(new Node(14), new Node(9)));
//		lista.add(new Edge(new Node(9), new Node(9), 2.0));
//		lista.add(new Edge(new Node(9), new Node(17)));
//		lista.add(new Edge(new Node(17), new Node(4)));
//		lista.add(new Edge(new Node(4), new Node(12)));
//		lista.add(new Edge(new Node(12), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(20)));
//		lista.add(new Edge(new Node(20), new Node(7)));
//		
//		for (Edge e:lista)
//			assertTrue(listaConfronto.contains(e));
//	}
//	
//	
//	
//}
