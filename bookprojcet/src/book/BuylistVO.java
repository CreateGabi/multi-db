package book;

import java.util.Date;

public class BuylistVO {
	String buyBook;
	String buyMember;
	Date buyDate;

	public String getBuyBook() {
		return buyBook;
	}

	public void setBuyBook(String buyBook) {
		this.buyBook = buyBook;
	}

	public String getBuyMember() {
		return buyMember;
	}

	public void setBuyMember(String buyMember) {
		this.buyMember = buyMember;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
}
