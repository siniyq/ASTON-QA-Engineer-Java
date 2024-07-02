import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        // Создаем массив с набором слов
        String[] wordsArray = {
                "apple", "banana", "apple", "orange", "banana",
                "kiwi", "apple", "grape", "kiwi", "banana",
                "apple", "grape", "mango", "peach", "mango",
                "orange", "peach", "kiwi", "apple", "mango"
        };

        // Используем HashSet для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(wordsArray));

        // Используем HashMap для подсчета количества вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordsArray) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим список уникальных слов
        System.out.println("Unique words: " + uniqueWords);

        // Выводим количество вхождений каждого слова
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
