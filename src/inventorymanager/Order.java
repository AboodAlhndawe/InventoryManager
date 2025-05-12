/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*Order Class
Handles customer orders or internal stock orders.

Fields: orderId, orderedProducts, productsCount, orderStatus, id.

Methods: addProduct(), removeProduct(), orderPrice(), confirmOrder(), cnacelOrder(), getter, toString().
*/

// by Qasem 2022904067 

package inventorymanager;
public class Order{
    
    // defining variables needed in this class
    private String orderId;// Stores id of the order
    private Product[] orderedProducts;// defining array of type Project that stores ordered products
    private int productsCount;// Stores number of products that have been ordered
    private String orderStatus;// Stores the order status like (New Order, Under Process, Canceled)
    private static int id= 1;// number used to get unique orderId for example: (ORDNUM1, ORDNUM2, ORDNUM3.....)
    
    
    
    
    // (CONSTRUCTOR)
    public Order (){
        this.orderId= "ORDNUM" + id++;// each time we create an object of type order id will be incremented by 1 (to get unique id for order)
        this.orderedProducts= new Product[100];// Creating an array of type Project its size(100) // Can save in it 100 product maximum for each order
        this.productsCount= 0;// First value of this variable was 0 because whenwe start a  new order there is no products added yet to array
        this.orderStatus= "New Order";
    }
    
    
    
    
    // Method let me add product to order if there is space
    public void addProduct(Product product){
        int count= productsCount;// Saving productsCount in it to compare it after the loop if its changed or not
        for (int i=0; i < orderedProducts.length; i++){
            if (orderedProducts[i] == null){// Searching for first null value 
                orderedProducts[i]= product;// Replace first null value found with product
                productsCount++;
                System.out.println("Product added successfully.");
                break;
            }
        }
        if (count == productsCount){// checks if productsCount variable has changed (comparison between before loop and after loop) so if it's not that means no product was added
            System.out.println("Can't add more products, CAPACITY IS FULL.");
        }
    }
            

    
    
    
    
    // Method removes a product from order
    public void removeProduct(Product product){
        int count= productsCount;// Saving productsCount in it to compare it after the loop if its changed or not
        for (int i= 0; i < orderedProducts.length; i++){
            if (orderedProducts[i] != null && orderedProducts[i].equals(product)){// checks firstly if it's not null (to avoid if user enters null)
                orderedProducts[i]= null;// Set the value of target product to null
                productsCount--;
                System.out.println("Product removed successfully.");
                break;
            }
        }
        if (count == productsCount){// checks if product removed or not (if remove productsCount will me minused by 1 since before loop)
            System.out.println("Product not found, please enter an existed product.");
        }
    }
    
    
    
    
    // Method let me know how much the order costs
    public double orderPrice(){
        double price= 0.0;
        for (int i=0; i < orderedProducts.length; i++){
            if (orderedProducts[i] != null){
                    price+= orderedProducts[i].getPrice();// Calling method called getPrice from Product class
            }    
        }
        return price;
    }
    
    
    
    
    // Method to confirm the order (changes status of order to Under Process)
    public void confirmOrder(){
        if (productsCount != 0){// Must be at least one product to confirm order
            this.orderStatus= "Under Process";
            System.out.println("Order confirmed, its now under process.");
        }
        else{
            System.out.println("Please add some products to confirm order.");
        }
    }
    
    
    
    
    // Method to cancel the order (changes status of order to Canceled)
    public void cancelOrder(){
        this.orderStatus= "Canceled";
        System.out.println("Order Canceled.");
    }
    
    
    
    
    // Method prints all products added to order
    public void getOrderedProducts(){
        int num= 1;// Number used to organize the output from this method (incremented in each iteration (when if statement be true))
        for (int i=0; i < orderedProducts.length; i++){
            if (orderedProducts[i] != null){
                System.out.println("Product number " + num++ + ": " + orderedProducts[i]); 
        
            }   
        }
    }
    
    
    
    
    // Method to get oreder status
    public String getOrderStatus(){
        return orderStatus;
    }
    
    
    
    
    // Method to get order id
    public String getOrderId(){
        return orderId;
    }
    
    
    
    
    // Method to get number of products in order
    public int getProductsCount(){
        return productsCount;
    }
    
    
    
    
    // Method return most of varibales from this class (Order)
    public String toString(){
        return ("Order id is: " + this.orderId + "\n Number of ordered products: " + productsCount + "\n Order price: " + orderPrice() + "\n Order status: " + this.orderStatus);
    }
}
