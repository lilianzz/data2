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
public class AS_Branch <T extends Comparable<T>> implements Sequence<T>, Sequenced<T> {
    T here;
    int number;
    Sequence next;
    public AS_Branch(T here, int number, Sequence next) {
        this.here = here;
        this.number = number;
        this.next = next;
    }    
    
    public T here() {
        return this.here;
    }
    
    public boolean notEmpty() {
        return true;
    }
    
    public Sequence next() {
        if (this.number == 1) 
        {
            return next;
        }
        else
        {
            return new AS_Branch(this.here,(this.number-1),this.next);
        }
    }
    
    public Sequence seq() {
        return this;
    }
    
}
