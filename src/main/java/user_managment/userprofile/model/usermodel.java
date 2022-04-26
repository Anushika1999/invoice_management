package user_managment.userprofile.model;

public class usermodel {
	
	private int id;
	private String name;
	private String nic;
	private String address;
	private int zipCode;
	private String phoneNumber;
	private String email;

	public usermodel() {
	}

	public usermodel(int id, String name, String nic, String address, int zipCode, String phoneNumber,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.nic = nic;
		this.address = address;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
