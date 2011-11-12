package risk.game.client;

import java.io.IOException;
import java.net.SocketTimeoutException;

import risk.common.Logger;
import risk.common.Settings;
import risk.game.*;
import risk.network.IOutputQueue;
import risk.network.NetworkClient;
import risk.network.QueuedSender;
import risk.network.SocketClosedException;
import risk.protocol.ClientCommandVisitor;
import risk.protocol.ClientProtocolHandler;
import risk.protocol.command.Command;

public class GameClient extends Thread implements IOutputQueue {
    private static final int SOCKET_INTERRUPT_TIMEOUT = 1000;
    private static final int SENDER_INTERRUPT_TIMEOUT = 1000;

    private NetworkClient nc;
    private ClientProtocolHandler cph;
    private Game game = new Game();
    private QueuedSender queuedSender;
    private boolean serverIsAlive = false;

    public GameClient() {
        super("ClientThread");
    }

    public GameView getGameView() {
        return game;
    }
    
    public void ConnectToServer() throws IOException {
        String address = Settings.getInstance().getClientConnectAddr();
        int port = Settings.getInstance().getClientConnectPort();

        nc = new NetworkClient(SOCKET_INTERRUPT_TIMEOUT, false);
        nc.connect(address, port);
        Logger.logdebug("Socket established to server");
        queuedSender = new QueuedSender("ClientQueuedSenderThread", nc, SENDER_INTERRUPT_TIMEOUT);
        queuedSender.start();
        cph = new ClientProtocolHandler(queuedSender);
        cph.onConnectionEstablished(Settings.getInstance().getPlayerName());
        serverIsAlive = true;
    }
    
    @Override
    public void run() {
        try {
            try {
                Logger.loginfo("Client started");
                try {
                    ConnectToServer();
                } catch (IOException e) {
                    Logger.logexception(e, "Cannot connect to server");
                }

                Logger.loginfo("Connected to server");
                while (!interrupted() && serverIsAlive) {
                    try {
                        Command cmd = nc.readCommand();
                        ClientCommandVisitor ccv = new ClientCommandVisitor(game, game);
                        cmd.accept(ccv);
                    } catch (SocketTimeoutException e) {
                    } catch (SocketClosedException e) {
                        serverIsAlive = false;
                        Logger.loginfo("Server closed connection");
                    } catch (IOException e) {
                        Logger.logexception(e, "Couldn't read Command");
                        serverIsAlive = false;
                    }
                }
            } finally {
                onExit();
            }
        } catch (Exception e) {
            Logger.logexception(e, "Unhandled exception");
        }
    }

    private void onExit() {
        Logger.loginfo("Client stops");
        if (queuedSender != null) {
            queuedSender.interrupt();
        }
    }

    @Override
    public void queueForSend(Command cmd) {
        queuedSender.queueForSend(cmd);
    }

}
