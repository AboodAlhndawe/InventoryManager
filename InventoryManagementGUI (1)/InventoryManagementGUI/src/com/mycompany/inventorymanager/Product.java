package com.mycompany.inventorymanager;

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