package it.polito.tdp.alien;

import it.polito.tdp.alien.*;
import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		this.dizionario=new ArrayList<WordEnhanced>();
	}
	
	public void addWord (String alienWord, String translation) {
		WordEnhanced w = new WordEnhanced(alienWord, translation);
		
		for(int i=0; i<dizionario.size(); i++) {
			if(dizionario.get(i).getAlienWord().compareTo(alienWord)==0) { //entra qui solo se la parola che passo come parametro è presente nella lista
				dizionario.get(i).addTranslation(translation);
				System.out.println("Traduzione aggiunta alla lista");
				return;
			}
		}
		System.out.println("Traduzione aggiunta");
		dizionario.add(w);
		
	}
	
	public String translateWord(String alienWord) {
		String x="";
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				for(String s: w.getTranslationList()) {
					x+=s+ "\n";
						
				}
				return x+ "\n";
			}
    	}
		return null;
	}

}
