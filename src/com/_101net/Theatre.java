package com._101net;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		int lastRow = 'A' + (numRows - 1);
		
		for (char row = 'A'; row <= lastRow; row++) { // going through all the rows from A to Z
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println("Seat: " + seat.getSeatNumber());
		}
	}
	
	private class Seat {
		
		private final String seatNumber;
		private boolean isReserved = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
			
		}
		
		public boolean reserve() {
			if (! this.isReserved) {
				this.isReserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			} else {
				System.out.println("There was a problem reserving seat " + seatNumber);
				return false;
			}
		}
		
		public boolean cancel() {
			if (this.isReserved) {
				this.isReserved = false;
				System.out.println("Reservation of seat " + seatNumber + " cancelled");
				return true;
			} else {
				return false;
			}
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}
	}
}
