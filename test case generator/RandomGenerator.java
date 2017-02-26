/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAKA
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
public class RandomGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,j;
        int type = 0;
        int attractive = 0;
        int intelligence = 0;
        String name = "";
        int budget = 0;
        int maintainance;
       
        int price;
        int value;
        int luxury_rating;
        int diff_obtain;
        int utility_value;
        int utility_class;
        Random rand = new Random();
        
        //generating random values for boys
        try{
            PrintWriter writer = new PrintWriter("boys.txt");
            writer.println("100");
            for(i = 0; i < 100 ;i++){
                type = rand.nextInt(3) + 1;
                attractive = rand.nextInt(100) + 1;
                intelligence = rand.nextInt(100) + 1;
                budget = rand.nextInt(601) + 400;
                name = "";
                for(j = 0;j < 5;j++){
                    name = name + (char)(rand.nextInt(26)+97);
                }
            
                writer.println(name + "," + attractive + "," + budget + "," + intelligence + "," + type);
                
            }
            writer.close();
        }
            catch (IOException e){
                
            }
            
            
        //generating random values for girls
        
        try{
            PrintWriter writer = new PrintWriter("girls.txt");
            writer.println("10");
            for(i = 0; i < 10 ;i++){
                type = rand.nextInt(3) + 1;
                attractive = rand.nextInt(100) + 1;
                intelligence = rand.nextInt(100) + 1;
                maintainance = rand.nextInt(401) + 300;
                name = "";
                for(j = 0;j < 5;j++){
                    name = name + (char)(rand.nextInt(26)+97);
                }
                writer.println(name + "," + attractive + "," + maintainance + "," + intelligence + "," + type);
                
            }
            writer.close();
        }
            catch (IOException e){
                
            }
        
        
        //generating random values for gifts
        try{
            PrintWriter writer = new PrintWriter("gifts.txt");
            writer.println("1000");
            for(i = 0; i < 1000 ;i++){
                type = rand.nextInt(3) + 1;
                name = "";
                for(j = 0;j < 5;j++){
                    name = name + (char)(rand.nextInt(26)+97);
                }
                price = rand.nextInt(275) + 25;
                value = rand.nextInt(100) + 1;
                if(type == 1){
                    writer.println(type + "," + name + "," + price + "," + value);
                }
                else if(type == 2){
                    luxury_rating = rand.nextInt(100) + 1;
                    diff_obtain = rand.nextInt(100) + 1;
                    writer.println(type + "," + name + "," + price + "," + value + "," + luxury_rating + "," + diff_obtain);
                    
                }
                else if(type == 3){
                    utility_value = rand.nextInt(100) + 1;
                    utility_class = rand.nextInt(100) + 1;
                    writer.println(type + "," + name + "," + price + "," + value + "," + utility_value + "," + utility_class);
                }
                
                
            }
            writer.close();
        }
            catch (IOException e){
                
            }
    }
    
}
