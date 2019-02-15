package com.cg.demo.TestDemo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.demo.TestDemo.entity.Reservation;
@DataJpaTest
@RunWith(SpringRunner.class)

public class ReservationJpaTest {
	@Autowired
	private TestEntityManager tem;
	
	@Test
	public void mapping() {
		Reservation deep=this.tem.persistFlushFind(new Reservation(null, "deep"));
		Assertions.assertThat(deep.getReservationName()).isEqualTo("deep");
		Assertions.assertThat(deep.getId()).isNotNull();
		Assertions.assertThat(deep.getId()).isGreaterThan(0);
		
	}
}
