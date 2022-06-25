package section2.heap;

public class Pair3 {
	int wi,bi,d;
	public Pair3(int wi, int bi,int d) {
		super();
		
		this.wi = wi;
		this.bi = bi;
		this.d = d;
	}

	public int getWi() {
		return wi;
	}

	public int getBi() {
		return bi;
	}	
	public int getD() {
		return d;
	}	
	@Override
	public String toString() {
		return "Pair3 [wi=" + wi + ", bi=" + bi + ", d=" + d + "]";
	}

}
