package ascii_art;

import java.io.IOException;


import static ascii_art.ColorParser.RGBSumToChars;
import static ascii_art.ImageParser.imageToRGBSum;


public class Main {
    private static char[][] processImage(String path) throws IOException {
       return RGBSumToChars(imageToRGBSum(path));
    }

    public static void main(String [] args) throws IOException, InterruptedException {
        Animation picture = new Animation(processImage(
                "/home/xeno/xWs/Java/ascii-art/src/ascii_art/horses.jpg"));
        System.out.println(picture.toString());
        picture.animate();

    }
}
