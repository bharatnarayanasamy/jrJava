package jrJava.tetris;

public class Tee extends Rotatable{

	@Override
	public void createShape() {
		blocks = new Block[4];
		blocks[0] = new Block(-1, 0, color);
		blocks[1] = new Block(0,  0, color);
		blocks[2] = new Block(1,  0, color);
		blocks[3] = new Block(0,  1, color);
	}

}
