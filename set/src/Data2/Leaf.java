/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data2;

/**
 *
 * @author 栗粒盐
 * @param <T>
 */
public class Leaf <T extends Comparable<T>> implements Multiset<T>{
    Leaf(){}
    public static Leaf empty() {
        return new Leaf();
    }
    public Sequence seq() {
        return new AS_Leaf();
    }
    public boolean isEmptyHuh() {
        return true;
    }
    public T getKey() {
        throw new EmptySequenceException("No elements in an empty sequence"); 
    }
    public int cardinality() {
        return 0;
    }    
    public boolean member(T x) {
	return false;
    }
    public int count(T x) {
        return 0;
    }
    public Multiset add(T x) {
	return new Branch(this, x, this,1);
    }
    public Multiset add(T x, int n) {
        return new Branch(this,x,this,n);
    }
    public Multiset remove(T x) {
	return this;
    }  
    public Multiset remove(T x, int n) {
        return this;
    }
    public Multiset removeall(T x) {
        return this;
    }
    public Multiset filter(T x) {
        return this;
    }
    public Multiset union(Multiset u) {
	return u;
    }
    public Multiset inter(Multiset u) {
	return this;
    }
    public Multiset diff(Multiset u) {
	return u;
    }
    public boolean equal(Multiset u) {
	return u.isEmptyHuh();
    }
    public boolean subset(Multiset u) {
	return true;
    }
    public String toString() {
	return "";
    }
    public int sum() {
        return 0;
    }
    public T nth(int n) {
        throw new EmptySequenceException("No elements in an empty sequence");    
    }
    
    public int getDepth() {
        return 0;
    }
    public Multiset right() {
        return new Leaf();
    }
    public Multiset left() {
        return new Leaf();
    }
   
    //public Multiset toSet() {
    //    return new Leaf();
    //}
}