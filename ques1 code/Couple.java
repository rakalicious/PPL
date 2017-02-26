/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *class for Couple
 * @author RAKA
 */
import java.io.IOException;
import java.io.*;
import java.lang.Math;
import java.sql.Timestamp;
import java.util.ArrayList;
public class Couple {
    private Boys boy;
    private Girls girl;
    private int boy_happiness;
    private int girl_happiness;
    private int happiness;
    private int compatibility;
    private int totalcost = 0;
    private int totalvalue = 0;
    private ArrayList <Gifts> gifts_given = new ArrayList <Gifts>();
    private int i;
    /**
     * constructor for class gift
     * @param boy the boy in the couple
     * @param girl the girl in the couple
     */
    public Couple(Boys boy,Girls girl){
        this.boy = boy;
        this.girl = girl;
    }
    
    /**
     * to set the object corresponding to boy
     * @param boy boy in the couple
     */
    public void set_boy(Boys boy){
        this.boy = boy;
    }
    /**
     * to return the object corresponding to boy
     * @return return the boy object
     */
    public Boys get_boy(){
        return boy;
    }
    
    /**
     * to set the object corresponding to girl
     * @param girl girl in the couple
     */
    public void set_girl(Girls girl){
        this.girl = girl;
    }
    /**
     * to return the object corresponding to girl
     * @return return the girl object
     */
    public Girls get_girl(){
        return girl;
    }
    
    /**
     * method to calculate boy's happiness
     */
    public void calc_boy_happiness(){
        if(boy.get_type() == 1){
            boy_happiness = boy.get_budget() - totalcost;
        }
        else if(boy.get_type() == 2){
            boy_happiness = girl_happiness;
        }
        else if(boy.get_type() == 3){
            boy_happiness = girl.get_intellig();
        }
    }
    /**
     * to return boy's happiness
     * @return return boy's happiness
     */
    public int get_boy_happiness(){
        return boy_happiness;
    }
    
    /**
     * calculate girl's happiness
     */
    public void calc_girl_happiness(){
        if(girl.get_type() == 1){
            for(Gifts g : gifts_given){
                if(g.get_type() == 2){
                    totalvalue = totalvalue + g.get_value();
                }
            }
            girl_happiness = (int) Math.log(totalcost - girl.get_maintain() + 2*totalvalue);
        }
        else if(girl.get_type() == 2){
            for(Gifts g : gifts_given){
                totalvalue = totalvalue + g.get_value();
            }
            girl_happiness = totalcost - girl.get_maintain() + totalvalue;
        }
        else if(girl.get_type() == 3){
            girl_happiness = (int) Math.exp((totalcost - girl.get_maintain())%10);
        }
    }
    /**
     * to return girl's happiness
     * @return return girl's happiness
     */
    public int get_girl_happiness(){
        return girl_happiness;
    }
    
    /**
     * to calculate couple happiness
     */
    public void calc_couple_happiness(){
        happiness = boy_happiness + girl_happiness;
    }
    /**
     * to return couple happiness
     * @return return couple happiness
     */
    public int get_couple_happiness(){
        return happiness;
    }
    
    /**
     * to calculate couple compatibility
     */
    public void calc_couple_compatibility(){
        compatibility = boy.get_budget() - girl.get_maintain() + Math.abs(boy.get_attract() - girl.get_attract()) + Math.abs(boy.get_intellig()-girl.get_intellig());
    }
    /**
     * to return couple compatibility
     * @return return couple compatibility
     */
    public int get_couple_compatibility(){
        return compatibility;
    }
    
    /**
     * method to choose gift for the couple according to their type
     * @param giftArray an array of all gifts from which the boy can choose
     */
    public void choose_gift(Gifts[] giftArray){
        i = 0;
        Timestamp tmstamp = new Timestamp(System.currentTimeMillis());
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("GiftsExchanged.txt"), true));
            
            writer.println("Couple : " + boy.get_name() + " " + girl.get_name());
            
            if(boy.get_type() == 1){
                while(true){
                    if(totalcost < girl.get_maintain()){
                        gifts_given.add(giftArray[i]);
                        writer.println(tmstamp);
                        writer.println(giftArray[i].get_name());
                        
                        totalcost = totalcost + giftArray[i].get_price();
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(boy.get_type() == 2){
                if(totalcost < boy.get_budget()){
                        gifts_given.add(giftArray[i]);
                        totalcost = totalcost + giftArray[i].get_price();
                }
                while(true){
                    if(totalcost < boy.get_budget()){
                        writer.println(tmstamp);
                        writer.println(giftArray[i].get_name());
                        i++;
                        gifts_given.add(giftArray[i]);
                        totalcost = totalcost + giftArray[i].get_price();
                    }
                    else{
                        i--;
                        gifts_given.remove(i);
                        totalcost = totalcost - giftArray[i].get_price();
                        break;
                    }
                }
            }
            else if(boy.get_type() == 3){
                while(true){
                    if(totalcost < girl.get_maintain()){
                        gifts_given.add(giftArray[i]);
                        writer.println(tmstamp);
                        writer.println(giftArray[i].get_name());
                        totalcost = totalcost + giftArray[i].get_price();
                        i++;
                    }
                    else{
                    break;
                    }
                }
                while(giftArray[i].get_type() != 2){
                    i++;
                }
                if(boy.get_budget() - totalcost >= giftArray[i].get_price()){
                    gifts_given.add(giftArray[i]);
                    writer.println(tmstamp);
                    writer.println(giftArray[i].get_name());
                    totalcost = totalcost + giftArray[i].get_price();
                }
            }
            writer.println();
            writer.close();
        }
    
        catch (IOException e){
    
        }
    }
}
