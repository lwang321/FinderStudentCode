//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class TST {
    TSTNode root = new TSTNode();

    int childindex(char c, char compareto) {
        if (c == compareto) {
            return 1;
        } else {
            return c < compareto ? 0 : 2;
        }
    }

    void insert(String s, String Value) {
        TSTNode current = this.root;
        this.root.setLetter('m');

        int childindex;
        for(int i = 0; i < s.length(); current = current.getChildren()[childindex]) {
            if (current.getLetter() == 0) {
                current.setLetter(s.charAt(i));
            }

            childindex = this.childindex(s.charAt(i), current.getLetter());
            if (current.getChildren()[childindex] == null) {
                current.getChildren()[childindex] = new TSTNode();
            }

            if (childindex == 1) {
                ++i;
            }
        }

        current.setWord();
        current.setValue(Value);
    }

    String lookup(String s) {
        TSTNode current = this.root;

        int childindex;
        for(int i = 0; i < s.length(); current = current.getChildren()[childindex]) {
            childindex = this.childindex(s.charAt(i), current.getLetter());
            if (current.getChildren()[childindex] == null) {
                return null;
            }

            if (childindex == 1) {
                ++i;
            }
        }

        return current.getValue();
    }
}
