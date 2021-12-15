import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {

    public static Edge checkE(Point p, ArrayList<Edge> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).weight == p.weight && p.vertex == list.get(i).vertex2)
                return list.get(i);
        }
        return new Edge(0, 0, 0);
    }
    public static void main(String[] args) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        boolean[] check = {false,false,false,false,false};
        edges.add(new Edge(0, 1, 4)) ;
        edges.add(new Edge(0, 2, 4)) ;
        edges.add(new Edge(0, 3, 6)) ;
        edges.add(new Edge(0, 4, 6)) ;
        edges.add(new Edge(1, 2, 2)) ;
        edges.add(new Edge(2, 3, 8)) ;
        edges.add(new Edge(3, 4, 9)) ;
        // bat dau tu dinh 0, them cac canh ket noi voi dinh 0 vao PQ
        for (int i=0;i<edges.size();i++){
            if(edges.get(i).vertex1 == 0){
                PQ.add(new Point(edges.get(i).weight, edges.get(i).vertex2));
            }
        }
        check[0] = true;
        while ( PQ.isEmpty()==false){
            Point checkP = PQ.poll();
            if (check[checkP.vertex] == false){
                mst.add(checkE(checkP, edges));
                check[checkP.vertex] = true;
                for (int i=0;i<edges.size();i++){
                    if(edges.get(i).vertex1 == checkP.vertex){
                        PQ.add(new Point(edges.get(i).weight, edges.get(i).vertex2));
                    }
                }
            }
        }
        for(int i=0;i<mst.size();i++){
            System.out.println("edge: "+mst.get(i).vertex1+", "+mst.get(i).vertex2+", "+mst.get(i).weight);
        }
        int sumW = 0;
        for(int i=0;i<mst.size();i++){
            sumW += mst.get(i).weight;
        }
        System.out.println("total weight in this MST: "+ sumW);
    }
}
