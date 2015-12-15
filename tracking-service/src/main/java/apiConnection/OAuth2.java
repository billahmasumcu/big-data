package apiConnection;

import org.jinstagram.auth.model.Token;

public interface OAuth2 {

	public Token saveAccessToken(String clientID, String clientSecret, String callbackURL, String verifierString);
	public Token getStoredAccessToken(String clientID);
}
