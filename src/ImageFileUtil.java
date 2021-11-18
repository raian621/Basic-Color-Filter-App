import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageFileUtil {
	static private JFileChooser chooser = new JFileChooser();
	
	static public BufferedImage openImage() throws IOException {
		int i = chooser.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			return ImageIO.read(f);
		}
		return null;
	}
	public static void saveImage(BufferedImage image) throws IOException {
		int i = chooser.showSaveDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			ImageIO.write(image, "png", f);
		}
	}
}
