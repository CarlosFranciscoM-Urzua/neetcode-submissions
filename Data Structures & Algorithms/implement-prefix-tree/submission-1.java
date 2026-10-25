class PrefixTree {
    private class Node{
        char c;
        boolean isFinal;
        Node father;
        HashMap<Character, Node> sons;

        Node(char c, boolean isFinal, Node father, HashMap<Character, Node> sons){
            this.c = c;
            this.isFinal = isFinal;
            this.father = father;
            this.sons = sons;
        }

        Node(char c, boolean isFinal, Node father){
            this.c = c;
            this.isFinal = isFinal;
            this.father = father;
            this.sons = new HashMap<>();
        }
    }

    private Node root;

    public PrefixTree() {
        root = new Node(' ', false, null);
    }

    public void insert(String word) {
        char c = ' ';
        Node father = this.root;
        HashSet<Node> level;

        for(int i = 0; i < word.length(); i++){
            c = word.charAt(i);

            father.sons.putIfAbsent(c, new Node(c, false, father));

            father = father.sons.get(c);
        }

        father.isFinal = true;    
    }

    public boolean search(String word) {
        Node n = root;
        char c = ' ';

        for (int i = 0; i < word.length(); i++){
            c = word.charAt(i);

            n = n.sons.get(c);

            if (n == null) return false;
        }
        
        return n.isFinal;
    }

    public boolean startsWith(String prefix) {
        Node n = root;
        char c = ' ';

        for (int i = 0; i < prefix.length(); i++){
            c = prefix.charAt(i);

            n = n.sons.get(c);

            if (n == null) return false;
        }
        
        return true;
    }
}
