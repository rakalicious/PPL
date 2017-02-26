/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *class for Girls
 * @author RAKA
 */
public class Girls {
    private String name;
    private int attractive;
    private int maintain_cost;
    private int intelligence;
    private int type;
    private int is_commited;
    
    /**
     * constructor for girl class
     * @param name name of girl
     * @param attractive attractiveness of girl
     * @param maintain_cost total maintenance cost of girl
     * @param intelligence intelligence of girls
     * @param type type of girl ; 1 - choosey 2-normal 3-desperate
     * @param is_commited is the girl committed or not
     */
    public Girls(String name,int attractive,int maintain_cost,int intelligence,int type,int is_commited){
        this.set_name(name);
        this.set_attract(attractive);
        this.set_maintain(maintain_cost);
        this.set_intellig(intelligence);
        this.set_type(type);
        this.set_commited(is_commited);
    }
    
    /**
     * to set the name of the girl
     * @param name name of girl
     */
    public void set_name(String name){
        this.name = name;    
    }
    /**
     * to return the name of the boy
     * @return name of boy
     */
    public String get_name(){
        return name;
    }
    
    /**
     * to set the attractiveness of boy
     * @param attractive attractiveness of boy
     */
    public void set_attract(int attractive){
        this.attractive = attractive;
    }
    /**
     * to return the attractiveness of boy
     * @return return value of attractiveness at a scale of 1 to 100
     */
    public int get_attract(){
        return attractive;
    }
    
    /**
     * to set the maintenance cost of girl
     * @param maintain_cost maintenance cost of girl
     */
    public void set_maintain(int maintain_cost){
        this.maintain_cost = maintain_cost;
    }
    /**
     * to return the maintenance cost of girl
     * @return the value of maintenance cost ranging from 300 to 700
     */
    public int get_maintain(){
        return maintain_cost;
    }
    /**
     * to set the intelligence of girl
     * @param intelligence intelligence of girl
     */
    public void set_intellig(int intelligence){
        this.intelligence = intelligence;
    }
    /**
     * to return the intelligence of girl 
     * @return return the intelligence of girl on a scale of 1 to 100 
     */
    public int get_intellig(){
        return intelligence;
    }
    
    /**
     * set the type of girl ; 1 - choosey 2-normal 3-desperate 
     * @param type type of girl
     */
    public void set_type(int type){
        this.type = type;    
    }
    /**
     * to return the type of girl ; 1 - choosey 2-normal 3-desperate
     * @return return the type of girl
     */
    public int get_type(){
        return type;
    }
    
    /**
     * to set if the girl is committed or not ;1 - committed 0 - not committed
     * @param is_commited the girl is committed or not
     */
    public void set_commited(int is_commited){
        this.is_commited = is_commited;
    }
    /**
     * to return if the girl is committed or not
     * @return 1 - committed 0 - not committed
     */
    public int get_commited(){
        return is_commited;
    }
}
