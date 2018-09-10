//Name: Michael Stanley
//Course: CSC 151 0002
//Assignment: Project Car/Fleet GUI

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class FleetOfCars {
	
	private Fleet f1;
	private JTextField idInput;
	private JTextField mileInput;
	private JTextField fuelInput;
	private JLabel bestMile;
	private JLabel highMile;
	private JLabel fleetAvg;
	private JTextArea fleetList;
	private JTextArea fleetSortMPG;
	
	
	
	public FleetOfCars() {
		
		//Create elements
		WidgetView wv = new WidgetView();
		Fleet f1 = new Fleet();
		JLabel carID = new JLabel("New Car ID:");
		JTextField idInput = new JTextField(10);
		JLabel carMile = new JLabel("New Car Mileage:");
		JTextField mileInput = new JTextField(5);
		JLabel carFuel = new JLabel("New Car Fuel: ");
		JTextField fuelInput = new JTextField(5);
		JButton addCar = new JButton("Make a new car");
		JLabel bestMile = new JLabel("Best MPG: N/A");
		JLabel highMile = new JLabel("Highest Mileage: N/A");
		JLabel fleetAvg = new JLabel("Fleet AVG MPG: N/A");
		JTextArea fleetList = new JTextArea("Fleet as Entered:");
		JTextArea fleetSortMPG = new JTextArea("Fleet by MPG:");
		

		
		//Add ActionListeners - write class to add a car
		addCar.addActionListener(new CarCollector(f1, idInput, mileInput, fuelInput, bestMile, highMile, fleetAvg, fleetList, fleetSortMPG));
				
		//Add elements
		wv.add(carID);
		wv.add(idInput);
		wv.add(carMile);
		wv.add(mileInput);
		wv.add(carFuel);
		wv.add(fuelInput);
		wv.add(addCar);
		wv.add(bestMile);
		wv.add(highMile);
		wv.add(fleetAvg);
		wv.add(fleetList);
		wv.add(fleetSortMPG);
			
		
	}
	
	
	
	
	class CarCollector extends WidgetViewActionEvent{
		
		private Fleet myF1;
		private JTextField myIdInput;
		private JTextField myMileInput;
		private JTextField myFuelInput;
		private JLabel myBestMile;
		private JLabel myHighMile;
		private JLabel myFleetAvg;
		private JTextArea myFleetList;
		private JTextArea myFleetSortMPG;
		
		public CarCollector(Fleet f1, JTextField idInput, JTextField mileInput, JTextField fuelInput, JLabel bestMile, JLabel highMile, JLabel fleetAvg, JTextArea fleetList, JTextArea fleetSortMPG) {
			
			myF1 = f1;
			myIdInput = idInput;
			myMileInput = mileInput;
			myFuelInput = fuelInput;
			myBestMile = bestMile;
			myHighMile = highMile;
			myFleetAvg = fleetAvg;
			myFleetList = fleetList;
			myFleetSortMPG = fleetSortMPG;
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String name = myIdInput.getText();
				int miles = Integer.parseInt(myMileInput.getText());
				int fuel = Integer.parseInt(myFuelInput.getText());
				//Data Check
				if(miles < 0 || fuel < 0) {
					myIdInput.setText("Try Again");
					myMileInput.setText("Try Again");
					myFuelInput.setText("Try Again");
				}
				else {
					//Add car and reset form
				myF1.add(new Car(name, miles, fuel));
				myFleetList.setText(myF1.toString());
				myFleetSortMPG.setText("Fleet by MPG: \n" + myF1.sortedString());
				myBestMile.setText("Best MPG: " + myF1.getBestMPG());
				myHighMile.setText("Highest Mileage: " + myF1.getHighMile());
				String avg = String.format("Fleet AVG MPG: %.2f", myF1.getFleetAverageMPG());
				myFleetAvg.setText(avg);
				myIdInput.setText("");
				myMileInput.setText("");
				myFuelInput.setText("");
				
				}
				
				
			}
			catch (NumberFormatException ex) {
				myIdInput.setText("Try Again");
				myMileInput.setText("Try Again");
				myFuelInput.setText("Try Again");
		}
		
		
	}
	}
}
	


