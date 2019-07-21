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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((scanned == null) ? 0 : scanned.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Context other = (Context) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (scanned == null) {
			if (other.scanned != null)
				return false;
		} else if (!scanned.equals(other.scanned))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	
	
}
