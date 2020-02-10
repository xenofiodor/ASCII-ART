package ascii_art;

import java.util.HashMap;

public class Picture {
    private char [][] picture;
    private Picture[] pictureStorage;
    private int width;
    private int height;
    private String pictureString;

    public Picture(char [][] picture){
        this.picture = picture;
        this.height = picture.length;
        this.width = picture[0].length;
        this.generateString();
    }

    private void generateString(){
        char[] string = new char[this.width * this.height + this.height];
        int k = 0;
        for (int x = 0; x < this.height; x++){
            for (int y = 0; y < this.width; y++){
                string[k] = this.picture[x][y];
                k++;
            }
            string[k] = '\n';
            k++;
        }
        this.pictureString = String.valueOf(string);
    }

    public String toString(){
        return this.pictureString;
    }

    private void fillPicStorage(){
        this.pictureStorage = new Picture[6];
        this.pictureStorage[0] = this;
        for (int i = 1; i <= 5; i++){

            HashMap<Character, Character> shiftedChars = new HashMap<>();
            shiftedChars.put(Symbol.upTo128.getCharacter(), Symbol.upTo128.shift(i).getCharacter());
            shiftedChars.put(Symbol.upTo255.getCharacter(), Symbol.upTo255.shift(i).getCharacter());
            shiftedChars.put(Symbol.upTo383.getCharacter(), Symbol.upTo383.shift(i).getCharacter());
            shiftedChars.put(Symbol.upTo510.getCharacter(), Symbol.upTo510.shift(i).getCharacter());
            shiftedChars.put(Symbol.upTo638.getCharacter(), Symbol.upTo638.shift(i).getCharacter());
            shiftedChars.put(Symbol.upTo765.getCharacter(), Symbol.upTo765.shift(i).getCharacter());

            char[][] tempPic = new char[this.height][this.width];
            for (int x = 0; x < this.height; x++){
                for (int y = 0; y < this.width; y++){
                    tempPic[x][y] = shiftedChars.get(this.picture[x][y]);
                }
            }

            this.pictureStorage[i] = new Picture(tempPic);
        }
    }

    public void animate() throws InterruptedException {
        this.fillPicStorage();
        for (int i = 0;; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(this.pictureStorage[i % 6].toString());
            Thread.sleep(250);
        }
    }
}