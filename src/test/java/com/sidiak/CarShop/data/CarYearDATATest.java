package com.sidiak.CarShop.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CarYearDATATest {

	@Test
	public void shouldCorrectlyCreateYear() {
		final int exampleCorrectYear = 2010;

		final CarYearDATA carYearDATA = new CarYearDATA(exampleCorrectYear);

		Assertions.assertThat(carYearDATA.getYear().equals(exampleCorrectYear));
	}

	@Test
	public void shouldNotCreateMinusYear() {
		final int exampleYear = -1;

		Assertions.assertThatThrownBy(() -> new CarYearDATA(exampleYear), "Year can't be less than 0");
	}


	@Test
	public void shouldNotCreateFutureYear() {
		final int exampleFutureYear = LocalDate.now().plusYears(1).getYear();

		Assertions.assertThatThrownBy(() -> new CarYearDATA(exampleFutureYear), "Car production year can't be from future");
	}
}