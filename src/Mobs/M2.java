package Mobs;

import java.util.ArrayList;

import Monde.Monde;

public class M2 extends M{

	public M2(int x, int y) {
		super(x, y);
		atk=(int) (Math.random()*100);
		pv=500;
		S="0";
	}

	public String getS() {
		return S;
	}
	
	public void move(int dx, int dy) {
		if (this.sens == 0) {
			this.x=(this.x-1+dx)%dx;
		}
		if (this.sens == 1) {
			this.x=(this.x+1+dx)%dx;
		}
		if (this.sens == 2) {
			this.y=(this.y+1+dy)%dy;
		}
		if (this.sens == 3) {
			this.y=(this.y-1+dy)%dy;
		}
		for (int m=  0; m < Monde.getcarte_P().size();m++) {
			if (Monde.getcarte_P().get(m) instanceof Pomme && ((Pomme) Monde.getcarte_P().get(m)).getX() == this.x && ((Pomme) Monde.getcarte_P().get(m)).getY() == this.y) {
				manger_pomme((Pomme) Monde.getcarte_P().get(m));
			}
		}
		
	}
	
	public void evoluer() {
		if(nb_pomme_manger >= 30 && evolution == false) {
			evolution = true;
		}
	}
	public void manger_pomme(Pomme apple) {
		for(int i = 0; i < Monde.getcarte_P().size(); i++) {
				if(Monde.getcarte_P().get(i).equals(apple)){
					if (apple.isEstPourrie()) 
						nb_pomme_manger += 1 ;
					else 
						nb_pomme_manger += 2 ;
					Monde.getcarte_P().remove(i);
					evoluer();
					return ;
			}
		}
	}
	public void setSens() {
		int cpt=0;
		int tab_A[] = new int[4];
		for (int i=0;i<Monde.getcarte_Ab().size();i++) {
			if (Monde.getcarte_Ab().get(i).getX()==this.x-1 && Monde.getcarte_Ab().get(i).getY()==this.y) {
				cpt+=1;
				tab_A[cpt]=i;
			}
			if (Monde.getcarte_Ab().get(i).getX()==this.x+1 && Monde.getcarte_Ab().get(i).getY()==this.y) {
				cpt+=1;
				tab_A[cpt]=i;
			}
			if (Monde.getcarte_Ab().get(i).getX()==this.x && Monde.getcarte_Ab().get(i).getY()==this.y+1) {
				cpt+=1;
				tab_A[cpt]=i;
			}
			if (Monde.getcarte_Ab().get(i).getX()==this.x && Monde.getcarte_Ab().get(i).getY()==this.y-1) {
				tab_A[cpt]=i;				
			}
		}
		if (cpt == 4) {
			Monde.getcarte_Ab().get(tab_A[0]).setEnfeu(true);
			Monde.getcarte_Ab().get(tab_A[1]).setEnfeu(true);
			Monde.getcarte_Ab().get(tab_A[2]).setEnfeu(true);
			Monde.getcarte_Ab().get(tab_A[3]).setEnfeu(true);
			Monde.getcarte_Ag().remove(this);
			return ;
		}
		
		for(int m=  0; m < Monde.getcarte_P().size();m++) {
			if(((Pomme) Monde.getcarte_P().get(m)).getX() == this.x-1 && ((Pomme) Monde.getcarte_P().get(m)).getY() == this.y) {
					this.sens = 0;
					return ;
				}
				if(((Pomme) Monde.getcarte_P().get(m)).getX() == this.x+1 && ((Pomme) Monde.getcarte_P().get(m)).getY() == this.y) {
					this.sens = 1;
					return ;
				}
				if(((Pomme) Monde.getcarte_P().get(m)).getX() == this.x && ((Pomme) Monde.getcarte_P().get(m)).getY() == this.y+1) {
					this.sens = 2;
					return ;
				}
				if(((Pomme) Monde.getcarte_P().get(m)).getX() == this.x && ((Pomme) Monde.getcarte_P().get(m)).getY() == this.y-1) {
					this.sens = 3;
					return ;
				}
			
		}
		int x1,y1;
		//do {
			this.sens = (int)(Math.random()*4);
			x1=this.x;
			y1=this.y;
			if (this.sens == 0) {
				x1=(x1-1+Monde.getDx())%Monde.getDx();
			}
			if (this.sens == 1) {
				x1=(x1+1+Monde.getDx())%Monde.getDx();
			}
			if (this.sens == 2) {
				y1=(y1+1+Monde.getDy())%Monde.getDy();
			}
			if (this.sens == 3) {
				y1=(y1-1+Monde.getDy())%Monde.getDy();
			}
		//}while(Monde.testC(x1, y1,Mobs.Arbre.class).size() ==1);
}
	public int getSens() {
		return this.sens;
	}
	
}