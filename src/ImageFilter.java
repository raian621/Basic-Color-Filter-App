import java.awt.image.BufferedImage;

public class ImageFilter {
	public static BufferedImage invertImage(BufferedImage image) {
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int argb = image.getRGB(x, y);
				argb = ~argb | (argb &0xff000000);
				
				output.setRGB(x, y, argb);
			}
		}
		return output;
	}
	public static BufferedImage seperateRed(BufferedImage image) {
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				output.setRGB(x, y, image.getRGB(x, y) & 0xffff0000);
			}
		}
		return output;
	}
	public static BufferedImage seperateGreen(BufferedImage image) {
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				output.setRGB(x, y, image.getRGB(x, y) & 0xff00ff00);
			}
		}
		return output;
	}
	public static BufferedImage seperateBlue(BufferedImage image) {
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				output.setRGB(x, y, image.getRGB(x, y) & 0xff0000ff);
			}
		}
		return output;
	}
	public static BufferedImage monochromeImage(BufferedImage image) {
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int argb = image.getRGB(x, y);
				int average = ((((argb >> 0x10) & 0xff) + ((argb >> 0x8)  & 0xff) + ((argb) & 0xff)) / 3) & 0xff;
				output.setRGB(x, y, (argb & 0xff000000) | average << 0x10 | average << 0x8 | average);
			}
		}
		return output;
	}
}
