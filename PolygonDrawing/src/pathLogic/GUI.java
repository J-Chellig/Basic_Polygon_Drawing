package pathLogic;

import javafx.scene.canvas.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class GUI extends Application {
	
	public Canvas mainstage = new Canvas(700, 700);
	public DataManagement lineControl = new DataManagement();
	public GraphicsContext g = mainstage.getGraphicsContext2D();
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public void start(Stage stage) {
		
		mainstage.setOnMouseClicked(evt -> onMouseClick(evt));
		BorderPane root = new BorderPane();
		root.setCenter(mainstage);
	
		Scene scene = new Scene(root, 700, 700);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Polygon drawing");
		
	}

	public void onMouseClick(MouseEvent evt) {
		
		double[] newCords =  new double[2];
		
		newCords[0] = evt.getX();
		newCords[1] = evt.getY();
		
		lineControl.decidingOnClick(newCords);
		drawingChoices();
	}
	
	public void drawingChoices() {
		
		g.setStroke(Color.BLACK);
		g.setFill(Color.RED);
		
		switch(lineControl.getCurrentState()) {
		
		case DRAWING: {
		
		g.strokeLine(lineControl.getPastPosition()[0], lineControl.getPastPosition()[1], 
				lineControl.getCurrentPos()[0], lineControl.getCurrentPos()[1]);
		
		return;
		
		
		}
		case RESET: {
			
		g.clearRect(0, 0, mainstage.getWidth(), mainstage.getHeight());	
		return;	
		}
		
		case COMPLETED: {
		
			g.strokePolygon(lineControl.getxCords(), lineControl.getyCords(), lineControl.getCount());
			g.fillPolygon(lineControl.getxCords(), lineControl.getyCords(), lineControl.getCount());
			return;
		}
		
		
		
		
	}
		
		
		
		
		
		
	}
	
	
	
	
}
