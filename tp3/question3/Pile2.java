package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;
    int elems;
    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille) {
    	// completed code
        if(taille<0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
        elems = 0;
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException {
    	// completed code
    	if (estPleine())
        throw new PilePleineException();
       this.stk.push(o);
       elems++;
    
    }

    public T depiler() throws PileVideException {
    	// completed code
    	if (estVide())
            throw new PileVideException();
            elems--;
        return this.stk.pop();
    }

    public T sommet() throws PileVideException {
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

	@Override
	public int capacite() {
		// completed code
		return this.capacite;
	}

	@Override
	public int taille() {
		// // completed code
		if(elems <= 0) return 0;
        return this.elems ;
	}

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2