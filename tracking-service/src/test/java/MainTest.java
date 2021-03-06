
import java.util.List;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.jinstagram.entity.users.feed.MediaFeed;
import org.jinstagram.entity.users.feed.UserFeed;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.jinstagram.exceptions.InstagramException;

import apiConnection.API;
import apiConnection.InstagramAPI;
import apiConnection.OAuth2;
import apiConnection.OAuth2Instagram;

/**
 * 
 * @author Salah Beck
 *
 */
public class MainTest {

	public static void main(String[] args) {

		final String clientID = "c8759156358249ce9cc23cff1f0a88ce";
		final String clientSecret = "e91fa2cd8dc94cd5aa98ec3f53893a6d";
		final String callbackURL = "http://ayylmao.com/";
		final String verifycode = "5702b998080d45f98c80a883235fa4bf"; // TODO
																		// read
																		// from
																		// UI!

		OAuth2 oAuth2 = new OAuth2Instagram();
		API<?> api = new InstagramAPI();
		Token accessToken = null;

		if (oAuth2.getStoredAccessToken(verifycode) != null) {
			accessToken = oAuth2.getStoredAccessToken(verifycode);
		} else {
			oAuth2.createService(clientID, clientSecret, callbackURL);
			System.out.println(oAuth2.getAuthURL());
			accessToken = oAuth2.saveAccessToken(clientID, verifycode);
		}

		Instagram instagram = (Instagram) api.getconnection(accessToken.getToken(), clientSecret);
		UserInfo userInfo = null;

		try {
			userInfo = instagram.getCurrentUserInfo();
		} catch (InstagramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			String query = "taylorswift";
			UserFeed userFeed2 = instagram.searchUser(query);

			List<UserFeedData> userList = userFeed2.getUserList();

			System.out.println(userList);
			
			UserFeed userFeed = instagram.getUserFollowedByList("2324365545");
			MediaFeed tagMediaFeed = instagram.getUserLikedMediaFeed();
			TagMediaFeed tagMediaFeed2 = instagram.getRecentMediaTags("swag");

			System.out.println(userFeed.getUserList());
			System.out.println(tagMediaFeed.getData());
			System.out.println(tagMediaFeed2.getData());

		} catch (InstagramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfoData userData = userInfo.getData();
		System.out.println(userData);

	}
}
