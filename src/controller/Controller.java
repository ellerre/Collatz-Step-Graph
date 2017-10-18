package controller;
/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */


import java.io.IOException;

import javax.swing.JOptionPane;

import persistence.GraphWriter;
import model.CSGraph;


public class Controller {
	
	private CSGraph graph;
	private boolean weight;
	
	public Controller(int n, boolean weight) {
		if (n<1 || n> Integer.MAX_VALUE)
			throw new IllegalArgumentException("Value not valid. Valid values: 1< n <="+Integer.MAX_VALUE);
		this.graph= new CSGraph(n); //Generate the graph using the algorithm
		this.weight=weight;
	}
	
	public boolean hasWeight() {
		return weight;
	}

	public void setWeight(boolean weight) {
		this.weight = weight;
	}

	public CSGraph getGraph() {
		return graph;
	}
	
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		sb.append("Number of nodes:\t");
		sb.append(graph.getListOfNodesWithoutRepetitions().size());
		sb.append(System.getProperty("line.separator"));
		sb.append("Number of edges:\t");
		if (weight)
			sb.append(graph.getListOfWeightedEdges().size());
		else 
			sb.append(graph.getListOfNotWeightedEdges().size());
		sb.append(System.getProperty("line.separator"));
		
		return sb.toString();
	}

	public void write(String fileName) {
		if (!fileName.endsWith(".gdf"))
			fileName= fileName+".gdf";
		GraphWriter gw = new GraphWriter(fileName, graph, weight);
		try {
			gw.write();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while writing file");
		}		
	}
	
	public void writeStatsForWeightedEdges(String fileName) {
		if (!fileName.endsWith(".csv"))
			fileName= fileName+".csv";
		GraphWriter gw = new GraphWriter(fileName, graph, weight);
		try {
			gw.writeStatsForWeighted();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while writing file");
		}		
	}
	
	public void writeForSIFExtension(String fileName) {
		if (!fileName.endsWith(".sif"))
			fileName= fileName+".sif";
		GraphWriter gw = new GraphWriter(fileName, graph, weight);
		try {
			gw.writeForSIFExtension();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while writing file");
		}		
	}
	
}
