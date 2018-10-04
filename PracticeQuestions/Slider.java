import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Slider extends JFrame {

	JSlider slider;
	JButton button;
	JLabel label;

	JPanel jp, lp;

	JTabbedPane jtb;

	Slider() {

		slider = new JSlider(0, 255);
		button = new JButton("Get Value");
		label = new JLabel();

		jp = new JPanel();
		lp = new JPanel();

		jtb = new JTabbedPane();

		jtb.addTab("Control", lp);
		jtb.addTab("Color", jp);

		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label.setText("Mouse Entered");
			}
		});

		slider.setPaintLabels(true);
		slider.setPaintTicks(true);

		slider.addChangeListener(e -> {
			int rgb = slider.getValue();
			label.setText(String.valueOf(rgb));
			Color bg = new Color(rgb, 0, 0);
			jp.setBackground(bg);
		});
		
		lp.setLayout(new GridLayout(2, 3));
		jp.setLayout(new GridLayout(3, 3));
		setLayout(new FlowLayout());

		lp.add(slider);
		lp.add(button);
		lp.add(label);
		lp.add(jp);
		// add(lp);
		// add(jp);
		add(jtb);

		setVisible(true);
		setSize(500, 200);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}    

	public static void main(String[] args) {
		
		new Slider();
		
	}   

 }