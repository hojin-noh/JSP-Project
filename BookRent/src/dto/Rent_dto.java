package dto;

public class Rent_dto {
String  rent_no, member_id, book_no, rent_date, return_date;


public Rent_dto(String rent_no, String member_id, String book_no, String rent_date, String return_date) {
	super();
	this.rent_no = rent_no;
	this.member_id = member_id;
	this.book_no = book_no;
	this.rent_date = rent_date;
	this.return_date = return_date;
}

public String getRent_no() {
	return rent_no;
}

public String getMember_id() {
	return member_id;
}

public String getBook_no() {
	return book_no;
}

public String getRent_date() {
	return rent_date;
}

public String getReturn_date() {
	return return_date;
}
}
