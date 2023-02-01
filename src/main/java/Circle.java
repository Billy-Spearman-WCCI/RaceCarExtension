import java.util.Objects;

public class Circle {
    private final double x, y, radius;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " + has hashCode " + (Math.abs(new Circle(i, i, i).hashCode()) % 100));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.x, x) == 0 && Double.compare(circle.y, y) == 0 && Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius);
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
