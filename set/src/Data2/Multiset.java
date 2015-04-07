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
interface Multiset<T extends Comparable<T>> extends Sequenced<T> { 
    int cardinality();
    boolean isEmptyHuh();
    boolean member(T elt);    
    int count(T elt);
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
    int getDepth();
    T getKey();
    //Multiset toSet(); -> iteration
    Multiset right();
    Multiset left();

    public int sum();
    public T nth(int n);
}

