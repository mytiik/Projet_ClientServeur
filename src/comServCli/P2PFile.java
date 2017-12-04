
package comServCli;

public class P2PFile {
    String name;
    double size;
    
    public P2PFile( String name, double size ){
        this.name = name;
        this.size = size;
    }
    public P2PFile( String name ){
        this.name = name;
        this.size = 0;
    }
}
