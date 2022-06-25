package section2.heap;

public class Element {
	int data;
	int row;
	int col;
	
	public Element(int data, int row, int col) {
		super();
		this.data = data;
		this.row = row;
		this.col = col;
	}

	public int getData() {
		return data;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}	
}
