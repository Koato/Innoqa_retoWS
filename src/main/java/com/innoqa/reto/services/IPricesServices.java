package com.innoqa.reto.services;

import java.util.List;
import java.util.Optional;
import com.innoqa.reto.dao.Prices;

public interface IPricesServices {
	List<Prices> getPrices();

	Optional<Prices> getPrice(String fechaAplicacion, Long idProducto, Long idCadena);

}