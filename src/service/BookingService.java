package service;

import java.util.ArrayList;
import java.util.List;

import entity.*;

public class BookingService {

	private List<Booking> bookings;

	public BookingService() {
		this.bookings = new ArrayList<>();
	}

	public void add(Booking booking) {
		bookings.add(booking);
	}

	public void remove(Booking booking) {
		bookings.remove(booking);
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void displayAllBooking() {
		System.out.println("\nAll Booking Details:");
		for (Booking b : bookings) {
			b.displayAllBooking();
		}
	}

	public Booking findBookingByCustomerId(int customerId) {
		for (Booking b : bookings) {
			if (b.getCustomer().getCustomerId() == customerId) {
				return b;
			}
		}
		return null;
	}

	public Booking findBookingByFlightId(int flightId) {
		for (Booking b : bookings) {
			if (b.getFlight().getFlightId() == flightId) {
				return b;
			}
		}
		return null;
	}

	public void saveAllDetailsToFile(String filename) {
		for (Booking b : bookings) {
			b.SaveDetailsToFile(filename);
		}
	}

	public void displayAllCustomers() {
		System.out.println("\nAll Customers:");
		for (Booking b : bookings) {
			System.out.println(b.getCustomer().toString());
		}
	}

	// Method to display all flights
	public void displayAllFlights() {
		System.out.println("\nAll Flights:");
		for (Booking b : bookings) {
			System.out.println(b.getFlight().toString());
		}
	}

}
