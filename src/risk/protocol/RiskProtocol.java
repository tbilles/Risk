package risk.protocol;

import risk.common.Logger;
import risk.game.Player;
import risk.network.NetworkClient;

class RiskProtocol {
	private NetworkClient nc;
	
	public RiskProtocol(NetworkClient nc) {
		this.nc = nc;
	}
	
    public void sendHello(Player p) {
    	Logger.logdebug("Sending Hello to server");
    	// TODO: impelement
    }

};
