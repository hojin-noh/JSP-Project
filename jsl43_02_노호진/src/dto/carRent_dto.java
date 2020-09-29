package dto;

public class carRent_dto {
	String member_name, rent_no, member_id, car_no, rent_date, return_day, return_sche_date;

	public carRent_dto(String rent_no, String member_id, String car_no, String rent_date, String return_day,
			String return_sche_date) {
		super();
		this.rent_no = rent_no;
		this.member_id = member_id;
		this.car_no = car_no;
		this.rent_date = rent_date;
		this.return_day = return_day;
		this.return_sche_date = return_sche_date;
	}

	public String getRent_no() {
		return rent_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getCar_no() {
		return car_no;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getReturn_day() {
		return return_day;
	}

	public String getReturn_sche_date() {
		return return_sche_date;
	}

	public carRent_dto(String rent_no, String member_id, String car_no, String rent_date, String return_sche_date) {
		super();
		this.rent_no = rent_no;
		this.member_id = member_id;
		this.car_no = car_no;
		this.rent_date = rent_date;
		this.return_sche_date = return_sche_date;
	}

	
	
	
}
