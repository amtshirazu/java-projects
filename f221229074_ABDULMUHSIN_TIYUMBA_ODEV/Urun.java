

public abstract class Urun {

    protected String name;
    protected int categoryIndex;
    protected String weight;
    protected double unitPrice;
    protected int stockQuantity;

    public Urun() {
    
    }

    public Urun(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        this.name = name;
        this.categoryIndex = categoryIndex;
        this.weight = unitWeight;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }


    public String getName(){
    	return name; 
    }
    
    public int getCategoryIndex(){
    	return categoryIndex; 
    }
    
    public String getWeight(){
    	return weight; 
    }
    
    public double getUnitPrice(){
    	return unitPrice;
    }
    
    public int getStockQuantity(){
    	return stockQuantity;
    }


    public abstract void EnKisaIsimliUrunIsimGuncelle(String yeniIsim);
    public abstract void StokEnAzOlanUrunSil();

   
}
