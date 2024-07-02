import java.util.*;

public class PhoneDirectory {
    // Храним данные в HashMap, где ключ - фамилия, значение - список телефонных номеров
    private Map<String, List<String>> directory = new HashMap<>();

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        // Если фамилии еще нет в справочнике, добавляем новую запись
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        // Добавляем номер телефона к соответствующей фамилии
        directory.get(lastName).add(phoneNumber);
    }

    // Метод для поиска номеров телефонов по фамилии
    public List<String> get(String lastName) {
        // Возвращаем список номеров телефонов для данной фамилии или пустой список, если фамилии нет в справочнике
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    // Метод для вывода всех записей в справочнике (для удобства проверки)
    public void printAll() {
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println("Last Name: " + entry.getKey() + ", Phone Numbers: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Добавляем записи
        phoneDirectory.add("Ivanov", "+375296787546");
        phoneDirectory.add("Petrov", "+375334591542");
        phoneDirectory.add("Ivanov", "+375291234567");
        phoneDirectory.add("Sidorov", "+37598765432");

        // Ищем номера телефонов по фамилии
        System.out.println("Phone numbers for Ivanov: " + phoneDirectory.get("Ivanov"));
        System.out.println("Phone numbers for Petrov: " + phoneDirectory.get("Petrov"));
        System.out.println("Phone numbers for Sidorov: " + phoneDirectory.get("Sidorov"));
        System.out.println("Phone numbers for Smirnov: " + phoneDirectory.get("Smirnov")); // Фамилии нет в справочнике

        // Выводим все записи в справочнике
        phoneDirectory.printAll();
    }
}

