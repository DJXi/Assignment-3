package com.mcfarevee.shopping;

import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.NonFood;

public class Cart {

  int numThings;
  int numEntries;
  int price;
  int weightArray[] = {0, 0, 0, 0};
  List<Item> items;

  public Cart() {
    numThings = 0;
    numEntries = 0;
    price = 0;
    items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.numEntries++;

    if (item instanceof ManyPackages) {
      ManyPackages mp = (ManyPackages) item;
      numThings += mp.getAmount();
    } else {
      this.numThings++;
    }

    this.price += item.getPrice();

    if (item.getWeight().getUnit().toString().equalsIgnoreCase("pound")) {
      weightArray[0] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("ounce")) {
      weightArray[1] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("kilogram")) {
      weightArray[2] += item.getWeight().getAmount();
    } else if (item.getWeight().getUnit().toString().equalsIgnoreCase("gram")) {
      weightArray[3] += item.getWeight().getAmount();
    }

    this.items.add(item);
  }

  public void remove(String name) {
    for (int i = 0; i < numEntries; i++) {
      int counter1 = 0;
      int counter2 = 0;
      int counter3 = 0;
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
        }
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
        }
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
        }
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
        }
      }
      this.numEntries -= counter1;
      this.numThings -= counter2;
      this.price -= counter3;
    }
  }

  public int numThings() {
    return numThings;
  }

  public int numEntries() {
    return numEntries;
  }

  public void printContents(PrintWriter pen) {
    for (int i = 0; i < numEntries; i++) {
      pen.println(items.get(i).toString());
    }

  }

  public int getPrice() {
    return price;
  }

  public int[] getWeight() {
    return weightArray;
  }



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
        }
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
        }
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
      }
    }
  }
}
