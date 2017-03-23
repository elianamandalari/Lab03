/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	Dictionary dictionary;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbLanguange"
    private ComboBox<String> cmbLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="txtInputWords"
    private TextArea txtInputWords; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtWrongWords"
    private TextArea txtWrongWords; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrors"
    private Label lblErrors; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="lblTime"
    private Label lblTime; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    txtWrongWords.clear();
    txtInputWords.clear();
    lblErrors.setText("");
    lblTime.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    long t1=System.nanoTime();	
    	dictionary.loadDictionary(cmbLanguage.getValue());
    	String parolaInput=txtInputWords.getText().toLowerCase().replaceAll("\\p{Punct}","");
    	String[] array=parolaInput.split(" ");
    	int count=0;
    	 List<String> listaInput=new ArrayList<String>();
    	 String result="";
    	 
    	for(int i=0;i<array.length;i++)
    		listaInput.add(array[i]);
    	
    		
    			if(array.length<0)
    				lblErrors.setText("Devi inserire almeno una parola");
    			
    			
    			for(RichWord r:dictionary.spellCheckText(listaInput)){
    				if(r.isCorretta()==false){
    					result+=r.getParola()+"\n";
    					count++;
    				}
    			}
    			
         txtWrongWords.setText(result);
    lblErrors.setText("The text contains "+count+" errors");
    	lblTime.setText("Spell check completed in "+(System.nanoTime()-t1)/1e9+" seconds");
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguange\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInputWords != null : "fx:id=\"txtInputWords\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrors != null : "fx:id=\"lblErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        cmbLanguage.getItems().addAll("English","Italian");
    }
    public void setModel(Dictionary dictionary){
    	this.dictionary=dictionary;
    }
}

