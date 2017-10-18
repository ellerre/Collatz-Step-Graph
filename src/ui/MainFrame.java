/**
 * Author: Lorenzo Rosa - Collegio Superiore, Alma Mater Studiorum Università di Bologna - 2015/08/17
 * Network Science - Prof. Babaoglu
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;


public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JTextField numberField;
	private JCheckBox checkButton;
	private JButton generateGraph, saveGraph, saveStatsWeightedEdges, saveSifFile;
	private JTextArea areaStats;

	public MainFrame() {
		
		setSize(650,200);
		setTitle("GENERATE A COLLATZ STEP GRAPH");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initGUI();
	}
	
	private void initGUI() {
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new BorderLayout(5,5));
		this.add(generalPanel);
		
		//==================================================//
		
		JLabel title = new JLabel("GENERATE A COLLATZ STEP GRAPH");
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		generalPanel.add(title, BorderLayout.PAGE_START);
		
		//==================================================//
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridLayout(4, 2));
		generalPanel.add(settingsPanel, BorderLayout.WEST);
		
		JLabel insertNumber = new JLabel("INSERT THE NUMBER n\t");
		insertNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		settingsPanel.add(insertNumber);
		
		numberField = new JTextField(1);
		numberField.setHorizontalAlignment(SwingConstants.CENTER);
		numberField.setSize(10, 10);
		settingsPanel.add(numberField);
		
		JLabel insertWeighted = new JLabel("WEIGHTED");
		insertWeighted.setFont(new Font("Times New Roman", Font.BOLD, 12));
		settingsPanel.add(insertWeighted);
		
		checkButton = new JCheckBox();
		checkButton.setSelected(true);
		settingsPanel.add(checkButton);
		
		generateGraph = new JButton("Generate GRAPH");
		generateGraph.addActionListener(this);
		settingsPanel.add(generateGraph);
		
		saveGraph = new JButton("Save GDF file");
		saveGraph.addActionListener(this);
		saveGraph.setEnabled(false);
		settingsPanel.add(saveGraph);
		
		saveStatsWeightedEdges= new JButton("Get stats for weighted edges");
		saveStatsWeightedEdges.addActionListener(this);
		saveStatsWeightedEdges.setEnabled(false);
		settingsPanel.add(saveStatsWeightedEdges);
		
		saveSifFile = new JButton("save .sif file");
		saveSifFile.addActionListener(this);
		saveSifFile.setEnabled(false);
		settingsPanel.add(saveSifFile);
		
		//==================================================//
		
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new BorderLayout(5,5));
		generalPanel.add(statsPanel, BorderLayout.CENTER);
		
		areaStats = new JTextArea();
		areaStats.setFont(new Font("Comic Sans Ms", Font.BOLD, 15));
		areaStats.setVisible(true);
		areaStats.setEditable(false);
		statsPanel.add(areaStats, BorderLayout.CENTER);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int n;
		try {
			n = Integer.parseInt(numberField.getText());
			controller= new Controller(n, checkButton.isSelected());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Format not valid. Only integers are allowed");
			return;
		} catch (IllegalArgumentException ne) {
			JOptionPane.showMessageDialog(null, ne.getMessage());
			return;
		} 
		if (o==generateGraph) {
			areaStats.setText(controller.getStats());
			saveGraph.setEnabled(true);
			saveStatsWeightedEdges.setEnabled(true);
			saveSifFile.setEnabled(true);
		}
		else if (o==saveGraph) {
			JFileChooser chooser = new JFileChooser((String)null);
			int res = chooser.showSaveDialog(this); 
			if (res == JFileChooser.APPROVE_OPTION) 
				controller.write(chooser.getSelectedFile().toString());
			
			else JOptionPane.showMessageDialog(null, "Access denied");
		}
		else if (o==saveStatsWeightedEdges) {
			JFileChooser chooser = new JFileChooser((String)null);
			int res = chooser.showSaveDialog(this); 
			if (res == JFileChooser.APPROVE_OPTION) 
				controller.writeStatsForWeightedEdges(chooser.getSelectedFile().toString());
			else JOptionPane.showMessageDialog(null, "Access denied");
		}
		else if(o==saveSifFile) {
			JFileChooser chooser = new JFileChooser((String)null);
			int res = chooser.showSaveDialog(this); 
			if (res == JFileChooser.APPROVE_OPTION) 
				controller.writeForSIFExtension(chooser.getSelectedFile().toString());
			else JOptionPane.showMessageDialog(null, "Access denied");
		}
	}

}
