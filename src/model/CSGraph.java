/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/24
 * Network Science - Prof. Babaoglu
 */
package model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.NodeReader;

@SuppressWarnings("unused")
public class CSGraph {

	private List<Node> listOfNodes;
	private List<Node> listOfNodesWithoutRepetitions;
	private List<Edge> listOfNotWeightedEdges;
	private Collection<Edge> listOfWeightedEdges;
	
	public CSGraph(Integer n) {
		if (n==0)
			throw new IllegalArgumentException("Parameter n not valid");
		listOfNodes = new ArrayList<Node>();
//		NodeReader nr = new NodeReader("nodes.txt");
//		try {
			listOfNodes= /*nr.read();*/
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, "Error reading the file containing nodes");
//		}				
				CollatzAlgorithm.stepSequence(n);
		listOfNodesWithoutRepetitions = deleteNodeRepetitions(listOfNodes);
		listOfNotWeightedEdges = CollatzAlgorithm.getListOfNotWeightedEdges(listOfNodes);		
		listOfWeightedEdges = CollatzAlgorithm.getListOfWeightedEdges(listOfNodes);
		
	}

	private List<Node> deleteNodeRepetitions(List<Node> listOfNodes) {
		List<Node> res = new ArrayList<Node>();
		for(int i=0; i<listOfNodes.size(); i++) {
			Node n = listOfNodes.get(i);
		if (!res.contains(n))
				res.add(n);
		}
		
		return	res;
	}

	public List<Node> getListOfNodes() {
		return listOfNodes;
	}

	public List<Edge> getListOfNotWeightedEdges() {
		return listOfNotWeightedEdges;
	}

	public Collection<Edge> getListOfWeightedEdges() {
		return listOfWeightedEdges;
	}
	
	public List<Node> getListOfNodesWithoutRepetitions() {
		return listOfNodesWithoutRepetitions;
	}
 
 /* Alternative method
	private List<Node> stepSequence;
	private List<Node> listOfNodes;
	private List<Edge> listOfNotWeightedEdges;
	private List<Edge> listOfWeightedEdges;
	
	public CSGraph(Integer n) {
		if (n<=0)
			throw new IllegalArgumentException("Parameter n not valid");
		stepSequence = CollatzAlgorithm.stepSequence(n);
		listOfNodes =  new ArrayList<Node>();
		listOfNotWeightedEdges =  new ArrayList<Edge>();	
		listOfWeightedEdges =  new ArrayList<Edge>();
		
		algorithm(n);
	}

	private void algorithm(Integer n) {
		if (n>1) {
			int i=0;
			while(i<stepSequence.size()-1) {
				Node currentNode= stepSequence.get(i);
				if (!listOfNodes.contains(currentNode))
					listOfNodes.add(currentNode);
				Edge e = new Edge(currentNode, stepSequence.get(i+1));
				listOfNotWeightedEdges.add(e);
				if (!listOfWeightedEdges.contains(e))
					listOfWeightedEdges.add(e);
				else {
					Edge tmp = listOfWeightedEdges.get(listOfWeightedEdges.indexOf(e));
					double weight = tmp.getWeight()+1;
					tmp.setWeight(weight);
				}
			i++;		
			}
			if (!listOfNodes.contains(stepSequence.get(i)))
				listOfNodes.add(stepSequence.get(i));
		}
}

	public List<Node> getListOfNodes() {
		return stepSequence;
	}

	public List<Edge> getListOfNotWeightedEdges() {
		return listOfNotWeightedEdges;
	}

	public Collection<Edge> getListOfWeightedEdges() {
		return listOfWeightedEdges;
	}
	
	public List<Node> getListOfNodesWithoutRepetitions() {
		return listOfNodes;
	}
	*/
}
	
