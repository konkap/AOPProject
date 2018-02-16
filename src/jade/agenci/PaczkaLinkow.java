package jade.agenci;
import java.io.Serializable;
import java.util.ArrayList;

//@author Konrad

public class PaczkaLinkow implements Serializable {
    
    private ArrayList<String> linki;
    
    public PaczkaLinkow(ArrayList<String> linki){
        this.setList(linki);
    }
    
    public ArrayList<String> getList() {
        return linki;
    }
    
    public void setList(ArrayList<String> linki) {
        this.linki = linki;
    }
}
