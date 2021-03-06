package view;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.BFS;
import model.Graph;

public class BFSView extends BorderPane implements Observer {

	// model variable(s)
	private BFS bfs;
	private Graph theGraph;
	// view variable(s)
	private GridPane gp;
	private Button button;
	private TextField textField;
	private Label responseText;
	private Label functionHeader;
	// static variable(s)
	public static final int width = 800;
	public static final int height = 400;
	
	@Override
	public void update(Observable o, Object arg) {
		// update the graph
		theGraph = (Graph) o;
	}
	
	// constructor 
	public BFSView (Graph g) {
		// set the graph
		theGraph = g;
		// init the BFS
		bfs = new BFS(theGraph);
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
		// create button
		button = new Button("Search");
		// create input text field
		textField = new TextField();
		// make the input text field editable
		textField.setEditable(true);
		// create response text
		responseText = new Label("Enter a Vertex to perform BFS from");
		functionHeader = new Label("Breadth First Search");
		// set grid pane width & height
		gp.setPrefSize(width, height);
		// add button listener
		ButtonListener handler = new ButtonListener();
		// set the listener
		button.setOnAction(handler);
		// set position
		GridPane.setConstraints(functionHeader, 1, 1);
		GridPane.setConstraints(textField, 1, 2);
		GridPane.setConstraints(button, 2, 2);
		GridPane.setConstraints(responseText, 1, 3);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.getChildren().addAll(functionHeader, textField, button, responseText);
		
		// TODO: add any listeners
		
		
	}
	
	public class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String text = textField.getText();
			
			if (!text.isEmpty() && (Integer.parseInt(text) < 11 && Integer.parseInt(text) > 0)) {
				bfs = new BFS(theGraph);
				String result = bfs.start(Integer.parseInt(text));
				responseText.setText("BFS for Vertex " + text + " -> " + result); //theGraph.BFS(Integer.parseInt(text)));
				
			} else {
				responseText.setText("Please enter a valid vertex number");
			}
			textField.setText("");
		}
		
	}
	
}
