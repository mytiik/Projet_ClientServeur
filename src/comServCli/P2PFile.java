
package comServCli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class P2PFile implements Serializable {
    
    private String          name;
    private long            size;
    private ArrayList<String> listeIpClient;
    
    // default constructor
    public P2PFile( String name, long size ){
        this.name        = name;
        this.size        = size;
        this.listeIpClient = new ArrayList<String>();
    }
    // empty constructor
    public P2PFile(){
        this.name        = "[]";
        this.size        = 0;
        this.listeIpClient = new ArrayList<String>();
    }

    // getters
    public String           getName() {
        return name;
    }
    public double           getSize() {
        return size;
    }
    public ArrayList<String>  getListeIpClient() {
        return listeIpClient;
    }
    
    // setters
    public void     setName(String name) {
        this.name = name;
    }
    public void     setSize(long size) {
        this.size = size;
    }
    public void     setListeIpClient(ArrayList<String> listeClient) {
        this.listeIpClient = listeClient;
    }
    
    @Override
    public int      hashCode(){
        int hash = 14;
        hash = (31 * hash) + this.name.hashCode();
     //   hash = (31 * hash) + this.size;
        return hash;
    }

    @Override
    public boolean  equals(Object obj) {
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