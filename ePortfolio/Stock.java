package bturnert_a1.ePortfolio;

import java.util.Scanner;

/**
 * This class creates and edits objects of type Stock.
 * <p> 
 * Stock contains inforamtion on a stock's name, symbol, price, quantity, and book value
 *
 * @author Ben Turner-Theijsmeijer 
 * @version 1.0
 */
public class Stock {
    
    private String name;
    private String symbol;
    private int quantity;
    private double price;
    private double bookValue;
    private static double commission = 9.99;

    static Scanner scan = new Scanner(System.in);

    /**
     * Create a new Stock object, given the data provided.
     * @param symbolOfStock represents the symbol for the stock object. This is required as the only perameter as it must be specfied beforehand in the even the stock already exists.
     */
    public Stock(String symbolOfStock){
        this.setName();
        this.setSymbol(symbolOfStock);
        this.setquantity();
        this.setPrice();
        this.setBookValue();
    }

    /**
     * Gets the name of this Stock object and returns it as a String.
     * @return Returns the String representing the name for this Stock object.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Prompts the user for a Name for the current Stock object. Scans a line from system.in and sets the current Stock's Name equal to what was read.
     */
    public  void setName() {
        String enteredName;
        do{
            System.out.print("Enter the Name of the stock: ");
            enteredName = scan.nextLine();
        }while(enteredName.isBlank());
        this.name = enteredName;
    }
    
    /**
     * Gets the symbol of this Stock object and returns it as a String.
     * @return Returns a String representing the symbol for this Stock object.
     */
    public String getSymbol(){
        return this.symbol;
    }
    /**
     * Sets the current Stock's symbol equal to what was passed by the param.
     * @param symbolOfStock String passed to method representing the symbol for the current Stock, Sets the current Stock's symbol equal to symbolofStock.
     */
    public void setSymbol(String symbolOfStock) {
        this.symbol = symbolOfStock;
    }
    
    /**
     * Gets the quantity of this Stock object and returns it as an integer.
     * @return Returns an interger representing the symbol for this Stock object.
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Prompts the user for a quantity for the current Stock object. Scans an integer from system.in and sets the current Stock's quantity equal to what was read.
     * <p>
     * Loops  until a valid integer value is entered by the user.
     */
    public void setquantity() {
        boolean isValid = false;
        int tempQuantity;
        System.out.print("Enter the Quantity you would like to buy: ");
        do{
            if(scan.hasNextInt()){
                tempQuantity = scan.nextInt();
                if(tempQuantity <= 0){
                    System.out.print("Sorry: Quantity cannot be negative try again:");
                }
                else{
                    this.quantity = tempQuantity;
                    isValid = true;
                }
            }
            else{
                System.out.print("Sorry: invlid Quantity please try again: ");
                scan.next();
            }
        }while(isValid == false);
    }

    /**
     * Gets the price of this Stock object and returns it as a double.
     * @return Returns a double representing the price for this Stock object.
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Prompts the user for a price for the current Stock object. Scans a double from system.in and sets the current Stock's price equal to what was read.
     * <p>
     * Loops  until a valid double value is entered by the user.
     */
    public void setPrice() {
        boolean isValid = false;
        double tempPrice;
        System.out.print("Enter the price of the stock: ");
        do{
            if(scan.hasNextDouble()){
                tempPrice = scan.nextDouble();
                if(tempPrice <= 0){
                    System.out.print("Sorry: Price cannot be negative try again:");
                }
                else{
                    this.price = tempPrice;
                    isValid = true;
                }
            }
            else{
                System.out.print("Sorry: invlid Price please try again: ");
                scan.next();
            }
        }while(isValid == false);
    }

    /**
     * Gets the book value of this Stock object and returns it as a double.
     * @return Returns a double representing the book value for this Stock object.
     */
    public double getBookValue(){
        return this.bookValue;
    }
    /**
     * Sets the current Stock's book value equal to the result of multiplying the current Stock's price by the quantity and adding the commission fee.
     */
    public void setBookValue() {
        int tempQuantity = getQuantity();
        double tempPrice = getPrice();
        this.bookValue = tempQuantity * tempPrice + commission;
    }

    //buy operations on Stock
    /**
     * Updates the current Stock object's price, quantity, and book value when a buy operation is performed .
     */
    public void buyUpdate(){
        double tempPrice = buyUpdatePrice();
        int tempQuantity = buyUpdateQuantity();
        buyUpdateBookValue(tempPrice, tempQuantity);
    }

    /**
     * Prompts the user for additional quantity for the current Stock object. Scans an integer from system.in and adds what was read to the current Stock's quantity.
     * <p>
     * Loops  until a valid integer value is entered by the user.
     * @return Returns an interger representing the new additional quantity bought.
     */
    public int buyUpdateQuantity(){
        boolean isValid = false;
        int tempQuantity = 0;
        System.out.print("Enter the Quantity you would like to buy: ");
        do{
            if(scan.hasNextInt()){
                tempQuantity = scan.nextInt();
                if(tempQuantity <= 0){
                    System.out.print("Sorry: Quantity cannot be negative try again:");
                }
                else{
                    this.quantity += tempQuantity;
                    isValid = true;
                }
            }
            else{
                System.out.print("Sorry: invlid Quantity please try again: ");
                scan.next();
            }
        }while(isValid == false);
        return tempQuantity;
    }

