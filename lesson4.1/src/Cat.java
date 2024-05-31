public class Cat extends Animal {
    private static int totalCats = 0;
    private static final int RUN_LIMIT = 200;
    private boolean full;

    public Cat(String name) {
        super(name);
        totalCats++;
        this.full = false;
    }

    public static int getTotalCats() {
        return totalCats;
    }

    public boolean isFull() {
        return full;
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
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            this.full = true;
        } else {
            this.full = false;
        }
    }
}
