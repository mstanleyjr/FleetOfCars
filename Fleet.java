//Name: Michael Stanley
//Course: CSC 151 0002
//Assignment: Fleet for Project

import java.util.ArrayList;
import java.util.Arrays;

public class Fleet {
 
 private ArrayList<Car> myCars;
 
 public Fleet() {
  myCars = new ArrayList<>();
 }
 
 public Car find(String identifier) {
  for (Car c: myCars) {
   if (c.getIdentifier().equals(identifier)) {
    return c;
   }
  }
  return null;
 }
 
 public boolean add(Car carToAdd) {
  return myCars.add(carToAdd);
 }
 
 public int size() {
  return myCars.size();
 }
 
 public Car get(int position) {
  return myCars.get(position);
 }
 
 public int getTotalMiles() {
  int totalMiles = 0;
  for (Car c: myCars) {
   totalMiles += c.getMiles();
  }
  return totalMiles;
 }
 
 public int getTotalFuel() {
  int totalFuel = 0;
  for (Car c: myCars) {
   totalFuel += c.getFuelUsed();
  }
  return totalFuel;
 }
 
 public double getCarAverageMPG() {
  if (size() == 0) return 0;
  double totMPG = 0;
  for (Car c: myCars) {
   totMPG += c.getMPG();
  }
  return totMPG / myCars.size();
 }
 
 public double getFleetAverageMPG() {
  if (getTotalFuel() == 0) return -1;
  return (double)getTotalMiles() / getTotalFuel();
 }
 
 public ArrayList<Car> getSortedByMPG() {
  ArrayList<Car> newList = new ArrayList<>(myCars);
  selectionSort(newList);
  return newList;
 }
 
 //Sort by mileage
 public ArrayList<Car> getSortedByMiles(){
	 ArrayList<Car> newList = new ArrayList<>(myCars);
	 mileSort(newList);
	 return newList;
 }
 
 //Reverse Sort
 public ArrayList<Car> getReverseSort(){
	 ArrayList<Car> newList = new ArrayList<>(myCars);
	 reverseSort(newList);
	 return newList;
 }

 @Override
 public String toString() {
  String s = "Fleet [\n";
  for (Car c: myCars) {
   s += c.toString() + "\n";
  }
  s += "]";
  return s;
 }
 
 public String sortedString() {
	 String s = "Fleet [\n";
	 ArrayList<Car> newList = new ArrayList<>(myCars);
	 mileSort(newList);
	 for (Car c: newList) {
		 s += c.toString() + "\n";
	 }
	 s += "]";
	 return s;
 
 }
 

 // from Liang Ch 07
   private void selectionSort(ArrayList<Car> list) {
      for (int i = 0; i < list.size() - 1; i++) {
        // Find the minimum in the list[i..list.length-1]
        Car currentMin = list.get(i);
        int currentMinIndex = i;

        for (int j = i + 1; j < list.size(); j++) {
          if (currentMin.getMPG() > list.get(j).getMPG()) {
            currentMin = list.get(j);
            currentMinIndex = j;
          }
        }

        // Swap list[i] with list[currentMinIndex] if necessary;
        if (currentMinIndex != i) {
          list.set(currentMinIndex, list.get(i));
          list.set(i, currentMin);
        }
      }
    }

   //Adding mile sort
   private void mileSort(ArrayList<Car> list) {
	   for (int i = 0; i < list.size() - 1; i++) {
	        // Find the minimum in the list[i..list.length-1]
	        Car currentMin = list.get(i);
	        int currentMinIndex = i;

	        for (int j = i + 1; j < list.size(); j++) {
	          if (currentMin.getMiles() > list.get(j).getMiles()) {
	            currentMin = list.get(j);
	            currentMinIndex = j;
	          }
	        }

	        // Swap list[i] with list[currentMinIndex] if necessary;
	        if (currentMinIndex != i) {
	          list.set(currentMinIndex, list.get(i));
	          list.set(i, currentMin);
	        }
	      }
	   
   }
   
   //Reverse Sort
   private void reverseSort(ArrayList<Car> list) {
	   ArrayList<Car> rf = new ArrayList<Car>();
	   for (int i = 0; i < list.size(); i++) {
		    rf.add(list.get(list.size() - 1 - i));
		    }
	   list.clear();
	   for(Car c: rf) {
		   list.add(c);
	   }
   }
   
   
   
   //Get Best MPG(s) in String
   public String getBestMPG() {
	   if (size() == 0) return "-1";
	   ArrayList<Car> result = new ArrayList<Car>();
	   selectionSort(myCars);
	   reverseSort(myCars);
	   for(Car c: myCars) {
		   if (myCars.get(0).compareMPG(c) == 0)
			   result.add(c);
	   }
	   String best = "";
	   for(Car c: result) {
		   best += c.getIdentifier() + " ";
	   }
	    return best;
   }
   
   //Get Highest Mileage(s) in String
   public String getHighMile() {
	   if (size() == 0) return "-1";
	   ArrayList<Car> result = new ArrayList<Car>();
	   mileSort(myCars);
	   reverseSort(myCars);
	   for (Car c: myCars) {
		   if(myCars.get(0).compareMiles(c) == 0)
			   result.add(c);
	   }
	   String best = "";
	   for(Car c: result) {
		   best += c.getIdentifier() + " ";
	   }
	  return best;
	   }
	   
	   
   }
   
