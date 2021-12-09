package com._101net;

public class Main {
	
	public static void main(String[] args) {
		Theatre theatre = new Theatre("Olympian", 10, 12);
		theatre.getSeats();
		if (theatre.reserveSeat("H11")) {
			System.out.println("Please pay");
		} else {
			System.out.println("Sorry, seat is taken");
		}
		// repeated to show "Sorry, ..."
		//
		if (theatre.reserveSeat("H11")) {
			System.out.println("Please pay");
		} else {
			System.out.println("Sorry, seat is taken");
		}
	}
}
