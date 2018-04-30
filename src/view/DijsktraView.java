package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Graph;

public class DijsktraView extends BorderPane implements Observer {

	// model variable(s)
	private Graph theGraph;
	// view variable(s)
	private GridPane gp;
	// static variable(s)
	public static final int width = 500;
	public static final int height = 400;
	
	@Override
	public void update(Observable o, Object arg) {
		// update the graph
		theGraph = (Graph) o;
	}
	
	// constructor 
	public DijsktraView (Graph g) {
		// set the graph
		theGraph = g;
		// init grid pane
		gp = new GridPane();
		// set grid pane to center
		this.setCenter(gp);
		// init the pane
		initializePane();
	}
	
	// grid pane initializer
	private void initializePane() {
		// TODO: init grid pane variables like text fields, labels, buttons, etc.
		
		// set grid pane width & height
		gp.setPrefSize(width, height);
		
		// TODO: add any listeners
		
		
	}
	

}
