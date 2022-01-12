
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author bgete
 */
public class K_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 double[] D = {1,2,3,4,50,51,52,53,500,501,502,503};
        int k = 3;
        double loss_convergence = 1e-10;
        int iterations_num = 500;
     ArrayList<Double>[]  answer=compute_centroids(D, k, loss_convergence,  iterations_num); 
     
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].size(); j++) {
                System.out.print(""+answer[i].get(j)+" ");
            }
            System.out.println();
            
        }
    }
    
    
        public static List<Object> do_kmeans(int k,double[] area_list,Double[] centroids) {
        double loss=0;
        ArrayList<Double>[] groups = new ArrayList[k];
    
        for (int i = 0; i < k; i++) {
             groups[i] = new ArrayList<Double>();
            }
   
        
        
        Double[]  new_centroids = new Double[k];
        //比較每個點和質點的距離假如是最小的則寫入
        for (double area : area_list) {
            int min_distance = 999999;
            int group_index = 0;
            int centroid_index = 0;
            for (Object centroid : centroids) {
                double distance = dis(area, (double) centroid);
                if (distance < min_distance){
                    min_distance = (int) distance;
                    group_index = centroid_index;                  
                }
                centroid_index = centroid_index+1;
            }    
//            System.out.println("centroid_index"+centroid_index);
//            System.out.println("area"+area);
            groups[group_index].add(area);
            loss =loss+ min_distance;
   
            new_centroids[group_index]= area;
            //System.out.println("new_centroids"+new_centroids.length);
            //System.out.println("gruos"+groups[0]);
        }
        for (int i = 0; i < k; i++) {
                if(groups[i].size()!=0){
        new_centroids[i] = listsum(groups[i])/(groups[i].size());        
        }
        else{
            new_centroids[i]=0.0;
        }
            }
       Arrays.sort(new_centroids);      
       // System.out.println(new_centroids[2]);
      return  Arrays.asList(new_centroids, groups, loss);
    }
        public static double dis(double point1, double point2) {
        double sum = 0.0;
            sum = Math.abs(point1-point2);
        
        return (sum);
    }
    public static ArrayList<Double>[] compute_centroids(double[] D,int k,double loss_convergence,int iterations_num){
        double[] area_list = D;
        Random rand = new Random();
        double centroid_indices[]=new double[k];
       // double[] centroid_indices = {1,501,503};
 
        for (int i = 0; i < k; i++) {
           int randomIndex = rand.nextInt(area_list.length);
           centroid_indices[i]=area_list[randomIndex];          
        }
      
        Arrays.sort(centroid_indices);
        System.out.print("隨機元素:");
        for (double d : centroid_indices) {
            System.out.print(""+d+" ");
        }
        System.out.println();
        
        Double[] centroids = new Double[3];
        for (int i = 0; i < k; i++) {
                centroids[i]=centroid_indices[i];
        }
        
        
        List<Object> keeanslist = do_kmeans(k, area_list, centroids);
        centroids=(Double[]) keeanslist.get(0);
        ArrayList<Double>[] groups = (ArrayList<Double>[]) keeanslist.get(1);
        double old_loss = (double) keeanslist.get(2);
        Double[] old_centroids=centroids;
        int iterations = 1;
        //int counter = 0;
        while (true) {
            //counter = counter +1;
            keeanslist=do_kmeans(k, area_list, centroids);
            centroids=(Double[]) keeanslist.get(0);
            groups = (ArrayList<Double>[]) keeanslist.get(1);
            double loss = (double) keeanslist.get(2);
            iterations = iterations + 1;
//            if(dis(old_loss,loss)< loss_convergence || iterations > iterations_num){
            if(old_centroids[0].equals(centroids[0]) && old_centroids[1].equals(centroids[1]) && old_centroids[2].equals(centroids[2])|| iterations > iterations_num){
                break;
            }
            old_loss = loss;
        }
        System.out.println("總共跑"+iterations+"次");
        System.out.println("質點: "+centroids[0]+" "+centroids[1]+" "+centroids[2]);
        return (groups);
        }
        public static double listsum(ArrayList<Double> DoubleList) {
        if (DoubleList == null || DoubleList.size() == 0) {
            return 0;
        }
        double sum = 0;
        for ( Double n : DoubleList) {
            sum += n;
        }
        return sum;
    }
}
