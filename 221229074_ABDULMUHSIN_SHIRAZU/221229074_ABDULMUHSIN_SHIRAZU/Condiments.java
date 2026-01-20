import java.util.ArrayList;

public class Condiments extends Urun {

    public Condiments(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


    public static ArrayList<Condiments>  changePrice(ArrayList<Condiments> condiments,int N,double newPrice){

        int counter = 0;
        for (Condiments product : condiments) {
            if(counter == (N-1)){
                product.unitPrice = newPrice;
                break;
            }
            counter++;
        }

        return condiments;
    }
}