package com.example.async_test;

import com.example.async_test.domain.Building;
import com.example.async_test.domain.repository.BuildingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest
class AsyncTestApplicationTests {

	@Autowired
	private BuildingRepository buildingRepository;

	@Test
	void contextLoads() {
		Building building = buildingRepository.save(Building.building("mybb"));
		System.out.println("test: " + building.getId());
	}

}
