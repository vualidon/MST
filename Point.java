public class Point implements Comparable<Point> {
    int weight, vertex;
    public Point(int weight, int vertex){
        this.weight = weight;
        this.vertex = vertex;
    }
    public int compareTo(Point p){
        if(weight > p.weight)
            return 1;
        else if (weight < p.weight)
            return -1;
        else return 0;
    }
}
