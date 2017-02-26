/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *class for Gifts
 * @author RAKA
 */
public class Gifts {
    private String name;
    private int type;
    private int price;
    private int value;
    private int luxury_rating;
    private int diff_obtain;
    private int utility_value;
    private int utility_class;
    /**
     * constructor for gift class
     * @param type type of gift ; 1 - essential 2 - luxury 3 - utility
     * @param name name of gift
     * @param price price of gift
     * @param value value of gift
     * @param luxury_rating luxury rating of gift
     * @param diff_obtain difficulty to obtain the gift
     * @param utility_value utility value of gift
     * @param utility_class utility class of gift
     */
    public Gifts(int type,String name,int price,int value,int luxury_rating,int diff_obtain,int utility_value,int utility_class){
        this.name = name;
        this.type = type;
        this.price = price;
        this.value = value;
        this.luxury_rating = luxury_rating;
        this.diff_obtain = diff_obtain;
        this.utility_value = utility_value;
        this.utility_class = utility_class;
    }
    
    /**
     * to set the name of the gift
     * @param name name of the gift
     */
    public void set_name(String name){
        this.name = name;
    }
    
    /**
     * to return the name of the gift
     * @return return name of the gift
     */
    public String get_name(){
        return name;
    }
    /**
     * to set the price of the gift
     * @param price price of the gift
     */
    public void set_price(int price){
        this.price = price;
    }
    /**
     * to return the price of the gift
     * @return return the price of gift
     */
    public int get_price(){
        return price;
    }
    
    /**
     * to set the type of gift ; 1 - essential 2 - luxury 3 - utility
     * @param type type of gift
     */
    public void set_type(int type){
        this.type = type;    
    }
    /**
     * to return the type of gift ; 1 - essential 2 - luxury 3 - utility
     * @return return the type of gift
     */
    public int get_type(){
        return type;
    }
    
    /**
     * to set the value of gift
     * @param value value of gift
     */
    public void set_value(int value){
        this.value = value;
    }
    /**
     * to return the value of gift
     * @return return the value of gift
     */
    public int get_value(){
        return value;
    }
    
    /**
     * to set the luxury rating of gift on rating of 1 to 100
     * @param luxury_rating luxury rating of gift
     */
    public void set_Luxury_rating(int luxury_rating){
        this.luxury_rating = luxury_rating;
    }
    /**
     * to return the luxury rating of gift on a rating of 1 to 100
     * @return luxury rating of gift
     */
    public int get_Luxury_rating(){
        return luxury_rating;
    }
    
    /**
     * to set the difficulty to obtain on a rating of 1 to 100
     * @param diff_obtain difficulty to obtain the gift
     */
    public void set_diff_obtain(int diff_obtain){
        this.diff_obtain = diff_obtain;
    }
    /**
     * to return the difficulty to obtain
     * @return return the difficulty to obtain
     */
    public int get_diff_obtain(){
        return diff_obtain;
    }
    
    /**
     * to set the utility value of the gift on a rating of 1 to 100
     * @param utility_value utility value of the gift
     */
    public void set_utility_value(int utility_value){
        this.utility_value = utility_value;
    }
    /**
     * to return the utility value on a rating of 1 to 100
     * @return return the utility value
     */
    public int set_utility_value(){
        return utility_value;
    }
    
    /**
     * to set the utility class of the gift on a rating of  1 to 100
     * @param utility_class utility class of the gift
     */
    public void set_utility_class(int utility_class){
        this.utility_class = utility_class;
    }
    /**
     * to return the utility class of the gift
     * @return return the utility class of gift
     */
    public int get_utility_class(){
        return utility_class;
    }
}
