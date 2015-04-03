/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data1;

/**
 *
 * @author 栗粒盐
 */
interface Multiset<T extends Comparable<T>> { 
    int cardinality();
    boolean isEmptyHuh();
    boolean member(T elt);    
    int number(T elt);
    Multiset add(T elt);
    Multiset add(T elt, int n);
    Multiset remove(T elt);
    Multiset remove(T elt, int n);
    Multiset removeall(T elt);
    Multiset union(Multiset u);
    Multiset inter(Multiset u);
    Multiset diff(Multiset u);
    boolean equal(Multiset u);
    boolean subset(Multiset u);
    String toString();
    Multiset filter(T elt);
}

