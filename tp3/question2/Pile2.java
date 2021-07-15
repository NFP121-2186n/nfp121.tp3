package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;
    int elems;
    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
    	// completed code
        if(taille<0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite = taille;
        elems = 0;
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
    	// completed code
    	if (estPleine())
        throw new PilePleineException();
       this.stk.push(o);
       elems++;
    
    }

    public Object depiler() throws PileVideException {
    	// completed code
    	if (estVide())
            throw new PileVideException();
            elems--;
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
    	// completed code
    	return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
    	// completed code
    	return elems <= 0;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
    	// completed code
        return elems >= capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
    	// completed code
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=this.elems-1; i>= 0; i--) {
            sb.append(stk.get(i).toString());
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
    	// completed code
        if(elems <= 0) return 0;
        return this.elems ;
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
    	// completed code
        return this.capacite;
    }

} // Pile2.java
