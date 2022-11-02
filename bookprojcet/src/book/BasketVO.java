package book;

import java.util.Date;

public class BasketVO {
	String basketBook;
	String basketMember;
	Date basketDate;

	public String getBasketBook() {
		return basketBook;
	}

	public void setBasketBook(String basketBook) {
		this.basketBook = basketBook;
	}

	public String getBasketMember() {
		return basketMember;
	}

	public void setBasketMember(String basketMember) {
		this.basketMember = basketMember;
	}

	public Date getBasketDate() {
		return basketDate;
	}

	public void setBasketDate(Date basketDate) {
		this.basketDate = basketDate;
	}

}
