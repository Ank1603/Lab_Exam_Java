package entity;

import exception.SeatsAvailableException;

public class Flight {

	private int flightId;
	private String destination;
	private String departureTime;
	private int seatsAvailable;
	private double ticketPrice;
	private int numTickets;
	
	public Flight(int flightId, String destination, String departureTime, int seatsAvailable, double ticketPrice
			)throws SeatsAvailableException {
		if (seatsAvailable <= 0) {
			throw new SeatsAvailableException("Seats Not Available");
		}

		this.flightId = flightId;
		this.destination = destination;
		this.departureTime = departureTime;
		this.seatsAvailable = seatsAvailable;
		this.ticketPrice = ticketPrice;
		
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", destination=" + destination + ", departureTime=" + departureTime
				+ ", seatsAvailable=" + seatsAvailable + ", ticketPrice=" + ticketPrice + "]";
	}

	
	


	
	
}
