package com.innoqa.reto.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoqa.reto.dao.Prices;
import com.innoqa.reto.repository.IPricesRepository;
import com.innoqa.reto.services.IPricesServices;

@Service("iPricesServices")
public class PricesImpl implements IPricesServices {

	@Autowired
	IPricesRepository pricesRepository;

	@Override
	public Optional<Prices> getPrice(String fechaAplicacion, Long idProducto, Long idCadena) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
		LocalDateTime dateTime = LocalDateTime.parse(fechaAplicacion, formatter);
		List<Prices> prices = getPrices().stream()
				.filter(x -> dateTime.isAfter(x.getStartDate()) && dateTime.isBefore(x.getEndDate()))
				.collect(Collectors.toList());
		if (prices.stream().count() > 1) {
			int mayor = 0;
			for (int i = 0; i < prices.size(); i++) {
				if (prices.get(i).getPriority() > mayor) {
					mayor = prices.get(i).getPriority();
				}
			}
			return Optional.of(prices.get(mayor));
		} else {
			return prices.stream().findFirst();
		}
	}

	@Override
	public List<Prices> getPrices() {
		return StreamSupport.stream(pricesRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}