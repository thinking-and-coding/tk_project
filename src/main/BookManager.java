package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

	static List<PlayGround> playGrounds = new ArrayList<>();

	public BookManager() {
		playGrounds.add(new PlayGround("A"));
		playGrounds.add(new PlayGround("B"));
		playGrounds.add(new PlayGround("C"));
		playGrounds.add(new PlayGround("D"));
	}

	/*
	 * public static void main(String[] args) { BookManager bookManager = new
	 * BookManager(); Scanner sc = new Scanner(System.in); while (sc.hasNext())
	 * { String operate = sc.nextLine(); BookInfo bookInfo =
	 * Util.processOperatr(operate); if (bookInfo == null) {
	 * System.out.println("Error:the booking is invalid!"); } PlayGround
	 * playGround = bookManager.getPlayGround(bookInfo.getPlayGround()); if
	 * (playGround == null) {
	 * System.out.println("Error:the booking is invalid!"); } if
	 * (!bookInfo.isCancel()) { if (playGround.addNewBook(bookInfo)) {
	 * System.out.println("Success:the booking is accepted!"); } else {
	 * System.out.println("Error:the booking is invalid!"); } } else { if
	 * (playGround.cancelBook(bookInfo)) {
	 * System.out.println("Success:the booking is accepted!"); } else {
	 * System.out.println("Error:the booking being cancelled does not exist!");
	 * } } }
	 * 
	 * System.out.println("收入汇总："); int total = 0; for (int i = 0; i <
	 * playGrounds.size(); i++) { PlayGround playGround = playGrounds.get(i);
	 * System.out.println("---"); System.out.println("场地" + playGround.getName()
	 * + ":"); List<BookInfo> bookInfos = playGround.getBookInfo();
	 * List<BookInfo> cancelInfos = playGround.getBookInfo(); for (int j = 0; j
	 * < bookInfos.size(); i++) { System.out.println(bookInfos.get(i)); } for
	 * (int j = 0; j < cancelInfos.size(); i++) {
	 * System.out.println(cancelInfos.get(i)); } System.out.println("小计：" +
	 * playGround.getTotal() + "元"); total += playGround.getTotal(); }
	 * System.out.println("总计：" + total + "元"); sc.close();
	 * 
	 * }
	 */

	public PlayGround getPlayGround(String s) {
		for (int i = 0; i < playGrounds.size(); i++) {
			PlayGround playGround = playGrounds.get(i);
			if (playGround.getName().equals(s)) {
				return playGround;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BookManager bookManager = new BookManager();

		List<String> strings = new ArrayList<>();
		strings.add("abcdefghijk12334989");
		strings.add("U001 2016-06-02 22:00~22:00 A");
		strings.add("U002 2017-08-01 19:00~22:00 A");
		strings.add("U003 2017-08-02 13:00~17:00 A");
		strings.add("U003 2017-08-02 13:00~17:00 B");
		strings.add("U004 2017-08-03 15:00~16:00 C");
		strings.add("U005 2017-08-05 09:00~11:00 D");
		for (String operate : strings) {
			BookInfo bookInfo = Util.processOperatr(operate);
			if (bookInfo == null) {
				System.out.println("Error:the booking is invalid!");
				continue;
			}
			PlayGround playGround = bookManager.getPlayGround(bookInfo.getPlayGround());
			if (playGround == null) {
				System.out.println("Error:the booking is invalid!");
				continue;
			}
			if (!bookInfo.isCancel()) {
				if (playGround.addNewBook(bookInfo)) {
					System.out.println("Success:the booking is accepted!");
				} else {
					System.out.println("Error:the booking is invalid!");
				}
			} else {
				if (playGround.cancelBook(bookInfo)) {
					System.out.println("Success:the booking is accepted!");
				} else {
					System.out.println("Error:the booking being cancelled does not exist!");
				}
			}

		}

		System.out.println("收入汇总：");
		int total = 0;
		for (int i = 0; i < playGrounds.size(); i++) {
			PlayGround playGround = playGrounds.get(i);
			System.out.println("---");
			System.out.println("场地" + playGround.getName() + ":");
			List<BookInfo> bookInfos = playGround.getBookInfo();
			List<BookInfo> cancelInfos = playGround.getBookInfo();
			for (int j = 0; j < bookInfos.size(); i++) {
				System.out.println(bookInfos.get(i));
			}
			for (int j = 0; j < cancelInfos.size(); i++) {
				System.out.println(cancelInfos.get(i));
			}
			System.out.println("小计：" + playGround.getTotal() + "元");
			total += playGround.getTotal();
		}
		System.out.println("总计：" + total + "元");

	}

}
