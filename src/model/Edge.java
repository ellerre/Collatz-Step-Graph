/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */
package model;

public class Edge {
	private Node node1, node2;
	private Double weight;
	
	public Edge(Node node1, Node node2, double weight) {
		if (node1==null)
			throw new IllegalArgumentException("node1 must be a valid Node");
		if (node2==null)
			throw new IllegalArgumentException("node2 must be a valid Node");
		this.node1=node1;
		this.node2=node2;
		this.weight=weight;
	}
	
	public Edge(Node node1, Node node2) {
		this(node1, node2, 1.0);
	}

	public Node getNode1() {
		return node1;
	}

	public Node getNode2() {
		return node2;
	}

	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(double newWeight) {
		if (newWeight<1)
			throw new IllegalArgumentException("Weight must be at least 1.0");
		this.weight=newWeight;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Edge))
			return false;
		else return this.getNode1().equals(((Edge)o).getNode1()) &&
					this.getNode2().equals(((Edge)o).getNode2());
	}
	
	@Override
	public String toString() {
		return node1.getName()+", "+node2.getName()+", "+weight.toString();
		
	}

}
