package berry.eva.core;

public final class Config {

	private String userAgent;
	private String pragma;
	private String cacheControl;
	private String cookie;

	public Config() {

	}

	public Config(String userAgent, String pragma, String cacheControl, String cookie) {
		super();
		this.userAgent = userAgent;
		this.pragma = pragma;
		this.cacheControl = cacheControl;
		this.cookie = cookie;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getPragma() {
		return pragma;
	}

	public void setPragma(String pragma) {
		this.pragma = pragma;
	}

	public String getCacheControl() {
		return cacheControl;
	}

	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cacheControl == null) ? 0 : cacheControl.hashCode());
		result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
		result = prime * result + ((pragma == null) ? 0 : pragma.hashCode());
		result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
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
		Config other = (Config) obj;
		if (cacheControl == null) {
			if (other.cacheControl != null)
				return false;
		} else if (!cacheControl.equals(other.cacheControl))
			return false;
		if (cookie == null) {
			if (other.cookie != null)
				return false;
		} else if (!cookie.equals(other.cookie))
			return false;
		if (pragma == null) {
			if (other.pragma != null)
				return false;
		} else if (!pragma.equals(other.pragma))
			return false;
		if (userAgent == null) {
			if (other.userAgent != null)
				return false;
		} else if (!userAgent.equals(other.userAgent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Config [userAgent=" + userAgent + ", pragma=" + pragma + ", cacheControl=" + cacheControl + ", cookie="
				+ cookie + "]";
	}

}
