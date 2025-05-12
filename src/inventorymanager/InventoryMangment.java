/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager;

public class InventoryMangment {

    //Create a array to store a products
    Product[] arr = new Product[3];

    public InventoryMangment() {

        // Create the object number 0 in the array (Keyboard)
        Product keyboard = new Product();
        keyboard.setID("0");
        keyboard.setName("Keyboard");
        keyboard.setQuantity(0);
        keyboard.setCategory("input device");
        keyboard.setPrice(25.00);

        // Create the object number 1 in the array (Mouse)
        Product mouse = new Product();
        mouse.setID("0");
        mouse.setName("Mouse");
        mouse.setQuantity(0);
        mouse.setCategory("input device");
        mouse.setPrice(15.00);

        // Create the object number 2 in the array (Screen)
        Product Screen = new Product();
        Screen.setID("2");
        Screen.setName("Screen");
        Screen.setQuantity(0);
        Screen.setCategory("output device");
        Screen.setPrice(100.00);

        // Store objects in the array
        arr[0] = keyboard;
        arr[1] = mouse;
        arr[2] = Screen;

    }

    public void addProduct(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            arr[number_of_product].quantity += 1;
            System.out.println();
            System.out.println("The Quantity of " + arr[number_of_product].name + " was equal = " + arr[number_of_product].getQuantity());


        } else {

            System.out.println("unvalid value ");

        }

    }

    public void removeProduct(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            arr[number_of_product].quantity -= 1;
            System.out.println();
            System.out.println("The Quantity of " + arr[number_of_product].name + " was equal = " + arr[number_of_product].getQuantity());
            if (arr[number_of_product].getQuantity() <= -1) {
                System.out.println("Warning your inventory is empty from this item you should get some " + arr[number_of_product].name + "s");

            }
        } else {

            System.out.println("unvalid value ");

        }
    }

    public String showProduct(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            return arr[number_of_product].toString() + "\n";

        } else {

            return "unvalid value ";
        }

    }

    public void showInventory() {
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i].toString() + "\n");

        }
    }

    public Product getProductname(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            return arr[number_of_product];

        } else {

            return null;
        }
    }

    public String getProductcatagory(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            return arr[number_of_product].category;

        } else {

            return null;
        }
    }

    public int getProductquanitiy(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            return arr[number_of_product].quantity;

        } else {

            return 0;

        }
    }

    public double getProductprice(int number_of_product) {

        if (number_of_product >= 0 && number_of_product <= 2) {
            return arr[number_of_product].price;

        } else {

            return 0.0;
        }
    }

}
