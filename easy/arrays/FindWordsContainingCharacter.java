package easy.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';

        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(Character.toString(x))) {
                // or use cond. ``words[i].indexOf(x) != -1`` for a direct way to check for the character
                indexes.add(i);
            }
        }

        return indexes;
    }
}
