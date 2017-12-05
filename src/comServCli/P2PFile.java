
package comServCli;
import java.util.Arrays;
import java.util.Objects;


public class P2PFile {
    
    private String      name = "";
    private int         size = 0;
    private String[]    listeClient = null;
    
    // default constructor
    public P2PFile( String name, int size ){
        this.name = name;
        this.size = size;
    }
    // ^ (name only)
    public P2PFile( String name ){
        this.name = name;
    }

    // getters
    public String[] getListeClient() {
        return listeClient;
    }
    public String   getName() {
        return name;
    }
    public double   getSize() {
        return size;
    }
    
    // setters
    public void     setListeClient(String[] listeClient) {
        this.listeClient = listeClient;
    }
    public void     setName(String name) {
        this.name = name;
    }
    public void     setSize(int size) {
        this.size = size;
    }
    
    @Override
    public int      hashCode(){
        int result = 14;
        
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.size;
        result = 31 * result + Arrays.hashCode(this.listeClient);
        
        return result;
    }

    @Override
    public boolean  equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final P2PFile other = (P2PFile) obj;
        if (Double.doubleToLongBits(this.size) != Double.doubleToLongBits(other.size)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}