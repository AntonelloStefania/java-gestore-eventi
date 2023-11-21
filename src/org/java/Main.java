package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.java.pojo.Concerto;
import org.java.pojo.Evento;
import org.java.pojo.ProgrammaEventi;

public class Main {
	public static void main(String[] args) throws Exception  {
		int intPrenotazioni =0;
		int intDisdette = 0;
		BigDecimal price = null;
		LocalTime hourTime = null;
		Evento event = null;
		Scanner in = new Scanner(System.in);
		LocalDate dateEvent = null;
		
		System.out.print("titolo lista programma-eventi: ");
		String programTitle = in.nextLine();
		ProgrammaEventi eventi = new ProgrammaEventi(programTitle);
		
		
		while(true) {
			
		
			System.out.print("qual è il titolo dell'evento? ");
			String title = in.nextLine();
			
			System.out.print("qual è la data dell'evento? dd-mm-yyyy ");
			String eventDate = in.nextLine();
			dateEvent = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			System.out.print("posti totali dell'evento? ");
			String strPosti = in.nextLine();
			int intPosti = Integer.valueOf(strPosti);
			
			System.out.print("vuoi aggiungere prenotazioni? y/n ");
			String strAddPrenotazioni = in.nextLine();
			
			
			if(strAddPrenotazioni.equals("y")) {				
				System.out.print("quante prenotazioni vuoi aggiungere? ");
				String strPrenotazioni = in.nextLine();
			    intPrenotazioni = Integer.valueOf(strPrenotazioni);
			}
			
			System.out.print("vuoi disdire prenotazioni? y/n ");
			String strDelPrenotazioni = in.nextLine();
			
			if(strDelPrenotazioni.equals("y")) {
				
				System.out.print("quante prenotazioni vuoi disdire?");
				String strDisdette = in.nextLine();
				intDisdette = Integer.valueOf(strDisdette);
			}
			
			System.out.print("questo evento e' un concerto? y/n ");
			String concerto = in.nextLine();
			
			if(concerto.equals("y")) {
				System.out.print("a che ora è il concerto? hh:mm ");
				String strHour = in.nextLine();
				int hour = Integer.valueOf(strHour.split(":")[0]);
				int min = Integer.valueOf(strHour.split(":")[1]);
				
				 hourTime = LocalTime.of(hour, min);
				
				System.out.print("prezzo del biglietto? ");
				String strPrice = in.nextLine();
				 price = new BigDecimal(strPrice);
				 
				 
			}
			
				try {
					switch(concerto) {
					case "y": event = new Concerto(title, dateEvent, intPosti, price, hourTime); break;
					case "n": event = new Evento(title,dateEvent, intPosti ); break;
					}
					
					eventi.addEvento(event);
					
				    
					System.out.println(event);
					System.out.println("\n-------------------------------\n");
					
					for(int x = 0; x < intPrenotazioni; x++) {
						event.addPrenotazione();
						
					}
					System.out.println("posti prenotati: " +event.getPostiPrenotati()+"/"+event.getPostiTotali());
					for(int y = 0; y<intDisdette; y++) {
						event.eliminatePrenotazione();
					}
					System.out.println("\n-------------------------------\n");
					System.out.println("posti prenotati dopo le disdette: " +event.getPostiPrenotati()+"/"+event.getPostiTotali());

					
				} catch (Exception e) {
					System.err.println("Errore: " + e.getMessage());
				}
				
				System.out.println("\n----------------------\n");
				System.out.print("vuoi aggiungere un evento? y/n ");
				String userAnsw = in.nextLine();
				if(!userAnsw.equals("y")) {
					
					System.out.print("vuoi filtrare gli elementi in una determinata data? y/n ");
					String filterAns = in.nextLine();
					if(filterAns.equals("y")) {
						System.out.print("inserisci una data in formato dd-mm-yyyy ");
						String dateAns = in.nextLine();
						LocalDate formattedDateAns = LocalDate.parse(dateAns, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
						System.out.println(eventi.getEventiFiltrati(formattedDateAns));
					}
					
					System.out.print("vuoi eliminare tutti gli elementi nella lista? y/n ");
					String delAns = in.nextLine();
					if(delAns.equals("y")) {
						eventi.removeAllEvent();
						System.out.println("la lista " + programTitle + " è stata svuotata");
						
						return;
					}
					break;
				}
				
		}
		
		
		System.out.println(eventi.eventiTotali(eventi.getEventi()));
		System.out.println("numero di eventi salvati: " + eventi.eventoList());
			
		in.close();
	}
}
