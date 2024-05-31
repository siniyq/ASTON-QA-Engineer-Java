public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.setFillColor("Red");
        circle.setBorderColor("Black");

        Rectangle rectangle = new Rectangle(4, 7);
        rectangle.setFillColor("Blue");
        rectangle.setBorderColor("Green");

        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("Yellow");
        triangle.setBorderColor("Purple");

        printShapeDetails(circle);
        printShapeDetails(rectangle);
        printShapeDetails(triangle);
    }

    public static void printShapeDetails(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }
}

