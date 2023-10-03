/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductManagement {

    List<Product> products = new ArrayList<>();
    Set<String> storekeepers = new HashSet<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addStorekeeper(String name) {
        storekeepers.add(name);
        System.out.println("added");
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
        System.out.println("added");
    }

    public void updateProduct(int idToUpdate, Product productToUpDate) {
        products.set(idToUpdate - 1, productToUpDate);
        System.out.println("updated");
    }

    public void searchOption(String searchTypeString, String searchValue) {
        List<Product> matchings = new ArrayList<>();
        switch (searchTypeString) {
            case "name":
                for (Product p : products) {
                    if (p.getName().toLowerCase().contains(searchValue)) {
                        matchings.add(p);
                    }
                }
                break;
            case "category":
                for (Product p : products) {
                    if (p.getCategory().toLowerCase().contains(searchValue)) {
                        matchings.add(p);
                    }
                }
                break;
            case "storekeeper":
                for (Product p : products) {
                    if (p.getStorekeeper().toLowerCase().contains(searchValue)) {
                        matchings.add(p);
                    }
                }
                break;
            case "receiptdate":
                for (Product p : products) {
                    if (p.getReceiptDate().toLowerCase().contains(searchValue)) {
                        matchings.add(p);
                    }
                }
                break;
        }
        for (Product p : matchings) {
            System.out.println(p.toString());
        }
    }

    public void sort(String sortOption) {

        SimpleDateFormat dateFormat = new SimpleDateFormat();

        if (sortOption.equals("expiry") || sortOption.equals("manufacture")) {
            products.sort((p1, p2) -> {
                Date date1=null;
                Date date2=null;
                if (sortOption.equals("expiry")) {
                    try {
                        date1 = dateFormat.parse(p1.getExpiryDate());
                    } catch (ParseException ex) {
                        Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        date2 = dateFormat.parse(p2.getExpiryDate());
                    } catch (ParseException ex) {
                        Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        date1 = dateFormat.parse(p1.getManufactureDate());
                    } catch (ParseException ex) {
                        Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        date2 = dateFormat.parse(p2.getManufactureDate());
                    } catch (ParseException ex) {
                        Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return date1.compareTo(date2);
            });
            System.out.println("sorted");
        } else {
            System.out.println("not a sort option");
        }
    }
}
