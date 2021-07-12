import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		
		int pos = 0;
		for(int i=0;i<buttons.length;i++)
		{
			if(buttonClicked==buttons[i])
			{
				pos = i;
				break;
			}
		}
		if((Math.abs(emptyCellId-pos)==1)||(Math.abs(emptyCellId-pos)==4))
		{
			swapButton(buttons[emptyCellId], buttonClicked);
			return pos;
		}
		else
			return emptyCellId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		int[] count = new int[15];
		//Your logic here
		int a;
		for(int i=0;i<15;i++)
		{
			a = getRandomNumber() % 15;
			while(count[a]!=0)
			{
				a = getRandomNumber() % 15;
			}
			count[a] = 1;
			
			if(a == 0)
			{
				a=15;
			}
			
			arr[i] = a;
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] buttonIds = new int[15];
		buttonIds = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<14;i++)
			if(buttonIds[i]>buttonIds[i+1])
				winner = false;

		return winner;
	}
}