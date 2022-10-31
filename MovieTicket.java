import java.io.Serializable;

public class MovieTicket implements Serializable{
    private double price;
    private Type MovieType;

    enum Type {
        THREE_D, BLOCKBUSTER; // THREE_D = 3D 
    }
    
    public MovieTicket(Type t, double standardPrice) {
        this.setPrice(standardPrice);
        this.setType(t);
    }
    public double getPrice() {
        return this.price;
    }
    
    public String getType() {
        if (this.MovieType == Type.THREE_D) {
            return "3D";
        }
        else {
            return "Blockbuster";
        }
    }

    public void setPrice(double standardPrice) {
        this.price = standardPrice;
    }

    public void setType(Type type) {
        this.MovieType = type;
    }
}
