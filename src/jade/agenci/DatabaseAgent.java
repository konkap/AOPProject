/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade.agenci;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.filechooser.FileSystemView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Konrad
 */
public class DatabaseAgent extends Agent{
    
    File home = FileSystemView.getFileSystemView().getHomeDirectory();
    String pt = home.getAbsolutePath() + "/baza.txt";
    DataBase baza = new DataBase(pt);;
    
    protected void setup() {
        addBehaviour(new DatabaseAgent.SzukajTagow());
    }
    protected void takeDown() {
        baza.DBwrite("");
    }
    public class SzukajTagow extends CyclicBehaviour {
        ArrayList<String> proponowane = new ArrayList<String>();
        public void action() {
            ACLMessage msg = myAgent.receive();
            if (msg == null)
            {
                block();    
            }    
            else {
                String tag = msg.getContent();
                baza.DBwrite(tag);
                proponowane = new ArrayList<String>(baza.DBsearch(tag));
            }
            try{
                ACLMessage replyMsg = msg.createReply();
                replyMsg.setPerformative(ACLMessage.INFORM);
                replyMsg.setContentObject(new PaczkaLinkow(proponowane));
                myAgent.send(replyMsg);
            } catch(Exception ex){
                System.out.println("ERROR Wysylanie wiadomosci z propozycjami: "+ ex.getMessage());
            } 
            
      }
      
    }

}
