package ascii_art;

public enum Symbol {
    upTo128(0, ' '),
    upTo255(1, '-'),
    upTo383(2, '+'),
    upTo510(3, '='),
    upTo638(4, '%'),
    upTo765(5, '#');
    private int value;
    private char character;
    private static  Symbol [] storage = new Symbol [] {upTo128, upTo255, upTo383, upTo510, upTo638, upTo765};
    private static char [] symbols = new char [] {upTo128.getCharacter(), upTo255.getCharacter(),
            upTo383.getCharacter(), upTo510.getCharacter(), upTo638.getCharacter(), upTo765.getCharacter()};
    Symbol(int value, char character){
        this.value = value;
        this.character = character;
    }

    public int getValue(){
        return this.value;
    }

    public char getCharacter(){
        return this.character;
    }

    public static Symbol valueOf(int value){
        if (value < 6)
            return storage[value];
        else throw new IllegalArgumentException("The value " + value + " is out of the range");
    }

    public static char charOfValue(int value){
        if (value < 6)
            return symbols[value];
        throw new IllegalArgumentException("The value " + value + " is out of the range");
    }

    public static int valueOfChar(char c){
        int value = 0;
        while (symbols[value] != c && value < 6)
            value++;
        if (value >= 6)
            throw new IllegalArgumentException("The character " + value + " is illegal");
        return value;
    }

    public static char nextChar(char c){
        return symbols[(valueOfChar(c) + 1) % 6];
    }

    public static char shiftCharBy(char c, int n){
        return symbols[(valueOfChar(c) + n) % 6];
    }
}
