package ascii_art;

import java.io.IOException;

import static ascii_art.ImageParser.imageToRGBSum;
import static ascii_art.ColorParser.charsToString;

public class Main {
    public static void main(String [] args) throws IOException {
        ColorParser colorParser = new ColorParser();
        System.out.println(charsToString(colorParser.RGBSumToChars(
                imageToRGBSum("/home/xeno/xWs/Java/ascii-art/src/ascii_art/horses.jpg"))));
    }
}
