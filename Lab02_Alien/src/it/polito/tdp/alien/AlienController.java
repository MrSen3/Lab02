package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionario= new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	//.matches("[a-zA-Z]*");
    	String [] s = txtWord.getText().trim().toLowerCase().split(" ");
    	
    	String alienWord=s[0];
    	String translation;
    	
    	if(s.length==1) {
    		//Siamo nel caso in cui deve restituire la traduzione se presente nel vocabolario
    		if(alienWord.matches("[a-zA-Z]*")) {
    			if(dizionario.translateWord(alienWord)!=null)
    				txtResult.appendText(dizionario.translateWord(alienWord));
    			else
    				txtResult.appendText("Nessuna traduzione presente!\n");
    		}
    		else
    			txtResult.appendText("La parola scritta contiene caratteri incompatibili\n");
    			
    		
    		txtWord.clear();
    	}
    		
    	else if(s.length==2){
    		//Qui deve aggiungere la parola aliena e la relativa traduzione
    		translation=s[1];
    		if(alienWord.matches("[a-zA-Z]*") && translation.matches("[a-zA-Z]*")) {
    			txtResult.appendText("Nuova traduzione aggiunta per la parola aliena: '" +alienWord+ "' \n");
    			dizionario.addWord(alienWord, translation);
    			}
    		
    		else
    			txtResult.appendText("La parola scritta contiene caratteri incompatibili.\n");
    	}
    	else {
    		txtResult.appendText("Errore! Scrivere una parola per ottenere la traduzione o due separate da uno spazio per aggiornare il dizionario!\n");
    	}
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
