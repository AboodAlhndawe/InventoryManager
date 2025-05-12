package com.mycompany.inventorymanager;

/*Supplier Class
Represents product suppliers.

Fields: supplierId, supplierName, supplierPhone, productsInventory[], productsCount

Methods: setter, geetter, toString(), addProductToSupplier(), removeProductFromSupplier(), searchProductById(), searchProdcutByName(), authenticate().
*/

// by Qasem 2022904067
public class Supplier{
        
    // defining variables needed in this class 
    private final String supplierId;// stores supplier id in it
    private final String supplierName;//  stores name of supplier in it 
    private String supplierPhone;// stores supplier phone in it
    public final Product[] productsInventory;// defining array to store the products which the supplier have      //Product is a class represents the product in inventory
    private int productsCount;// stores the number of products the supplier have
    
    
    
    
    // (CONSTRUCTOR)
    public Supplier (String sId, String sName, String sPhone){
        this.supplierId= sId;
        this.supplierName= sName;
        this.supplierPhone= sPhone;
        this.productsInventory= new Product[3];// creating array of size (3)  
        this.productsCount= 0;// (supplier have 0 products at beginning)
        
        
        
        Product keyboard = new Product();
        keyboard.setID("0");
        keyboard.setName("Keyboard");
        keyboard.setCategory("input device");
        keyboard.setQuantity(0);
        keyboard.setPrice(25.0);
        productsInventory[0] = keyboard;// defining keyboard in index 0

        Product mouse = new Product();
        mouse.setID("1");
        mouse.setName("Mouse");
        mouse.setCategory("input device");
        mouse.setQuantity(0);
        mouse.setPrice(15.0);
        productsInventory[1] = mouse;// defining mouse in index 1

        Product screen = new Product();
        screen.setID("2");
        screen.setName("Screen");
        screen.setCategory("output device");
        screen.setQuantity(0);
        screen.setPrice(100.0);
        productsInventory[2] = screen;//  defining screen in index 2
    }
    
    
    
    
    // method gives predefined suppliers
    public static Supplier[] getPredefinedSuppliers() {
    Supplier s1 = new Supplier("Qa", "Qasem", "777");
    Supplier s2 = new Supplier("Ab", "Abood", "222");
    Supplier s3 = new Supplier("Mo", "Mohammed", "111");
    return new Supplier[] { s1, s2, s3 };
    }
    
    
    
    
    // method to change phone number of supplier
    public void setSupplierPhone(String sPhone){
        this.supplierPhone= sPhone;
        System.out.println("Phone number updated successfully.");
    }
    
    
    
    
    // method returns supplier id
    public String getSupplierId(){
        return this.supplierId;
    }
    
    
    
    
    // method returns supplier name
    public String getSupplierName(){
        return this.supplierName;
    }
    
    
    
    
    // method returns supplier phone number
    public String getSupplierPhone(){
        return this.supplierPhone;
    }
    
    
    
    
    // method outputs all products the supplier have in his inventory
    public void getSupplierProducts(){
        if (productsCount == 0){
            System.out.println("Supplier don't have products yet.");
            return;
        }
        for (int i= 0; i < this.productsInventory.length; i++ ){
            if (productsInventory[i].getQuantity() > 0){
                System.out.println("Product " + (i + 1) +": ");
                System.out.println("Id: " + productsInventory[i].getID());
                System.out.println("Name: " + productsInventory[i].getName());
                System.out.println("Category: " + productsInventory[i].getCategory());
                System.out.println("Quantity: " + productsInventory[i].getQuantity());
                System.out.println("Pricce: " + productsInventory[i].getPrice());
                System.out.println("__________________________________________");
            }
            else{
                System.out.println("No products of " + productsInventory[i].getName() + " in inventory yet");
                System.out.println("__________________________________________");
            }
        }
    }
    
    
    
    
    // method returns number of products in supplier inventory
    public int getSupplierProductsCount(){
        return this.productsCount;
    }
    
    
    
    
    // method adds product to supplier inventory
    public void addProductToSupplier(int index) {
        if (index >= 0 && index <= 2) {// (0 || 1 || 2 means true)
            Product product = productsInventory[index];
            int quantity = product.getQuantity();
            product.setQuantity(quantity + 1);
            productsCount++;
            System.out.println("Added one unit of " + product.getName() + " New quantity : " + product.getQuantity());
        }
        else{
            System.out.println("Invalid product selection. Choose 0 (Keyboard), 1 (Mouse), or 2 (Screen).");
        }


    }
    
    
    
    
    // method removes product by id
    public void removeProductFromSupplier(String productId) {
        boolean exist= false;
        for (int i = 0; i < productsInventory.length; i++) {
            if (productsInventory[i] != null && productsInventory[i].getID().equals(productId)) {
                if (productsInventory[i].getQuantity() > 0) {
                    productsInventory[i].setQuantity(productsInventory[i].getQuantity() - 1);
                    productsCount--;
                    System.out.println("Removed one piece of " + productsInventory[i].getName() + ". New quantity: " + productsInventory[i].getQuantity());
                    
                }
                else {
                    System.out.println("There is no products of " + productsInventory[i].getName() + " to remove.");
                }
                break;
            }
        }
        if (exist != true){// if its true that means product not found (there is no product with such id)
            System.out.println("Product not found.");
        }
    }

    
    
    
    // method searches for product by id
    public void searchForProductById(String id){
        boolean check= false;// for compare after loop
        for (int i=0; i < productsInventory.length; i++){
            if (productsInventory[i] != null && productsInventory[i].getID().equals(id)){
                System.out.println("Product Found: ");
                System.out.println();
                System.out.println("Id: " + productsInventory[i].getID());
                System.out.println("Name: " + productsInventory[i].getName());
                System.out.println("Category: " + productsInventory[i].getCategory());
                System.out.println("Quantity: " + productsInventory[i].getQuantity());
                System.out.println("Price: " + productsInventory[i].getPrice());
                check= true;
                break;
            }
        }
        if (check != true){// if its true that means product not found (there is no product with such  id)
            System.out.println("Product Not Found.");
        }
    }
    
    
    
    
    // method searches for product by name
    public void searchForProductByName(String name){
        boolean check= false;// for compare after loop
        
        for (int i=0; i < productsInventory.length; i++){
            if (productsInventory[i] != null && productsInventory[i].getName().equalsIgnoreCase(name)){
                System.out.println();
                System.out.println("Product Found: ");
                System.out.println();
                System.out.println("Id: " + productsInventory[i].getID());
                System.out.println("Name: " + productsInventory[i].getName());
                System.out.println("Category: " + productsInventory[i].getCategory());
                System.out.println("Quantity: " + productsInventory[i].getQuantity());
                System.out.println("Price: " + productsInventory[i].getPrice());
                check= true;
                break;
            }
        }
        if (check != true){// if its true that means product not found (there is no product with such name)
            System.out.println("Product Not Found");
        }
    }
    
    
    
    
    // method authenticates supplier by name and id
    public boolean authenticate(String name, String id) {
        return this.supplierName.equals(name) && this.supplierId.equals(id);
    }
    
    
    
    
    // method returns all variables in this class (Supplier)
    @Override
    public String toString() {
        return "Name: " + supplierName + "\nPhone: " + supplierPhone;
    }
}
    
