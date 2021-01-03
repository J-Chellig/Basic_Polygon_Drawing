package pathLogic;


 enum State {DRAWING, COMPLETED, RESET}


public class DataManagement {
	
	private double[] xCords = new double[50];
	private double[] yCords = new double[50];
	
	private double[] currentPos = new double[2];
    private double[] pastPosition = new double[2];
    
    private int count = 0;
	
	private State currentState = State.DRAWING; 
	
	
	
	public double[] getxCords() {
		return xCords;
	}


    public double[] getyCords() {
		return yCords;
	}


	public double[] getCurrentPos() {
		return currentPos;
	}
    
	public double[] getPastPosition() {
		return pastPosition;
	}
	
	public State getCurrentState() {
		
		return this.currentState;
	}
	
	public int getCount() {
		
		return this.count;
		
	}
	
	
	
	public void appendCords(double[] xyInput) {
		
		if(xyInput.length != 2) { System.out.println("Error");
		return;
		}
		else {
			
			xCords[count] = xyInput[0];
			yCords[count] = xyInput[1];
			count++;
			
			return;
		}
	}	
	
	public void resetData() {
		
		
		this.xCords = new double[50];
		this.yCords = new double[50];
		this.currentPos = new double[2];
		this.pastPosition = new double[2];
		this.count = 0;
	}
	
	
	public void decidingOnClick(double[] inputXY) {
		
		if(currentState == State.COMPLETED) {
			
			resetData();
			currentState = State.RESET;
			return;
			
		}
		
		else { newPoint(inputXY);}
		
	}
	
	
	public void newPoint(double[] inputXY) {
		
		if(count == 0) {
			
			currentState = State.DRAWING;
			this.currentPos = inputXY;
			this.pastPosition = inputXY;
			appendCords(inputXY);
			return;
			
		} else {
				  
                double[] originalPosition = {xCords[0], yCords[0]};
                
				if(EuclideanNorm.euclideanNorm(originalPosition, inputXY) < 20) {
					
					this.currentState = State.COMPLETED;
					return;
					
				}
				
				else {
					
					this.pastPosition = this.currentPos;
					this.currentPos = inputXY;
					appendCords(inputXY);
			        }		
				}
		
		
		
	}	
}

	
