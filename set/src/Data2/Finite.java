/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data2;


public class Finite {

    /**
     * @param args the command line arguments
     */
    
    
    // -> Multiset
    //generate random finite set of certain size
    public static Multiset randIntMset(int size) {
	Multiset temp = new Leaf();        
	for(; size > 0; size--) {
	    temp = temp.add((int) ((Math.random()-.5) * 100),((int) (Math.random() * 100)));
	}
	return temp;
    }
    
    public static Multiset randCharMset() {
        Multiset temp = new Leaf();
        for (int i =0; i<30; i++) {
            temp = temp.add(((char) ((Math.random() * 26)+97)),((int) (Math.random() * 5)));      
        }
        return temp;
    }
    
    public static boolean depthRoot(int size) {
	Multiset temp = new Leaf();
        boolean t = true;
        int a;
        int b;
        for (int i=0;i<10;i++) {
            temp = new Leaf();  
            for(int j = 20; j > 0; j--) {
                a = ((int) ((Math.random()-.5) * 100));
                b = ((int)((Math.random()+1) * 5));
                temp = temp.add(a,b);              
            }
            if (!(temp.getDepth() == (Math.max(temp.left().getDepth(), temp.right().getDepth())+1))) {
               t = false;}
        }
        return t;
    }
    
    // test if cardinality of a random generated set is right
    public static boolean tCardi() {
        Multiset temp = new Leaf();
        //int size = ((int)(Math.random() * 50));
        int size = 10;
        int s = 0;
        int c;
        int d;
        for(; size > 0; size--) {            
            c = ((int) ((Math.random()) * 10));
            s = s + c;
            d = ((int) (Math.random() * 10));
	    temp = temp.add(d,c);
	}
        if (temp.cardinality() == s) 
            return true;        
        else {
            System.out.println(temp.cardinality()+ " "+ s + " "+ temp+"" );
        }
            return false;               
        
    }
    
