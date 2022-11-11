package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		
		System.out.print("Check-in(dd/MM/yyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(),fm1);
		System.out.print("Check-out(dd/MM/yyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(),fm1);
		Reserva Gui = new  Reserva(numeroQuarto, checkin, checkout);
		System.out.println(Gui.toString());
		
		System.out.println("Entre com os dados para atualizar a reserva: ");
		System.out.print("Data de checkin (dd/MM/yyyy): ");
		checkin = LocalDate.parse(sc.next(),fm1);
		System.out.print("Data de checkout (dd/MM/yyyy): ");
		checkout = LocalDate.parse(sc.next(),fm1);
		Gui.updateDatas(checkout, checkin);
		}
		catch(InputMismatchException e) {
			System.out.print("Entre com um numero de quarto valido!");
		}
		catch(DomainException e) {
			System.out.print("\nMensagem da Reserva: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Erro desconhecido!");
		}
	
		sc.close();
	}

}
