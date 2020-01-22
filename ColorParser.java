package ascii_art;

public class ColorParser {
    public static char[][] RGBSumToChars(int[][] colors){
        int width = colors[0].length;
        int height = colors.length;
        char[][] chars = new char[height][width];
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                if(colors[x][y] > 638)
                    chars[x][y] = Symbol.upTo765.getCharacter();
                else if(colors[x][y] > 510)
                    chars[x][y] = Symbol.upTo638.getCharacter();
                else if(colors[x][y] > 383)
                    chars[x][y] = Symbol.upTo510.getCharacter();
                else if(colors[x][y] > 255)
                    chars[x][y] = Symbol.upTo383.getCharacter();
                else if(colors[x][y] > 128)
                    chars[x][y] = Symbol.upTo255.getCharacter();
                else
                    chars[x][y] = Symbol.upTo128.getCharacter();

            }
        }
        return chars;
    }
}
