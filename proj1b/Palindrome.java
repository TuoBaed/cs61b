
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> n = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            n.addLast(word.charAt(i));
        }
        return n;
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) > 'z' || word.charAt(i) < 'A' ||
                    (word.charAt(i) > 'Z' && word.charAt(i) < 'a')) {
                return false;
            }
            if (!cc.equalChars(word.charAt(i), word.charAt(length - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
