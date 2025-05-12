/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*

name : abd alrhman habis jamil suliman 

*Inventory_prodect

Fields: id, name, category, quantity, price.
Methods: updateQuantity(), updatePrice(), toString().


Inventory Manages a collection of Product objects.

Methods: addProduct(), removeProduct(), updateProduct(), getProductById(), listAllProducts().


name : qasem abu alqasem
Supplier Represents product suppliers.

Fields: supplierId, name, contactInfo, productSupplied.
Methods: addProductToSupplier(), toString().



Order Handles customer orders or internal stock orders.
Fields: orderId, List<Product> orderedProducts, orderDate, status.
Methods: addProductToOrder(), removeProductFromOrder(), calculateTotal().


name : Mohammed Murad Hassan Al-Eidah

InventoryManager (Main Controller) Acts as the main controller or interface for the system.

Handles user interactions (through console or GUI).
Methods: main(), displayMenu(), handleInput().



ReportGenerator

Fields name, quantity, category.
methods  getQuantity() and getCategory().
  
*/


package inventorymanager;

import java.util.Scanner;

public class Product {
    
        //initialization the attributs
        public String ID ;
        public int quantity ;
        public String name ;
        public String category ;
        public double price ;
        
        //constructor
        public Product(){        

        ID = "0000000000"  ;
        quantity = 0 ;
        name = "non";
        category = "non" ;
        price  = 0.0;
        
        }
        

        //get methods for all attributs
        public String getID() {
                return ID;
        }

        public int getQuantity() {
                return quantity;
        }

        public String getName() {
                return name;
        }

        public String getCategory() {
                return category;
        }      

        public double getPrice() {
                return price;
        }

        // Set methods for all attributs
        
         public void setID(String ID) {
               this.ID = ID;
        }
         
        public void setQuantity(int quantity) {
               this.quantity = quantity;
        }

        public void setName(String name) {
               this.name = name;
        }

        public void setCategory(String category) {
               this.category = category;
        }

        public void setPrice(double price) {
               this.price = price;
        }
        
        
        public String toString(){
        
        return "the product : " + this.name +
                "\nID : "+ this.ID +
                "\nquantity : " + this.quantity +
                "\ncategory : " + this.category +
                "\nprice : " + this.price  ;
        
        }

    }