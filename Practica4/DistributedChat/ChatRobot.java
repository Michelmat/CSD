// This file must be implemented when completing activity 2
//

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

//
// ChatRobot implementation
//
public class ChatRobot implements MessageListener
{
    private IChatServer srv = null;   
    private ChatUI ui = null;         // User interface for fancy UI-driven chatting.
   public static void main (String args [] )
   {
      System.out.println ("To be implemented");
   }
   public void doSendChannelMessage (String dst, String msg) throws Exception
   {
      try {
     IChatChannel c_dst = srv.getChannel (dst);
     //IChatMessage c_msg = new ChatMessage(myUser, c_dst, msg);
     //c_dst.sendMessage (c_msg);
      } catch (Exception e) {
     throw new Exception ("Cannot send message: " + e);
      }
   }
   public void messageArrived (IChatMessage msg) {
      try {
     IChatUser src = msg.getSender();
     Remote dst = msg.getDestination();
     String str = msg.getText();
     IChatChannel c_dst = srv.getChannel (dst);
     IChatChannel c_dst = srv.getChannel (dst);
     if (msg.isPrivate()) {
        IChatUser u_dst = (IChatUser) dst;
        ui.showPrivateMessage (src.getNick(), u_dst.getNick(), str);

     } else {
        IChatChannel c_dst = (IChatChannel) dst;
        if (src == null) { // Control message from the channel itself
           String nick = null;
           if (str.startsWith (ChatChannel.LEAVE)) {
          nick = str.substring (ChatChannel.LEAVE.length() + 1);
          ui.showUserLeavesChannel (c_dst.getName(), nick);
           } else if (str.startsWith (ChatChannel.JOIN)) {
          nick = str.substring (ChatChannel.JOIN.length() + 1);
          ui.showUserEntersChannel (c_dst.getName(), nick);
          if("#Friends".equals(dst))
          doSendChannelMessage("#Friends", "Holaa "+nick);
           }
        } else { // Normal channel message
           ui.showChannelMessage (src.getNick(), c_dst.getName(), str);
        }
     }
      } catch (Exception e) {
     ui.showErrorMessage ("Error when receiving message: " + e.getMessage());
      }
   }
}
