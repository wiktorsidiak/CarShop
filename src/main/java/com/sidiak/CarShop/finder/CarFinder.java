package com.sidiak.CarShop.finder;

import com.sidiak.CarShop.model.Car.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Car.class, idClass = String.class)
public interface CarFinder {
	Page<CarData> findAll(Pageable pageable);
}
