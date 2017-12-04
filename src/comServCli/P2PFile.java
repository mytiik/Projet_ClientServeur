
package comServCli;
/*
   definir equals
   definir hashcode
*/

public class P2PFile extends Object {
    String name;
    double size;
    
    // Default constructor
    public P2PFile( String name, double size ){
        this.name = name;
        this.size = size;
    }
    // (name only)
    public P2PFile( String name ){
        this.name = name;
        this.size = 0;
    }
    
    public boolean equals(){
        return true;
    }
    public int hashCode(){
        return 0;
    }
    
}
