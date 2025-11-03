//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class TSTNode {
    private boolean isWord;
    private TSTNode[] children = new TSTNode[3];
    private char letter;
    private String Value;

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isWord() {
        return this.isWord;
    }

    public void setWord() {
        this.isWord = true;
    }

    public TSTNode[] getChildren() {
        return this.children;
    }
}