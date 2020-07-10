package com.sidiak.CarShop.model.Car;

public enum CarCategory implements CarCategoryModel {
	MICRO("micro"), SEDAN("sedan"), CUV("cuv"), SUV("suv"),
	CABRIOLET("cabriolet"), KOMBI("combi"), MINIVAN("minivan"),
	COUPE("coupe"), PICKUP("pickup"), SUPERCAR("supercar"), VAN("van");

	private String category;

	CarCategory(String category) {

		this.category = category;
	}

	@Override
	public String getCategory() {
		return category;

	}
}
