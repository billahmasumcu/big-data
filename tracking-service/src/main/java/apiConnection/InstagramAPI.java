package apiConnection;

import java.util.List;

import org.jinstagram.Instagram;
/**
 * API to get responses from Instagram
 * @author Salah Beck
 *
 */
public class InstagramAPI implements API<Instagram> {

	@Override
	public Instagram getconnection(String accesstoken, String clientSecret) {
		Instagram instagram = new Instagram(accesstoken, clientSecret);
		return instagram;

	}

	@Override
	public List<?> getRecentMediaByHashTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
