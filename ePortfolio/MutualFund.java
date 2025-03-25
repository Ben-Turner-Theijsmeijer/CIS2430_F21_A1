package bturnert_a1.ePortfolio;

import java.util.Scanner;

/**
 * This class creates and edits objects of type MutualFund.
 * <p> 
 * MutualFund contains inforamtion on a MutualFund's name, symbol, price, quantity, and book value
 *
 * @author Ben Turner-Theijsmeijer 
 * @version 1.0
 */
public class MutualFund {
    
    private String name;
    private String symbol;
    private int quantity;
    private double price;
    private double bookValue;
    private static int redemtionFee = 45;

    static Scanner scan = new Scanner(System.in);

    /**
     * Create a new MutualFund object, given the data provided.
     * @param symbolOfMutualFund represents the symbol for the MutualFund object. This is required as the only perameter as it must be specfied beforehand in the even the MutualFund already exists.
     */
    public MutualFund(String symbolOfMutualFund){
        this.setName();
        this.setSymbol(symbolOfMutualFund);
        this.setquantity();
        this.setPrice();
        this.setBookValue();
    }

    /**
     * Gets the name of this MutualFund object and returns it as a String.
     * @return Returns the String representing the name for this MutualFund object.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Prompts the user for a Name for the current MutualFund object. Scans a line from system.in and sets the current MutualFund's Name equal to what was read.
     */
    public void setName() {
        String enteredName;
        do{
            System.out.print("Enter the Name of the mutual fund: ");
            enteredName = scan.nextLine();
        }while(enteredName.isBlank());
        this.name = enteredName;
    }

    /**
     * Gets the symbol of this MutualFund object and returns it as a String.
     * @return Returns a String representing the symbol for this MutualFund object.
     */
    public String getSymbol(){
        return this.symbol;
    }
    /**
     * Sets the current MutualFund's symbol equal to what was passed by the param.
     * @param symbolOfMutualFund String passed to method representing the symbol for the current MutualFund, Sets the current MutualFund's symbol equal to symbolofMutualFund.
     */
    public void setSymbol(String symbolOfMutualFund) {
        this.symbol = symbolOfMutualFund;
    }

    /**
     * Gets the quantity of this MutualFund object and returns it as an integer.
     * @return Returns an interger representing the symbol for this MutualFund object.
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Prompts the user for a quantity for the current MutualFund object. Scans an integer from system.in and sets the current MutualFund's quantity equal to what was read.
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
     * Gets the price of this MutualFund object and returns it as a double.
     * @return Returns a double representing the price for this MutualFund object.
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Prompts the user for a price for the current MutualFund object. Scans a double from system.in and sets the current MutualFund's price equal to what was read.
     * <p>
     * Loops  until a valid double value is entered by the user.
     */
    public void setPrice() {
        boolean isValid = false;
        double tempPrice;
        System.out.print("Enter the Price of the mutual fund: ");
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
     * Gets the book value of this MutualFund object and returns it as a double.
     * @return Returns a double representing the book value for this MutualFund object.
     */
    public double getBookValue(){
        return this.bookValue;
    }
    /**
     * Sets the current MutualFund's book value equal to the result of multiplying the current MutualFund's price by the quantity and adding the commission fee.
     */
    public void setBookValue() {
        int tempQuantity = getQuantity();
        double tempPrice = getPrice();
        this.bookValue = tempQuantity * tempPrice;
    }

    //buy operations on MutualFund
    /**
     * Updates the current MutualFund object's price, quantity, and book value when a buy operation is performed .
     */
    public void buyUpdate(){
        double tempPrice = buyUpdatePrice();
        int tempQuantity = buyUpdateQuantity();
        buyUpdateBookValue(tempPrice, tempQuantity);
    }

    /**
     * Prompts the user for additional quantity for the current MutualFund object. Scans an integer from system.in and adds what was read to the current MutualFund's quantity.
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
     * Prompts the user for a new price for the current MutualFund object. Scans a double from system.in and sets the current MutualFund's price equal to what was read.
     * <p>
     * Loops  until a valid double value is entered by the user.
     * @return Returns a double representing the new price the MutualFund was bought at.
     */
    public double buyUpdatePrice(){
        boolean isValid = false;
        double tempPrice = 0;
        System.out.print("Enter the Price of the Mutual Fund: ");
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
     * Updates the current MutualFund's book value to the result of adding the multiplication of the updated MutualFund's price by the new quantity and adding the commission fee to the current book value.
     * @param tempPrice Double passed to method representing the new Price for the MutualFund object.
     * @param tempQuantity Integer passed to method representing the new quantity of the MutualFund being bought.
     */
    public void buyUpdateBookValue(double tempPrice, int tempQuantity){
        double tempBookValue = getBookValue();
        this.bookValue = tempBookValue + (tempQuantity * tempPrice);
    }

    //sell operations on MutualFund
    /**
     * Prompts the user for the quantity of the current MutualFund object to be sold. Scans an integer from system.in and removes what was read from the current MutualFund's quantity. 
     * Prints the gain from selling the specified quantity of the MutualFund object
     * If after selling, the quantity for the current MutualFund object equals 0, returns 1.
     * If after selling, the quantity for the current MutualFund object does not equal 0, updates the book value for the current MutualFund object and returns 0.
     * <p>
     * Loops  until a valid integer value is entered by the user.
     * @return Returns either the interger 0 representing that not all of the MutualFund object was sold or 1 representing all of the MutualFund object was sold.
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
        //selling the whole mutual fund
        if(tempQuantity == currentQuantity){
            sellValue = currentPrice * tempQuantity - redemtionFee;
            gain = sellValue - tempBookValue;
            System.out.printf("You sold all of this mutual fund for a total gain of: $%.2f\n", gain);
            return 1;   //indicating object deletion from arraylist
        }
        //selling only part
        else{
            sellValue = currentPrice * tempQuantity - redemtionFee;
            tempBookValue = tempBookValue * (tempQuantity / currentQuantity);
            gain = sellValue - tempBookValue;
            System.out.printf("You sold part of this mutual fund for a total gain of: $%.2f\n", gain);
            //updating bookvalue
            this.bookValue = this.bookValue - tempBookValue;
        }
        this.quantity -= tempQuantity;
        return 0;
    }

    //get gain operation on MutualFund
    /**
     * Calculates the gain aquired if all currently held MutualFund objects were sold completely at their current prices.
     * @return Returns a double representing the gain aquired if all currently held MutualFund objects were sold completely at their current prices.
     */
    public double getGain(){
        int tempQuantity = getQuantity();
        double tempPrice = getPrice();
        double tempBookValue = getBookValue();
        double sellValue = tempPrice * tempQuantity - redemtionFee;
        double gain = sellValue - tempBookValue;
        return gain;
    }

    //display mutual fund object
    /**
     * Displays all attributes of the current MutualFund object.
     */
    public void displayMutualFund(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Mutual Fund name: " + getName());
        System.out.println("Mutual Fund symbol: " + getSymbol());
        System.out.println("Mutual Fund quantity currently owned: " + getQuantity());
        System.out.println("Mutual Fund price per unit: $" + getPrice());
        System.out.println("Mutual Fund book value: $" + getBookValue());
        System.out.println("----------------------------------------------------------");
    }
}
