package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    
    public final static int TAILLE_PAR_DEFAUT = 6;
    
    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
    	// completed code
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
    	// completed code
        if (estPleine())
        throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
    	// completed code
        if (estVide())
            throw new PileVideException();
        zone[ptr] = null;
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
    	// completed code
        return zone[ptr-1];
    }


    public int capacite() {
    	// completed code
        return zone.length;
    }

    public int taille() {
    	// completed code
        if(this.ptr <= 0) return 0;
        return this.ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        if (o instanceof PileI) {
          PileI p = (PileI) o;
          return this.capacite() == p.capacite()
              && this.hashCode() == p.hashCode() && this.taille() == p.taille()
              && this.toString().equals(p.toString());
              
        } else
          return false;
      }
//    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
    	// completed code

        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]).toString();
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    
    }
}