package bigO.src.practice.codefights;

/**
 * Created by Stanimir on 5/19/17.
 */

import java.util.*;

class Plane {
    ArrayList<Point> itsPoints;

    public Plane() {
        myPoints();
//        randomPoints();
    }

    private void myPoints() {
        int[][] points = new int[][]{{1, 1}, {3, 1}, {3, 2}, {3, 3}, {1, 3}, {2, 5}, {1, 5}, {-1, -1}, {-1, -2}, {-2, -3}, {-4, -4}};
        itsPoints = new ArrayList<>();
        for (int[] e : points) {
            Point p = new Point(e[0], e[1], 'a');
            itsPoints.add(p);
        }

    }

    private void randomPoints() {
        Random r = new Random();
        itsPoints = new ArrayList<Point>();
        char c = 'A';
        for (int i = 0; i < 400; i++) {
            double x = r.nextDouble() * 1000;
            double y = r.nextDouble() * 1000;
            itsPoints.add(new Point(x, y, c));
            c++;
        }
    }

    public Plane(ArrayList<Point> thePoints) {
        itsPoints = thePoints;
    }

    public LinkedHashSet<Point> getColinearPoints() {
        HashMap<Line, LinkedHashSet<Point>> aMap = new HashMap<Line, LinkedHashSet<Point>>();
        Line result = null;
        int max = 0;
        for (int i = 0; i < itsPoints.size(); i++) {
            Point a = itsPoints.get(i);
            for (int j = i + 1; j < itsPoints.size(); j++) {
                Point b = itsPoints.get(j);
                Line aLine = new Line(a, b);
                LinkedHashSet<Point> points;
                if (aMap.containsKey(aLine)) {
                    points = aMap.get(aLine);
                    points.add(a);
                    points.add(b);
                } else {
                    points = new LinkedHashSet<Point>();
                    points.add(a);
                    points.add(b);
                    aMap.put(aLine, points);
                }
                if (points.size() > max) {
                    max = points.size();
                    result = aLine;
                }
            }
        }

        return aMap.get(result);
    }
}

class Point {
    public double x;
    public double y;
    public char name;

    public Point(double x, double y, char name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}

class Line {

    public double yIntercept;
    public double slope;
    public double episilon = 0.0001;
    public boolean isInfinity = false;

    public Line(Point a, Point b) {
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        if (Math.abs(dx) <= episilon) {
            isInfinity = true;
        } else {
            slope = dy / dx;
            yIntercept = b.y - slope * b.x;
        }
    }

    private boolean isEqual(Line theLine) {
        double dslope = Math.abs(theLine.slope - this.slope);
        double dInt = Math.abs(theLine.yIntercept - this.yIntercept);
        return dslope <= episilon && dInt <= episilon;

    }

    @Override
    public boolean equals(Object obj) {
        Line aLine = (Line) obj;
        return aLine.isInfinity == this.isInfinity && isEqual(aLine);

    }

    @Override
    public int hashCode() {
        int a = (int) (1000 * yIntercept);
        int b = (int) (1000 * slope);
        return a | b;
    }

}

class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Plane aPlane = new Plane();
        LinkedHashSet<Point> x = aPlane.getColinearPoints();
        for (Point p : x) {
            System.out.print("{" + p.x + "," + p.y + "}");
            System.out.print(",");
        }
    }

    public int get_collinear(int x1,int y1,int x2, int y2,List<Point> points)
    {
        int c=0;
        for(int i=0;i<points.size();i++){
            double k1=x1-points.get(i).x;
            double l1=y1-points.get(i).y;
            double k2=x2-points.get(i).x;
            double l2=y2-points.get(i).y;
            if((k1*l2-k2*l1)==0)
                c++;
        }
        return c;
    }

}
