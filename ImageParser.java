package ascii_art;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageParser {
    private int[][] colors;
    private char[][] chars;
    private Picture picture;

    public ImageParser(String location){
        if(this.imageToRGBSum(location)) {
            this.RGBSumToChars();
            this.initializePicture();
        }
    }

    private boolean imageToRGBSum(String location){
        try{
            File file = new File(location);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            this.colors = new int[height][width];
            for (int x = 0; x < height; x++){
                for (int y = 0; y < width; y++){
                    Color tempColor = new Color(image.getRGB(y, x));
                    this.colors[x][y] = tempColor.getRed() + tempColor.getGreen() + tempColor.getBlue();
                }
            }
            return true;
        } catch (IOException ex){
            System.err.println(ex.toString());
            System.out.println("\nTry one more time\n");
            return false;
        }
    }

    private void RGBSumToChars(){
        int width = this.colors[0].length;
        int height = this.colors.length;
        this.chars = new char[height][width];
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                if(this.colors[x][y] > 638)
                    this.chars[x][y] = Symbol.upTo765.getCharacter();
                else if(this.colors[x][y] > 510)
                    this.chars[x][y] = Symbol.upTo638.getCharacter();
                else if(this.colors[x][y] > 383)
                    this.chars[x][y] = Symbol.upTo510.getCharacter();
                else if(this.colors[x][y] > 255)
                    this.chars[x][y] = Symbol.upTo383.getCharacter();
                else if(colors[x][y] > 128)
                    this.chars[x][y] = Symbol.upTo255.getCharacter();
                else
                    this.chars[x][y] = Symbol.upTo128.getCharacter();
            }
        }
    }

    private void initializePicture(){
        this.picture = new Picture(this.chars);
    }

    public Picture getPicture(){
        return this.picture;
    }
}