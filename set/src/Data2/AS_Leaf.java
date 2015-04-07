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

public class AS_Leaf <T extends Comparable<T>> implements Sequence<T>,Sequenced<T> {    
    public T here() {
        throw new EmptySequenceException("No elements in an empty sequence");    
    }
    public boolean notEmpty() {
        return false;
    }
    public Sequence next() {
        return this;
    }
    public Sequence seq() {
        return this;
    }
}