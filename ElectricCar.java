public class ElectricCar extends Vehicle implements Rechargeable {
	// Initialize unique variable
	private int batteryPercent;
	
	// Constructor for an Electric Car
	public ElectricCar(String vehicleID, int maxSpeed, int batteryPercent) {
		super(vehicleID, maxSpeed);
		this.batteryPercent = batteryPercent;
	}
	
	// Overridden needsService() method
	@Override
	public boolean needsService() {
		// Returns true if the battery level is below 25%
		if(batteryPercent < 25) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Overridden getPowerStatus() method
	@Override
	public String getPowerStatus() {
		// Checks if the vehicle needs service before printing its power status
		if(needsService() == true) {
			return "Battery: " + getBatteryLevel() + "% (CRITICAL)";
		}
		else {
			return "Battery: " + getBatteryLevel() + "%";
		}
	}
	
	// Overridden performMaintenance() method
	@Override
	public String performMaintenance() {
		recharge();
		return "Electric systems checked. Charging initiated.";
	}
	
	// Returns battery level as a percentage
	public int getBatteryLevel() {
		return batteryPercent;
	}
	
	// Recharges battery back to 100%
	public void recharge() {
		batteryPercent = 100;
	}
	
	// Returns engine type of an Electric Car: Electric
	public String getEngineType() {
		return "Electric";
	}

}

