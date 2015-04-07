/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data2;

import static java.lang.Integer.min;

/**
 *
 * @author 栗粒盐
 */
public class Branch <T extends Comparable<T>> implements Multiset<T>{
    Multiset left;
    T key;
    Multiset right;
    int number;
    private int depth;
    
    // return a new leaf to create an empty finite set
    public static Multiset empty() {
        return new Leaf();
    }    
    
    //constructor
    Branch(Multiset left, T key, Multiset right, int n) {
        this.left = left;
        this.key = key;
        this.right = right;
        this.number = n;
        if (left.isEmptyHuh() && right.isEmptyHuh())
			this.depth =1;
		else if (left.isEmptyHuh())
			this.depth = right.getDepth()+ 1;
		else if (right.isEmptyHuh())
			this.depth = left.getDepth()+ 1;
		else
			depth = (Math.max(left.getDepth(), right.getDepth()) + 1);
    }
    public T getKey() {
        return this.key;
    }
    public Multiset right() {
        return this.right;
    }
    public Multiset left() {
        return this.left;
    }
    public int getDepth() {
        return this.depth;
    }
    
    //add the cardinality of left subtree and right 
    //subtree and 1 for the node itself
    
    public int cardinality() {
        return (this.number+left.cardinality() +right.cardinality());
    }
    
    //since it's not a Leaf, it's not empty, return false
    public boolean isEmptyHuh() {
        return false;
    }       
    
    private int balance() {
	int L = this.left.getDepth();
	int R = this.right.getDepth();
	if (L - R >= 2)
            return -1;
	else if (L - R <= -2)
            return 1;
            return 0;
    }

    //add an element to the Multiset
    public Multiset<T> add( T x ) {
        int k = x.compareTo(this.key);
        Branch q;
        if ( k < 0 ) {
            q= new Branch( this.left.add(x),
                               this.key,
                               this.right,
                               this.number);
        } else if (k==0) {
            q= new Branch( this.left,
                               this.key,
                               this.right,
                               (this.number+1));}
            else { /* if k >= 0 */
            q= new Branch( this.left,
                               this.key,
                               this.right.add(x),
                               this.number);
        }
        if (this.balance()==1) {
            return q.rotateL();
        } else {
            if (this.balance() == -1) {
                return q.rotateR();
            } else {
                return q;
		}
        }
    }
    
    public Multiset add(T x, int n) {
        Branch q;
        int k = x.compareTo(this.key);
        if ( k < 0 ) {
            q = new Branch( this.left.add(x,n),
                               this.key,
                               this.right,
                               this.number);
        } else if (k==0) {
            q = new Branch( this.left,
                            this.key,
                            this.right,
                            (this.number+n));}
            else { /* if k >= 0 */
            q = new Branch( this.left,
                               this.key,
                               this.right.add(x,n),
                               this.number);
        }
        if (this.balance()==1) {
            return q.rotateL();
        } else {
            if (this.balance() == -1) {
                return q.rotateR();
            } else {
                return q;
		}
        }
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
        Branch q;
        int k = x.compareTo(this.key);
        if (k == 0) {
            if (this.number ==1 ) {
                q = (Branch) this.left.union(this.right);
            } else
                q =  new Branch(this.left, 
                        this.key,
                        this.right,
                        (this.number-1));
        }
        else 
            if (k < 0) {
                q = new Branch(this.left.remove(x), key, right,this.number);
            }
            else q = new Branch(left,key,this.right.remove(x),this.number);
        
        if (this.balance()==1) {
            return q.rotateL();
        } else {
            if (this.balance() == -1) {
                return q.rotateR();
            } else {
                return q;
		}
        }
    }
    
    public Multiset remove(T x, int n) {
        int k = x.compareTo(this.key);
        if (n==0) {return this;} else {
        if (k == 0) {
            if (this.number<=n) {
                return this.left.union(this.right);
            } else {
                return new Branch(this.left, 
                        this.key,
                        this.right,
                        (this.number-n));
            }
        }
        else 
            if (k < 0) {
                return new Branch(this.left.remove(x,n), key, right,this.number);
            }
            else return new Branch(left,key,this.right.remove(x,n),this.number);
        }
    }
    
