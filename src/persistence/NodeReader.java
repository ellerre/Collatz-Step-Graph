package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import model.Node;

public class NodeReader {

	private BufferedReader reader;
	
	public NodeReader(String fileName) {
		if (fileName==null)
			throw new IllegalArgumentException("file name not valid");
		FileReader fr=null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error reading the file containing nodes");
		}
		this.reader= new BufferedReader(fr);
	}

	public List<Node> read() throws IOException {
		List<Node> sequence = new ArrayList<>();
		String line;
		while((line=reader.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(line, System.getProperty("line.separator"));
			Integer tmp;
			try {
				tmp= Integer.parseInt(st.nextToken());
				sequence.add(new Node(tmp));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error reading the file containing nodes");
			}
		}
		try {
			reader.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error closing the file containing nodes");
		}
		return sequence;
	}
}
