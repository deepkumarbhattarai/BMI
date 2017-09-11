
package application;
/*
 * @Deep Kumar
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMI extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Text height = new Text("Height: ");
		Text weight = new Text("Weight: ");
		Text kg = new Text("kg");
		Text cm = new Text("cm");
		Text bmi = new Text("BMI : ");
		Text comment = new Text("Comment : ");
		TextField heightfield = new TextField();
		TextField weightfield = new TextField();
		Text bmifield = new Text();
		Label comment1 = new Label();
		Button calculate = new Button("Calculate");
		calculate.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event) {
				double hight = 0 ;
				double wight = 0;
				double bmi= 0;
				String formatbmi;
				try {
					hight = Double.parseDouble(heightfield.getText());
					System.out.println(hight);
				}catch(NumberFormatException ex) {
					heightfield.setText("Enter a Decimal");
					bmifield.setText("");
					comment1.setText("");
				}
				try {
					wight = Double.parseDouble(weightfield.getText());
					System.out.println(wight);
				}catch(NumberFormatException ex) {
					weightfield.setText("Enter a Decimal");
					bmifield.setText("");
					comment1.setText("");
				}
				if(hight != 0 && wight != 0) {
					bmi = wight / Math.pow((hight/100), 2.0);
					formatbmi = String.format("%.02f", bmi);
					bmifield.setText(formatbmi);
					if(bmi <= 16) {
						comment1.setText("Severely UnderWeight");
					} else if(bmi >16 && bmi <= 18.5) {
						comment1.setText("UnderWeight");
					}  else if(bmi > 18.5 && bmi <= 25) {
						comment1.setText("Normal");
					} else {
						comment1.setText("Over weight");
					}
				}
				
				
			}
		});
		
		
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(300, 200); 
		gridPane.setPadding(new Insets(100, 100, 100, 100)); 
		gridPane.setVgap(5); 
	    gridPane.setHgap(6); 
	    gridPane.setAlignment(Pos.CENTER); 
	    gridPane.add(height, 0, 0);
	    gridPane.add(heightfield, 1, 0);
	    gridPane.add(weight, 0, 1);
	    gridPane.add(weightfield, 1, 1);
	    gridPane.add(calculate, 1, 2);
	    gridPane.add(bmi,0,7);
	    gridPane.add(bmifield, 1, 7);
	    gridPane.add(comment, 0, 8);
	    gridPane.add(comment1, 1, 8);
	    gridPane.add(cm, 2, 0);
	    gridPane.add(kg, 2,1 );
	    Scene scene = new Scene(gridPane);
		primaryStage.setTitle("BMI Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
