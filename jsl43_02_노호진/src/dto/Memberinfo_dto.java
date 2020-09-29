package dto;

public class Memberinfo_dto {
	String id, name, address, tell, age, reg_date;

	public Memberinfo_dto(String id, String name, String address, String tell, String age, String reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tell = tell;
		this.age = age;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getTell() {
		return tell;
	}

	public String getAge() {
		return age;
	}

	public String getReg_date() {
		return reg_date;
	}
	
	
}
