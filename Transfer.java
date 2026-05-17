import java.util.Scanner;
import java.util.ArrayList;

public class Transfer {

  // **** Sets up our arrays, do not edit  ****
  Setup setup = new Setup();
  Food[] foodArray = setup.getFoodArray();
  Parts[] partsArray = setup.getPartsArray();
  Supplies[] suppliesArray = setup.getSuppliesArray();
  // **** Sets up our arrays, do not edit ****


  /* STEP 1 */
  ArrayList<Food> foodList = new ArrayList<>();
  ArrayList<Parts> partsList = new ArrayList<>();
  ArrayList<Supplies> suppliesList = new ArrayList<>();


  /* STEP 4 */
  Inventory<Food> foodInventory;
  Inventory<Parts> partsInventory;
  Inventory<Supplies> suppliesInventory;


  public Transfer() {

    // transfer arrays → ArrayLists
    for (Food f : foodArray) {
      foodList.add(f);
    }

    for (Parts p : partsArray) {
      partsList.add(p);
    }

    for (Supplies s : suppliesArray) {
      suppliesList.add(s);
    }

    // create Inventory objects
    foodInventory = new Inventory<>(foodList);
    partsInventory = new Inventory<>(partsList);
    suppliesInventory = new Inventory<>(suppliesList);
  }


  public void addItems(int listNumber) {

    Scanner keyboard = new Scanner(System.in);

    if(listNumber == 1) {

      System.out.print("Food name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Perishable? (T/F): ");
      boolean perishable = keyboard.nextLine().substring(0,1).equalsIgnoreCase("T");

      Food newFoodItem = new Food(name, qty, perishable);
      foodList.add(newFoodItem);
      System.out.println("Added to food list");

    }
    else if(listNumber == 2) {

      System.out.print("Part name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      System.out.print("Part Number (5-digit) : ");
      int pn = keyboard.nextInt();

      Parts newPartsItem = new Parts(name, qty, pn);
      partsList.add(newPartsItem);
      System.out.println("Added to parts list");

    }
    else {

      System.out.print("Supplies name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();

      Supplies newSuppliesItem = new Supplies(name, qty);
      suppliesList.add(newSuppliesItem);
      System.out.println("Added to supplies list");
    }
  }


  public void removeItems(int listNumber) {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("\nName of Item to be Removed: ");
    String name = keyboard.nextLine();

    if(listNumber == 1) {

      int index = foodInventory.searchByName(foodList, name);
      foodList.remove(index);

    }
    else if(listNumber == 2) {

      int index = partsInventory.searchByName(partsList, name);
      partsList.remove(index);

    }
    else {

      int index = suppliesInventory.searchByName(suppliesList, name);
      suppliesList.remove(index);
    }
  }


  public void editQuantity(int listNumber) {

    Scanner keyboard = new Scanner(System.in);
    System.out.println("\nName of Item to Edit: ");
    String name = keyboard.nextLine();
    System.out.println("Desired Quantity: ");
    int desiredQty = keyboard.nextInt();

    if(listNumber == 1) {

      foodInventory.checkQty(foodList, name, desiredQty);

    }
    else if(listNumber == 2) {

      partsInventory.checkQty(partsList, name, desiredQty);

    }
    else {

      suppliesInventory.checkQty(suppliesList, name, desiredQty);

    }
  }


  // PRINT LISTS (UNCOMMENTED AS REQUIRED)
  public void printLists() {

    System.out.println("\n");

    if(foodList.isEmpty() && partsList.isEmpty() && suppliesList.isEmpty()) {
      System.out.printf("\n%19s", "No objects found in lists.");
    }

    if(!foodList.isEmpty()) {
      System.out.printf("\n\n%s", "FOOD");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Perishable", "Qty");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < foodList.size(); i++) {
        Food tempFood = foodList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                tempFood.getName(),
                tempFood.getPerishable(),
                tempFood.getQuantity());
      }
    }

    if(!partsList.isEmpty()) {
      System.out.printf("\n\n%s", "PARTS");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "PN", "Qty");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < partsList.size(); i++) {
        Parts tempPart = partsList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                tempPart.getName(),
                tempPart.getPartNumber(),
                tempPart.getQuantity());
      }
    }

    if(!suppliesList.isEmpty()) {
      System.out.printf("\n\n%s", "SUPPLIES");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Qty", "");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < suppliesList.size(); i++) {
        Supplies tempSupplies = suppliesList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                tempSupplies.getName(),
                tempSupplies.getQuantity(),
                "");
      }
    }
  }
}
