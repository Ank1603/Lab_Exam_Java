package entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Booking {

	private Customer customer;
	private Flight flight;

	public Booking(Customer customer, Flight flight) {

		this.customer = customer;
		this.flight = flight;

	}

	public Customer getCustomer() {
		return customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public double getTotalPrice() {
		return flight.getTicketPrice();
	}
	

	public void SaveDetailsToFile(String filename) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			System.out.println("\n========Airline Booking System=======\n");
			writer.write(customer.toString());
			writer.newLine();
			writer.write(flight.toString());
			writer.newLine();
			writer.write("-------------------------");
			writer.newLine();
			System.out.println("Booking saved to file: " + filename);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void displayAllBooking() {

		System.out.println("============================================================================================");
		System.out.println("\nCustomer Details:\n");
		System.out.println(customer.toString() + "\n");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\nFlight Details:\n");
		System.out.println(flight.toString() + "\n");
		System.out.println("============================================================================================");
	}

}
