package apiConnection;

import org.jinstagram.auth.model.Token;
/**
 * Interface to provide an connection with the OAuth2 Protocol
 * @author Salah Beck
 *
 */
public interface OAuth2 {

	/**
	 * creates service to communicate with API
	 * @param clientID
	 * @param clientSecret
	 * @param callbackURL
	 */
	public void createService(String clientID, String clientSecret, String callbackURL);
	
	/**
	 * gets the AuthURL, must have an created Service to actually work
	 * @return String
	 */
	public String getAuthURL();
	
	/**
	 * saves accessToken as .token File and uses it for this and later sessions
	 * @param clientID
	 * @param verifierString
	 * @return Token
	 */
	public Token saveAccessToken(String clientID, String verifierString);
	
	/**
	 * gets accessToken from .token File with verifyString
	 * @param clientID
	 * @return Token
	 */
	public Token getStoredAccessToken(String verifyCode);
}
