package org.yottabase.yottaquake.core;

import java.util.Date;

public class EventFilter {

	private Date from, to;
	private Integer minMagnitude, maxMagnitude;
	private Integer minDepth, maxDepth;
	private String magnitudeType;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Integer getMinMagnitude() {
		return minMagnitude;
	}

	public void setMinMagnitude(Integer minMagnitude) {
		this.minMagnitude = minMagnitude;
	}

	public Integer getMaxMagnitude() {
		return maxMagnitude;
	}

	public void setMaxMagnitude(Integer maxMagnitude) {
		this.maxMagnitude = maxMagnitude;
	}

	public Integer getMinDepth() {
		return minDepth;
	}

	public void setMinDepth(Integer minDepth) {
		this.minDepth = minDepth;
	}

	public Integer getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(Integer maxDepth) {
		this.maxDepth = maxDepth;
	}

	public String getMagnitudeType() {
		return magnitudeType;
	}

	public void setMagnitudeType(String magnitudeType) {
		this.magnitudeType = magnitudeType;
	}

	@Override
	public String toString() {
		return "EventFilter [from=" + from + ", to=" + to + ", minMagnitude="
				+ minMagnitude + ", maxMagnitude=" + maxMagnitude
				+ ", minDepth=" + minDepth + ", maxDepth=" + maxDepth
				+ ", magnitudeType=" + magnitudeType + "]";
	}

}
