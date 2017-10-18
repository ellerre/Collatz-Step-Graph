/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */
package model;

public class Node {

	private Integer intValue;
	private String name;
	
	public Node(Integer n) {
		if (n==null || n<1)
			throw new IllegalArgumentException("Parameter n not valid");
		intValue=n;
		name= new Integer(n.intValue()).toString();
	}

	public Integer getIntValue() {
		return intValue;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Node))
			return false;
		else return this.getName().equals(((Node)other).getName());
	}
	
	@Override
	public String toString() {
		return name + "," + name;
	}
	
	
}
