package util;

public class AristaGrafo {
	public VerticeGrafo u;
	public VerticeGrafo w;
	public int dist;
	
	public AristaGrafo() {
		u = null;
		w = null;
		dist = -1;
	}
	
	public AristaGrafo(VerticeGrafo pU, VerticeGrafo pW, int pDist) {
		u = pU;
		w = pW;
		dist = pDist;
	}
}
