package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class SudokuDisplay {
    public SudokuDisplay(SudokuSolver sudoku) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku, "Sudoku Solver", 500, 550));
    }
    
    private void createWindow(SudokuSolver sudoku, String title,
                                    int width, int height) {
    	JFrame frame = new JFrame(title);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container pane = frame.getContentPane();
    	
    	JPanel center = new JPanel();
    	center.setPreferredSize(new Dimension(500, 500));
    	center.setBackground(Color.LIGHT_GRAY);
    	pane.add(center, BorderLayout.CENTER);
    	
    	JTextField[][] cells = new JTextField[9][9];

    	for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                cells[r][c] = new JTextField();
                cells[r][c].setPreferredSize(new Dimension(50, 50));
                cells[r][c].setHorizontalAlignment(JTextField.CENTER);
                cells[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                if (((r / 3) % 2 == 0 && (c / 3) % 2 == 0) ||
                		((r / 3) % 2 == 1 && (c / 3) % 2 == 1)) {
                    cells[r][c].setBackground(new Color(178, 255, 102));
                }
                center.add(cells[r][c]);
            }
    	}
	 	
    	JButton buttonS = new JButton("Solve");
    	buttonS.addActionListener(e -> {
    		for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                	String s = cells[r][c].getText();
                	if (!s.equals("")) {
                		try {
                    		int n = Integer.parseInt(s);
                            if (n < 1 || n > 9) {
                                throw new NumberFormatException();
                            }
                    	} catch (NumberFormatException ex) {
                    		 JOptionPane.showMessageDialog(null, "Must be a number between 1 and 9.",
                                     "Value Error", JOptionPane.ERROR_MESSAGE);
                             cells[r][c].setText(""); 
                             return;
                    	}
                	}
                	int n = 0;
                	if (!s.equals("")) {
                		n = Integer.valueOf(s);
                	}
                	sudoku.set(r, c, n);
                }
        	}
    		if (!sudoku.solve()) {
    			JOptionPane.showMessageDialog(null, "No solution found",
        		        "Solve", JOptionPane.ERROR_MESSAGE);
    		} else {
    			for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                    	if (sudoku.get(r, c) != 0) {
                    		cells[r][c].setText(String.valueOf(sudoku.get(r,  c)));
                    	} else {
                    		cells[r][c].setText("");
                    	}
                    }
            	}
    		}
    	}); 
    	
    	JButton buttonC = new JButton("Clear");
    	buttonC.addActionListener(e -> {
    		for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                	cells[r][c].setText("");
                }
        	}
    	});
      
    	JPanel southPanel = new JPanel();
    	southPanel.setBackground(Color.WHITE);
    	southPanel.setPreferredSize(new Dimension(500, 50));
    	pane.add(southPanel, BorderLayout.SOUTH);
    	southPanel.add(buttonS);
    	southPanel.add(buttonC);
    	southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
    	
    	frame.pack();
    	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
    	SudokuSolver s = new SudokuDescribe();
    	new SudokuDisplay(s);
    } 
    
}