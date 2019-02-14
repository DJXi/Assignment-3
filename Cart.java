package com.mcfarevee.shopping;

// import packages
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.NonFood;

// class Cart
public class Cart {
  //field
  int numThings;
  int numEntries;
  int price;
  int weightArray[] = {0, 0, 0, 0}; // the first is pound, second is ounce, third is kilogram and the fourth is gram
  List<Item> items;
  // Constructor
  public Cart() {
    numThings = 0;
    numEntries = 0;
    price = 0;
    items = new ArrayList<Item>();
  }
  //Method addItemm, take item as a parameter and add this item into cart
  public void addItem(Item item) {
    // numEntries increment by 1 if one item is added to the cart
    this.numEntries++;
    // numThings increment by 1 if one BulkItem is added and by amount if Manypackages are added
    if (item instanceof ManyPackages) {
      ManyPackages mp = (ManyPackages) item;
      numThings += mp.getAmount();
    } else {
      this.numThings++;
    }
    // price increment by the price of item
    this.price += item.getPrice();
    // Get the item's weight
    if (item.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
      weightArray[0] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
      weightArray[1] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
      weightArray[2] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
      weightArray[3] += item.getWeight().getAmount();
    }
    // add it to the arrayList of items
    this.items.add(item);
  }
  // the method to remove all the items with the same name
  public void remove(String name) {
    for (int i = 0; i < numEntries; i++) {
      int counter1 = 0; // counter for numEntries
      int counter2 = 0; // counter for numThings
      int counter3 = 0; // counter for price
     
      if (items.get(i) instanceof ManyPackages) {
        ManyPackages mp = (ManyPackages) items.get(i);
        if (mp.pack.name.equalsIgnoreCase(name)) {
          counter1++;
          counter2 += mp.getAmount();
          counter3 += mp.getPrice();
          if (mp.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
            weightArray[0] -= mp.getWeight().getAmount();
          } else if (mp.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
            weightArray[1] -= mp.getWeight().getAmount();
          } else if (mp.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
            weightArray[2] -= mp.getWeight().getAmount();
          } else if (mp.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
            weightArray[3] -= mp.getWeight().getAmount();
          }
          items.remove(i);
          i--;
        } // check if a ManyPackages object needs to be removed
      } else if (items.get(i) instanceof Package) {
        Package p = (Package) items.get(i);
        if (p.name.equalsIgnoreCase(name)) {
          counter1++;
          counter2++;
          counter3 += p.getPrice();
          if (p.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
            weightArray[0] -= p.getWeight().getAmount();
          } else if (p.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
            weightArray[1] -= p.getWeight().getAmount();
          } else if (p.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
            weightArray[2] -= p.getWeight().getAmount();
          } else if (p.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
            weightArray[3] -= p.getWeight().getAmount();
          }
          items.remove(i);
          i--;
        } // check if a Package object needs to be removed
      } else if (items.get(i) instanceof BulkItem) {
        BulkItem bi = (BulkItem) items.get(i);
        if (bi.food.name.equalsIgnoreCase(name)) {
          counter1++;
          counter2++;
          counter3 += bi.getPrice();
          if (bi.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
            weightArray[0] -= bi.getWeight().getAmount();
          } else if (bi.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
            weightArray[1] -= bi.getWeight().getAmount();
          } else if (bi.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
            weightArray[2] -= bi.getWeight().getAmount();
          } else if (bi.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
            weightArray[3] -= bi.getWeight().getAmount();
          }
          items.remove(i);
          i--;
        } // check if a BulkItem object needs to be removed 
      } else if (items.get(i) instanceof NonFood) {
        NonFood nf = (NonFood) items.get(i);
        if (nf.name.equalsIgnoreCase(name)) {
          counter1++;
          counter2++;
          counter3 += nf.getPrice();
          if (nf.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
            weightArray[0] -= nf.getWeight().getAmount();
          } else if (nf.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
            weightArray[1] -= nf.getWeight().getAmount();
          } else if (nf.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
            weightArray[2] -= nf.getWeight().getAmount();
          } else if (nf.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
            weightArray[3] -= nf.getWeight().getAmount();
          }
          items.remove(i);
          i--;
        } // check if a NonFood object needs to be removed
      } // for loop
      this.numEntries -= counter1;
      this.numThings -= counter2;
      this.price -= counter3;
    }
  }
  // method of getting the number of things in the cart
  public int numThings() {
    return numThings;
  }
  // method of getting the number of entries in the cart
  public int numEntries() {
    return numEntries;
  }
  // method of printing the content of the cart 
  public void printContents(PrintWriter pen) {
    for (int i = 0; i < numEntries; i++) {
      pen.println(items.get(i).toString());
    }

  }
  // method of getting the total price of the cart
  public int getPrice() {
    return price;
  }
  // method of getting the total weight of the cart
  public int[] getWeight() {
    return weightArray;
  }
  // method of merging same items
  public void merge() {
    for (int i = 0; i < numEntries; i++) {
      if (items.get(i) instanceof Package) {
        Package p = (Package) items.get(i);
        for (int j = i + 1; j < numEntries;j++) {
          if (items.get(j) instanceof Package) {
            Package otherP = (Package) items.get(j);
            if (otherP.equals(p)) {
              this.items.add(new ManyPackages (p, 2));
              this.items.remove(j);
              this.items.remove(i);
              this.numEntries--;
            }              
          } else if (items.get(j) instanceof ManyPackages) {
            ManyPackages otherMp = (ManyPackages) items.get(j);
            if (otherMp.pack.equals(p)) {
              otherMp.amount++;
              items.set(j, otherMp);
              items.remove(i);
              this.numEntries--;
            }              
          }
        } // the case when Package object has duplicates of Package or ManyPackages objects
      } else if (items.get(i) instanceof ManyPackages) {
        ManyPackages mp = (ManyPackages) items.get(i);
        for (int j = i + 1; j < numEntries;j++) {
          if (items.get(j) instanceof Package) {
            Package otherP = (Package) items.get(j);
            if (otherP.equals(mp.pack)) {
              mp.amount++;
              items.set(i, mp);
              items.remove(j);
              this.numEntries--;
            }              
          } else if (items.get(j) instanceof ManyPackages) {
            ManyPackages otherMp = (ManyPackages) items.get(j);
            if (otherMp.equals(mp)) {
              otherMp.amount += mp.amount;
              items.set(j, otherMp);
              items.remove(i);
              this.numEntries--;
            }              
          }
        } // the case when ManyPackages object has duplicates of Package or ManyPackages objects
      } else if (items.get(i) instanceof BulkItem) {
        BulkItem bi = (BulkItem) items.get(i);
        for (int j = i + 1; j < numEntries; j++) {
          if (items.get(j) instanceof BulkItem) {
            BulkItem otherBi = (BulkItem) items.get(j);
            if (otherBi.equals(bi)) {
              bi.amount += otherBi.amount;
              items.set(i, bi);
              items.remove(j);
              this.numEntries--;
              this.numThings--;
            }
          }
        }
      } // the case when BulkItem obejct has duplicates of BulkItem objects
    } // for loop
  } // method merge
} // Cart class
