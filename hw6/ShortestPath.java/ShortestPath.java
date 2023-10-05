import java.util.Scanner;

public class ShortestPath {
	public static void main (String[] a) {
		Scanner in = new Scanner (System.in);
		Path3 pathA = new Path3(in);
		Path3 pathB = new Path3(in);
		System.out.println(pathA.getLabel()+": "+pathA.length());
		System.out.println(pathB.getLabel()+": "+pathB.length());
		System.out.println("shortest path: " + (pathA.length() < pathB.length() ? pathA.getLabel() : pathB.getLabel()));
	}
}
class BestRoute {
	public static void main (String[] a) {
		Scanner in = new Scanner (System.in);
		Point2D p1 = new Point2D (in);
		Point2D p2 = new Point2D (in);
		Point2D p3 = new Point2D (in);
		Point2D p4 = new Point2D (in);
		Path3 pathA = new Path3 ("", p1, p2, p4);
		Path3 pathB = new Path3 ("", p1, p3, p4);
		System.out.println("Best Route: " + ( pathA.length() < pathB.length() ? pathA:pathB));
	}
}
class Point2D {
	private double x, y;
	private String label;
	public Point2D (Scanner in) {
		label = in.next();
		x = in.nextDouble();
		y = in.nextDouble();
	}
	public Point2D(String label, Scanner in) {
		this.label = label;
		x = in.nextDouble();
		y = in.nextDouble();
	}
	public String toString() {
		return label+ "(" + x + "," + y + ")";
	}
	public double distance(Point2D p) {
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)+(y-p.y));
	}
	public String getLabel() {
		return label;
	}
}
class Path3 {
	private Point2D start,midpt, finish;
	private String label;
	public Path3 (String l, Point2D s, Point2D m, Point2D f) {
		label = l;
		start = s;
		midpt = m;
		finish = f;
	}
	public Path3 (Scanner in) {
		label = in.next();
		start = new Point2D("",in);
		midpt = new Point2D("",in);
		finish = new Point2D("",in);
	}
	public String toString() {
		return start.getLabel() + "-" + midpt.getLabel() + "-" + finish.getLabel();
	}
	public double length() {
		return start.distance(midpt) + midpt.distance(finish);
	}
	public String getLabel() {
		return label;
	}
}
