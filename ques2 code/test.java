/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 *main class
 * @author RAKA
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // The name of the file to open.     
        new test().go();
          
    }  
    public class happinessComparator implements Comparator{
        public int compare(Object o1, Object o2){
            Couple c1 = (Couple) o1;
            Couple c2 = (Couple) o2;
            return Float.compare(c1.get_couple_happiness(),c2.get_couple_happiness());
        }
    }
    public class compatibilityComparator implements Comparator{
        public int compare(Object o1, Object o2){
            Couple c1 = (Couple) o1;
            Couple c2 = (Couple) o2;
            return Float.compare(c1.get_couple_compatibility(),c2.get_couple_compatibility());
        }
    }
    
    
    public void go(){
        int number = 0;
        int i,j;
        //making an array of boys object
        String fileName = "boys.txt";
        
        String name;
        int attractive;
        int budget;
        int intelligence;
        int type;
        int maintain_cost;
        int price;
        int value;
        int luxury_rating;
        int diff_obtain;
        int utility_value;
        int utility_class;
        int noOfGirls = 0;
        int noOfBoys = 0;
        Girls[] girlArray = null;
        Boys[] boyArray = null;
        Gifts[] giftArray = null;
        ArrayList<Couple> coupleArray = new ArrayList <Couple>();
        
        String line = null;

        try {
            
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
                
            line = bufferedReader.readLine();
            number = Integer.parseInt(line);
            noOfBoys = number;
            boyArray = new Boys[number];
            i = 0;
            while((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line,",");
                name = st.nextToken();
                attractive = Integer.parseInt(st.nextToken());
                budget = Integer.parseInt(st.nextToken());
                intelligence = Integer.parseInt(st.nextToken());
                type = Integer.parseInt(st.nextToken());
                boyArray[i] = new Boys(name,attractive,budget,intelligence,type,0);
                i++;
                
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }
        //making an array of girls object
        fileName = "girls.txt";
        line = null;

        try {
            
            FileReader fileReader = new FileReader(fileName);

            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                
            line = bufferedReader.readLine();
            number = Integer.parseInt(line);
            noOfGirls = number;
            girlArray = new Girls[number];
            i = 0;
            while((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line,",");
                name = st.nextToken();
                attractive = Integer.parseInt(st.nextToken());
                maintain_cost = Integer.parseInt(st.nextToken());
                intelligence = Integer.parseInt(st.nextToken());
                type = Integer.parseInt(st.nextToken());
                
                girlArray[i] = new Girls(name,attractive,maintain_cost,intelligence,type,0);
                i++;
                    
            }   

            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        //making an array of gifts object
        fileName = "gifts.txt";
        line = null;

        try {
            
            FileReader fileReader = new FileReader(fileName);

            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                
            line = bufferedReader.readLine();
            number = Integer.parseInt(line);
            giftArray = new Gifts[number];
            i = 0;
            while((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line,",");
                type = Integer.parseInt(st.nextToken());
                if(type == 1){
                    name = st.nextToken();
                    price = Integer.parseInt(st.nextToken());
                    value = Integer.parseInt(st.nextToken());
                    giftArray[i] = new Gifts(type,name,price,value,0,0,0,0);
                }
                else if(type == 2){
                    name = st.nextToken();
                    price = Integer.parseInt(st.nextToken());
                    value = Integer.parseInt(st.nextToken());
                    luxury_rating = Integer.parseInt(st.nextToken());
                    diff_obtain = Integer.parseInt(st.nextToken());
                    giftArray[i] = new Gifts(type,name,price,value,luxury_rating,diff_obtain,0,0);
                }
                else if(type == 3){
                    name = st.nextToken();
                    price = Integer.parseInt(st.nextToken());
                    value = Integer.parseInt(st.nextToken());
                    utility_value = Integer.parseInt(st.nextToken());
                    utility_class = Integer.parseInt(st.nextToken());
                    giftArray[i] = new Gifts(type,name,price,value,0,0,utility_value,utility_class);
                }
                i++;
                    
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        //linking girl and boy and make couple object
        Timestamp tmstamp = new Timestamp(System.currentTimeMillis());
        try{
            //PrintWriter writer = new PrintWriter("couplesFormed.txt");
            PrintWriter writer1 = new PrintWriter("GiftsExchanged.txt");
            for(i = 0;i < noOfGirls ; i++){
                for(j = 0;j < noOfBoys ; j++){
                        if(girlArray[i].get_maintain() < boyArray[j].get_budget() && girlArray[i].get_commited() != 1 && boyArray[j].get_commited() != 1){
                        boyArray[j].set_commited(1);
                        girlArray[i].set_commited(1);
                        coupleArray.add(new Couple(boyArray[j],girlArray[i]));
                        
                        break;
                    }
                }
            }
            writer1.close();
        }
        catch (IOException e){
            
        }
        Gifts temp;
        //arranging gifts in ascending order of price
        for(i = 0;i < number ;i++){
            for(j = i + 1 ;j < number ;j++){
                if (giftArray[i].get_price() > giftArray[j].get_price()){
                    temp = giftArray[i];
                    giftArray[i] = giftArray[j];
                    giftArray[j] = temp;
                }
            }
        }
        //assigning gifts
        for(Couple c : coupleArray){
            c.choose_gift(giftArray);
            c.calc_girl_happiness();
            c.get_boy_happiness();
            c.calc_boy_happiness();                 
            c.calc_couple_happiness();
            c.calc_couple_compatibility();
        }
        
        //sorting couples by happiness
        Collections.sort(coupleArray,new happinessComparator());
        try{
           
            PrintWriter writer = new PrintWriter("HappinessSortedCouples.txt");
            for(Couple c :coupleArray){
                writer.println(c.get_boy().get_name() + " and " + c.get_girl().get_name());
                writer.println("Happiness " + c.get_couple_compatibility());
            }
            writer.close();
        }
        catch (IOException e){
            
        }
        
        //sorting couples by compatibility
        Collections.sort(coupleArray,new compatibilityComparator());
        try{
           
            PrintWriter writer = new PrintWriter("CompatibilitySortedCouples.txt");
            for(Couple c :coupleArray){
                writer.println(c.get_boy().get_name() + " and " + c.get_girl().get_name());
                writer.println("Compatibility " + c.get_couple_compatibility());
            }
            writer.close();
        }
        catch (IOException e){
            
        }
      
    }
}
