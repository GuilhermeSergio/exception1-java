package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reserva() {
	}
	public Reserva(Integer numeroQuarto, LocalDate checkin, LocalDate checkout) throws DomainException {
		if(checkout.isBefore(checkin)) {
			throw new DomainException("Data invalida");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
		
	}
	
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		Duration d1 = Duration.between(checkin.atTime(0, 0), checkout.atTime(0, 0));
		return d1.toDays();
	}
	public void updateDatas(LocalDate checkout, LocalDate checkin) throws DomainException {
		LocalDate now = LocalDate.now();
		if(now.isBefore(checkin)&&now.isBefore(checkout)&&checkin.isBefore(checkout)) {
			this.checkin = checkin;
			this.checkout = checkout;
			System.out.print(toString());
			throw new DomainException("Sucesso");
		}
		throw new DomainException("Data invalida");
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: Quarto  ");
		sb.append(getNumeroQuarto()+", ");
		sb.append("Check-in: ");
		sb.append(getCheckin().format(fm1)+", ");
		sb.append("Check-out: ");
		sb.append(getCheckout().format(fm1)+", ");
		sb.append(duracao()+" noites.");
		
		return sb.toString();
	}
}
