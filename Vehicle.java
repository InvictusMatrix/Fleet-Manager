// Kelvin Bhual
// Assignment 5
// COP3330

package assignment5;

public abstract class Vehicle {
	// Initialize variables
	private String vehicleID;
	private int maxSpeed;
	
	// Constructor for vehicleID and maxSpeed
	public Vehicle(String vehicleID, int maxSpeed) {
		this.setVehicleID(vehicleID);
		this.setMaxSpeed(maxSpeed);
	}
	
	// Returns type of engine
	public abstract String getEngineType();
	
	// Returns true if service is needed and false if service is not needed
	public abstract boolean needsService();
	
	// Returns power status, defaults to unknown
	public String getPowerStatus() {
		return "Power status unknown.";
	}
	
	// Performs maintenance on the vehicle, defaults to completing a standard checkup
	public String performMaintenance() {
		return "Standard checkup complete.";
	}
	
	// Accessor for vehicleID
	public String getVehicleID() {
		return vehicleID;
	}
	
	// Modifier for vehicleID
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	// Accessor for maxSpeed
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	// Modifier for maxSpeed
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
