package com.cg.demo.TestDemo;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.cg.demo.TestDemo.entity.Reservation;

public class ReservationTest {
	
	@Test
	public void creation() {
		Reservation r = new Reservation(1L,"deep");
		Assert.assertEquals(r.getId(), (Long)1L);
		Assert.assertThat(r.getId(), Matchers.equalTo(1L));
		Assertions.assertThat(r.getId()).isEqualTo(1L);
		Assertions.assertThat(r.getReservationName()).isNotBlank();
		Assertions.assertThat(r.getReservationName()).isEqualTo("deep");
	}

}
