package springStegnography.Extract;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class Extract_img {

	public String getdata(CommonsMultipartFile img) throws IOException {

		StringBuilder extractedMessage = new StringBuilder();
		FileInputStream stream = (FileInputStream) img.getInputStream();
		try {
			BufferedImage image = ImageIO.read(stream);

			StringBuilder binaryMessage = new StringBuilder();
			for (int y = 0; y < image.getHeight(); y++) {
				for (int x = 0; x < image.getWidth(); x++) {
					int pixel = image.getRGB(x, y);

					// Extract the least significant bit of each color channel
					int bit = pixel & 0x01;
					binaryMessage.append(bit);

					// Every 8 bits form a byte of the hidden message
					if (binaryMessage.length() % 8 == 0) {
						int asciiValue = Integer.parseInt(binaryMessage.toString(), 2);
						if (asciiValue == 0) {
							return extractedMessage.toString();// End of message

						}
						if (asciiValue == 47) {
							return extractedMessage.toString();
						}
						extractedMessage.append((char) asciiValue);
						binaryMessage.setLength(0); // Reset for the next byte
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return extractedMessage.toString();

	}

}
