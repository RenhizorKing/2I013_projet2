package Mobs;

import Monde.Monde;

public class Braconnier {
	private int x;
	private int y;
	public Braconnier(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void move(int dx, int dy) {
		int x1,x2;
		for (int i=0;i<Monde.getcarte_Ag().size();i++) {
			if (Monde.getcarte_Ag().get(i) instanceof M) { //&& Utilitaire.distance2O(((M) Monde.getCarte().get(i)),this)<=1) {
				if (Math.random() <=1.0) {
					System.out.println("GO GO");
					x=((M)Monde.getcarte_Ag().get(i)).getX();
					y=((M)Monde.getcarte_Ag().get(i)).getY();
					return ;
				}
			}
		}
		//do {
			x1= (int) (Math.random()*3) -1;
			x2= (int) (Math.random()*3) -1;
		//}while(Monde.testC(((x+x1+dx)%dx),((y+x2+dy)%dy)).size() !=0);
		x=(x+x1+dx)%dx;
		y=(y+x2+dy)%dy;
	}
	public static void chasser() {
		for (int c=0;c<Monde.getcarte_Ag().size();c++) {

			if (Monde.getcarte_Ag().get(c) instanceof Braconnier) {
				for(int i = ((Braconnier)Monde.getcarte_Ag().get(c)).getX() - 1; i <= ((Braconnier)Monde.getcarte_Ag().get(c)).getX() + 1; i++) { //Parcours voisin selon voisinage de Moore
					for(int j = ((Braconnier)Monde.getcarte_Ag().get(c)).getY() - 1; j <= ((Braconnier)Monde.getcarte_Ag().get(c)).getY() + 1; j++) {
						for(int m=0; m < Monde.getcarte_Ag().size();m++) {
							if (Monde.getcarte_Ag().get(m) instanceof M1 && ((M1) Monde.getcarte_Ag().get(m)).getX() == i && ((M1) Monde.getcarte_Ag().get(m)).getY() == j) {// si M1 voisin
								if (Math.random() <0.6)
									Monde.getcarte_Ag().remove(Monde.getcarte_Ag().get(m));
									//System.out.println("OK"+Monde.getCarte().size());
									return ;
							}
							if (Monde.getcarte_Ag().get(m) instanceof M2 && ((M2) Monde.getcarte_Ag().get(m)).getX() == i && ((M2) Monde.getcarte_Ag().get(m)).getY() == j) {// si M2 voisin
								if (Math.random() <0.6)
									Monde.getcarte_Ag().remove(Monde.getcarte_Ag().get(m));
									//System.out.println("OK"+Monde.getCarte().size());
									return ;
							}
						}
					}
				}
			}
		}
	}
}
