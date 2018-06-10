package main;

import java.util.Date;

import javax.print.attribute.ResolutionSyntax;

public class BookInfo {
	private String playGround;
	private String userId;
	private Date startTime;
	private Date endTime;
	private int cost;
	private boolean isCancel;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public String getPlayGround() {
		return playGround;
	}

	public void setPlayGround(String playGround) {
		this.playGround = playGround;
	}

	@Override
	public String toString() {
		if (!isCancel) {
			return getStartTime() + " " + getStartTime() + " " + getCost();
		} else {
			return getStartTime() + " " + getStartTime() + " 违约金 " + getCost();
		}
		
	}

}
