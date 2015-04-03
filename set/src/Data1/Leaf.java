/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data1;

/**
 *
 * @author 栗粒盐
 * @param <T>
 */
public class Leaf <T extends Comparable<T>> implements Multiset<T> {
    Leaf(){}
    public static Leaf empty() {
        return new Leaf();
    }
    public boolean isEmptyHuh() {
        return true;
    }
    public int cardinality() {
        return 0;
    }    
    public boolean member(T x) {
	return false;
    }
    public int number(T x) {
        return 0;
    }
    public Multiset add(T x) {
	return new Branch(this, x, this);
    }
    public Multiset add(T x, int n) {
        return new Branch(this,x,this);
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
}