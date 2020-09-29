package dto;

public class Member_dto {
	String id, name, adress, tell, reg_date, no, bookName, publisher, writer, bookReg_date, rent_gubun;
	int age;
	public Member_dto(String id, String name, String adress, String tell, String reg_date, int age) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.tell = tell;
		this.reg_date = reg_date;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public String getTell() {
		return tell;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getAge() {
		return age;
	}
	public Member_dto(String no, String bookName, String publisher, String writer, String bookReg_date,
			String rent_gubun) {
		super();
		this.no = no;
		this.bookName = bookName;
		this.publisher = publisher;
		this.writer = writer;
		this.bookReg_date = bookReg_date;
		this.rent_gubun = rent_gubun;
	}
	public String getNo() {
		return no;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getBookReg_date() {
		return bookReg_date;
	}
	
	public String getRent_gubun() {
		return rent_gubun;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
