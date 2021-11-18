
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Tab extends JScrollPane {
	protected BufferedImage image;
	protected JFileChooser chooser;
	String name = null;
	
	public Tab() {
		setLayout(new BorderLayout());
		
	}
	public Tab(String name) {
		this.name = name;
	}
	public Tab(BufferedImage image, String name) {
		this(name);
		this.image = image;
		setViewportView(new JLabel(new ImageIcon(this.image)));
	}
	
	public void load() throws IOException {
		image = ImageFileUtil.openImage();
		setViewportView(new JLabel(new ImageIcon(image)));
	}
	public void save() throws IOException {
		ImageFileUtil.saveImage(image);
	}
	public void clear() {
		this.getViewport().removeAll();
	}
	public Tab invert() {
		return new Tab(ImageFilter.invertImage(image), name + "_inverted");
	}
	public Tab seperateRed() {
		return new Tab(ImageFilter.seperateRed(image), name + "_red");
	}
	public Tab seperateGreen() {
		return new Tab(ImageFilter.seperateGreen(image), name + "_grn");
	}
	public Tab seperateBlue() {
		return new Tab(ImageFilter.seperateBlue(image), name + "_blu");
	}
	public Tab monochrome() {
		return new Tab(ImageFilter.monochromeImage(image), name + "_monochrome");
	}
}