package org.java.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
	private BigDecimal price;
	private LocalTime hour;

	public Concerto(String titolo, LocalDate data, int postiTotali, BigDecimal price, LocalTime hour) throws Exception {
		super(titolo, data, postiTotali);
		setPrice(price);
		setHour(hour);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) throws Exception {
		if(price.compareTo(BigDecimal.ZERO) < 0 ) {
			throw new Exception("il prezzo non può essere negativo");
		}
		this.price = price;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		
		return super.toString()+ "\n"
				+ "il concerto si terrà alle ore: " + getHour()+ "\n"
				+ "il prezzo del concerto è: "+String.format("%.2f", getPrice())+"€";
	}
}
