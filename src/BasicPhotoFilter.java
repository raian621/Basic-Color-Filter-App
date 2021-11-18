
import java.awt.BorderLayout;

import javax.swing.*;

public class BasicPhotoFilterApp extends JFrame {
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem open = new JMenuItem("Open");
	JMenu edit = new JMenu("Edit");
	JMenuItem invert = new JMenuItem("Invert");
	JMenuItem monochrome = new JMenuItem("Monochrome");
	JMenuItem seperateRGB = new JMenuItem("Seperate RGB");
	JMenuItem seperateRed = new JMenuItem("Seperate Red");
	JMenuItem seperateBlue = new JMenuItem("Seperate Blue");
	JMenuItem seperateGreen = new JMenuItem("Seperate Green");
	
	JTabbedPane tabs = new JTabbedPane();
	
	public BasicPhotoFilterApp() {
		setLayout(new BorderLayout(20, 0));
		
		menu.add(file);
		menu.add(edit);
		file.add(open);
		file.add(save);
		edit.add(invert);
		edit.add(monochrome);
		edit.add(seperateRGB);
		edit.add(seperateRed);
		edit.add(seperateBlue);
		edit.add(seperateGreen);
		
		tabs.add("Panel 1", new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
		
		add(menu, BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);
		
		setSize(800, 500);
		setDefaultCloseOperation(2);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BasicPhotoFilterApp();
	}
}
