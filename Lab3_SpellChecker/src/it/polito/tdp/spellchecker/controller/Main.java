package it.polito.tdp.spellchecker.controller;



import it.polito.tdp.spellchecker.controller.SpellCheckerController;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application  {
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SpellChecker.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			SpellCheckerController controller = loader.getController() ;
			Dictionary dictionary= new Dictionary() ;
			controller.setModel(dictionary) ;
			
			Scene scene = new Scene(root);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}