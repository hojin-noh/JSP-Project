package dto;

public class Return_dto {
	String rent_no, member_id, member_name, book_no, book_name, rent_date, rent_gubun;

	public Return_dto(String rent_no, String member_id, String member_name, String book_no, String book_name,
			String rent_date, String rent_gubun) {
		super();
		this.rent_no = rent_no;
		this.member_id = member_id;
		this.member_name = member_name;
		this.book_no = book_no;
		this.book_name = book_name;
		this.rent_date = rent_date;
		this.rent_gubun = rent_gubun;
	}


	public String getRent_no() {
		return rent_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public String getBook_no() {
		return book_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getRent_gubun() {
		return rent_gubun;
	}

	
	
}
