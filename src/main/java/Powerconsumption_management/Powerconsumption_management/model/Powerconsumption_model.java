package Powerconsumption_management.Powerconsumption_management.model;

public class Powerconsumption_model {
	private int id;
	private String customer_registration_id;
	private int last_meter_reading;
	private int curent_meter_reading;
	private int monthly_payable_units;

	public  Powerconsumption_model() {

	}

	public  Powerconsumption_model(int id, String customer_registration_id, int last_meter_reading, int curent_meter_reading,int monthly_payable_units) {
		super();
		this.setId(id);
		this.setCustomer_registration_id(customer_registration_id);
		this.setLast_meter_reading(last_meter_reading);
		this.setCurent_meter_reading(curent_meter_reading);
		this.setMonthly_payable_units(monthly_payable_units);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_registration_id() {
		return customer_registration_id;
	}

	public void setCustomer_registration_id(String customer_registration_id) {
		this.customer_registration_id = customer_registration_id;
	}

	public int getLast_meter_reading() {
		return last_meter_reading;
	}

	public void setLast_meter_reading(int last_meter_reading) {
		this.last_meter_reading = last_meter_reading;
	}

	public int getCurent_meter_reading() {
		return curent_meter_reading;
	}

	public void setCurent_meter_reading(int curent_meter_reading) {
		this.curent_meter_reading = curent_meter_reading;
	}

	public int getMonthly_payable_units() {
		return monthly_payable_units;
	}

	public void setMonthly_payable_units(int monthly_payable_units) {
		this.monthly_payable_units = monthly_payable_units;
	}

	
	
	/*public int getmonthly_payable_units(int curent_meter_reading,int last_meter_reading) {
		
		int monthly_payable_unit = 0;
		monthly_payable_unit = curent_meter_reading-last_meter_reading;
		return monthly_payable_unit;
	}

	public void setmonthly_payable_units(int monthly_payable_units) {
		this.monthly_payable_units = monthly_payable_units;
	}*/
	
	
	
}
