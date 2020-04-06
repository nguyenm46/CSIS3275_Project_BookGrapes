package com.user.nguyenm46.model;

import java.util.List;
//Hsueh-Cheng Liu 300280496 

public class ReviewInfo {

	private String booktitle;
	private String review;
	private List<String> userreview;

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public List<String> getUserreview() {
		return userreview;
	}

	public void setUserreview(List<String> userreview) {
		this.userreview = userreview;
	}

}
