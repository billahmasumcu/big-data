package apiConnection;

import java.util.List;

/**
 * Interface for API to use for several APIS
 * @author Salah Beck
 *
 * @param <T>
 */
public interface API<T> {

	/**
	 * gets connection to serve the OAuth protocol
	 * 
	 * @param accessToken
	 * @param clientSecret
	 * @return
	 */
	 T getconnection(String accessToken, String clientSecret);

	 /**
	  * returns a List of Medias searched by hashtags
	  * @param tag
	  * @return
	  */
	 List<?> getRecentMediaByHashTag(String tag);
}
