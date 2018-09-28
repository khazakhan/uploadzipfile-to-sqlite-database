package info.whats_online.sqlitedbwithimages;

/**
 * Visit website http://www.whats-online.info
 * **/

public class Contact {

    //private variables
    int _id;
    String _fname;
    String _img;



    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String fname, String img){
        this._id = id;
        this._fname = fname;
        this._img = img;

    }

    // constructor
    public Contact(String fname, String img){

        this._fname = fname;
        this._img = img;

    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting first name
    public String getFName(){
        return this._fname;
    }

    // setting first name
    public void setFName(String fname){
        this._fname = fname;
    }

    //getting profile pic
    public String getImage(){
        return this._img;
    }

    //setting profile pic

    public void setImage(String b){
        this._img=b;
    }

}

