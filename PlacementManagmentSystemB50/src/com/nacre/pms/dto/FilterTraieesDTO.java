package com.nacre.pms.dto;

import java.util.Arrays;

public class FilterTraieesDTO {

	float sscPercentage ;
	int sscYop[] ;
	 float hscPercentage ;
	int hscyop[] ;
	float gradPercentge ;
	int gradYop[] ;
	String gradSpecialization[] ;
	String gradStream[] ;
	float postPercentage ;
	int postYop[] ;
	String postSpecialization[];
	String postStream[];
	public float getSscPercentage() {
		return sscPercentage;
	}
	public void setSscPercentage(float sscPercentage) {
		this.sscPercentage = sscPercentage;
	}
	public int[] getSscYop() {
		return sscYop;
	}
	public void setSscYop(int[] sscYop) {
		this.sscYop = sscYop;
	}
	public float getHscPercentage() {
		return hscPercentage;
	}
	public void setHscPercentage(float hscPercentage) {
		this.hscPercentage = hscPercentage;
	}
	public int[] getHscyop() {
		return hscyop;
	}
	public void setHscyop(int[] hscyop) {
		this.hscyop = hscyop;
	}
	public float getGradPercentge() {
		return gradPercentge;
	}
	public void setGradPercentge(float gradPercentge) {
		this.gradPercentge = gradPercentge;
	}
	public int[] getGradYop() {
		return gradYop;
	}
	public void setGradYop(int[] gradYop) {
		this.gradYop = gradYop;
	}
	public String[] getGradSpecialization() {
		return gradSpecialization;
	}
	public void setGradSpecialization(String[] gradSpecialization) {
		this.gradSpecialization = gradSpecialization;
	}
	public String[] getGradStream() {
		return gradStream;
	}
	public void setGradStream(String[] gradStream) {
		this.gradStream = gradStream;
	}
	public float getPostPercentage() {
		return postPercentage;
	}
	public void setPostPercentage(float postPercentage) {
		this.postPercentage = postPercentage;
	}
	public int[] getPostYop() {
		return postYop;
	}
	public void setPostYop(int[] postYop) {
		this.postYop = postYop;
	}
	public String[] getPostSpecialization() {
		return postSpecialization;
	}
	public void setPostSpecialization(String[] postSpecialization) {
		this.postSpecialization = postSpecialization;
	}
	public String[] getPostStream() {
		return postStream;
	}
	public void setPostStream(String[] postStream) {
		this.postStream = postStream;
	}
	@Override
	public String toString() {
		return "FilterTraieesDTO [sscPercentage=" + sscPercentage + ", sscYop=" + Arrays.toString(sscYop)
				+ ", hscPercentage=" + hscPercentage + ", hscyop=" + Arrays.toString(hscyop) + ", gradPercentge="
				+ gradPercentge + ", gradYop=" + Arrays.toString(gradYop) + ", gradSpecialization="
				+ Arrays.toString(gradSpecialization) + ", gradStream=" + Arrays.toString(gradStream)
				+ ", postPercentage=" + postPercentage + ", postYop=" + Arrays.toString(postYop)
				+ ", postSpecialization=" + Arrays.toString(postSpecialization) + ", postStream="
				+ Arrays.toString(postStream) + "]";
	}
}
