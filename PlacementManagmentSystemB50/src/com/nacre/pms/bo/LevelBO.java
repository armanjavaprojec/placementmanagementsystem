package com.nacre.pms.bo;

public class LevelBO {

	private Integer levelId;
	private String level;
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "LevelBO [levelId=" + levelId + ", level=" + level + "]";
	}
	
}
