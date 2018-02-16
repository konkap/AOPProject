/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade.agenci;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Konrad
 */
public class PictureAgent extends Agent {
    
    protected void setup() {
        addBehaviour(new SzukajObrazow());
    }
    
    public class SzukajObrazow extends CyclicBehaviour {
        ArrayList<String> picD;
        String url;
        Document document;
        public void action() {
            ACLMessage msg = myAgent.receive();
            if (msg == null)
            {
                block();    
            }    
            else {
                String tag = msg.getContent();
                System.out.println("PicAgent: probuje pobrac " + tag + "*@*");
            url = "https://www.wykop.pl/tag/"+tag.substring(1)+"/";  
            try{
                document = Jsoup.connect(url).timeout(10000).get();
            }
            catch(Exception e){
                System.out.println("Laczenie ze strona: "+ e.getMessage());
            }        
            picD = new ArrayList<String>();
            Elements med = document.getElementsByClass("media-content");  
            for (Element e : med)
                picD.add(e.getElementsByAttributeValueStarting("href", "https://www.wykop.pl").attr("href"));            
            try{
                ACLMessage replyMsg = msg.createReply();
                replyMsg.setPerformative(ACLMessage.INFORM);
                replyMsg.setContentObject(new PaczkaLinkow(picD));
                myAgent.send(replyMsg);
            } catch(Exception ex){
                System.out.println("ERROR Wysylanie wiadomosci z linkami: "+ ex.getMessage());
            } 
            
      }
    }
  }    
}
