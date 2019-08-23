import javafx.application.Application;		//Application is the main class needed for javafx programs to make apps.																								
import javafx.stage.Stage;					// Remember theater analogy, The theater has the overall stage which equals the window.												
import javafx.scene.Scene;					// What's inside the window or stage is the scene, and what's in the scene are panes, and what's in
import javafx.scene.layout.BorderPane;		// the panes are buttons. For example, the equals sign is a button, that goes into a pane, for this 
import javafx.scene.layout.GridPane;		// program I used the border pane. That pane goes into the scene and the scene is inside the 
import javafx.scene.text.Font;				// stage. When the stage is shown or window, what is seen is a button inside of a pane inside of a 
import javafx.scene.text.FontPosture;		// scene
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;			
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GUICalculator extends Application

{
	MemoryCalculatorBluePrintClass classLevelObject = new MemoryCalculatorBluePrintClass();	// Class level object so I can call for the operator
	TextField textField = new TextField("0.0");												// methods essentially.
	String currentOperand = null;
	boolean isBuildingNumber = false;
	
	public static void main(String[] args)							// I need this so I can simply launch the application.
	{
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) 
	{	

		DigitHandler handlerForDigits = new DigitHandler();				// Here I'm creating a handler object for my different buttons.
		OperatorHandler handlerForOperators = new OperatorHandler();	// What the handler does is it handles the event, the event being
		ClearHandler handlerForClear = new ClearHandler();				// when the user presses a button.
		EqualsHandler handlerForEquals = new EqualsHandler();
		
		BorderPane borderPane = new BorderPane();	// I need border pane layout for the text field showing the current value, and the equals button.
		GridPane gridPane = new GridPane();			// The grid pane is perfect for the buttons in the middle.
					
													
		textField.setEditable(false);				// setEditable(false) makes it so no one can tamper with the text box for the current value.
		textField.setPrefSize(250, 60);				// Width of 250 units and height of 60 units.
		textField.setFont(Font.font("monospaced",FontWeight.BOLD, FontPosture.REGULAR,20));	// This changes how the current value looks.
		
		Button equalsButton = new Button("=");	
		equalsButton.setOnAction(handlerForEquals);
		equalsButton.setPrefSize(350, 100);								
		borderPane.setTop(textField);									// text field is in the top pane.
		borderPane.setCenter(gridPane);									// This is a pane inside a pane essentially, the gridPane is put inside	the middle of the borderPane.											
		borderPane.setBottom(equalsButton);								// Here I am putting the equals button inside the bottom pane.
		
		Button button7 = new Button("7");
		button7.setOnAction(handlerForDigits);		// When button 7 is pressed, I use the setOnAction method to call for the handler where
		button7.setPrefSize(65, 50);				// the handler tackles the event, again the event being clicking button 7.							
		gridPane.add(button7, 0, 0);
																	
		Button button8 = new Button("8");			// All the preceding buttons follow the same idea as with 7.
		button8.setOnAction(handlerForDigits);		// Important to know, when I'm adding a button to the grid pane, it's put in the column, then
		button8.setPrefSize(65, 50);				// row, so "7" through "/" is on row 0 and the column changes by a factor of 5 units.							
		gridPane.add(button8, 5, 0);
		
		Button button9 = new Button("9");			
		button9.setOnAction(handlerForDigits);
		button9.setPrefSize(65, 50);									
		gridPane.add(button9, 10, 0);
		
		Button buttonDivide = new Button("/");			// end row 0.
		buttonDivide.setOnAction(handlerForOperators);
		buttonDivide.setPrefSize(65, 50);
		gridPane.add(buttonDivide, 15,0 );								
		
		Button button4 = new Button("4");				// "4 through * row 1 column changes by 5 each time.
		button4.setOnAction(handlerForDigits);
		button4.setPrefSize(65, 50);
		gridPane.add(button4, 0, 1);
		
		Button button5 = new Button("5");
		button5.setOnAction(handlerForDigits);
		button5.setPrefSize(65, 50);
		gridPane.add(button5, 5, 1);
		
		Button button6 = new Button("6");
		button6.setOnAction(handlerForDigits);
		button6.setPrefSize(65, 50);
		gridPane.add(button6, 10, 1);
		
		Button buttonMultiply = new Button("*");					// end row 1.
		buttonMultiply.setOnAction(handlerForOperators);
		buttonMultiply.setPrefSize(65, 50);
		gridPane.add(buttonMultiply, 15, 1);
		
		Button button1 = new Button("1");						// "1" through "-" row 2
		button1.setOnAction(handlerForDigits);
		button1.setPrefSize(65, 50);
		gridPane.add(button1, 0, 2);
		
		Button button2 = new Button("2");
		button2.setOnAction(handlerForDigits);
		button2.setPrefSize(65, 50);
		gridPane.add(button2, 5, 2);
		
		Button button3 = new Button("3");
		button3.setOnAction(handlerForDigits);
		button3.setPrefSize(65, 50);
		gridPane.add(button3, 10, 2);
		
		Button buttonMinus = new Button("-");					// end row 2.
		buttonMinus.setOnAction(handlerForOperators);
		buttonMinus.setPrefSize(65, 50);
		gridPane.add(buttonMinus, 15, 2);
		
		Button buttonClear = new Button("C");					// "C" through "+" row 3
		buttonClear.setOnAction(handlerForClear);
		buttonClear.setPrefSize(65, 50);
		gridPane.add(buttonClear, 0, 3);
		
		Button button0 = new Button("0");
		button0.setOnAction(handlerForDigits);
		button0.setPrefSize(65, 50);
		gridPane.add(button0, 5, 3);
		
		Button buttonPeriod = new Button(".");
		buttonPeriod.setOnAction(handlerForDigits);
		buttonPeriod.setPrefSize(65, 50);
		gridPane.add(buttonPeriod, 10, 3);
		
		Button buttonAdd = new Button("+");					// end row 3.
		buttonAdd.setOnAction(handlerForOperators);
		buttonAdd.setPrefSize(65, 50);
		gridPane.add(buttonAdd, 15, 3);
		
		Scene scene = new Scene(borderPane,250,350);	// I put the whole border pane of size 250X350 in the scene object. Remember,
														// the grid pane is inside this border pane.
		primaryStage.setResizable(false);							// setResizable makes it so no one can tamper with the size of the calculator.
		primaryStage.setTitle("Calculator");						// I set the title for the stage.
		primaryStage.setScene(scene);								// I set the scene just like I'm setting up a scene for a play.
		primaryStage.show();										// Show the play or App!
	
	}
	
	class DigitHandler implements EventHandler<ActionEvent>		//DigitHandler which is one of my inner classes inside the big class.
	{
		public void handle(ActionEvent event)	
		{
			System.out.println("Digits pressed.");
			
			if (isBuildingNumber)
			{
				textField.appendText(((Button) event.getSource()).getText());
			}
			else if (currentOperand != null)
			{
				textField.clear();				
				isBuildingNumber = true;
				textField.setText(((Button) event.getSource()).getText());	// This line essentially sets the text of the text field to the 
			}																// button selected through getting the source of the event.
		}
	}
	
	class OperatorHandler implements EventHandler<ActionEvent>		//OperatorHandler inner class 2.
	{
		@Override
		public void handle(ActionEvent event)
		{
			System.out.println("Operators triggered.");
			currentOperand = ((Button) event.getSource()).getText();
		}
	}
	
	class ClearHandler implements EventHandler<ActionEvent>		//ClearHandler inner class 3.
	{
		@Override
		public void handle(ActionEvent event)
		{
			System.out.println("Cleared");
			classLevelObject.clear();
			textField.setText(String.valueOf(classLevelObject.getCurrentValue()));
			currentOperand = null;
			isBuildingNumber = false;
		}
	}
	
	class EqualsHandler implements EventHandler<ActionEvent>	//EqualsHandler inner class 4.
	{
		@Override
		public void handle(ActionEvent event)
		{
			try
			{
				switch(currentOperand)	// For each case I call for the appropriate method, use the Double class to set the value of the text field to a double.
				{
				case "/":	classLevelObject.divide(Double.valueOf(textField.getText()));
						  	break;
						  	
				case "+": 	classLevelObject.add(Double.valueOf(textField.getText()));
							break;
							
				case "-": 	classLevelObject.subtract(Double.valueOf(textField.getText()));
							break;
							
				case "*": 	classLevelObject.multiply(Double.valueOf(textField.getText()));
				
				default:
							break;
				}
			}
			catch (Exception ex)	// In the case a user presses 3..45 for example then an alert box pops up saying ERROR!
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Message");
				alert.setContentText("Incorrect value choosen, make sure if you input a decimal you don't have multiple decimal points.");
				alert.showAndWait();
			}
			finally
			{
				textField.setText(String.valueOf(classLevelObject.getCurrentValue()));	// Whether the exception goes through or not, this is
				currentOperand = null;													// what needs to happen.							
				isBuildingNumber = false;											
			}
		}
	}
}





