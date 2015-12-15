package apiConnection;

import java.util.List;

public interface API<T> {

	/**
	 * uses generic type to be more flexible
	 * @param accessToken
	 * @param clientSecret
	 * @return
	 */
	public T getconnection(String accessToken, String clientSecret);

	public List<?> getRecentMediaByHashTag(String tag);
}
