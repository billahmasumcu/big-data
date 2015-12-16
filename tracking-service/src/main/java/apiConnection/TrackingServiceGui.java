package apiConnection;

import java.util.List;

import org.jinstagram.entity.likes.LikesFeed;
import org.jinstagram.entity.media.MediaInfoFeed;
import org.jinstagram.entity.tags.TagInfoFeed;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.tags.TagSearchFeed;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.feed.MediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.entity.users.feed.UserFeed;

/**
 * @author Florian
 *
 */
public interface TrackingServiceGui {

	/**
	 * sets the used Api
	 * 
	 */
	void setApi();

	/**
	 * returns VerifyCode from textBox
	 * @return
	 */
	String getVerifyCode();
	
	/**
	 * returns the Auth URL
	 * @return String
	 */
	String showAuthURL();
	
	/**
	 * sets a boolean if the Data go through online Analysis
	 * 
	 * @return boolean
	 */
	boolean onlineAnalysis();

	/**
	 * sets a boolean if the Data go through offline Storage
	 * 
	 * @return boolean
	 */
	boolean offlineStorage();

	/**
	 * Search for a User by its Name
	 * 
	 * @param name
	 * @return UserFeed
	 */
	UserFeed searchUserByName(String name);

	/**
	 * Takes an userId and returns general user data
	 * 
	 * @param userId
	 * @return UserInfo
	 */
	UserInfo getGeneralUserData(long userId);

	/**
	 * Returns the general user data from the authenticated user
	 * 
	 * @return List<MediaFeedData>
	 */
	List<MediaFeedData> getAuthenticatedUserData();

	/**
	 * Provides the recent Media for a given userId
	 *
	 * @param userId
	 * @return MediaFeed
	 */
	MediaFeed getRecentMediaFromAUser(long userId);

	/**
	 * Provides Media information for a given mediaId
	 * 
	 * @param mediaId
	 * @return MediaInfoFeed
	 */
	MediaInfoFeed getMediaInfo(long mediaId);

	/**
	 * Provides Media for a given Location
	 * 
	 * @param latitude
	 * @param longitude
	 * @return MediaFeed
	 */

	MediaFeed searchMedia(double latitude, double longitude);

	/**
	 * Provides a list of what media is most popular at the moment.
	 * 
	 * @return MediaFeed
	 */
	MediaFeed getPopularMedia();

	/**
	 * Provides Users which liked the Media
	 * 
	 * @param mediaId
	 * @return LikesFeed
	 */
	LikesFeed getMediaLikes(long mediaId);

	/**
	 * Provides Information about a Hashtag
	 * 
	 * @param tagName
	 * @return TagInfoFeed
	 */
	TagInfoFeed getHashtagInfo(String tagName);

	/**
	 * Provides the recent Media for a given Hashtag
	 * 
	 * @param tagName
	 * @return TagMediaFeed
	 */
	TagMediaFeed getRecentMediaFromHashtag(String tagName);

	/**
	 * Provides the Number of Media which used this Hashtag
	 * 
	 * @param tagName
	 * @return TagSearchFeed
	 */
	TagSearchFeed countHashtag(String tagName);

}
