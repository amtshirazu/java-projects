import java.util.*;
import java.io.*;

package com.mycompany.excelprocessor;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;
import java.io.InputStream;

public class Main_2274 {

	public static void main(String[] args) {
		ArrayList<Urun> urunList = new ArrayList<Urun>();
		ArrayList<Kategori> yeniList = new ArrayList<Kategori>();
        String filename = "/UrunListesi.xlsx";
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean inprogress = true;
        while (inprogress) {
            System.out.println("1.ListeOlustur");
            System.out.println("2.YeniKategoriListesiOlustur");
            System.out.println("3.BirimFiyatGuncelle");
            System.out.println("4.YeniUrunEkle");
            System.out.println("5.UrunleriSil");
            System.out.println("6.cikis");
            System.out.println("Choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    urunList = ListeOlustur(filename);
                    yazdir1(urunList);
                    break;
                case 2:
                	System.out.println("Enter A:");
                    int A = scanner.nextInt();
                	yeniList=YeniKategoriListesiOlustur(urunList,A);
                	yazdir2(yeniList);
                    break;
                case 3:
                    int x;
                    System.out.println("Enter X:");
                    x = scanner.nextInt();
                    System.out.println("Enter value of indirimMi:");
                    boolean indirimMi = scanner.nextBoolean();
                    BirimFiyatGuncelle(urunList,x, indirimMi);
                    break;

                case 4:
                	 urunList = YeniUrunEkle(urunList);
                	 yazdir1(urunList);
                    break;
                case 5:
                	System.out.println("Those whose stock are 0 will be deleted!");
                	System.out.println("Before deletion:");
                	yazdir1(urunList);
                	System.out.println("\n");
                	System.out.println("After deletion:");               	
                	urunList = urunSil(urunList);
                	yazdir1(urunList);
                    break;
                case 6:
                	System.out.println("Exiting.....");
                    inprogress = false;
                    break;
            }
        }

        scanner.close();
    }

