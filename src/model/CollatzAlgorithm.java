/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollatzAlgorithm {
	
	private static Integer t;

	private static Integer collatz(Integer n) {
		if (n==null || n<1)
			throw new IllegalArgumentException("Parameter n not valid");
		while (n!=1) {
			t++;
			if ((n%2)!=0) 
				n= 3*n+1;
			else n=n/2;
		}
		return n;
	}

	private static Node stepFunction(Integer n) 
	{
		t=0;
		collatz(n);
		return new Node(t);
	}

	public static List<Node> stepSequence(Integer n) {
		if (n==null)
			throw new IllegalArgumentException("n can't be null");
		if (n<=1)
			throw new IllegalArgumentException("n must be at least 2");
		List<Node> sequence = new ArrayList<Node>();
		Integer index = n;
		while (index>1) {
			sequence.add(stepFunction(index));
			index--;
		}
		Collections.reverse(sequence);
		return sequence;
	}
	
	public static List<Edge> getListOfNotWeightedEdges (List<Node> listOfNodes) {
		if (listOfNodes==null)
			throw new IllegalArgumentException("list of node must exist");
		List<Edge> result = new ArrayList<Edge>();
		int size = listOfNodes.size();
		if (size<=1)
			return result;
		for (int i=0; i<size-1; i++) {
			Edge tmp = new Edge(listOfNodes.get(i), listOfNodes.get(i+1));
			result.add(tmp);
		}
		return result;		
	}
	
	public static Collection<Edge> getListOfWeightedEdges (List<Node> listOfNodes){
		List<Edge> temp = CollatzAlgorithm.getListOfNotWeightedEdges(listOfNodes);
		List<Edge> res = new ArrayList<Edge>();
		for(int i=0; i<temp.size(); i++) {
			Edge e = temp.get(i);
			if (!res.contains(e))
				res.add(e);
			else {
				res.get(res.indexOf(e)).setWeight(res.get(res.indexOf(e)).getWeight()+e.getWeight());
			}
		}
		return res;	
	}
	
}
