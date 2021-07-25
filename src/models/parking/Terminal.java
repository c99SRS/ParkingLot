package models.parking;

public abstract class Terminal {

     private String id;

     public Terminal(String id){
         this.id = id;
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
