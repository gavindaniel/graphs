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
import model.Edge;
import model.Graph;
import model.Vertex;
import view.DijsktraView;
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
//		theGraph = new Graph();
		theGraph = initializeGraph1();
		// run DFS
		System.out.print("DFS starting at Vertex 1 -> ");
		theGraph.DFS(1);
		System.out.println();
		// run BFS
		System.out.print("BFS starting at Vertex 1 -> ");
		theGraph.BFS(1);
		System.out.println();
		
		// create  view(s)
		
		dijsktraView = new DijsktraView(theGraph);
		BFSView = new BFSView(theGraph);
		DFSView = new DFSView(theGraph);
		// set initial view
		setViewTo(BFSView);
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
		MenuItem exitMI = new MenuItem("Exit");
		// create the menu
		Menu menu = new Menu("Options");
		// add menu item(s) to menu
		menu.getItems().addAll(bfsMI, dfsMI, dijsktraMI, exitMI);
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
		}
		
	}
	
	private Graph initializeGraph1() {
		
		Graph g = new Graph();
		// init vertices 
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);
		Vertex v10 = new Vertex(10);
		// init edges 
//		Edge e1 = new Edge(v1, v2, 1);
//		v1.addEdge(e1);
		
		// vertex 1 adjacent
		v1.addAdjacentVertex(v2);
		v1.addAdjacentVertex(v3);
		v1.addAdjacentVertex(v4);
		// vertex 2 adjacent
		v2.addAdjacentVertex(v1);
		v2.addAdjacentVertex(v3);
		v2.addAdjacentVertex(v4);
		// vertex 3 adjacent
		v3.addAdjacentVertex(v1);
		v3.addAdjacentVertex(v2);
		v3.addAdjacentVertex(v4);
//		v3.addAdjacentVertex(v5);
		// vertex 4 adjacent
		v4.addAdjacentVertex(v1);
		v4.addAdjacentVertex(v2);
		v4.addAdjacentVertex(v3);
		v4.addAdjacentVertex(v6);
		// vertex 5 adjacent
		v5.addAdjacentVertex(v6);
		v5.addAdjacentVertex(v7);
		v5.addAdjacentVertex(v8);
//		v5.addAdjacentVertex(v3);
		// vertex 6 adjacent
		v6.addAdjacentVertex(v4);
		v6.addAdjacentVertex(v5);
		v6.addAdjacentVertex(v7);
		// vertex 7 adjacent
		v7.addAdjacentVertex(v5);
		v7.addAdjacentVertex(v6);
		v7.addAdjacentVertex(v8);
		// vertex 8 adjacent
		v8.addAdjacentVertex(v5);
		v8.addAdjacentVertex(v7);
		v8.addAdjacentVertex(v10);
		// vertex 9 adjacent
		v9.addAdjacentVertex(v8);
		v9.addAdjacentVertex(v10);
		// vertex 10 adjacent
		v10.addAdjacentVertex(v8);
		v10.addAdjacentVertex(v9);
		
		
		g.add(v1);
		g.add(v2);
		g.add(v3);
		g.add(v4);
		g.add(v5);
		g.add(v6);
		g.add(v7);
		g.add(v8);
		g.add(v9);
		g.add(v10);
		// set root of graph
		g.setRoot(v1);
		// add vertices to graph
		
		
		return g;
		
	}
}
