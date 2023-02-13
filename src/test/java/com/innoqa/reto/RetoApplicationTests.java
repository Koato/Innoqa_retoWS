package com.innoqa.reto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.innoqa.reto.dao.Prices;
import com.innoqa.reto.services.IPricesServices;

@SpringBootTest
class RetoApplicationTests {

	@Autowired
	private IPricesServices iPricesServices;

	private static final Long idProducto = 35455L;
	private static final Long idCadena = 1L;

	@Test
	void Test1() {
		String fechaAplicacion = "2020-06-14 10:00:00";
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(1L, op.get().getId());
	}

	@Test
	void Test2() {
		String fechaAplicacion = "2020-06-14 16:00:00";
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(2L, op.get().getId());
	}

	@Test
	void Test3() {
		String fechaAplicacion = "2020-06-14 21:00:00";
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(1L, op.get().getId());
	}

	@Test
	void Test4() {
		String fechaAplicacion = "2020-06-15 10:00:00";
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(3L, op.get().getId());
	}

	@Test
	void Test5() {
		String fechaAplicacion = "2020-06-16 21:00:00";
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(4L, op.get().getId());
	}
}
