package id.co.javan.news.entity;

/**
 * Menu
 */
public class Field {

    private String name;
    private String action;
    
    public Field(String name , String action){
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