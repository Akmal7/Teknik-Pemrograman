public class TestShape {
    public static void main(String[] args) {

        // Test Shape
        Shape s1 = new Shape();
        System.out.println(s1);

        Shape s2 = new Shape("blue", false);
        System.out.println(s2);

        System.out.println("================================");

        // Test Circle
        Circle c1 = new Circle(5.0, "red", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println("================================");

        // Test Rectangle
        Rectangle r1 = new Rectangle(4.0, 6.0, "yellow", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println("================================");

        // Test Square
        Square sq1 = new Square(4.0, "purple", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
    }
}