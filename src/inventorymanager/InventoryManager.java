package inventorymanager;

import java.util.Scanner;

public class InventoryManager {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        InventoryMangment inventory = new InventoryMangment(); // Create inventory object once
        Supplier supplier= null;
        

        System.out.println("Welcome to our inventory management program ");
        boolean exit= false;


        while (exit != true){
            System.out.println("Are you a Supplier , Maneger or Buyer ?");
            System.out.println("1- Supplier  \n2- Maneger \n3- Buyer \n4- Exit");
            System.out.println();
            int choose = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();
            switch (choose){
                case 1:
                boolean authenticate= false;
                boolean inBack= false;
                while (authenticate != true){
                    System.out.println("Type 'back' at any time to return to the main menu.");
                    System.out.println("Hint names: Qasem/Abood/Mohammed");
                    System.out.print("Please enter your name : ");
                    String authName = keyboard.nextLine();

                    if (authName.equalsIgnoreCase("back")) {
                        inBack= true;
                        break; // exits the supplier case and returns to main menu
                    }
                    System.out.print("Enter supplier id: ");
                    String authId = keyboard.nextLine();

                    if (authId.equalsIgnoreCase("back")) {
                        inBack= true;
                        break;
                    }

                
                    Supplier[] suppliers = Supplier.getPredefinedSuppliers();
                    for(int i=0; i < suppliers.length; i++){
                        if (suppliers[i].authenticate(authName,authId)){
                            supplier= suppliers[i];
                            authenticate= true;
                            break;
                        }
                    }
                
                    if (authenticate == true){
                        System.out.println();
                        System.out.println("Welcome " + supplier.getSupplierName() + " to your inventory!");
                    }
                
                    else{
                        System.out.println("Please try again.");
                        System.out.println();
                    }
                }
                
                if (inBack == true){
                    break;
                }
                
                
                boolean back= false;
                while (back != true){
                    System.out.println("\n------ Supplier Menu ------");
                    System.out.println("1. Add Product");
                    System.out.println("2. Remove Product by ID");
                    System.out.println("3. View Supplier Products");
                    System.out.println("4. View Total Count Of Products");
                    System.out.println("5. Search Product by ID");
                    System.out.println("6. Search Product by Name");
                    System.out.println("7. View Supplier Info");
                    System.out.println("8. Back");
                    System.out.println("9. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    
                    int supplierChoice= keyboard.nextInt();
                    keyboard.nextLine();
                    
                    
                    switch (supplierChoice){
                        case 1:
                            System.out.println("Which product you want to add (0 for Keyboard, 1 for Mouse, 2 for Screen): ");
                            int addPro= keyboard.nextInt();
                            keyboard.nextLine();
                            System.out.println();
                            supplier.addProductToSupplier(addPro);
                            break;
                            
                            
                        case 2:
                             System.out.println("Which product you want to remove  (0 for Keyboard, 1 for Mouse, 2 for Screen): ");
                            System.out.print("Enter product id to remove : ");
                            String removeById= keyboard.nextLine();
                            supplier.removeProductFromSupplier(removeById);
                            break;
                            
                            
                        case 3:
                            supplier.getSupplierProducts();
                            break;
                            
                            
                        case 4:
                            System.out.println(supplier.getSupplierProductsCount());
                            break;
                            
                            
                        case 5:
                            System.out.println("Choose one  : 0 (Keyboard), 1 (Mouse), or 2 (Screen)");
                            System.out.print("Enter product id: ");
                            String searchId= keyboard.nextLine();
                            System.out.println();
                            supplier.searchForProductById(searchId);
                            break;
                            
                            
                        case 6:
                            System.out.print("Enter product name: ");
                            String searchName= keyboard.nextLine();
                            keyboard.nextLine();
                            supplier.searchForProductByName(searchName);
                            break;
                            
                            
                        case 7:
                            System.out.println(supplier);
                            break;
                            
                            
                        case 8:
                            back= true;
                            break;
                            
                            
                        case 9:
                            back= true;
                            exit= true;
                            System.out.println("Exited successfully");
                            break;
                            
                            
                    }
                }
                    break;
            
            
            
            
//_______________________________________________________________________________________________________________________________________________________________
                case 2: 
                    int choose2 = 0;

                     while (choose2 != 6) {
                        System.out.println("You want to:");
                        System.out.println("1- Add product");
                        System.out.println("2- Remove product");
                        System.out.println("3- Update product");
                        System.out.println("4- Get product by ID");
                        System.out.println("5- List all products");
                        System.out.println("6- Back");
                        System.out.println("7- Exit");
                        System.out.println();
                        System.out.print("Please choose a number : ");
                        choose2 = keyboard.nextInt();
                        System.out.println();

                        switch (choose2) {
                            case 1:
                                System.out.println("A- number 0 for Keyboard \nB- number 1 for Mouse \nC- number 2 for Screen");
                                System.out.println();
                                int addChoice = keyboard.nextInt();
                                inventory.addProduct(addChoice);

                                break;

                            case 2:
                                System.out.println("A- number 0 for Keyboard \nB- number 1 for Mouse \nC- number 2 for Screen");
                                System.out.println();
                                int removeChoice = keyboard.nextInt();
                                inventory.removeProduct(removeChoice);
                                break;

                            case 3:
                               System.out.println("A- number 0 for Keyboard \nB- number 1 for Mouse \nC- number 2 for Screen");
                               System.out.println();
                               System.out.print("Enter product number to update : ");
                               int updateChoice = keyboard.nextInt();
                               System.out.println();

                                if (updateChoice >= 0 && updateChoice <= 2) {
                                    System.out.println("What do you want to update?");
                                    System.out.println("1 - Quantity");
                                    System.out.println("2 - Price");
                                    System.out.println();
                                    int updateOption = keyboard.nextInt();
                                    System.out.println();

                                    switch (updateOption) {
                                        case 1:
                                           System.out.print("Enter new quantity : ");
                                           System.out.println();
                                           int newQuantity = keyboard.nextInt();
                                           System.out.println();
                                           inventory.getProductname(updateChoice).setQuantity(newQuantity);
                                           System.out.println("Quantity updated successfully.");
                                           break;

                                        case 2:
                                            System.out.print("Enter new price : ");
                                            double newPrice = keyboard.nextDouble();
                                            inventory.getProductname(updateChoice).setPrice(newPrice);
                                            System.out.println("Price updated successfully.");
                                            break;

                                        default:
                                            System.out.println("Invalid option. Returning to main menu.");
                                    }

                                } 
                      
                                else {
                                    System.out.println("Invalid product number.");
                                }
                                break;
                         
                            case 4:
                                System.out.println("A- number 0 for Keyboard \nB- number 1 for Mouse \nC- number 2 for Screen");
                                System.out.println();
                                int idChoice = keyboard.nextInt();
                                System.out.println(inventory.showProduct(idChoice));
                                break;
                        

                            case 5:
                                inventory.showInventory();
                                break;
                                
                            case 6:
                                break;

                            case 7:
                                System.out.println("Exiting the program. Goodbye!");
                                System.exit(0);

                            default:
                                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                        }

                        System.out.println();
                     }
                    break;
                    
                    
                    
                    
//_______________________________________________________________________________________________________________________________________________________________ 
                case 3:
                    Order order = new Order(); // Create new order for buyer
                    boolean buyerExit = false;

                    while (buyerExit != true) {
                        System.out.println("\n------ Buyer Menu ------");
                        System.out.println("1. Add Product to Order");
                        System.out.println("2. Remove Product from Order");
                        System.out.println("3. View Ordered Products");
                        System.out.println("4. Confirm Order");
                        System.out.println("5. Cancel Order");
                        System.out.println("6. View Order Summary");
                        System.out.println("7. Back");
                        System.out.println("8. Exit");
                        System.out.println();
                        System.out.println("Choose an option : ");

                        int buyerChoice = keyboard.nextInt();
                        keyboard.nextLine(); // consume newline

                        switch (buyerChoice) {
                            case 1:
                                System.out.println("Which product would you like to add?");
                                System.out.println("0 - Keyboard");
                                System.out.println("1 - Mouse");
                                System.out.println("2 - Screen");
                                int prodAdd = keyboard.nextInt();
                                keyboard.nextLine();
                
                                if (prodAdd >= 0 && prodAdd <= 2) {
                                    Product selectedProduct = inventory.getProductname(prodAdd);
                                    if (selectedProduct.getQuantity() > 0) {
                                        order.addProduct(selectedProduct);
                                        selectedProduct.setQuantity(selectedProduct.getQuantity() - 1); // reduce inventory
                                    } else {
                                        System.out.println("Sorry, this product is out of stock.");
                                    }
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                                break;
                                
                            case 2:
                                System.out.println("Which product would you like to remove?");
                                                System.out.println("0 - Keyboard");
                                System.out.println("1 - Mouse");
                                System.out.println("2 - Screen");
                                int prodRemove = keyboard.nextInt();
                
                                if (prodRemove >= 0 && prodRemove <= 2) {
                                    Product removeProduct = inventory.getProductname(prodRemove);
                                    order.removeProduct(removeProduct);
                                    removeProduct.setQuantity(removeProduct.getQuantity() + 1); // restock
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                                break;

                            case 3:
                                order.getOrderedProducts();
                                break;
                
                            case 4:
                                order.confirmOrder();
                                break;
                
                            case 5:
                                order.cancelOrder();
                                break;

                            case 6:
                                System.out.println(order);
                                break;

                            case 7:
                                buyerExit = true;
                                break;
                
                            case 8:
                                buyerExit = true;
                                exit = true;
                                System.out.println("Exited successfully.");
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                    
                    
//_______________________________________________________________________________________________________________________________________________________________
                case 4:
                    System.out.println("Exited successfully.");
                    exit= true;
                    break;
                    
                    
                default:
                    System.out.println("Invalid vlaue.");
                    System.out.println();
                    
            }
        }
    }
}