    static ArrayList<Urun> ListeOlustur(String filename) {
        ArrayList<Urun> urunList = new ArrayList<>();
        
        try (InputStream inputStream = Main_2274.class.getResourceAsStream(filename);
                Workbook workbook = new XSSFWorkbook(inputStream)) {

               Sheet sheet = workbook.getSheetAt(0);
               for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                   Row row = sheet.getRow(i);
                   if (row != null) { 
                       String name = row.getCell(0).getStringCellValue();
                       int categoryIndex = (int) row.getCell(1).getNumericCellValue();
                       String unitWeight = row.getCell(2).getStringCellValue();
                       double unitPrice = row.getCell(3).getNumericCellValue();
                       int stockQuantity = (int) row.getCell(4).getNumericCellValue();

                       Urun urun = new Urun(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
                       urunList.add(urun);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        return urunList;
    }

    static  ArrayList<Kategori> YeniKategoriListesiOlustur(ArrayList<Urun> urunList, int A) {
        ArrayList<Kategori> yeniList = new ArrayList<>();
        
        for(Urun urun: urunList) {
        	if(urun.getStockQuantity() > A) {
        		int index = urun.getCategoryIndex();
        		int quantity = urun.getStockQuantity();
        		Kategori kategori = new Kategori(index,quantity);
        		yeniList.add(kategori);
        	}
        }
        
        yeniList.sort(Comparator.comparingInt(Kategori::getAmount).reversed());
        return yeniList;
    }

    static void BirimFiyatGuncelle(ArrayList<Urun> urunList, int x, boolean indirimMi) {
    	double fiyatOrtalamasi = 0;
        for (Urun part : urunList) {
        	fiyatOrtalamasi += part.getUnitPrice();
        }
        
        fiyatOrtalamasi = fiyatOrtalamasi/urunList.size();
        
        double enYakinfark = Double.MAX_VALUE;
        Urun yakinUrun = null;
        
        for (Urun part2 : urunList) {
            if(Math.abs(part2.getUnitPrice()-fiyatOrtalamasi) < enYakinfark) {
            	enYakinfark = Math.abs(part2.getUnitPrice()-fiyatOrtalamasi);
            	yakinUrun = part2;
            }
        }
        
        if(indirimMi) {
        	double change = (x/100.0)*yakinUrun.getUnitPrice();
        	yakinUrun.setUnitPrice(yakinUrun.getUnitPrice() - change);
        }else {
        	double change = (x/100.0)*yakinUrun.getUnitPrice();
        	yakinUrun.setUnitPrice(yakinUrun.getUnitPrice() + change);
        }

            System.out.println(yakinUrun.getName() + "\t" + yakinUrun.getCategoryIndex() + "\t" + yakinUrun.getUnitWeight() + "\t"
                    + yakinUrun.getUnitPrice() + "\t" + yakinUrun.getStockQuantity());
 }


    static ArrayList<Urun> urunSil(ArrayList<Urun> urunList) {    
    	Iterator<Urun> it = urunList.iterator();
    	
    	while(it.hasNext()) {
    		if(it.next().getStockQuantity() == 0) {
    			it.remove();
    		}
    		
    	}

    return urunList;
}
    
    	
    static ArrayList<Urun> YeniUrunEkle(ArrayList<Urun> urunList) {   
        int[] value = new int[5]; // Assuming category indices 1 to 5
        double fiyatortalamasi = 0;
        double stokortalamasi = 0;

        // Count stock quantities and calculate average prices
        for (Urun urun : urunList) {
            int categoryIndex = urun.getCategoryIndex();
            if (categoryIndex >= 1 && categoryIndex <= 5) {
                value[categoryIndex - 1] += urun.getStockQuantity(); 
            }
            fiyatortalamasi += urun.getUnitPrice();
            stokortalamasi += urun.getStockQuantity();
        }

        // Calculate averages
        fiyatortalamasi /= urunList.size();
        stokortalamasi /= urunList.size();

        
        int lowest = Integer.MAX_VALUE; 
        int index = -1; 
        for (int i = 0; i < value.length; i++) {
            if (value[i] < lowest) {
                lowest = value[i];
                index = i + 1; 
            }
        }

        
        if (index == -1) {
            System.out.println("No category with stock available to add a new product.");
            return urunList; 
        }

        
        String name = "yeniUrun_" + lowest;
        String unitWeight = "10 boxes";
        double unitPrice = fiyatortalamasi;
        int stockQuantity = (int) stokortalamasi;

        Urun yeniUrun = new Urun(name, index, unitWeight, unitPrice, stockQuantity);
        urunList.add(yeniUrun);

        
        List<Urun> lowestStockProducts = new ArrayList<>();
        for (Urun urun : urunList) {
            if (urun.getCategoryIndex() == index) {
                lowestStockProducts.add(urun);
            }
        }

        System.out.println("Products in category " + index + " with the lowest stock:");
        for (Urun urun : lowestStockProducts) {
            System.out.println(urun.getName() + "\t" + urun.getStockQuantity());
        }

        return urunList;
    }


 static void yazdir1(ArrayList<Urun> urunList) {
	 
	 for (Urun part : urunList) {
         System.out.println(part.getName() + "\t\t" + part.getCategoryIndex() + "\t\t" + part.getUnitWeight() + "\t\t"
                 + part.getUnitPrice() + "\t\t" + part.getStockQuantity());
     }

     System.out.println("\n");
 }

static void yazdir2(ArrayList<Kategori> yeniList) {
	 
	 for (Kategori part : yeniList) {
         System.out.println(part.getIndex() + "\t\t" + part.getAmount());
     }

     System.out.println("\n");
 }

}


class Urun {
    private String name;
    private int categoryIndex;
    private String unitWeight;
    private double unitPrice;
    private int stockQuantity;

 
    public Urun(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        this.name = name;
        this.categoryIndex = categoryIndex;
        this.unitWeight = unitWeight;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }
    
    public void setUnitPrice(double unitPrice){
    	this.unitPrice = unitPrice; 
    }

    public String getName(){
    	return name; 
    }
    
    public int getCategoryIndex(){
    	return categoryIndex; 
    }
    
    public String getUnitWeight(){
    	return unitWeight; 
    }
    
    public double getUnitPrice(){
    	return unitPrice;
    }
    
    public int getStockQuantity(){
    	return stockQuantity;
    }

    
}


class Kategori {
    private int index;
    private int amount;

 
    public Kategori(int index,int amount) {
        this.index = index;
        this.amount = amount;
    }

    
    public int getIndex(){
    	return index;
    }
    
    public int getAmount(){
    	return amount;
    }
    
}