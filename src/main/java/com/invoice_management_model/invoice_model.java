package com.invoice_management_model;

public class invoice_model {
	private String invoice_id;
	private String customer_id;
	private String customer_name;
	private String customer_type;
	private int pay_units;
	private float monthly_amount;

	public invoice_model() {

	}

	public invoice_model(String invoice_id, String customer_id, String customer_name, String customer_type,
			int pay_units, float monthly_amount) {
		super();
		this.invoice_id = invoice_id;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_type = customer_type;
		this.pay_units = pay_units;
		this.monthly_amount = monthly_amount;
	}

	public String getInvoice_id() {
		return invoice_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public int getPay_units() {
		return pay_units;
	}

	public float getMonthly_amount() {
		return monthly_amount;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public void setPay_units(int pay_units) {
		this.pay_units = pay_units;
	}

	public void setMonthly_amount(float monthly_amount) {
		this.monthly_amount = monthly_amount;
	}
	
	
}
