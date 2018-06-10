package main;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {

	private String name;
	private List<BookInfo> bookInfo = new ArrayList<>();
	private List<BookInfo> cancelInfo = new ArrayList<>();

	public PlayGround(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<BookInfo> getBookInfo() {
		return bookInfo;
	}

	public List<BookInfo> getCancelInfo() {
		return cancelInfo;
	}

	public boolean addNewBook(BookInfo newBookInfo) {
		for (int i = 0; i < bookInfo.size(); i++) {
			BookInfo info = bookInfo.get(i);
			if ((info.getStartTime().getTime() > newBookInfo.getStartTime().getTime()
					&& info.getStartTime().getTime() < newBookInfo.getEndTime().getTime())
					|| (info.getEndTime().getTime() > newBookInfo.getStartTime().getTime()
							&& info.getEndTime().getTime() < newBookInfo.getEndTime().getTime())) {
				return false;
			}
		}
		bookInfo.add(newBookInfo);
		return true;
	}

	public boolean cancelBook(BookInfo newUserCancel) {
		for (int i = 0; i < bookInfo.size(); i++) {
			BookInfo info = bookInfo.get(i);
			if (info.getUserId() == newUserCancel.getUserId() && info.getStartTime() == newUserCancel.getStartTime()
					&& info.getEndTime() == newUserCancel.getEndTime()) {
				if (!Util.isWeekend(newUserCancel.getStartTime())) {
					newUserCancel.setCost(newUserCancel.getCost() / 2);
				} else {
					newUserCancel.setCost(newUserCancel.getCost() / 4);
				}
				cancelInfo.add(newUserCancel);
				bookInfo.remove(info);
				return true;
			}
		}
		return false;
	}

	public int getTotal() {
		int total = 0;
		for (int i = 0; i < bookInfo.size(); i++) {
			total += bookInfo.get(i).getCost();
		}
		for (int i = 0; i < cancelInfo.size(); i++) {
			total += bookInfo.get(i).getCost();
		}
		return total;
	}

}
