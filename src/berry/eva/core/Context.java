package berry.eva.core;

import org.jsoup.Connection;

public final class Context {

	private Integer index;
	private String url;
	private String time_request;
	private Boolean scanned;
	private Connection.Response response;

	public Context() {

	}

	public Boolean getScanned() {
		return scanned;
	}

	public void setScanned(Boolean scanned) {
		this.scanned = scanned;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTime_request() {
		return time_request;
	}

	public void setTime_request(String time_request) {
		this.time_request = time_request;
	}

	public Connection.Response getResponse() {
		return response;
	}

	public void setResponse(Connection.Response response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Context [index=" + index + ", url=" + url + ", time_request=" + time_request + ", scanned=" + scanned
				+ ", response=" + response + "]";
	}

	
}
