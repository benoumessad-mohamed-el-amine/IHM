package serie1;

class Vecteur3d{ 
	public Vecteur3d (double x, double y, double z){ 
		this.x = x ; 
		this.y = y ; 
		this.z = z ;
	}
	
	public void affiche (){ 
		System.out.println ("< " + x + ", " + y + ", " + z + " >") ;
	}
	
	public double norme (){ 
		return (Math.sqrt (x*x + y*y + z*z)) ;
	}

	public static Vecteur3d somme(Vecteur3d v, Vecteur3d w){
		Vecteur3d s = new Vecteur3d (0, 0, 0) ;
		s.x = v.x + w.x ; s.y = v.y + w.y ; s.z = v.z + w.z ;
		return s ;
	}
	
	public double pScal (Vecteur3d v){
		return (x*v.x + y*v.y + z*v.z) ;
	}
	
	private double x, y, z ;
}
	public class ex1{ 
		public static void main (String args[]){	
		Vecteur3d v1 = new Vecteur3d (3, 2, 5) ;
		Vecteur3d v2 = new Vecteur3d (1, 2, 3) ;
		Vecteur3d v3 ;
		
		System.out.print ("v1 = " ) ; v1.affiche() ;
		System.out.print ("v2 = " ) ; v2.affiche() ;
		v3 = Vecteur3d.somme (v1, v2) ;
		System.out.print ("v1 + v2 = " ) ; v3.affiche() ;
		System.out.println ("v1.v2 = " + v1.pScal(v2)) ; // ou
		v2.pScal(v1);
		}
	}
