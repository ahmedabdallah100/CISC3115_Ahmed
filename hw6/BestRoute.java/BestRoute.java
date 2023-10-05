import java.util.Scanner;

class Point2D {
    private String label;
    double x;
    double y;

    public Point2D(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}

class Path3 {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    public Path3(Point2D point1, Point2D point2, Point2D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public String toString() {
        return point1.getLabel() + "-" + point2.getLabel() + "-" + point3.getLabel();
    }

    public double length() {
        double distance1 = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
        double distance2 = Math.sqrt(Math.pow(point2.x - point3.x, 2) + Math.pow(point2.y - point3.y, 2));
        return distance1 + distance2;
    }
}

public class BestRoute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point2D[] points = new Point2D[4];

        for (int i = 0; i < 4; i++) {
            String label = scanner.next();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point2D(label, x, y);
        }

        Path3 path1 = new Path3(points[0], points[1], points[3]);
        Path3 path2 = new Path3(points[0], points[2], points[3]);

        if (path1.length() < path2.length()) {
            System.out.println("Best Route: " + path1.toString());
        } else {
            System.out.println("Best Route: " + path2.toString());
        }
    }
}
