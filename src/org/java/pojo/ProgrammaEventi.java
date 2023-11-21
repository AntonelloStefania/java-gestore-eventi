package org.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {

	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammaEventi(String titolo) {
		setTitolo(titolo);
		setEventi(new ArrayList<>());
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void addEvento(Evento e){
		getEventi().add(e);
	}
	
	public int eventoList() {
		return getEventi().size();
	}
	
	public void removeAllEvent() {
		getEventi().clear();
	}
	
	  public List<Evento> getEventiFiltrati(LocalDate data){
	        
	        List<Evento> filteredEventi = new ArrayList<>();
	        
	        for (Evento evento : getEventi()) {
	            
	            if (evento.getData().isEqual(data)) {
	                
	                filteredEventi.add(evento);
	            }
	        }
	        
	        return filteredEventi;
	    }
	
	public String eventiTotali(List<Evento> eventi) {
		eventi.sort(Comparator.comparing(evento -> evento.getData()));
		

        String strList = "\nEvento: " + getTitolo() + "\n-----------------------\n";
        
        for (Evento evento : eventi) {
            
            String d = evento.dataFormattata();
            
            String t = evento.getTitolo();
            
            strList = strList + d + " - " + t + "\n";
        }
        
        return strList;
	}

}	
	