    //member (add t x) y = true <-> x = y \/ member t y = true
    /*public static boolean memberAdd (BST t) {
        int x = ((int) ((Math.random()-.5) * 100));
        int y = ((int) ((Math.random()-.5) * 100));
        boolean o1 = t.add(x).member(y);
        boolean o2 = ((x == y) || (t.member(y)));
        return o1 == o2;      
        
    }
    
    //
    public static boolean removeAddEqual (BST t) {
        int x = ((int) ((Math.random()-.5) * 100));
        BST temp = t.remove(x).add(x);
        boolean o1 = temp.equal(t);
        boolean o2 = t.member(x);
        return o1 == o2;      
        
    }
    
    // (member (remove t x) y) <-> (y \neq x and (member t y))
    public static boolean memberRemove (BST t) {
        int x = ((int) ((Math.random()-.5) * 100));
        int y = ((int) ((Math.random()-.5) * 100));
        boolean o1 = t.remove(x).member(y);
        boolean o2 = (!(x == y) && (t.member(y)));
        return o1 == o2;      
        
    }
    
    //member (union s s') x = true <-> member s x = true \/ member s' x = true
    public static boolean memberUnion (BST s1, BST s2) {
        int x = ((int) ((Math.random()-.5) * 100));
        boolean o1 = s1.union(s2).member(x);
        boolean o2 = (s1.member(x) || s2.member(x));
        return o1 == o2;
    }
    
    public static boolean CardiUnion(BST t, BST u) {
        int x = t.union(u).cardinality();
        int y = t.cardinality() + u.cardinality();
	return x <= y;
    }
    
    public static boolean memberInter (BST s1,BST s2) {
        int x = ((int) ((Math.random()-.5) * 100));
        boolean o1 = s1.inter(s2).member(x);
        boolean o2 = (s1.member(x) && s2.member(x));
        return o1 == o2;
        
    }
    
    
    public static boolean memberDiff (BST s1,BST s2) {
        int x = ((int) ((Math.random()-.5) * 100));
        boolean o1 = s1.diff(s2).member(x);
        boolean o2 = (!s1.member(x) && s2.member(x));
        return o1 == o2;
        
    }
    
    public static boolean memberEqual(BST t) {
        BST t2;
        int a = ((int) ((Math.random()-.5) * 100));
        t2 = t.remove(a);
        boolean o1 = t2.equal(t);
        boolean o2 = !t.member(a);
        return o1==o2;             
        
    }
    
    
    
    public static boolean memberSubset(BST t) {        
        BST u = new Leaf();
        BST v = new Leaf();
        int a;
        for (int i = 0; i<30; i++) {
            a = ((int) ((Math.random()-.5) * 100));
            if (t.member(a)) u.add(a); else v.add(a);     
            
        }
        return (u.subset(t) && (v.isEmptyHuh() || !(v.subset(t))));
    }
    */
    public static void main(String[] args) {
        // test on a given finite set
        
        /*Multiset bot = new Leaf();
        Multiset t1 = new Branch( bot, 1, bot );
        Multiset t3 = new Branch( bot, 3, bot );
        Multiset t2 = new Branch( t1, 2, t3 );
        Multiset t6 = new Branch( bot, 6, bot );
        Multiset t65 = new Branch(bot,6,t6);
        Multiset t8 = new Branch( bot, 8, bot );
        Multiset t7 = new Branch( t65, 7, t8 );
        Multiset t5 = new Branch( t2, 5, t7 );
        System.out.println("is bot empty? should be true: "+ bot.isEmptyHuh());
        System.out.println("t5 should be 1 2 3 5 6 7 8. It actually is: "+t5);
        System.out.println("t5.add(4) should add 4 before 5 and after 3: "+t5.add(4));
        System.out.println("cardinality of t5 = "+ t5.cardinality()+ "  should be 7");
        System.out.println("cardinality of bot = " + bot.cardinality()+"   should be 0");
        System.out.println("t5 remove all 6 should be 1 2 3 4 7 8: "+t5.removeall(6));
        System.out.println("t5 remove 9 should be 1 2 3 5 6 7 8: "+t5.remove(9));        
        System.out.println("t5 remove 5 and 6 should be 1 2 3 7 8: "+t5.remove(5).remove(6));
        System.out.println("Is 9 a member of t5? should be false: "+t5.member(9));        
        System.out.println("Is 3 a member of t5? should be true: "+t5.member(3));
        System.out.println("union of t3 and t65 should be 3 6 6: ." +t3.union(t65));
        System.out.println("union of t3 and bot should be 1 2 3: ." +t3.union(bot));        
        System.out.println("union of t6 and t2 should be 1 2 3 6: "+ t6.union(t2));
        System.out.println("intersection of t5 after removing 6 and t7 should be 7 8: "+t5.remove(6).inter(t7));
        System.out.println("intersection of t5 and bot should be nothing: "+t5.inter(bot));
        System.out.println("is t3 a subset of t5? should be true: "+t3.subset(t5));
        System.out.println("is t7 a subset of t3? should be false: "+t5.subset(t3));
        System.out.println("is bot a subset of t3? should be true: "+bot.subset(t3));
        System.out.println("does t5 equal t3? should be false: "+t5.equal(t3));        
        System.out.println("does t3 equal t3? should be true: "+t3.equal(t3));
        System.out.println("elements in t3 but not t6 should be 3:"+ t6.diff(t3));       
        System.out.println("elements in t3 but not t5 should be nothing:"+ t5.diff(t3));     
        System.out.println(""+t5.removeall(6).inter(t6)+"  ");
        System.out.println(""+t5.number(6));
        System.out.println(""+t5.filter(6));
        System.out.println(""+t5.add(6,4));
        System.out.println(""+t5.add(6,4).remove(6,9)); */
        
        Multiset tt = new Leaf();
        tt = tt.add('a');
        tt = tt.add('b');
        /*System.out.println(""+tt);
        System.out.println(""+tt.cardinality());
        System.out.println(""+tt.remove('b'));
        System.out.println(""+tt.add('a').removeall('a'));*/
        Multiset aa = new Leaf();
        aa = aa.add(1,5).add(6,2);
        Multiset bb = new Leaf();
        bb = bb.add(1,3).add(3).add(4).add(2).add(6).add(5).add(3).add(1,5).add(10).add(1).add(15);
        System.out.println(""+aa) ;            
        System.out.println(""+bb) ;
        /*System.out.println(""+aa.union(bb)) ;        
        System.out.println(""+aa.filter(1)) ;
        System.out.println(bb.sum());                  
        System.out.println(""+bb) ;                
        */System.out.println(""+((Branch) bb).key) ;
        System.out.println(depthRoot(50));
        System.out.println(randCharMset());
        
        // tests on randomly generated finite sets
        boolean t = true;
        //for(int i=0; i < 300; i++) {
            if (!tCardi()) {
                t = false;
            }            
        //}
        System.out.println("Whether passed cardinality test: "+t+"   (supposed to be true)");
        
        /*t=true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30));
            t2 = randBST((int)(Math.random() * 30));
            if (!CardiUnion(t1,t2)) {
                t = false;                
                System.out.println(""+t1+" and "+t2+" failed on cardinality of union test");
            }
        }        
        System.out.println("Whether passed Cardinality of Union test: "+t+"   (supposed to be true)");
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30));
            if (!memberAdd(t1)) {
                t = false;
                System.out.println(""+t1+"  failed on memberAdd test");
            }
        }                
        System.out.println("Whether passed memberAdd test: "+t+"   (supposed to be true)");
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30));
            if (!memberRemove(t1)) {
                t = false;
                System.out.println(""+t1+"  failed on memberRemove test");
            }
        }                
        System.out.println("Whether passed memberRemove test: "+t+"   (supposed to be true)");
        
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            t2 = randBST((int)(Math.random() * 30));
            if (!memberUnion(t1,t2)) {
                t = false;
                System.out.println(""+t1+" and "+t2+" failed on memberUnion test");
            }
        }                
        System.out.println("Whether passed memberUnion test: "+t+"   (supposed to be true)");
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            t2 = randBST((int)(Math.random() * 30));
            if (!memberInter(t1,t2)) {                
                System.out.println(""+t1+" and "+t2+" failed on memberInter test");
                t = false;
            }
        }                
        System.out.println("Whether passed memberInter test: "+t+"   (supposed to be true)");
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            t2 = randBST((int)(Math.random() * 30));
            if (!memberDiff(t1,t2)) {
                t = false;
                System.out.println(""+t1+" and "+t2+" failed on memberDiff test");
            }
        }                
        System.out.println("Whether passed memberDiff test: "+t+"   (supposed to be true)");
        
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            if (!memberSubset(t1)) {
                t = false;                
                System.out.println(""+t1+"  failed on memberSubset test");
            }
        }                
        System.out.println("Whether passed memberSubset test: "+t+"   (supposed to be true)");
        
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            if (!memberEqual(t1)) {
                t = false;
                System.out.println(""+t1+"  failed on memberEqual test");
            }
        }                
        System.out.println("Whether passed memberEqual test: "+t+"   (supposed to be true)");
        
        t = true;
        for(int i = 0; i< 300; i++) {
            t1 = randBST((int)(Math.random() * 30)); 
            if (!removeAddEqual(t1)) {
                t = false;
                System.out.println(""+t1+"  failed on removeAddEqual test");
            }
        }                
        System.out.println("Whether passed removeAddEqual test: "+t+"   (supposed to be true)");
        */
    }
    
}
