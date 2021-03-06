package jrJava.brickbuster;

import resources.DrawingBoard;

public class BrickManager {

	private int x, y; // left, top
	private int brickWidth, brickHeight;

	private Brick[] bricks;
	private int numOfBricks;
	

	public BrickManager(int _x, int _y, int _brickWidth, int _brickHeight, int _numOfBricks){
		x = _x;
		y = _y;
		brickWidth = _brickWidth;
		brickHeight = _brickHeight;
		numOfBricks = _numOfBricks;

		bricks = new Brick[numOfBricks];

		for(int i=0; i<numOfBricks; i++){
			//if(i==numOfBricks-1) bricks[i] = new Brick(x, y+i*brickHeight, brickWidth, brickHeight, true);
			//else bricks[i] = new Brick(x, y+i*brickHeight, brickWidth, brickHeight, false);

			//bricks[i] = new Brick(x, y+i*brickHeight, brickWidth, brickHeight, i==numOfBricks-1? true:false);
			bricks[i] = new Brick(x, y+i*brickHeight, brickWidth, brickHeight, i==numOfBricks-1);
		}
	}


	public boolean checkCollision(Ball ball){
		for(int i=0; i<numOfBricks; i++){
			if(bricks[i].isHit(ball)){
				if(i==numOfBricks-1){
					bricks[i] = null;
					if(i-1>=0) bricks[i-1].setAsBottomBrick();
				}
				else {
					for(int j=i+1; j<numOfBricks; j++){
						bricks[j].shiftUp();
						bricks[j-1] = bricks[j];
					}
					bricks[numOfBricks-1] = null;
				}
				numOfBricks--;
				return true;
			}
		}
		return false;
	}
	
	public int getNumOfBricks(){
		return numOfBricks;
	}



	public void draw(DrawingBoard board){
		for(int i=0; i<numOfBricks; i++){
			bricks[i].draw(board); 
		}
	}

}












