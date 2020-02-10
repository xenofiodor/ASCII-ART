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

    public Symbol next(){
        return storage[(this.getValue() + 1) % 6];
    }

    public Symbol shift(int n){
        return storage[(this.getValue() + n) % 6];
    }
}
