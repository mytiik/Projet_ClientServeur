
public class P2PClient {
    public class TestThreadIncShared {
public static void main(String[] args) {
Boite b = new Boite(); //(*1)
ThreadIncShared t1,t2;
t1 = new ThreadIncShared(b); //(*2)
t2 = new ThreadIncShared(b); //(*2)
t1.start();
t2.start();
try {
t1.join() ;
t2.join() ;
}
catch(InterruptedException e) { } ;
System.out.println("Threads terminés") ;
System.out.println("val : " + b.get()) ;
}
}
}
/*
    
    
    
    
    
    
    
    
*/