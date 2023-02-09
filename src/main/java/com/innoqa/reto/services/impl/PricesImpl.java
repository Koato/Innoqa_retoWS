package com.innoqa.reto.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoqa.reto.dao.Brand;
import com.innoqa.reto.dao.Prices;
import com.innoqa.reto.repository.IPricesRepository;
import com.innoqa.reto.services.IPricesServices;

@Service("iPricesServices")
public class PricesImpl implements IPricesServices {

	@Autowired
	IPricesRepository pricesRepository;

	@Override
	public Optional<Prices> getPrice(String fechaAplicacion, Long idProducto, Long idCadena) {
		Optional<Prices> otc = pricesRepository.findById(1L);
		if (otc.isPresent()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
			LocalDateTime dateTime = LocalDateTime.parse(fechaAplicacion, formatter);
			Prices prices = otc.get();
			prices.setStartDate(dateTime);
			prices.setProductId(idProducto);
			Brand brand = new Brand();
			brand.setId(idCadena);
			prices.setBrandId(brand);
			return Optional.of(prices);
		}
		return Optional.empty();
	}
}