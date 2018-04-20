// // This file must be implemented when completing activity 2
// //
// 
// import java.rmi.*;
// import java.rmi.registry.*;
// import java.rmi.server.*;
// import java.util.*;
// 
// //
// // ChatRobot implementation
// //
// public class ChatRobot
// {
//    public static void main (String args [] )
//    {
//       System.out.println ("To be implemented");
//    }
// }
// This file must be implemented when completing activity 2
//

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//
// Chat Robot
//
//
public class ChatRobot
        implements MessageListener {
    private ChatConfiguration conf;
    private IChatServer server = null;
    private IChatUser user = null;

    public ChatRobot(ChatConfiguration conf) {
        this.conf = conf;
    }

    private void doConnect() throws Exception {
        try {
            Registry reg = LocateRegistry.getRegistry(conf.getNameServiceHost(), conf.getNameServicePort());
            server = (IChatServer) reg.lookup(conf.getServerName());
        } catch (RemoteException e) {
            throw new Exception("rmiregistry not found at '" + conf.getNameServiceHost() + ":" +
                    conf.getNameServicePort() + "'");
        } catch (NotBoundException e) {
            throw new Exception("Server '" + conf.getServerName() + "' not found.");
        }

        user = new ChatUser("bot#" + this.hashCode(), this);
        if (!server.connectUser(user))
            throw new Exception("El nick esta en u");
        //conectar un canal(Lo de abajo, conecta a todos los canales)
        //         IChatChannel[] channels = server.listChannels();
        //         if (channels == null || channels.length == 0)
        //             throw new Exception("Server has not channel");
        //         for (IChatChannel channel : channels) {
        //             channel.join(user);
        //         }
        IChatChannel channel = server.getChannel("Friends");
        if (channel == null) {throw new Exception ("Channel not found");}
        channel.join (user); // join 
        System.out.println("Joined all channel Ready!");
    }

    @Override
    public void messageArrived(IChatMessage msg) {
        try {
            if (msg.getText().matches("JOIN .*")) {
                IChatChannel channel = server.getChannel(conf.getChannelName());
                IChatMessage message = new ChatMessage(user, channel,
                        "Greetings, " + msg.getText().substring(ChatChannel.JOIN.length() + 1));
                channel.sendMessage(message);
            }
        } catch (RemoteException e) {
            System.err.println("BOT: Error handling messages");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ChatRobot cr = new ChatRobot(ChatConfiguration.parse(args));
        cr.doConnect();
    }
}