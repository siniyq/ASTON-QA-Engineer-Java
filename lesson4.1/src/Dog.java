public class Dog extends Animal {
    private static int totalDogs = 0;
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;

    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_LIMIT) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " пробежал только " + RUN_LIMIT + " м. из " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= SWIM_LIMIT) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " проплыл только " + SWIM_LIMIT + " м. из " + distance + " м.");
        }
    }
}
