package jade.agenci;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//@author Konrad

public class InterfaceAgent extends Agent{
    
    private InterfaceAgentFormatka interfejs;
    
    protected void setup() {
    interfejs = new InterfaceAgentFormatka(this);
    interfejs.showGui();
    addBehaviour(new aktualizujListeObrazow());
    }
    
    public void wyslijZapytanieObrazy(String tag) {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("AgentWykopu", AID.ISLOCALNAME));
        msg.setLanguage("Polish");
        msg.setContent(tag);
        send(msg);
    }
    
    public void wyslijZapytanieTagi(String tag) {
        ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
        msg2.addReceiver(new AID("AgentBazodanowy", AID.ISLOCALNAME));
        msg2.setLanguage("English");
        msg2.setContent(tag);
        send(msg2);
    }
    
    public class aktualizujListeObrazow extends CyclicBehaviour {
        public void action() {
            ACLMessage msg = receive();
            if (msg == null) {
                System.out.println("InterfaceAgent: zablokowany");
                block();
            } else {
                if(interfejs.ktoreZapytanie == 0)
                {
                    try {
                        PaczkaLinkow komunikat = (PaczkaLinkow) msg.getContentObject();
                        interfejs.gotowe = true;
                        interfejs.ktoreZapytanie = 1;
                        interfejs.zaktualizujListeObrazow(komunikat.getList());
                    } catch (Exception ex) {
                        System.out.println("InterfaceAgent: blad w rozpakowaniu \n" + ex.getMessage());
                    }
                }else{
                    try {
                        PaczkaLinkow komunikat2 = (PaczkaLinkow) msg.getContentObject();
                        interfejs.zaktualizujListeProponowanych(komunikat2.getList());
                        System.out.println("InterfaceAgent: Otrzymalem paczke2.");
                        interfejs.ktoreZapytanie = 0;
                    } catch (UnreadableException ex) {
                        System.out.println("InterfaceAgent: blad w proponowanych: \n" + ex.getMessage());
                    }
                }
                
            }     
        }
    }
}
