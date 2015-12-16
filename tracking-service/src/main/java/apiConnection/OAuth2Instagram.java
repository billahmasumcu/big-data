package apiConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.exceptions.OAuthException;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
/**
 * OAuth2 Class to communicate with Instagram OAuth2 Protocol
 * @author Salah Beck
 *
 */
public class OAuth2Instagram implements OAuth2 {
	private static final Token EMPTY_TOKEN = null;
	InstagramService service;

	public void createService(String clientID, String clientSecret, String callbackURL) {
		service = new InstagramAuthService().apiKey(clientID).apiSecret(clientSecret).callback(callbackURL)
				.scope("public_content").scope("follower_list").build();
	}

	public Token saveAccessToken(String clientID, String verifierString) {

		Verifier verifier = new Verifier(verifierString);
		Token accessToken = null;

		try {
			accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);

		} catch (OAuthException a) {
			System.err.println("invalid Verifycode or ClientID");
		}

		try {
			FileOutputStream fos = new FileOutputStream(verifierString + ".token");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(accessToken);

			fos.flush();
			oos.flush();
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accessToken;
	}

	public Token getStoredAccessToken(String verifierString) {
		FileInputStream fis;
		Token token = null;
		File file = new File(verifierString + ".token");
		try {
			if (file.exists()) {
				fis = new FileInputStream(verifierString + ".token");
				ObjectInputStream ois = new ObjectInputStream(fis);
				token = (Token) ois.readObject();
				ois.close();
				fis.close();

			} else {
				System.err.println("no Token for given Client ID, proceeding to create one..");
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}

	@Override
	public String getAuthURL() {
		String authorizationUrl = "create Service please";
		if (service != null) {
			authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
			//TODO swap URL show to UI

		}

		return authorizationUrl;
	}

}
