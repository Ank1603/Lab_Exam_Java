package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import exception.*;
import entity.*;
import service.*;


public class Test {

	public static void main(String[] args) {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BookingService bookingservice = new BookingService();
		boolean continueRunning = true;


		try {
			do {
			System.out.println("\n===== Airline Booking System =====");
			System.out.println("1. Add Customer and Booking");
			System.out.println("2. Add Flight");
			System.out.println("3. Remove Customer");
			System.out.println("4. Remove Flight");
			System.out.println("5. Display All Bookings");
			System.out.println("6. Update Customer");
			System.out.println("7. Update Flight");
			System.out.println("8. Display All Customers");
			System.out.println("9. Display All Filghts");
			System.out.println("0. Exit");
			System.out.println("==================================");
			System.out.print("Choose an option: ");

			int choice = Integer.parseInt(read.readLine());

			switch (choice) {
			case 1: 
				System.out.println("Enter Customer id:");
				int id = Integer.parseInt(read.readLine());
				System.out.println("Enter Customer name:");
				String name = read.readLine();
				System.out.println("Enter Contact Number");
				String contactNo = read.readLine();

				Customer customer = new Customer(id, name, contactNo);

				System.out.println("Enter Flight id: ");
				int flightId = Integer.parseInt(read.readLine());
				System.out.println("Enter Destination:");
				String destination = read.readLine();
				System.out.println("Enter Departure Time:");
				String departureTime = read.readLine();
				System.out.println("Enter Seats Available For this flight:");
				int seatsAvailable = Integer.parseInt(read.readLine());
				System.out.println("Enter Price for one Ticket");
				int ticketPrice = Integer.parseInt(read.readLine());

				Flight flight = new Flight(flightId, destination, departureTime, seatsAvailable, ticketPrice);

				Booking booking = new Booking(customer, flight);
				bookingservice.add(booking);
				bookingservice.saveAllDetailsToFile("D:\\Ankita\\Airline.txt");

				System.out.println("Customer and Booking added successfully.");
				break;

			case 2:
				System.out.println("Enter Flight id: ");
				flightId = Integer.parseInt(read.readLine());
				System.out.println("Enter Destination:");
				destination = read.readLine();
				System.out.println("Enter Departure Time:");
				departureTime = read.readLine();
				System.out.println("Enter Seats Available For this flight:");
				seatsAvailable = Integer.parseInt(read.readLine());
				System.out.println("Enter Price for one Ticket");
				ticketPrice = Integer.parseInt(read.readLine());
				System.out.println("Number of tickets are: ");
				

				flight = new Flight( flightId,  destination,  departureTime,  seatsAvailable,  ticketPrice);
				System.out.println("Flight added successfully.");
				break;
				
			case 3: 
				System.out.println("Enter Customer ID to remove:");
				int CustomerId = Integer.parseInt(read.readLine());

				Booking bookingToRemove = null;
				for (Booking b : bookingservice.getBookings()) {
					if (b.getCustomer().getCustomerId() == CustomerId) {
						bookingToRemove = b;
						break;
					}
				}
				if (bookingToRemove != null) {
					bookingservice.remove(bookingToRemove);
					System.out.println("Customerremoved successfully.");
				} else {
					System.out.println("Customer not found.");
				}
				break;

			case 4: 
				System.out.println("Enter Flight ID to remove:");
				flightId = Integer.parseInt(read.readLine());

				Booking flightToRemove = null;
				for (Booking b : bookingservice.getBookings()) {
					if (b.getFlight().getFlightId() == flightId) {
						flightToRemove = b;
						break;
					}
				}
				if (flightToRemove != null) {
					bookingservice.remove(flightToRemove);
					System.out.println("Flight removed successfully.");
				} else {
					System.out.println("Flight not found.");
				}
				break;

			case 5: 
				bookingservice.displayAllBooking();
				break;

			case 6: 
				System.out.println("Enter Customer ID to update:");
				CustomerId = Integer.parseInt(read.readLine());

				for (Booking b : bookingservice.getBookings()) {
					if (b.getCustomer().getCustomerId() == CustomerId) {
						System.out.println("Enter new Customer Name:");
						String newName = read.readLine();
						System.out.println("Enter new Contact Number:");
						String newContactNo = read.readLine();
						b.getCustomer().setCustomerName(newName);
						b.getCustomer().setContactNumber(newContactNo);
						System.out.println("Customer details updated successfully.");
						break;
					}
				}
				break;

			case 7: 
				System.out.println("Enter Flight ID to update:");
				flightId = Integer.parseInt(read.readLine());

				for (Booking b : bookingservice.getBookings()) {
					if (b.getFlight().getFlightId() == flightId) {
						System.out.println("Enter new Destination:");
						String newDestination = read.readLine();
						System.out.println("Enter new Departure Time:");
						String newDepartureTime = read.readLine();
						System.out.println("Enter new Seats Available:");
						int newSeatsAvailable = Integer.parseInt(read.readLine());
						System.out.println("Enter new Ticket Price:");
						double newTicketPrice = Double.parseDouble(read.readLine());

						b.getFlight().setDestination(newDestination);
						b.getFlight().setDepartureTime(newDepartureTime);
						b.getFlight().setSeatsAvailable(newSeatsAvailable);
						b.getFlight().setTicketPrice(newTicketPrice);
						System.out.println("Flight details updated successfully.");
						break;
					}
				}
				break;

			case 8: 
				bookingservice.displayAllCustomers();
				break;

			case 9: 
				bookingservice.displayAllFlights();
				break;

			case 0: 
				System.out.println("Thank You...");
				break;

			default:
				System.out.println("Invalid option. Please select correct.");
			}
		}while (continueRunning);

		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid input. Please enter correct data.");
		} catch (SeatsAvailableException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
