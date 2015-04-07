/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data2;

/**
 *
 * @author 栗粒盐
 */

class AS_Cat <T extends Comparable<T>> implements Sequence<T>, Sequenced<T> {
    Sequence left;
    Sequence right;

    AS_Cat(Sequence l, Sequence r) {
        this.left = l;
        this.right = r;
    }

    public boolean notEmpty() {
        return this.left.notEmpty() || this.right.notEmpty();
    }
    
    public T here() {
        if ( this.left.notEmpty() ) {
            return (T) this.left.here();
        } else {
            return (T) this.right.here();
        }
    }
    public Sequence next() {
        if ( this.left.notEmpty() ) {
            // Potential optimizaiton if right is empty
            return new AS_Cat(this.left.next(), this.right);
        } else {
            return this.right.next();
        }
    }
    public Sequence seq() {
        return this;
    }
}
