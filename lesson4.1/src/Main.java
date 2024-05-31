public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(50);

        Cat[] cats = {new Cat("Мурзик"), new Cat("Барсик"), new Cat("Васька")};
        Dog[] dogs = {new Dog("Бобик"), new Dog("Шарик")};

        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        bowl.addFood(30); // Добавляем еду в миску

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 20);
            }
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        for (Dog dog : dogs) {
            dog.run(200);
            dog.swim(5);
            dog.run(600);  // тест для выхода за пределы бега
            dog.swim(15);  // тест для выхода за пределы плавания
        }

        for (Cat cat : cats) {
            cat.run(100);
            cat.swim(5);
            cat.run(250);  // тест для выхода за пределы бега
        }

        System.out.println("Всего животных: " + Animal.getTotalAnimals());
        System.out.println("Всего собак: " + Dog.getTotalDogs());
        System.out.println("Всего котов: " + Cat.getTotalCats());
    }
}
