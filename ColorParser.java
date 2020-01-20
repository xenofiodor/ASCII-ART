package ascii_art;

public class ColorParser {
    private char [] symbols = {' ', '-', '+', '=', '%', '#'};

    public char[][] RGBSumToChars(int[][] colors){
        int width = colors[0].length;
        int height = colors.length;
        char[][] chars = new char[height][width];
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                if(colors[x][y] >= 638)
                    chars[x][y] = this.symbols[5];
                else if(colors[x][y] >= 510)
                    chars[x][y] = this.symbols[4];
                else if(colors[x][y] >= 383)
                    chars[x][y] = this.symbols[3];
                else if(colors[x][y] >= 255)
                    chars[x][y] = this.symbols[2];
                else if(colors[x][y] >= 128)
                    chars[x][y] = this.symbols[1];
                else
                    chars[x][y] = this.symbols[0];

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

    private int getIndexOf (char c){
        for (int i = 0; i < 6; i++){
            if (this.symbols[i] == c)
                return i;
        }
        return -1;
    }

    public char[][][] fillPicStorage(char[][] pic){
        int width = pic[0].length;
        int height = pic.length;
        char[][][] picStorage = new char[6][height][width];
        picStorage[0] = pic;
        for (int i = 1; i <= 5; i++){
            for (int x = 0; x < height; x++){
                for (int y = 0; y < width; y++){
                    picStorage[i][x][y] = this.symbols[(this.getIndexOf(pic[x][y]) + i) % 6];
                }
            }
        }
        return picStorage;
    }

    public static void animate(char[][][] picStorage) throws InterruptedException {
        for (int i = 0; i < 6; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(charsToString(picStorage[i]));
            Thread.sleep(2000);
        }
    }



}
