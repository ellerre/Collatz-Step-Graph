/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */

package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import model.CSGraph;
import model.Edge;
import model.Node;

public class GraphWriter {
	
	private static String nodeIntroLine = "nodedef>name VARCHAR,label VARCHAR";
	private static String edgesIntroLine = "edgedef>node1 VARCHAR,node2 VARCHAR, weight DOUBLE";
	private CSGraph graph;
	private String fileName;
	private boolean weight;
	
	public GraphWriter(String fileName, CSGraph graph, boolean weight) {
		if (fileName == null)
			throw new IllegalArgumentException("File name not valid");
		if (graph==null)
			throw new IllegalArgumentException("Graph not valid");
		this.graph=graph;
		this.fileName=fileName;
		this.weight=weight;
	}
	
	public void write() throws IOException {
		FileWriter writer = new FileWriter(fileName);
		PrintWriter pw = new PrintWriter(writer);
		writeNodes(pw);
		if (weight)
			writeWeightEdges(pw);
		else
			writeNotWeightEdges(pw);
		
		pw.close();		
	}

	
	private void writeNodes(PrintWriter pw) {
		pw.println(nodeIntroLine);
		for (Node n : graph.getListOfNodesWithoutRepetitions())
			pw.println(n);
		
	}

	private void writeWeightEdges(PrintWriter pw) {
		pw.println(edgesIntroLine);
		for(Edge e : graph.getListOfWeightedEdges())
			pw.println(e);
		
	}
	
	private void writeNotWeightEdges(PrintWriter pw) {
		pw.println(edgesIntroLine);
		for(Edge e : graph.getListOfNotWeightedEdges())
			pw.println(e);		
	}
	
	public void writeStatsForWeighted() throws IOException { //Power law scaling of the edge weights in CS Graph
		Map<Double, Integer> map = computeStatsForWeight();
		FileWriter writer = new FileWriter(fileName);
		PrintWriter pw = new PrintWriter(writer);
		pw.println("Edge weights, Frequency");
		for (Double d : map.keySet()) {
			pw.println(d+"\t"+map.get(d));
		}
		pw.close();		
	}

	private Map<Double, Integer> computeStatsForWeight() {
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		for(Edge e:graph.getListOfWeightedEdges()) {
			Double weight = e.getWeight();
			if(!map.keySet().contains(weight))
				map.put(weight, 1);
			else {
				Integer i = map.get(weight);
				map.replace(weight, i+1);
			}
		}
		return map;
	}

	public void writeForSIFExtension() throws IOException {
		FileWriter writer = new FileWriter(fileName);
		PrintWriter pw = new PrintWriter(writer);
		
		for (Edge e : graph.getListOfNotWeightedEdges()){
			pw.println(e.getNode1().getName()+"\t"+e.getWeight()+"\t"+e.getNode2().getName()+"\n");
		}
		
		pw.close();		
	}
}