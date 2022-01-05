
import java.time.LocalDateTime;

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
        LocalDateTime today = LocalDateTime.now();     //Today
  
        LocalDateTime yesterday = today.minusDays(1);   //Minus 1 day
      
        int i = 0;
        while (i!=10) {
          yesterday = today.minusDays(i);
          i=i+1;
           
        }
        
        
        System.out.println("today "+today);
        System.out.println("yesterda "+yesterday);
    }
    
}
