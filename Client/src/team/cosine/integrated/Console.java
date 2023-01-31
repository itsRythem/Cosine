package team.cosine.integrated;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public final class Console {
	
    private JFrame frame;
    private JTextArea pane;
    
	public void initiate()
	{
        frame = new JFrame("Cosine Console");
        pane = new JTextArea();
        pane.setEditable(false);
        pane.setBackground(Color.BLACK);
        pane.setForeground(Color.WHITE);
        
        frame.setLayout(new BorderLayout());
        frame.add(pane,BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);
        frame.setVisible(true);
	}
	
	public void terminate()
	{
		frame.dispose();
	}
	
}
