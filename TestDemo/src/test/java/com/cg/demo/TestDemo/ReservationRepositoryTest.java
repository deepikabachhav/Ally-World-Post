package com.cg.demo.TestDemo;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.demo.TestDemo.entity.Reservation;
import com.cg.demo.TestDemo.repo.ReservationRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {
	
	@Autowired
	private ReservationRepository repository;
	
	
	@Test
	public void findByReservationName() {
		this.repository.save(new Reservation(null,"deep"));
		Collection<Reservation> by=this.repository.findByReservationName("deep");
		Assertions.assertThat(by.size()).isEqualTo(1);
		Assertions.assertThat(by.iterator().next().getId()).isGreaterThan(0);
		Assertions.assertThat(by.iterator().next().getReservationName()).isEqualTo("deep");
	}

}
