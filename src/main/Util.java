package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	public static BookInfo processOperatr(String operate) {
		BookInfo bookInfo = new BookInfo();
		String[] infos = operate.split(" ");
		if (infos.length < 4) {
			return null;
		}
		if (!isValide(infos[2])) {
			return null;
		}

		if (infos.length == 5 && infos[4] == "C") {
			bookInfo.setCancel(true);
		}

		bookInfo.setUserId(infos[0]);
		bookInfo.setPlayGround(infos[3]);

		String[] times = infos[2].split("~");
		String startTime = infos[1] + " " + times[0];
		String endTime = infos[1] + " " + times[1];
		bookInfo.setStartTime(getDate(startTime));
		bookInfo.setEndTime(getDate(endTime));
		int price = getPrice(startTime);
		if (price == 0) {
			return null;
		}
		int cost = price * getInterval(infos[2]);
		bookInfo.setCost(cost);

		return bookInfo;
	}

	/**
	 * 判断是否是周末
	 * 
	 * @return
	 */
	public static boolean isWeekend(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 6 || week == 0) {// 0代表周日，6代表周六
			return true;
		}
		return false;
	}

	/**
	 * 判断时间段单价
	 * 
	 * @return
	 */
	private static int getPrice(String startTime) {
		Date date = getDate(startTime);
		int time = Integer.parseInt(startTime.split(" ")[1].split(":")[0]);
		if (!isWeekend(date)) {
			if (time >= 9 && time < 12) {
				return 30;
			}
			if (time >= 12 && time < 18) {
				return 50;
			}
			if (time >= 18 && time < 20) {
				return 80;
			}
			if (time >= 20 && time < 22) {
				return 60;
			}
		} else {
			if (time >= 9 && time < 12) {
				return 40;
			}
			if (time >= 12 && time < 18) {
				return 50;
			}
			if (time >= 18 && time < 20) {
				return 60;
			}
		}
		return 0;
	}

	/**
	 * 判断时间段是否合法
	 * 
	 * @return
	 */
	private static boolean isValide(String time) {
		String times[] = time.split("~");
		String startTime = times[0];
		String endTime = times[1];
		String[] sTime = startTime.split(":");
		String[] eTime = endTime.split(":");
		if (Integer.parseInt(sTime[0]) < Integer.parseInt(eTime[0])) {
			return true;
		}
		return false;
	}

	/**
	 * 获取时间间隔
	 * 
	 * @return
	 */
	private static int getInterval(String time) {
		String times[] = time.split("~");
		String startTime = times[0];
		String endTime = times[1];
		String[] sTime = startTime.split(":");
		String[] eTime = endTime.split(":");
		int interval = Integer.parseInt(eTime[0]) - Integer.parseInt(sTime[0]);
		return interval;
	}

	/**
	 * 获取时间
	 * 
	 * @return
	 */
	private static Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date dDate = sdf.parse(date);
			return dDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
