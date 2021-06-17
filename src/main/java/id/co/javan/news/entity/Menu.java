package id.co.javan.news.entity;

/**
 * Menu
 */
public class Menu {

    private String name;
    private String action;
    
    public Menu(String name , String action){
        this.name =  name;
        this.action = action;
    }

    public String getName () {
        return this.name;
    }
    public String getAction () {
        return this.action;
    }



}