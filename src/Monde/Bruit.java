package Monde;

import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Bruit {
	public static int [][] monT;
	static BufferedImage bruit;
	
	public Bruit(int dx,int dy,int pic){
		bruit_P(dx, dy,pic);
		try {
//			bruit = ImageIO.read(new File("PERLINNOISE.jpeg"));
//			a=new int[220][220];
//			for (int i=0;i<bruit.getWidth();i++){
//				for (int j=0;j<bruit.getHeight();j++){
//					    a[i][j]=(bruit.getRGB(i, j) & 0x000000ff )/20;
//						//System.out.print(""+(bruit.getRGB(i, j) & 0x000000ff )/20+" ");
//				}
//				System.out.println();
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int[] generation_permut(int taille) {
		int perm[] = new int [taille];
		ArrayList<Integer> alea=new ArrayList<>();
		ArrayList<Integer> alea2=new ArrayList<>();
		for (int i=0;i<perm.length;i++) {
			alea.add(i);
		}
//		try {
//			BufferedImage bruit =  ImageIO.read(new File("PERLINNOISE.jpeg"));
////			Color b =bruit.getRGB(0, 0);
////			b.getBlue();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		int p;
		for (int i=0;i<perm.length;i++) {
			p=((int) (Math.random()*(alea.size())));
			//System.out.println(""+p+" "+alea.size());
			alea2.add(alea.get(p));
			alea.remove(p);
		}
		for (int i=0;i<perm.length;i++) {
			p=((int) (Math.random()*(alea2.size())));
			//System.out.println(""+p+" "+alea.size());
			perm[i]=alea2.get(p);
			alea2.remove(p);
		}
		//System.exit(0);
		return perm;
	}
	public static double Get2DPerlinNoiseValue(double x, double y, double res)
	{
	    double tempX,tempY;
	    int x0,y0,ii,jj,gi0,gi1,gi2,gi3;
	    double unit = 1.0f/Math.sqrt(2);
	    double tmp,s,t,u,v,Cx,Cy,Li1,Li2;
	    double gradient2[][] = {{unit,unit},{-unit,unit},{unit,-unit},{-unit,-unit},{1,0},{-1,0},{0,1},{0,-1}};
	    
	    int perm[] =
	       {151,160,137,91,90,15,131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,
	        142,8,99,37,240,21,10,23,190,6,148,247,120,234,75,0,26,197,62,94,252,219,
	        203,117,35,11,32,57,177,33,88,237,149,56,87,174,20,125,136,171,168,68,175,
	        74,165,71,134,139,48,27,166,77,146,158,231,83,111,229,122,60,211,133,230,220,
	        105,92,41,55,46,245,40,244,102,143,54,65,25,63,161,1,216,80,73,209,76,132,
	        187,208,89,18,169,200,196,135,130,116,188,159,86,164,100,109,198,173,186,3,
	        64,52,217,226,250,124,123,5,202,38,147,118,126,255,82,85,212,207,206,59,227,
	        47,16,58,17,182,189,28,42,223,183,170,213,119,248,152,2,44,154,163,70,221,
	        153,101,155,167,43,172,9,129,22,39,253,19,98,108,110,79,113,224,232,178,185,
	        112,104,218,246,97,228,251,34,242,193,238,210,144,12,191,179,162,241,81,51,145,
	        235,249,14,239,107,49,192,214,31,181,199,106,157,184,84,204,176,115,121,50,45,
	        127,4,150,254,138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,
	        156,180};
	    //perm = generation_permut(256);
	    //System.out.println(""+perm.length+" "+perm.length);
	    //System.exit(0);
	    //Adapter pour la résolution
	    x /= res;
	    y /= res;

	    //On récupère les positions de la grille associée à (x,y)
	    x0 = (int)(x);
	    y0 = (int)(y);

	    //Masquage
	    ii = x0 & 255;
	    jj = y0 & 255;

	    //Pour récupérer les vecteurs
//	    gi0 = perm.get(ii+perm.get(jj))%8;
//	    gi1 = perm.get(ii+1+perm.get(jj))%8;
//	    gi2 = perm.get(ii+perm.get(jj+1))%8;
//	    gi3 = perm.get(ii+1+perm.get(jj+1))%8;
	    
	    
	    gi0 = perm[(ii + perm[jj & (perm.length-1)]) & (perm.length-1)] % 8;
	    gi1 = perm[(ii + 1 + perm[jj & (perm.length-1)]) & (perm.length-1)] % 8;
	    gi2 = perm[(ii + perm[(jj + 1) & (perm.length-1)]) & (perm.length-1)] % 8;
	    gi3 = perm[(ii + 1 + perm[(jj + 1) & (perm.length-1)]) & (perm.length-1)] % 8;
	    
//	    gi0 = perm[ii + perm[jj]] % 8;
//	    gi1 = perm[ii + 1 + perm[jj]] % 8;
//	    gi2 = perm[ii + perm[jj + 1]] % 8;
//	    gi3 = perm[ii + 1 + perm[jj + 1]] % 8;

	    //on récupère les vecteurs et on pondère
	    tempX = x-x0;
	    tempY = y-y0;
	    s = gradient2[gi0][0]*tempX + gradient2[gi0][1]*tempY;

	    tempX = x-(x0+1);
	    tempY = y-y0;
	    t = gradient2[gi1][0]*tempX + gradient2[gi1][1]*tempY;

	    tempX = x-x0;
	    tempY = y-(y0+1);
	    u = gradient2[gi2][0]*tempX + gradient2[gi2][1]*tempY;

	    tempX = x-(x0+1);
	    tempY = y-(y0+1);
	    v = gradient2[gi3][0]*tempX + gradient2[gi3][1]*tempY;


	    //Lissageunsigned
	    tmp = x-x0;
	    Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    Li1 = s + Cx*(t-s);
	    Li2 = u + Cx*(v-u);

	    tmp = y - y0;
	    Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return Li1 + Cy*(Li2-Li1);
	}
	
	public static int bruitI(int x,int y, Image image) {
		return monT[x][y];
	}
	
	public static int bruit_P(int dx,int dy,int pic) {
		//Bruit.a=new int[dx][dy];
		monT=new int[dx][dy];
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				monT[i][j]=0;
			}
		}
		
		for (int i=0;i<pic;i++) {
			int x1=((int) (Math.random()*dx));
			int x2=((int) (Math.random()*dy));
			monT[x1][x2]=3;
		}
		int[][] monT2 = copy_T(monT, dx, dy);
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				if (monT[i][j]==3) {
					int cpt1=0;
					for (int i1=(i-1+dx)%dx;cpt1<3;cpt1++) {
						int cpt2=0;
						for (int j1=(j-1+dy)%dy;cpt2<3;cpt2++) {
							if (monT[(i1+cpt1)%dx][(j1+cpt2)%dy] < monT[i][j]) {
								if (Math.random()<0.5)
									monT2[(i1+cpt1+dx)%dx][(j1+cpt2+dy)%dy]=3;
							}
						}
					}
					monT2[i][j]=3;
				}
			}
		}
		monT=copy_T(monT2, dx, dy);
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				if (monT[i][j]==3) {
					int cpt1=0;
					for (int i1=(i-1+dx)%dx;cpt1<3;cpt1++) {
						int cpt2=0;
						for (int j1=(j-1+dy)%dy;cpt2<3;cpt2++) {
							if (monT[(i1+cpt1)%dx][(j1+cpt2)%dy] < monT[i][j]) {
									monT2[(i1+cpt1+dx)%dx][(j1+cpt2+dy)%dy]=2;
							}
						}
					}
					monT2[i][j]=3;
				}
			}
		}
		monT=lissage(dx, dy);
		monT=copy_T(monT2, dx, dy);
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				if (monT[i][j]==2) {
					int cpt1=0;
					for (int i1=(i-1+dx)%dx;cpt1<3;cpt1++) {
						int cpt2=0;
						for (int j1=(j-1+dy)%dy;cpt2<3;cpt2++) {
							if (monT[(i1+cpt1)%dx][(j1+cpt2)%dy] < monT[i][j])
								monT[(i1+cpt1+dx)%dx][(j1+cpt2+dy)%dy]=1;
						}
					}
					monT[i][j]=2;
				}
			}
		}
	return 0;
	}
	public static int[][] copy_T(int[][] tab,int dx,int dy) {
		int[][] t = new int[dx][dy];
		for (int x=0;x<dx;x++) {
			for (int y=0;y<dy;y++) {
				t[x][y]=tab[x][y];
			}
		}
		return t;
	}
	public static int[][] lissage(int dx, int dy) {
		int[][] t= copy_T(monT, dx, dy);
		for (int i=0;i<dx;i++) {
			for (int j=0;j<dy;j++) {
				int cpt1=0;
				int cpt=0;
				for (int i1=(i-1+dx)%dx;cpt1<3;cpt1++) {
					int cpt2=0;
					for (int j1=(j-1+dy)%dy;cpt2<3;cpt2++) {
						if (monT[i][j]==monT[i1][j1]) {
							System.out.print(""+monT[i][j]+" "+monT[i1][j1]+"| ");
							cpt+=1;
						}
					}
					System.out.println("");
				}
				if (cpt==2) {
					System.out.println("123--");
					t[i][j]=Math.max(0,t[i][j]-1);
				}
			}
		}
		return t;
	}
	
	public static void main(String[] args) {
		Bruit toto = new Bruit(15,15,2);
		//bruit_P(15,15);
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				System.out.print(""+Bruit.monT[i][j]);				
			}
			System.out.println("");
		}
		//System.exit(0);
		/*List<Integer> arrlist = new ArrayList<Integer>();
		//arrlist.add('a');
		//arrlist.add('b');
		arrlist =Arrays.asList(151,160,137,91,90,15,131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,
		        142,8,99,37,240,21,10,23,190,6,148,247,120,234,75,0,26,197,62,94,252,219,
		        203,117,35,11,32,57,177,33,88,237,149,56,87,174,20,125,136,171,168,68,175,
		        74,165,71,134,139,48,27,166,77,146,158,231,83,111,229,122,60,211,133,230,220,
		        105,92,41,55,46,245,40,244,102,143,54,65,25,63,161,1,216,80,73,209,76,132,
		        187,208,89,18,169,200,196,135,130,116,188,159,86,164,100,109,198,173,186,3,
		        64,52,217,226,250,124,123,5,202,38,147,118,126,255,82,85,212,207,206,59,227,
		        47,16,58,17,182,189,28,42,223,183,170,213,119,248,152,2,44,154,163,70,221,
		        153,101,155,167,43,172,9,129,22,39,253,19,98,108,110,79,113,224,232,178,185,
		        112,104,218,246,97,228,251,34,242,193,238,210,144,12,191,179,162,241,81,51,145,
		        235,249,14,239,107,49,192,214,31,181,199,106,157,184,84,204,176,115,121,50,45,
		        127,4,150,254,138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,
		        156,180);
		Collections.shuffle(arrlist);
		System.exit(0);*/
		//System.out.print(""+(bruitI(0, 0,null)+" "));
//		for (int i=0;i<10;i++){
//			for (int j=0;j<10;j++){
//				   System.out.print(""+bruitI(i, j, null)+" "); 
//			}
//			System.out.println();
		//}
		//System.out.println(""+bruitI(0, 0, null));
	}
}
