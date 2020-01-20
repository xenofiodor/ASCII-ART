package ascii_art;

public class ColorParser {
    private char upTo128 = ' ';
    private char upTo255 = '-';
    private char upTo383 = '+';
    private char upTo510 = '=';
    private char upTo638 = '%';
    private char upTo765 = '#';

    public char[][] RGBSumToChars(int[][] colors){
        int width = colors[0].length;
        int height = colors.length;
        char[][] chars = new char[height][width];
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                if(colors[x][y] >= 638)
                    chars[x][y] = this.upTo765;
                else if(colors[x][y] >= 510)
                    chars[x][y] = this.upTo638;
                else if(colors[x][y] >= 383)
                    chars[x][y] = this.upTo510;
                else if(colors[x][y] >= 255)
                    chars[x][y] = this.upTo383;
                else if(colors[x][y] >= 128)
                    chars[x][y] = this.upTo255;
                else
                    chars[x][y] = this.upTo128;

            }
        }
        return chars;
    }

    public static String charsToString(char[][] chars){
        int width = chars[0].length;
        int height = chars.length;
        char[] string = new char[width * height + height];
        int k = 0;
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                string[k] = chars[x][y];
                k++;
            }
            string[k] = '\n';
            k++;
        }
        return String.valueOf(string);
    }
}
