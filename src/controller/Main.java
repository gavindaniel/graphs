package controller;

import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import model.Edge;
import model.Graph;
import view.DijsktraView;
import view.FloydView;
import view.BFSView;
import view.DFSView;

public class Main extends Application {

	// model variable
	private Graph theGraph;			// the Graph
	// observer variable(s)
	private Observer currentView;
	private Observer BFSView;
	private Observer DFSView;
	private Observer dijsktraView;
	private Observer floydView;
	// stage variables
	private BorderPane window;
	private MenuBar menuBar;
	// static variables 
	public static final int width = 500;
	public static final int height = 500;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// set stage title
		primaryStage.setTitle("Graphs 'n' Stuff");
		// create new window to put stuff in
		window = new BorderPane();
		// create new scene to put window in
		Scene scene = new Scene(window, width, height);
		// setup sub menus
		setupMenus();
		// set the menu bar to the top of the window
		window.setTop(menuBar);
		// create a new model
		theGraph = Graph.graph1();
		// create  view(s)
		dijsktraView = new DijsktraView(theGraph);
		BFSView = new BFSView(theGraph);
		DFSView = new DFSView(theGraph);
		floydView = new FloydView(theGraph);
		// set initial view
		setViewTo(dijsktraView);
		// set the stage scene
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}
	
	private void setupMenus() {
		// create menu items 
		MenuItem bfsMI = new MenuItem("BFS");
		MenuItem dfsMI = new MenuItem("DFS");
		MenuItem dijsktraMI = new MenuItem("Dijsktra");
		MenuItem floydMI = new MenuItem("Floyd");
		MenuItem exitMI = new MenuItem("Exit");
		// create the menu
		Menu menu = new Menu("Options");
		// add menu item(s) to menu
		menu.getItems().addAll(bfsMI, dfsMI, dijsktraMI, floydMI, exitMI);
		// create menu bar
		menuBar = new MenuBar();
		// add menu to menu bar
		menuBar.getMenus().addAll(menu);
		// create menu listener
		MenuItemListener menuListener = new MenuItemListener();
		// add the menu listener to the menu item(s)
		bfsMI.setOnAction(menuListener);
		dfsMI.setOnAction(menuListener);
		dijsktraMI.setOnAction(menuListener);
		floydMI.setOnAction(menuListener);
		exitMI.setOnAction(menuListener);
	}
	
	private void setViewTo(Observer newView) {
		// clear the window
		window.setCenter(null);
		// set current view to new view
		currentView = newView;
		// set the window to the new view
		window.setCenter((Node) currentView);
	}
	
	private class MenuItemListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// create text for menu item text
			String text = ((MenuItem) event.getSource()).getText();
			// check which menu item was selected
			if (text.equals("Exit"))
				System.exit(0);
			else if (text.equals("BFS"))
				setViewTo(BFSView);
			else if (text.equals("DFS"))
				setViewTo(DFSView);
			else if (text.equals("Dijsktra"))
				setViewTo(dijsktraView);
			else if (text.equals("Floyd"))
				setViewTo(floydView);
		}
		
	}
}
