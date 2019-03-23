package Monde;

import Mobs.M;
import Mobs.M1;
import Mobs.M2;

public class Terrain {
	private static int[][][] terrain;
	private int dx;
	private int dy;
	
	public Terrain(int dx,int dy) {
		this.dx=dx;
		this.dy=dy;
		terrain = new int[dx][dy][2];
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				terrain[i][j][0]=0;
				terrain[i][j][1]=0;
			}
		}
	}
	public int cpt;
	public void Stockage_passage() {
		for (int i=0;i<Monde.getcarte_Ag().size();i++) {
			if (Monde.getcarte_Ag().get(i) instanceof M1)
				terrain[((M) Monde.getcarte_Ag().get(i)).getX()][((M) Monde.getcarte_Ag().get(i)).getY()][1]-=1;
			if (Monde.getcarte_Ag().get(i) instanceof M2)
				terrain[((M) Monde.getcarte_Ag().get(i)).getX()][((M) Monde.getcarte_Ag().get(i)).getY()][1]+=1;
		}
	}
	public void afficher() {
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				System.out.print(""+terrain[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static int[][][] getTerrain() {
		return terrain;
	}
	
}