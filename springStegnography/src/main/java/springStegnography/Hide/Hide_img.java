package springStegnography.Hide;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import jdk.internal.org.jline.terminal.spi.TerminalProvider.Stream;

@Service
public class Hide_img {
	static File fp;
	static BufferedImage image;

	public BufferedImage Hide(CommonsMultipartFile img, String content) {
		try {
			FileInputStream stream = (FileInputStream) img.getInputStream();
			image = ImageIO.read(stream);
			content += '/';
			// Convert the message to binary
			byte[] messageBytes = content.getBytes();

			StringBuilder binaryMessage = new StringBuilder();

			for (byte b : messageBytes) {

				binaryMessage.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));

			}

			// Hide the binary message in the image
			int messageIndex = 0;
			for (int y = 0; y < image.getHeight(); y++) {
				for (int x = 0; x < image.getWidth(); x++) {
					int pixel = image.getRGB(x, y);

					// Modify the least significant bits of each color channel
					if (messageIndex < binaryMessage.length()) {

						int bit = binaryMessage.charAt(messageIndex++) - '0';

						pixel = (pixel & 0xFE) | bit;

						image.setRGB(x, y, pixel);

					} else {
						break;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;

	}

}
