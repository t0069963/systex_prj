
import java.util.ArrayList;
import java.util.Random;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author bgete
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 double[] D = {1,501,502,503,2,3,4,50,51,52,53,500};
        int k = 3;
        double loss_convergence = 1e-10;
        int iterations_num = 500;
       compute_centroids(D, k, loss_convergence,  iterations_num);
        
        
        
    }
        public static double do_kmeans(int k,double[] area_list,ArrayList centroids) {
        double loss=0;
      
        ArrayList<Double>[][] groups = new ArrayList[1][k];
        groups[0][0] = new ArrayList<Double>();
        groups[0][1] = new ArrayList<Double>();
        groups[0][2] = new ArrayList<Double>();
        
        
        ArrayList<Double>[]  new_centroids = new ArrayList[3];
        new_centroids[0]=new ArrayList<Double>();
        new_centroids[1]=new ArrayList<Double>();
        new_centroids[2]=new ArrayList<Double>();
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
            groups[0][group_index].add(area);
            loss += min_distance;
   
            new_centroids[group_index].add(area);
           // System.out.println("new_centroids"+new_centroids[0]);
        
        }
           for (int i = 0; i < k; i++) {
                System.out.println("groups"+groups[0][i]);
                new_centroids[i].get(i);
               //System.out.println(new_centroids[0]);
           }
            //System.out.println(new_centroids[0]);
      return (k);
    }
        public static double dis(double point1, double point2) {
        double sum = 0.0;
            sum = Math.abs(point1-point2);
        
        return (sum);
    }
        public static double compute_centroids(double[] D,int k,double loss_convergence,int iterations_num){
        double[] area_list = D;
        Random rand = new Random();
        double centroid_indices[]=new double[k];
        for (int i = 0; i < k; i++) {
           int randomIndex = rand.nextInt(area_list.length);
           centroid_indices[i]=area_list[randomIndex];          
        }
        for (double d : centroid_indices) {
            System.out.println("randomElement:"+d);
        }
        ArrayList centroids = new ArrayList();
        for (double centroid_index : centroid_indices) {
                centroids.add(centroid_index);
        }
        
        do_kmeans(k, area_list, centroids);
        
     
        
            
            return (k);
        }
}
