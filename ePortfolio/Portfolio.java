package bturnert_a1.ePortfolio;

import java.util.Scanner;
import java.util.ArrayList;

public class Portfolio {

    private static String symbol;

    static Scanner scan = new Scanner(System.in);

    static ArrayList <Stock> stockInvestments = new ArrayList <Stock>();
    static ArrayList <MutualFund> mutualFundInvestments = new ArrayList <MutualFund>();

    //display the menu
    /**
     * Displays the command loop option menu; with options for buy, sell, update, getGain, search, and quit.
     */
    private static void dispalyMenu(){
        System.out.println("============================================MENU============================================");
        System.out.println("Options:");
        System.out.println("1) buy:        make a new investment or add to an existing one");
        System.out.println("2) sell:       sell all or part of an exisitng invesment");
        System.out.println("3) update:     refresh the invesment prices");
        System.out.println("4) getGain:    view total gain if all existing investments were sold at their current prices");
        System.out.println("5) search:     find all investments matching search request");
        System.out.println("6) quit:       end the program");
        System.out.println("============================================================================================");
    }
    //get command loop choice
    /**
     * Prompts the user to enter an option from the menu. Checks the entered string against the possible valid entires and returns a different intger based on what the entered string matched with.
     * Possible integeres include: 0 == unset, 1 == buy, 2 == sell, 3 == update, 4 == getaGain, 5 == search, and 6 == quit.
     * <p>
     * Loops until a valid String is entered by the user.
     * @return Returns a value from 0 to 6 indicating the user's operation choice from the menu's options.
     */
    private static int getCommandLoopOption(){
        int menuOption = 0; // 0 = unset, 1 = buy, 2 = sell, 3 = update, 4 = getGain, 5 = search, 6 = exit
        boolean isValid = false;
        String[] validInputBuy = {"buy", "B", "1"};
        String[] validInputSell = {"sell", "S", "2"};
        String[] validInputUpdate = {"update", "U", "3"};
        String[] validInputGetGain = {"getGain", "getGains", "get", "gain", "GG", "G", "4"};
        String[] validInputSearch = {"search", "SCH", "SH", "5"};
        String[] validInputQuit = {"quit", "Q", "6"};

        System.out.print("Choose option: ");
        String commandLoopInput = scan.nextLine();

        do{
            for(String temp: validInputBuy){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 1;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            for(String temp: validInputSell){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 2;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            for(String temp: validInputUpdate){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 3;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            for(String temp: validInputGetGain){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 4;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            for(String temp: validInputSearch){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 5;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            for(String temp: validInputQuit){
                if(commandLoopInput.equalsIgnoreCase(temp)){
                    menuOption = 6;
                    isValid = true;
                }
            }
            if(isValid == true){
                break;
            }
            else{
                System.out.println("Sorry: Choice not recognized, try again");
                System.out.print("Choose menu option: ");
                commandLoopInput = scan.nextLine();
            }
        }while(isValid == false);

        return menuOption;
    }
    //check if Stock ArrayList is empty
    /**
     * Checks if the Stock ArrayList is empty or not, returning a boolean value representing if the list is empty or not.
     * @return Returns either true if the ArrayList is empty or false if it is not empty.
     */
    private static boolean stockIsEmpty(){
        boolean isEmpty = false;
        if(stockInvestments.isEmpty()){
            isEmpty = true;
        }
        return isEmpty;
    }
    //check if MutualFund ArrayList is empty
    /**
     * Checks if the MutualFund ArrayList is empty or not, returning a boolean value representing if the list is empty or not.
     * @return Returns either true if the ArrayList is empty or false if it is not empty.
     */
    private static boolean mutualFundIsEmpty(){
        boolean isEmpty = false;
        if(mutualFundInvestments.isEmpty()){
            isEmpty = true;
        }
        return isEmpty;
    }
    //get investment type
    /**
     * Prompts the user to choose an option from the displayed sub menu. Checks the entered string against the possible valid entires and returns a different intger based on what the entered string matched with.
     * Possible integeres include: 0 == unset, 1 == Stock, 2 == MutualFund.
     * <p>
     * Loops until a valid String is entered by the user.
     * @return Returns a value from 0 to 2 indicating the user's choice from the sub menu's options.
     */
    private  static int getInvestmentType(){
        int type = 0; // 0 = unset, 1 = stock, 2 = mutual fund
        boolean isValid = false;
        String[] validInputsStock = {"Stock", "S", "1"};
        String[] validInputMututalFund = {"Mutual Fund", "MutualFund", "Mutual", "Fund", "MF", "M", "F", "2"};

        System.out.println("=====================================Invetestment Types=====================================");
        System.out.println("1) Stock");
        System.out.println("2) Mutual Fund");
        System.out.println("============================================================================================");
        System.out.print("Choose investment type: ");
        String investmentType = scan.nextLine();
        
        do{
            for(String temp: validInputsStock){
                if(investmentType.equalsIgnoreCase(temp)){
                    type = 1;
                    isValid = true;
                }
            }
            for(String temp: validInputMututalFund){
                if(investmentType.equalsIgnoreCase(temp)){
                    type = 2;
                    isValid = true;
                }
            }
            if(isValid == false){
                System.out.println("Sorry: Investment type not recognized, try again");
                System.out.print("Choose investment type: ");
                investmentType = scan.nextLine();
            }
        }while(isValid == false);

        return type;
    }
    //enter symbol
    /**
     * Prompts the user to enter a String representing the symbol for either a Stock object or a MutualFund object.
     */
    private static void enterSymbol(){
        System.out.print("Enter the Symbol representing the investment: ");
        symbol = scan.nextLine();
    }
    //check if symbol is in stockInvestments
    /**
     * Iterates trhough all Stock objects in the Stock ArrayList. Checks if the symbol matches symbol in the current Stock object. Returning the position in the ArrayList if found.
     * @return Returns an integer representing  either -1 if the symbol is not found in any of the Stock objects, or if found in the ArrayList indicating the position in the Stock ArrayList where the symbol was matched. 
     */
    private static int inStockInvestments(){
        int counter = 0;
        for(Stock temp: stockInvestments){
            if(temp.getSymbol().equalsIgnoreCase(symbol)){ 
                return counter;
            }
            counter++;
        }
        return -1; // not in list
    }
    //check if symbol is in MutualFundInvestments
    /**
     * Iterates trhough all MutualFund objects in the MutualFund ArrayList. Checks if the symbol matches symbol in the current MutualFund object. Returning the position in the ArrayList if found.
     * @return Returns an integer representing  either -1 if the symbol is not found in any of the MutualFund objects, or if found in the ArrayList indicating the position in the MutualFund ArrayList where the symbol was matched. 
     */
    private static int inMutualFunds(){
        int counter = 0;
        for(MutualFund temp: mutualFundInvestments){
            if(temp.getSymbol().equalsIgnoreCase(symbol)){ 
                return counter;
            }
            counter++;
        }
        return -1; // not in list
    }
    //search keywords
    /**
     * Scans a line from system.in and stores it as a string.
     * @return Returns a String representing the line that was read.
     */
    private static String searchWord(){
        String searchWord = scan.nextLine();
        return searchWord;
    }
    //get priceRange
    /**
     * Checks if the entered range is valid.
     * @param enteredRange String passed to method representing the range for the search method entered by the user. 
     * @return Returns either true indicating the range is valid or false indicating the range passed is invalid.
     */
    private static boolean validRange(String enteredRange){
        if(enteredRange.isBlank()){
            return true;
        }
        else if(enteredRange.contains("-")){
            return true;
        }
        else{
            return false;
        }
    }

    //buy operation
    /**
     * Creates Stock and MutualFund objects and adds them to their associated ArrayLists. 
     * <p>
     * Alternatively increases the varaibles in pre-existing Stock and MutualFund objects found in their associated ArrayLists.
     */
    private static void buy(){
        int investmentType = getInvestmentType();
        enterSymbol();
        int stockLocation = inStockInvestments();
        int mutualFundLocation = inMutualFunds();
        //if the investmetnt does not already exist creating a new investment
        if(stockLocation == -1 && mutualFundLocation == -1){
            //new Stock investment
            if(investmentType == 1){
                System.out.println("New Stock investment:");
                Stock newStock = new Stock(symbol);
                stockInvestments.add(newStock);
            }
            //new Mutual Fund investment
            else if(investmentType == 2){
                System.out.println("New Mutual Fund investment:");
                MutualFund newMutualFund = new MutualFund(symbol);
                mutualFundInvestments.add(newMutualFund);
            }
            //getInvestmentType did not work properly
            else{
                System.out.println("program is broken, did not read investment type properly, investment type = " + investmentType);
            }
        }
        //if the investment does exist retreiving the investment from the proper arrayList
        //found in stockInvestments ArrayList
        else if(stockLocation > -1){
            //is an exisitng Stock investment
            if(investmentType == 1){
                Stock existingStock = stockInvestments.get(stockLocation);
                System.out.println("Buying more " + existingStock.getName() + " Stock:");
                existingStock.buyUpdate();
                stockInvestments.set(stockLocation, existingStock);
            }
            //was found in stock arraylist but was specified as a mutual fund investment
            else if(investmentType == 2){
                System.out.println("Sorry, you are trying to buy a stock investment with the symbol: "+ symbol);
                System.out.println("This symbol has already been used to specify an existing mutual fund investment.");
                System.out.println("No two investments may be represented by the same symbol.");
                System.out.println("Aborting buy operation, please try again");
            }
            //getInvestmentType did not work properly
            else{
                System.out.println("program is broken, did not read investment type properly, investment type = " + investmentType);
            }
        }
        //found in mutualFundInvestments
        else if(mutualFundLocation > -1){
            //was found in mutualFund arraylist but was specified as stock stock investment
            if(investmentType == 1){
                System.out.println("Sorry, you are trying to buy a mutual fund investment with the symbol: "+ symbol);
                System.out.println("This symbol has already been used to specify an existing stock investment.");
                System.out.println("No two investments may be represented by the same symbol.");
                System.out.println("Aborting buy operation, please try again");
            }
            //is an exisitng Mutual Fund investment
            else if(investmentType == 2){
                MutualFund existingMutualFund = mutualFundInvestments.get(mutualFundLocation);
                System.out.println("Buying more of the " + existingMutualFund.getName() + " Mutual Fund:");
                existingMutualFund.buyUpdate();
                mutualFundInvestments.set(mutualFundLocation, existingMutualFund);
            }
            //getInvestmentType did not work properly
            else{
                System.out.println("program is broken, did not read investment type properly, investment type = " + investmentType);
            }
        }

    }

    //sell operation
    /**
     * Deletes pre-existing Stock and MutualFund objects form their associated ArrayLists.
     * <p>
     * Alternatively lowers the variables in pre-existing Stock and MutualFund objects found in their associated ArrayLists.
     */
    private static void sell(){
        boolean isEmptyStock = stockIsEmpty();
        boolean isEmptyMutualFund = mutualFundIsEmpty();
        //checking if there are investments that can be sold
        if(isEmptyStock == true && isEmptyMutualFund == true){
            System.out.println("Error: Cannot sell any investments at this time as you current have none");
            return;
        }

        enterSymbol();
        int remove = 0;
        int stockLocation = inStockInvestments();
        int mutualFundLocation = inMutualFunds();
        //symbol is not found in either list
        if(stockLocation == -1 && mutualFundLocation == -1){
            System.out.println("Error: Cannot sell specified investment as it does not currently exist");
        }
        //symbol is found in stockInestments
        else if(stockLocation > -1){
            Stock stockForSale = stockInvestments.get(stockLocation);
            System.out.println("selling " + stockForSale.getName() + " Stock:");
            stockForSale.setPrice();
            remove = stockForSale.sellUpdateQuantity();
            if(remove == 1){
                stockInvestments.remove(stockLocation);
            }
        }
        //symbol is found in mutualFundInvestments
        else if(mutualFundLocation > -1){
            MutualFund mutualFundForSale = mutualFundInvestments.get(mutualFundLocation);
            System.out.println("selling " + mutualFundForSale.getName() + " Mutual Fund:");
            mutualFundForSale.setPrice();
            remove = mutualFundForSale.sellUpdateQuantity();
            if(remove == 1){
                mutualFundInvestments.remove(mutualFundLocation);
            }
        }

    }

    //update oepration
    /**
     * Updates the Price associated with pre-existing Stock and MutualFund objects found in their associated ArrayLists.
     */
    private static void update(){
        boolean isEmptyStock = stockIsEmpty();
        boolean isEmptyMutualFund = mutualFundIsEmpty();
        //checking if there are investments that can be updated
        if(isEmptyStock == true && isEmptyMutualFund == true){
            System.out.println("Error: Cannot update any investments at this time as you current have none");
            return;
        }

        double price;
        for(Stock currentStock: stockInvestments){
            System.out.println("Updating " + currentStock.getName() + " stock price:");
            price = currentStock.buyUpdatePrice();
            System.out.printf("%s updated to $%.2f per unit\n", currentStock.getName(), price);
        }
        for(MutualFund currentMutualFund: mutualFundInvestments){
            System.out.println("Updating " + currentMutualFund.getName() + " mutual fund price:");
            price = currentMutualFund.buyUpdatePrice();
            System.out.printf("%s updated to $%.2f per unit\n", currentMutualFund.getName(), price);
        }
    }

    //getGains operation
    /**
     * Outputs the theoretical gain that could be obtained by the user if they completely sold all Stock and MutualFund investments in their portfolio at their current prices.
     */
    private static void getGain(){
        boolean isEmptyStock = stockIsEmpty();
        boolean isEmptyMutualFund = mutualFundIsEmpty();
        //checking if there are investments
        if(isEmptyStock == true && isEmptyMutualFund == true){
            System.out.println("Error: Cannot get gain of investments at this time as you current have none");
            return;
        }

        double totalGain = 0;
        double individualGain = 0;
        for(Stock currentStock: stockInvestments){
            individualGain = currentStock.getGain();
            totalGain += individualGain;
        }
        for(MutualFund currentMutualFund: mutualFundInvestments){
            individualGain = currentMutualFund.getGain();
            totalGain += individualGain;
        }
        System.out.println("Current gain if all held investments were sold at their current prices:");
        System.out.printf("Gain = $%.2f\n", totalGain);

    }

    //search operation
    /**
     * Searches the Stock and MutualFund Arraylists for specific objects based on three search paramiters. Paramiters are as follows: 1) symbol 2) key words 3) a price range.
     * Prints all objects that meet search requirements and  does not print thosee that do not. 
     */
    private static void search(){
        boolean isEmptyStock = stockIsEmpty();
        boolean isEmptyMutualFund = mutualFundIsEmpty();
        //checking if there are investments
        if(isEmptyStock == true && isEmptyMutualFund == true){
            System.out.println("Error: Cannot search for any investments at this time as you current have none");
            return;
        }

        //getting search options
        boolean isValid = false;
        String searchSymbol, searchKeyWord, searchPriceRange;
        System.out.println("You many use up to three search specifiers: a symbol, key word(s), and price range.");
        System.out.println("Enter: search specifications, if you do not wish to use a specifier leave it blank:");
        System.out.print("1) Enter the symbol to search for:");
        searchSymbol = searchWord();
        System.out.print("2) Enter the key word(s) to search for:");
        searchKeyWord = searchWord();
        System.out.print("3) Enter the price range to search for:");
        do{
            searchPriceRange = searchWord();
            isValid = validRange(searchPriceRange);
            if(isValid == false){
                System.out.println("Sorry the entered price range was invalid.");
                System.out.println("Make sure you input contains a dash and at least one number or is left blank. Example: 100-20000");
                System.out.print("Enter the price range to search for:");
            }
        }while(isValid == false);
        
        double min = -1;
        double max = -1;
        //parsing the search range if it is not empty
        if(!searchPriceRange.isBlank()){
            searchPriceRange = searchPriceRange.trim();
            Scanner splitRange = new Scanner(searchPriceRange);
            //max range only
            if(searchPriceRange.indexOf("-") == 0){
                searchPriceRange = searchPriceRange.replace("-", "");
                if(splitRange.hasNextDouble()){
                    max = splitRange.nextDouble();
                }
            }
            //min range only
            else if(searchPriceRange.indexOf("-") == searchPriceRange.length() - 1){
                searchPriceRange = searchPriceRange.replace("-", "");
                if(splitRange.hasNextDouble()){
                    min = splitRange.nextDouble();
                }

            }
            //min and max range
            else{
                searchPriceRange = searchPriceRange.replace("-", " ");
                if(splitRange.hasNextDouble()){
                    min = splitRange.nextDouble();
                }
                if(splitRange.hasNextDouble()){
                    max = splitRange.nextDouble();
                }
            }
            splitRange.close();
        }

        //loop to display all Stock metting search criteria
        for(Stock temp: stockInvestments){
            //case no search specifiers were entered
            if(searchSymbol.isBlank() && searchKeyWord.isBlank() && searchPriceRange.isBlank()){
                temp.displayStock();
            }
            //case symbol match
            else if(temp.getSymbol().equalsIgnoreCase(searchSymbol) && searchKeyWord.isBlank() && searchPriceRange.isBlank()){
                temp.displayStock();
            }
            //case search keyword match
            else if(searchSymbol.isBlank() && temp.getName().contains(searchKeyWord) && searchPriceRange.isBlank()){
                temp.displayStock();
            }
            //case entered a min and a max
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() &&  min != -1 && max != -1){
                if(temp.getPrice() > min && temp.getPrice() < max){
                    temp.displayStock();
                }
            }
            //case entered a min
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() && min != -1 && max == -1){
                if(temp.getPrice() > min){
                    temp.displayStock();
                }
            }
            //case entered a max
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() && min == -1 && max != -1){
                if(temp.getPrice() < max){
                    temp.displayStock();
                }
            }
            //case symbol and key word match
            else if(temp.getSymbol().equalsIgnoreCase(searchSymbol) && temp.getName().contains(searchKeyWord) && searchPriceRange.isBlank()){
                temp.displayStock();
            }

        }
        for(MutualFund temp: mutualFundInvestments){
            //case no search specifiers were entered
            if(searchSymbol.isBlank() && searchKeyWord.isBlank() && searchPriceRange.isBlank()){
                temp.displayMutualFund();
            }
            //case symbol match
            else if(temp.getSymbol().equalsIgnoreCase(searchSymbol) && searchKeyWord.isBlank() && searchPriceRange.isBlank()){
                temp.displayMutualFund();
            }
            //case search keyword match
            else if(searchSymbol.isBlank() && temp.getName().contains(searchKeyWord) && searchPriceRange.isBlank()){
                temp.displayMutualFund();
            }
            //case entered a min and a max
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() && min != -1 && max != -1){
                if(temp.getPrice() > min && temp.getPrice() < max){
                    temp.displayMutualFund();
                }
            }
            //case entered a min
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() && min != -1 && max == -1){
                if(temp.getPrice() > min){
                    temp.displayMutualFund();
                }
            }
            //case entered a max
            else if(searchSymbol.isBlank() && searchKeyWord.isBlank() && min == -1 && max != -1){
                if(temp.getPrice() < max){
                    temp.displayMutualFund();
                }
            }
            //case symbol and key word match
            else if(temp.getSymbol().equalsIgnoreCase(searchSymbol) && temp.getName().contains(searchKeyWord) && searchPriceRange.isBlank()){
                temp.displayMutualFund();
            }

        }
    }

 /**
  * Runs the ePortfolio program loop until such a time as the exit condition is entered.
  * @param args
  */
    public static void main(String[] args){
        int menuOption = 0;
        while(menuOption != 6){
            
            dispalyMenu();
            menuOption = getCommandLoopOption();
            switch(menuOption){
                case 1:
                    buy();
                    break;
                case 2:
                    sell();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    getGain();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    //ends the program
                    System.out.println("closing Program");
                    break;
            }
        }
    }
}
