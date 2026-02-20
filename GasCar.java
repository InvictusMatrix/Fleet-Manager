public class GasCar extends Vehicle implements FuelPowered {
	
	private double fuelGallons;
	
	public GasCar(String vehicleID, int maxSpeed, double fuelGallons) {
		super(vehicleID, maxSpeed);
		this.fuelGallons = fuelGallons;
		
	}
	
	@Override
	public String getPowerStatus() {
		if(needsService() == true) {
			return "Fuel: " + checkFuelLevel() + " gal (CRITICAL)";
		}
		else {
			return "Fuel: " + checkFuelLevel() + " gal";
		}
	}
	
	@Override
	public String performMaintenance() {
		refuel();
		return "Fluid levels good. Refueling car.";
	}
	
	public double checkFuelLevel() {
		return fuelGallons;
	}

	public void refuel() {
		fuelGallons = 30.0;		
	}

	public String getEngineType() {
		return "Gasoline";
	}

	public boolean needsService() {
		if(fuelGallons < 10.0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

