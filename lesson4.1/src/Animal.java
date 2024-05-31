public abstract class Animal {
    private static int totalAnimals = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}
