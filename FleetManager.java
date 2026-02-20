// Kelvin Bhual
// Assignment 5
// COP3330

package assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class FleetManager {
	// Initialize vehicleFleet ArrayList
	ArrayList<Vehicle> fleet = new ArrayList<Vehicle>();
	
	// Constructor for a Fleet Manager	
	public FleetManager(ArrayList<Vehicle> fleet) {
        this.fleet = fleet;
    }
	
	// Prints each vehicle in the input list to the console
	void runDiagnostics(ArrayList<Vehicle> fleet) {		
		for(Vehicle temp : fleet) {
			System.out.println("Vehicle ID: " + temp.getVehicleID() + " (" + temp.getEngineType() + "). Engine: " + temp.getEngineType() + ". Status: " + temp.getPowerStatus());
		}
	}
	
	// Adds vehicles from the input list to an urgent list if they need service
	ArrayList<Vehicle> prioritizeMaintenance(ArrayList<Vehicle> fleet) {
		// Initialize urgent list
		ArrayList<Vehicle> urgent = new ArrayList<Vehicle>();
		
		// Checks each vehicle and adds them to the urgent list if they need service
		for(Vehicle temp : fleet) {
			if(temp.needsService() == true) {
				urgent.add(temp);
			}
		}
		
		// Returns urgent list, which only has vehicles that need service
		return urgent;
	}
	
	// Performs maintenance on all vehicles that need service
	void startMaintenance(ArrayList<Vehicle> urgentFleet) {
		System.out.println("\n--- Running Urgent Maintenance ---");
		
		// Checks input list for vehicles that need service and performs maintenance on them
		for(Vehicle temp : urgentFleet) {
			if(temp.needsService() == true) {
				System.out.println(temp.getVehicleID() + ": " + temp.performMaintenance());
			}
		}
	}
	
	public static void main(String[] args) {
		// Initialize variables, scanners, and lists
		Scanner input = new Scanner(System.in);
		char userInput;
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> urgentVehicles = new ArrayList<Vehicle>();
		FleetManager manager = new FleetManager(vehicles);
		
		// Add vehicles to the vehicles list
		vehicles.add(new ElectricCar("E-450", 80, 20));
		vehicles.add(new ElectricCar("E-101", 80, 90));
		vehicles.add(new DieselTruck("D-900", 60, 5.5));
		vehicles.add(new DieselTruck("D-500", 60, 40));
		vehicles.add(new GasCar("G-888", 80, 30));
		vehicles.add(new GasCar("G-850", 60, 2.3));
		
		System.out.println("Welcome to the Logistics Fleet Manager.\n");
		System.out.print("Ready to begin fleet diagnostics? (y/n): ");
		
		// Checks for a single character as input
		userInput = input.next().charAt(0);
		
		// If the user enters 'y', print out initial diagnosis report and check for vehicles that need service
		if(userInput == 'y') {
		
			System.out.println("\n--- Fleet Diagnosis Report (Initial Status) ---");
			manager.runDiagnostics(vehicles);
			urgentVehicles = manager.prioritizeMaintenance(vehicles);
			
			// Checks for the presence of vehicles that need service and prints their ID and engine type to the console
			if(urgentVehicles.size() > 0) {
				System.out.println("\n--- Prioritization Scan ---\nThe following " + urgentVehicles.size() + " vehicles require urgent service:");
				for(Vehicle temp : urgentVehicles) {
					System.out.println("- " + temp.getVehicleID() + " (" + temp.getEngineType() + ")");
				}
				
				System.out.print("\nCritical issues found. Run full maintenance on prioritized vehicles? (y/n): ");
				userInput = input.next().charAt(0);
				
				// If the user enters 'y', perform maintenance on vehicles that need service
				if(userInput == 'y') {
					manager.startMaintenance(vehicles);
				}
				
				// If the user enters 'n', vehicles will not receive maintenance
				else if(userInput == 'n') {
					System.out.println("\nMaintenance declined.");
				}
				
				// Covers inputs that are not 'y' or 'n'
				else {
					System.out.println("Invalid input.");
				}
			}
			
			// Covers all other cases where there are no vehicles to be serviced
			else if(urgentVehicles.size() <= 0) {
				System.out.println("\n--- Prioritization Scan ---\nNo vehicles need service at this time.");
			}
			
			// Prints to the console regardless of whether or not the user performed maintenance
			System.out.println("\n--- Fleet Diagnosis Report (Post-Maintenance Status) ---");
			manager.runDiagnostics(vehicles);
			System.out.println("\nSimulation complete. Have a productive day!");
		}
		
		// If the user enters 'n', end the program prematurely
		else if(userInput == 'n') {
			System.out.println("\nSimulation complete. Have a productive day!");
		}
		
		// Covers inputs that are not 'y' or 'n'
		else {
			System.out.println("Invalid input.");
		}
		
		// Close Scanner
		input.close();
	}
}
