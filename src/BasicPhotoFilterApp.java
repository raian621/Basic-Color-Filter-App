
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class BasicPhotoFilterApp extends JFrame implements ActionListener {
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem clear = new JMenuItem("Clear");
	JMenu edit = new JMenu("Edit");
	JMenuItem invert = new JMenuItem("Invert");
	JMenuItem monochrome = new JMenuItem("Monochrome");
	JMenuItem seperateRGB = new JMenuItem("Seperate RGB");
	JMenuItem seperateRed = new JMenuItem("Seperate Red");
	JMenuItem seperateBlue = new JMenuItem("Seperate Blue");
	JMenuItem seperateGreen = new JMenuItem("Seperate Green");
	
	PhotoTabs tabs = new PhotoTabs();
	
	public BasicPhotoFilterApp() {
		setTitle("Basic Photo Filter App");
		setLayout(new BorderLayout(20, 0));
		
		menu.add(file);
		menu.add(edit);
		file.add(open);
		file.add(save);
		file.add(clear);
		edit.add(invert);
		edit.add(monochrome);
		edit.add(seperateRGB);
		edit.add(seperateRed);
		edit.add(seperateBlue);
		edit.add(seperateGreen);
		
		add(menu, BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);

		open.addActionListener(this);
		save.addActionListener(this);
		invert.addActionListener(this);
		monochrome.addActionListener(this);
		seperateRed.addActionListener(this);
		seperateGreen.addActionListener(this);
		seperateBlue.addActionListener(this);
		seperateRGB.addActionListener(this);
		
		setSize(800, 500);
		setDefaultCloseOperation(2);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BasicPhotoFilterApp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == save) {
				tabs.saveTab(tabs.getSelectedIndex());
			}
			if (e.getSource() == open) {
				tabs.loadTab(tabs.getSelectedIndex());
			}
			if (e.getSource() == clear) {
				tabs.clearTab(tabs.getSelectedIndex());
			}
			if (e.getSource() == invert) {
				tabs.addInvertFilter(tabs.getSelectedIndex());
			}
			if (e.getSource() == monochrome) {
				tabs.addMonochromeFilter(tabs.getSelectedIndex());
			}
			if (e.getSource() == seperateRGB) {
				tabs.addRedFilter(tabs.getSelectedIndex());
				tabs.addGreenFilter(tabs.getSelectedIndex());
				tabs.addBlueFilter(tabs.getSelectedIndex());
			}
			if (e.getSource() == seperateRed) {
				tabs.addRedFilter(tabs.getSelectedIndex());
			}
			if (e.getSource() == seperateGreen) {
				tabs.addGreenFilter(tabs.getSelectedIndex());
			}
			if (e.getSource() == seperateBlue) {
				tabs.addBlueFilter(tabs.getSelectedIndex());				
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
