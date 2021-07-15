package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int ptr;
    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
    	// completed code
    	
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        v = new Vector(taille);
        this.ptr = 0;
    
        
    }

    public void empiler(Object o) throws PilePleineException {
    	// completed code
    	
    	if (estPleine())
        throw new PilePleineException();
        this.v.add(ptr, o);
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
    	// completed code
    	
    	if (estVide())
            throw new PileVideException();
//        this.v.remove(ptr);
        this.ptr--;
        return v.get(ptr);
    }

    public Object sommet() throws PileVideException {
    	// completed code
        return v.get(ptr-1);
    }

    public int taille() {
    	// completed code
        if(this.ptr <= 0) return 0;
        return this.ptr;
    }

    public int capacite() {
        // // completed code
        return this.v.capacity();
    }

    public boolean estVide() {
    	// completed code
        return ptr <= 0;
    }

    public boolean estPleine() {
    	// completed code
        return this.ptr >= this.capacite() ;
    }

    public String toString() {
    	// completed code
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=this.ptr-1; i>= 0; i--) {
            sb.append(v.get(i).toString());
            if (i > 0)
                sb.append(", ");
        
        }
        sb.append("]");
        return sb.toString();
    }

      public boolean equals(Object o) {
    	// completed code
            if (o instanceof PileI) {
                PileI p = (PileI) o;
                return this.capacite() == p.capacite()
                    && this.hashCode() == p.hashCode() && this.taille() == p.taille()
                    && this.toString().equals(p.toString());
                    
              } else
                return false;
            }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
