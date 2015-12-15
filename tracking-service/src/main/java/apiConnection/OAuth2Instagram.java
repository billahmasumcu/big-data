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

public class OAuth2Instagram implements OAuth2 {
	private static final Token EMPTY_TOKEN = null;

	/**
	 * saves the Access Token for the next use AND for this session
	 */
	public Token saveAccessToken(String clientID, String clientSecret, String callbackURL, String verifierString) {
		InstagramService service = new InstagramAuthService().apiKey(clientID).apiSecret(clientSecret)
				.callback(callbackURL).scope("public_content").scope("follower_list").build();
		String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
		System.out.println(authorizationUrl);
		Verifier verifier = new Verifier(verifierString);
		Token accessToken = null;

		try {
			accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);

		} catch (OAuthException a) {
			System.err.println("invalid Verifycode or ClientID");
		}

		try {
			FileOutputStream fos = new FileOutputStream(clientID + ".token");
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

	/**
	 * gets the stored Access Token of clientID
	 */
	public Token getStoredAccessToken(String clientID) {
		FileInputStream fis;
		Token token = null;
		File file = new File(clientID + ".token");
		try {
			if (file.exists()) {
				fis = new FileInputStream(clientID + ".token");
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

}
