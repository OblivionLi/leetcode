package easy.arrays;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";

        System.out.println(mergeAlternately2(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        String[] word1Parts = word1.split("");
        String[] word2Parts = word2.split("");

        String[] parts = new String[word1Parts.length + word2Parts.length + 1];

        int count = 0;
        for (int i = 0; i < word1Parts.length && count <= parts.length; i++, count += 2) {
            parts[count] = word1Parts[i];
        }

        int count2 = 1;
        for (int j = 0; j < word1Parts.length && count2 < parts.length && j < word2Parts.length; j++, count2 += 2) {
            parts[count2] = word2Parts[j];
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String part : parts) {
            if (part != null) {
                stringBuilder.append(part);
            }
        }

        if (word1Parts.length == word2Parts.length) {
            return stringBuilder.toString();
        }

        if (word1Parts.length < word2Parts.length) {
            stringBuilder.append(word2, word2Parts.length - word1Parts.length, word2Parts.length);
        }

        return stringBuilder.toString();
    }

    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                merged.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                merged.append(word2.charAt(j++));
            }
        }

        return merged.toString();
    }
}
