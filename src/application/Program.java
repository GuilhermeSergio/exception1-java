package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Check-in(dd/MM/yyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(),fm1);
		System.out.print("Check-out(dd/MM/yyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(),fm1);
	
		Reserva Gui = new  Reserva(numeroQuarto, checkin, checkout);
		
		System.out.print(Gui.toString());
		
		sc.close();
	}

}
