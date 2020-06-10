package com.sidiak.CarShop.finder;

import java.math.BigDecimal;
import java.util.Date;

public interface CarData {
	String getMark();

	String getModel();

	String getCategory();

	BigDecimal getPrice();

	String getVinCode();

	Integer getYear();

	Integer getMileage();

	String getFuel();

	Date getCreatedAt();

	Date getUpdatedAt();
}