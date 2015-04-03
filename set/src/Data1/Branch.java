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
public class Branch <T extends Comparable<T>> implements Multiset<T> {
    Multiset left;
    T key;
    Multiset right;
    
    // return a new leaf to create an empty finite set
    public static Multiset empty() {
        return new Leaf();
    }    
    
    //constructor
    Branch(Multiset left, T key, Multiset right) {
        this.left = left;
        this.key = key;
        this.right = right;
    }
    
    //add the cardinality of left subtree and right 
    //subtree and 1 for the node itself
    
    public int cardinality() {
        return (1+left.cardinality() +right.cardinality());
    }
    
    //since it's not a Leaf, it's not empty, return false
    public boolean isEmptyHuh() {
        return false;
    }       

    //add an element to the Multiset
    public Multiset<T> add( T x ) {
        int k = x.compareTo(this.key);
        if ( k < 0 ) {
            return new Branch( this.left.add(x),
                               this.key,
                               this.right);
        } else { /* if k >= 0 */
            return new Branch( this.left,
                               this.key,
                               this.right.add(x));
        }
    }
    
    public Multiset add(T x, int n) {
        Multiset temp = this;
        for (int i=0; i<n; i++) {
            temp = temp.add(x);
        }
        return temp;
        /*
        int k = x.compareTo(this.key);
        if ( k < 0 ) {
            return new Branch( this.left.add(x,n),
                               this.key,
                               this.right);
        } else if (k==0) {
            return new Branch( this.left,
                               this.key,
                               this.right.add(x,(n-1)));}
            else { /* if k >= 0 
            return new Branch( this.left,
                               this.key,
                               this.right.add(x,n));
        }
        */
    }
    
    //search if x is in the tree
    public boolean member(T x) {
        int k = x.compareTo(this.key);
        // return true if x equals its value
        if (k == 0) {
            return true;
        }
        //otherwise see if x in the left subtree or 
        //in the right subree
        else
            if (k < 0) {
                return this.left.member(x);
            }
            else return this.right.member(x);
    }
    
    public Multiset remove(T x) {
        int k = x.compareTo(this.key);
        if (k == 0) {
                return this.left.union(this.right);
            } else
            if (k < 0) {
                return new Branch(this.left.remove(x), key, right);
            }
            else return new Branch(left,key,this.right.remove(x));
    }
    
    public Multiset remove(T x, int n) {
        int k = x.compareTo(this.key);
        if (n==0) {return this;} else {
        if (k == 0) {
                return this.left.union(this.right).remove(x, (n-1));
            } 
        else 
            if (k < 0) {
                return new Branch(this.left.remove(x,n), key, right);
            }
            else return new Branch(left,key,this.right.remove(x,n));
        }
    }
    
    public Multiset union(Multiset u) {
        return u.union(left).union(right).add(key);
    }
    
    public Multiset inter(Multiset u) {
        if (u.member(key)) {
            return u.inter(this.remove(key)).add(key);
        }
        else {
            return u.inter(this.remove(key));
        }          
    }
    
    public boolean subset(Multiset u) {
        if (u.member(this.key)) {
            return left.subset(u) && right.subset(u);
        }
        else
            return false;
    }    
    
    public boolean equal(Multiset u) {
        return (u.subset(this) && this.subset(u));
    }    
    
    public Multiset diff(Multiset u) {
        return this.remove(key).diff(u.remove(key));
    }
    
    public String toString() {
        return left.toString() + " " + this.key+ " " + right.toString();
    }

    @Override
    public int number(T x) {
        int k = x.compareTo(this.key);
        if (k == 0) {
            return (this.right.number(x)+1);
        }
        else 
            if (k < 0) {
                return this.left.number(x);
            }
            else return this.right.number(x);           
    }
    
    public Multiset filter(T x) {
        int k = x.compareTo(this.key);
        if (k==0) {
            return (this.remove(x,(this.number(x)-1)));
        } else
            if (k<0) {
                return new Branch(this.left.filter(x),key,this.right);
            } else
                return new Branch(this.left, key, this.right.filter(x));
    }

    @Override
    public Multiset removeall(T x) {
        int k = x.compareTo(this.key);
        if (k == 0) {
            return this.left.union(this.right.removeall(x));
        }
        else 
            if (k < 0) {
                return new Branch(this.left.removeall(x), key, right);
            }
            else return new Branch(left,key,this.right.removeall(x));
    }
}