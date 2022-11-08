package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Reserva Gui = new  Reserva(101, LocalDate.parse("2022-11-08"), LocalDate.parse("2022-11-10"));
		System.out.print(Gui.toString());
		
		sc.close();
	}

}
