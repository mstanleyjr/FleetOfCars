//Name: Michael Stanley
//Course: CSC 151 0002
//Assignment: Car for Project


public class Car {
 
 private String identifier;
 private int milage;
 private int fuelUsed;
 
 public Car() {
  identifier = "";
  milage = 0;
  fuelUsed = 0;
 }

 public Car(String identifier) {
  this.identifier = identifier;
  milage = 0;
  fuelUsed = 0;
 }
 
 public Car(String identifier, int milage, int fuelUsed) {
  this.identifier = identifier;
  this.milage = milage;
  this.fuelUsed = fuelUsed;
 }
 
 public void addFuel(int fuel) {
  fuelUsed += fuel;
 }
 
 public void addMiles(int miles) {
  milage += miles;
 }

 //Allowed for new cars
 public double getMPG() {
	 if (milage == 0 && fuelUsed == 0)
		 return 0;
  return (double)milage / fuelUsed;


 }

 public String getIdentifier() {
  return identifier;
 }

 public void setIdentifier(String identifier) {
  this.identifier = identifier;
 }

 public int getMiles() {
  return milage;
 }

 public void setMiles(int milage) {
  this.milage = milage;
 }

 public int getFuelUsed() {
  return fuelUsed;
 }

 public void setFuelUsed(int fuelUsed) {
  this.fuelUsed = fuelUsed;
 }
 
 public int compareMPG(Car otherCar) {
  double myMPG = getMPG();
  double otherMPG = otherCar.getMPG();
  if (myMPG == otherMPG) return 0;
  if (myMPG - otherMPG > 0) return 1;
  return -1;
 }
 
 //Adding CompareMiles
 public int compareMiles(Car otherCar) {
	 int myMiles = getMiles();
	 int otherMiles = otherCar.getMiles();
	 if(myMiles == otherMiles) return 0;
	 if(myMiles - otherMiles > 0) return 1;
	 return -1;
 }

 
 @Override
 public String toString() {
  return "Car [Identifier=" + identifier + ", Mileage=" + milage + ", Fuel Used =" + fuelUsed + "]";
 }
 public boolean equals(Object obj){
   if (this==obj) return true;
   if (obj==null) return false;
   if (this.getClass()!=obj.getClass()) return false;
   final Car other = (Car)obj;
   if ((this.getIdentifier().equals(other.getIdentifier()) &&
       this.getMPG()==other.getMPG()))
         return true;
       return false;
 }
}