    /**
     * Prompts the user for a new price for the current Stock object. Scans a double from system.in and sets the current Stock's price equal to what was read.
     * <p>
     * Loops  until a valid double value is entered by the user.
     * @return Returns a double representing the new price the stock was bought at.
     */
    public double buyUpdatePrice(){
        boolean isValid = false;
        double tempPrice = 0;
        System.out.print("Enter the Price of the Stock: ");
        do{
            if(scan.hasNextDouble()){
                tempPrice = scan.nextDouble();
                if(tempPrice <= 0){
                    System.out.print("Sorry: Price cannot be negative try again:");
                }
                else{
                    this.price = tempPrice;
                    isValid = true;
                }
            }
            else{
                System.out.print("Sorry: invlid Price please try again: ");
                scan.next();
            }
        }while(isValid == false);
        return tempPrice;
    }

    /**
     * Updates the current Stock's book value to the result of adding the multiplication of the updated Stock's price by the new quantity and adding the commission fee to the current book value.
     * @param tempPrice Double passed to method representing the new Price for the Stock object.
     * @param tempQuantity Integer passed to method representing the new quantity of the stock being bought.
     */
    public void buyUpdateBookValue(double tempPrice, int tempQuantity){
        double tempBookValue = getBookValue();
        this.bookValue = tempBookValue + ((tempQuantity * tempPrice) + commission);
    }

    //sell operations on Stock
    /**
     * Prompts the user for the quantity of the current Stock object to be sold. Scans an integer from system.in and removes what was read from the current Stock's quantity. 
     * Prints the gain from selling the specified quantity of the Stock object
     * If after selling, the quantity for the current Stock object equals 0, returns 1.
     * If after selling, the quantity for the current Stock object does not equal 0, updates the book value for the current Stock object and returns 0.
     * <p>
     * Loops  until a valid integer value is entered by the user.
     * @return Returns either the interger 0 representing that not all of the Stock object was sold or 1 representing all of the Stock object was sold.
     */
    public int sellUpdateQuantity(){
        boolean isValid = false;
        int tempQuantity = -1;
        double sellValue = 0;
        double gain = 0;
        double tempBookValue = getBookValue();
        double currentPrice = getPrice();
        int currentQuantity = getQuantity();
        System.out.print("Enter the Quantity you would like to sell: ");
        //checking for valid input
        do{
            if(scan.hasNextInt()){
                tempQuantity = scan.nextInt();
                if(tempQuantity <= 0){
                    System.out.print("Sorry: Quantity cannot be negative try again:");
                }
                else if(tempQuantity > currentQuantity){
                    System.out.println("Sorry: Cannot sell more than you currently own try again");
                }
                else{
                    isValid = true;
                }
            }
            else{
                System.out.print("Sorry: invlid Quantity please try again: ");
                scan.next();
            }
        }while(isValid == false);
        //selling the whole stock
        if(tempQuantity == currentQuantity){
            sellValue = currentPrice * tempQuantity - commission;
            gain = sellValue - tempBookValue;
            System.out.printf("You sold all of this stock for a total gain of: $%.2f\n", gain);
            return 1;   //indicating object deletion from arraylist
        }
        //selling only part
        else{
            sellValue = currentPrice * tempQuantity - commission;
            tempBookValue = tempBookValue * (tempQuantity / currentQuantity);
            gain = sellValue - tempBookValue;
            System.out.printf("You sold part of this stock for a total gain of: $%.2f\n", gain);
            //updating bookvalue
            this.bookValue = this.bookValue - tempBookValue;
        }
        this.quantity -= tempQuantity;
        return 0;
    }

    //get gain operation on Stock
    /**
     * Calculates the gain aquired if all currently held Stock objects were sold completely at their current prices.
     * @return Returns a double representing the gain aquired if all currently held Stock objects were sold completely at their current prices.
     */
    public double getGain(){
        int tempQuantity = getQuantity();
        double tempPrice = getPrice();
        double tempBookValue = getBookValue();
        double sellValue = tempPrice * tempQuantity - commission;
        double gain = sellValue - tempBookValue;
        return gain;
    }

    //display stock object
    /**
     * Displays all attributes of the current Stock object.
     */
    public void displayStock(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Stock name: " + getName());
        System.out.println("Stock symbol: " + getSymbol());
        System.out.println("Stock quantity currently owned: " + getQuantity());
        System.out.println("stock price per unit: $" + getPrice());
        System.out.println("Stock book value: $" + getBookValue());
        System.out.println("----------------------------------------------------------");
    }
}
