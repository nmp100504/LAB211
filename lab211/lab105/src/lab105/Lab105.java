/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab105;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab105 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        ProductManagement pm = new ProductManagement();
        Product product = new Product();
        while (true) {
            System.out.println("Main menu: ");
            System.out.println("1. Add Storekeeper");
            System.out.println("2. Add product");
            System.out.println("3. Update product");
            System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate");
            System.out.println("5. Sort product by Expiry date, Date of manufacture");
            System.out.println("6. Exit");

            int choice = validate.getInt("Your choice ", 1, 6);

            switch (choice) {
                case 1:
                    String storekeeperName = validate.getString("Store keeper name :", "[A-Za-z\\s]+");
                    pm.addStorekeeper(storekeeperName);
                    break;
                case 2:
                    System.out.println("Add new product: ");

                    boolean checkidnew = true;
                    do {
                        System.out.print("id: ");
                        int idNew = sc.nextInt();
                        sc.nextLine();
                        if (pm.getProducts().isEmpty()) {
                            break;
                        } else {
                            for (int i = 0; i < pm.getProducts().size(); i++) {
                                if (pm.getProducts().get(i).getId() == idNew) {
                                    checkidnew = false;
                                    break;
                                }
                            }
                        }

                    } while (checkidnew == true);

                    product.setName(validate.getString("name: ", "[A-Za-z\\s]+"));
                    product.setLocation(validate.getString("location: ", "[A-Za-z\\s]+"));
                    System.out.println("price: ");
                    product.setPrice(sc.nextDouble());
                    sc.nextLine();
                    product.setExpiryDate(validate.getString("expiry date: ", "[A-Za-z\\s]+"));
                    product.setManufactureDate(validate.getString("manufacture date: ", "[A-Za-z\\s]+"));
                    product.setCategory(validate.getString("category: ", "[A-Za-z\\s]+"));
                    product.setStorekeeper(validate.getString("store keeprt: ", "[A-Za-z\\s]+"));
                    product.setReceiptDate(validate.getString("receipt date: ", "[A-Za-z\\s]+"));

                    pm.addProduct(product);
                    break;
                case 3:
                    System.out.println("id to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    boolean check = false;
                    for (int i = 0; i < pm.getProducts().size(); i++) {
                        if (pm.getProducts().get(i).getId() == idToUpdate) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("Update product: ");
                        System.out.print("id: ");
                        product.setId(sc.nextInt());
                        sc.nextLine();
                        product.setName(validate.getString("new name: ", "[A-Za-z\\s]+"));
                        product.setLocation(validate.getString("new location: ", "[A-Za-z\\s]+"));
                        System.out.println("new price: ");
                        product.setPrice(sc.nextDouble());
                        sc.nextLine();
                        product.setExpiryDate(validate.getString("new expiry date: ", "[A-Za-z\\s]+"));
                        product.setManufactureDate(validate.getString("new manufacture date: ", "[A-Za-z\\s]+"));
                        product.setCategory(validate.getString("new category: ", "[A-Za-z\\s]+"));
                        product.setStorekeeper(validate.getString("new store keeprt: ", "[A-Za-z\\s]+"));
                        product.setReceiptDate(validate.getString("new receipt date: ", "[A-Za-z\\s]+"));
                        pm.updateProduct(idToUpdate, product);
                    } else {
                        System.out.println("not found");
                    }
                    break;
                case 4:
                    System.out.println("which type : name, category, storekeeper or receiptdate :");
                    String searchOption = sc.nextLine().toLowerCase();
                    System.out.println("search value :");
                    String searchValue = sc.nextLine();
                    pm.searchOption(searchOption, searchValue);
                    break;
                case 5:
                    String sortOption = validate.getString("sort by expiry or manufacture ", "[A-Za-z\\s]+");
                    pm.sort(sortOption);
                    break;
                case 6:
                    System.out.println("exit...");
                    System.exit(0);
            }

        }
    }

}
