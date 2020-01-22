package ascii_art;


import java.util.HashMap;

public class Animation {
    private char [][] picture;

    Animation(char [][] picture){
        this.picture = picture;
    }

    public String toString(){
        int width = this.picture[0].length;
        int height = this.picture.length;
        char[] string = new char[width * height + height];
        int k = 0;
        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                string[k] = this.picture[x][y];
                k++;
            }
            string[k] = '\n';
            k++;
        }
        return String.valueOf(string);
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

    public char[][][] fillPicStorage(){
        int width = this.picture[0].length;
        int height = this.picture.length;
        char[][][] picStorage = new char[6][height][width];
        picStorage[0] = this.picture;
        for (int i = 1; i <= 5; i++){
            HashMap<Character, Character> shiftedChars = new HashMap<>();
            shiftedChars.put(Symbol.upTo128.getCharacter(), Symbol.shiftCharBy(Symbol.upTo128.getCharacter(), i));
            shiftedChars.put(Symbol.upTo255.getCharacter(), Symbol.shiftCharBy(Symbol.upTo255.getCharacter(), i));
            shiftedChars.put(Symbol.upTo383.getCharacter(), Symbol.shiftCharBy(Symbol.upTo383.getCharacter(), i));
            shiftedChars.put(Symbol.upTo510.getCharacter(), Symbol.shiftCharBy(Symbol.upTo510.getCharacter(), i));
            shiftedChars.put(Symbol.upTo638.getCharacter(), Symbol.shiftCharBy(Symbol.upTo638.getCharacter(), i));
            shiftedChars.put(Symbol.upTo765.getCharacter(), Symbol.shiftCharBy(Symbol.upTo765.getCharacter(), i));
            for (int x = 0; x < height; x++){
                for (int y = 0; y < width; y++){
                    picStorage[i][x][y] = shiftedChars.get(this.picture[x][y]);
                }
            }
        }
        return picStorage;
    }

    public void animate() throws InterruptedException {
        char [][][] picStorage = this.fillPicStorage();
        for (int i = 0; i < 10; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(charsToString(picStorage[i % 6]));
            Thread.sleep(500);
        }
    }
}
