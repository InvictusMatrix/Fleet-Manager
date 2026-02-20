public class DieselTruck extends Vehicle implements FuelPowered {
	// Initialize unique variable
	private double fuelGallons;
	
	// Constructor for a Diesel Truck
	public DieselTruck(String vehicleID, int maxSpeed, double fuelGallons) {
		super(vehicleID, maxSpeed);
		this.fuelGallons = fuelGallons;
	}
	
	// Overridden needsService() method
	@Override
	public boolean needsService() {
		// Returns true if the fuel tank is below 10.0 gallons
		if(fuelGallons < 10.0) {
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
			return "Fuel: " + checkFuelLevel() + " gal (CRITICAL)";
		}
		else {
			return "Fuel: " + checkFuelLevel() + " gal";
		}
	}
	
	// Overridden performMaintenance() method
	@Override
	public String performMaintenance() {
		refuel();
		return "Fluid levels good. Refueling truck.";
	}
	
	// Returns fuel level in gallons
	public double checkFuelLevel() {
		return fuelGallons;
	}
	
	// Refills fuel back to full (50.0 gallons)
	public void refuel() {
		fuelGallons = 50.0;
	}
	
	// Returns engine type of a Diesel Truck: Diesel
	public String getEngineType() {
		return "Diesel";
	}

}

