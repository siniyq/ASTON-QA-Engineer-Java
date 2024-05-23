public class Park {
    public static class Attraction {
        private String name;
        private String workingHours;
        private int cost;

        public Attraction(String name, String workingHours, int cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Название аттракциона: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Attraction[] attractions = new Attraction[3];
        attractions[0] = new Attraction("Roller Coaster", "10:00 - 18:00", 500);
        attractions[1] = new Attraction("Ferris Wheel", "11:00 - 20:00", 300);
        attractions[2] = new Attraction("Haunted House", "12:00 - 22:00", 400);

        for (Attraction attraction : attractions) {
            attraction.printAttractionInfo();
        }
    }
}