    public Multiset union(Multiset u) {
        return u.union(left).union(right).add(key,this.number);
    }
    
    public Multiset inter(Multiset u) {    
        if (u.member(key)) {            
            return u.inter(this.removeall(key)).add(key,min(this.number,u.count(key)));
        }
        else {
            return u.inter(this.removeall(key));
        }          
    }
    
    public boolean subset(Multiset u) {
        Multiset temp = new Leaf();
        temp = temp.union(u);
        boolean t = true;
        for (int i = 0; i<(number-1); i++) {
            temp = temp.remove(this.key);
        }        
        if (temp.member(this.key)) {
            return left.subset(u) && right.subset(u);
        }
        else
            return false;
    }    
    
    public boolean equal(Multiset u) {
        return (u.subset(this) && this.subset(u));
    }    
    
    //
    public Multiset diff(Multiset u) {
        return this.remove(key).diff(u.remove(key));
    }
    
    public String toString() {
        String t = "";
        for (int i=0; i<number;i++) {
            t = t+key+" ";
        }
        return left.toString() + " " + t + right.toString();
    }

    @Override
    public int count(T x) {
        int k = x.compareTo(this.key);
        if (k == 0) {
            return (this.number);
        }
        else 
            if (k < 0) {
                return this.left.count(x);
            }
            else return this.right.count(x);           
    }
    
    public Multiset filter(T x) {
        int k = x.compareTo(this.key);
        if (k==0) {
            return (new Branch(this.left,this.key,this.right,1));
        } else
            if (k<0) {
                return (new Branch(this.left.filter(x),key,this.right,this.number));
            } else
                return (new Branch(this.left, key, this.right.filter(x),this.number));
    }

    @Override
    public Multiset removeall(T x) {
        int k = x.compareTo(this.key);
        if (k == 0) {
            return this.left.union(this.right);
        }
        else 
            if (k < 0) {
                return (new Branch(this.left.removeall(x), key, right,number));
            }
            else return (new Branch(left,key,this.right.removeall(x),number));
    }
    
    /*
    public int sumItS () {
        int sum = 0;
        Sequence as = this;
        while ( as.notEmpty() ) {
            sum = sum + this.here();
            as = as.next();
        }
        return sum;
    }
    */
    
    
    public T nth(int n) {
        Sequence as = this.seq();
        for (int i = n; i>0; i--) {
            as = as.next();            
            System.out.println(as.here());
        }
        return (T) as.here();
    }
    
    public int sum() {
        Sequence as = this.seq();
        int sum = 0;
        while ( as.notEmpty() ) {
            System.out.println(as.here());
            sum = sum + ((Integer) as.here());
            as = as.next();
        }
        return sum;
    } 
    
    public Sequence seq() {
        return new AS_Branch(key, number, (new AS_Cat(left.seq(), right.seq())));
    }
    
    /*public Multiset rotateR() {
        Multiset r = this.right;
        if (r.isEmptyHuh()) {
            return new Leaf();
        } else {
            Branch t = (Branch) this.right;
            return (new Branch(t.right,t.key,
                    new Branch(this.left,this.key,t.left,this.number),t.number));
        }
    }*/
    
    private Multiset<T> rotateR () {
	Branch q = this;
        Multiset p = q.left();
        Multiset c = q.right();
        Multiset a = p.left();
        Multiset b = p.right();
        q = new Branch(b,q.key,c,q.number);
        if (p.isEmptyHuh()) {
            return a.union(q);
        } else {
            p = new Branch(a, p.getKey(), q, ((Branch) p).number);
		return p;
	}
    }
    public Multiset<T> rotateL() {
        Branch q = this;        
        Multiset p = this.right();
        Multiset c = this.left();
        Multiset a = p.left();
        Multiset b = p.right();
        q = new Branch(c,q.key,a,this.number);      
        if (p.isEmptyHuh()) {
            return q.union(b);
        } else {
            p = new Branch(q,this.right().getKey(),b,((Branch) p).number);  
            return p;
        }
    }
    
    
}
