
public class MemoryCalculatorBluePrintClass	// This is the class I used for the memory calculator, the main use of this are the operator methods
{											// and clear. I deleted the menu and the operand method.
	MemoryCalculatorBluePrintClass()	// Constructor, It essentially constructs objects for the class.
	{
		currentValue = 0.0;	
	}
	
	private double currentValue; // Field Variable Private to this class.

	public double getCurrentValue()	// Getter, it gets whatever the current value is.
	{
		return currentValue;
	}
	
	public void add(double operand2)	//add
	{																	//operand2 = getOperand("What is the second number?");
		currentValue += operand2;										// I don't need this line of code because when I click
	}																	// on equals it essentially does this.
																		// If I was to have that line, when I press the equals button,
	public void subtract(double operand2)	//Subtract					// the program would crash and wouldn't know what to do.
	{
		currentValue -= operand2;	
	}
	
	public void multiply(double operand2)	//Multiply
	{
		currentValue *= operand2;	
	}
	
	public void divide(double operand2)		//Divide
	{
		currentValue /= operand2;
		
		if (operand2 == 0.0)	//Division by zero.
		{
			 currentValue = Double.NaN;
		}
	}
	
	public void clear()	// Clear
	{
		currentValue = 0.0;
	}
}