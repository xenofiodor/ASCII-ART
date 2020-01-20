package ascii_art;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageParser {
    public static int[][] imageToRGBSum(String location) throws IOException {
        File file = new File(location);
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] colors = new int[height][width];
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                Color tempColor = new Color(image.getRGB(y, x));
                colors[x][y] = tempColor.getRed() + tempColor.getGreen() + tempColor.getBlue();
            }
        }
        return colors;
    }
}
