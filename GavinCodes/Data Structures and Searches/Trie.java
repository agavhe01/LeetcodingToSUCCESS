import java.util.Map;
import java.util.HashMap;

public class Trie {

    /*
        All methods 0(1) or O(n) where n is length of the word
        Case Sensitive

    */
    
    class TrieNode {
        boolean isWord;   // isLeaf
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    TrieNode root;

    public Trie() {
        root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }

    public static void main(String[] args){
        Trie t = new Trie();
        
        t.insert("Anesu");
        t.insert("Ruvimbo");
        t.insert("Tawanda");
        t.insert("Rutendo");

        System.out.println("Looking for Jason : false --> " + t.search("Jason"));
        System.out.println("Looking for  Anes : false --> " + t.search("Anes"));
        System.out.println("Looking for Anesu :  true --> " + t.search("Anesu"));

        System.out.println();
        System.out.println();

        System.out.println("Looking for Prefix Anes :  true --> " + t.startsWith("Anes"));
        System.out.println("Looking for Prefix anes : false --> " + t.startsWith("anes"));
        System.out.println("Looking for Prefix Ruvi :  true --> " + t.startsWith("Ruvi"));
        System.out.println("Looking for Prefix tend : false --> " + t.startsWith("tend"));


    }
}