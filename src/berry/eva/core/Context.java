package berry.eva.core;

import java.util.HashMap;
import java.util.Map;

public final class Context {
	private Integer id;
	private String URL;
	private String method;
	private String Req_Timestamp;
	private Map<String, String> Req_Header = new HashMap<String, String>();
	private String Req_Body;
	private String Resp_Timestamp;
	private String Resp_Code;
	private Map<String, String> Resp_Headers = new HashMap<String, String>();
	private String Resp_Reason;
	private String Resp_Body;
	private String CWE_ID;
	private boolean isVulnerable = false;

	public Context() {

	}

	public Context setId(Integer id) {
		this.id = id;
		return this;
	}

	public Context setURL(String uRL) {
		URL = uRL;
		return this;
	}

	public Context setMethod(String method) {
		this.method = method;
		return this;
	}

	public Context setReq_Timestamp(String req_Timestamp) {
		Req_Timestamp = req_Timestamp;
		return this;
	}

	public Context setReq_Header(Map<String, String> req_Header) {
		this.Req_Header = req_Header;
		return this;
	}

	public Context setReq_Body(String req_Body) {
		Req_Body = req_Body;
		return this;
	}

	public Context setResp_Timestamp(String resp_Timestamp) {
		Resp_Timestamp = resp_Timestamp;
		return this;
	}

	public Context setResp_Code(String resp_Code) {
		Resp_Code = resp_Code;
		return this;
	}

	public Context setResp_Reason(String resp_Reason) {
		Resp_Reason = resp_Reason;
		return this;
	}

	public Context setResp_Body(String resp_Body) {
		Resp_Body = resp_Body;
		return this;
	}

	public Context setCWE_ID(String cWE_ID) {
		CWE_ID = cWE_ID;
		return this;
	}
	
	public Context setResp_Headers(Map<String, String> resp_Headers) {
		this.Resp_Headers = resp_Headers;
		return this;
	}
	
	public Context setVulnerable(boolean isVulnerable) {
		this.isVulnerable = isVulnerable;
		return this;
	}

	public Context build() {
		return this;
	}

	public Integer getId() {
		return id;
	}

	public String getURL() {
		return URL;
	}

	public String getMethod() {
		return method;
	}

	public String getReq_Timestamp() {
		return Req_Timestamp;
	}

	public Map<String, String> getReq_Header() {
		return Req_Header;
	}

	public String getReq_Body() {
		return Req_Body;
	}

	public String getResp_Timestamp() {
		return Resp_Timestamp;
	}

	public String getResp_Code() {
		return Resp_Code;
	}

	public String getResp_Reason() {
		return Resp_Reason;
	}

	public String getResp_Body() {
		return Resp_Body;
	}

	public String getCWE_ID() {
		return CWE_ID;
	}

	public Map<String, String> getResp_Headers(){
		return this.Resp_Headers;
	}

	public boolean getIsVulnerable() {
		return isVulnerable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CWE_ID == null) ? 0 : CWE_ID.hashCode());
		result = prime * result + ((Req_Body == null) ? 0 : Req_Body.hashCode());
		result = prime * result + ((Req_Header == null) ? 0 : Req_Header.hashCode());
		result = prime * result + ((Req_Timestamp == null) ? 0 : Req_Timestamp.hashCode());
		result = prime * result + ((Resp_Body == null) ? 0 : Resp_Body.hashCode());
		result = prime * result + ((Resp_Code == null) ? 0 : Resp_Code.hashCode());
		result = prime * result + ((Resp_Headers == null) ? 0 : Resp_Headers.hashCode());
		result = prime * result + ((Resp_Reason == null) ? 0 : Resp_Reason.hashCode());
		result = prime * result + ((Resp_Timestamp == null) ? 0 : Resp_Timestamp.hashCode());
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isVulnerable ? 1231 : 1237);
		result = prime * result + ((method == null) ? 0 : method.hashCode());
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
		if (CWE_ID == null) {
			if (other.CWE_ID != null)
				return false;
		} else if (!CWE_ID.equals(other.CWE_ID))
			return false;
		if (Req_Body == null) {
			if (other.Req_Body != null)
				return false;
		} else if (!Req_Body.equals(other.Req_Body))
			return false;
		if (Req_Header == null) {
			if (other.Req_Header != null)
				return false;
		} else if (!Req_Header.equals(other.Req_Header))
			return false;
		if (Req_Timestamp == null) {
			if (other.Req_Timestamp != null)
				return false;
		} else if (!Req_Timestamp.equals(other.Req_Timestamp))
			return false;
		if (Resp_Body == null) {
			if (other.Resp_Body != null)
				return false;
		} else if (!Resp_Body.equals(other.Resp_Body))
			return false;
		if (Resp_Code == null) {
			if (other.Resp_Code != null)
				return false;
		} else if (!Resp_Code.equals(other.Resp_Code))
			return false;
		if (Resp_Headers == null) {
			if (other.Resp_Headers != null)
				return false;
		} else if (!Resp_Headers.equals(other.Resp_Headers))
			return false;
		if (Resp_Reason == null) {
			if (other.Resp_Reason != null)
				return false;
		} else if (!Resp_Reason.equals(other.Resp_Reason))
			return false;
		if (Resp_Timestamp == null) {
			if (other.Resp_Timestamp != null)
				return false;
		} else if (!Resp_Timestamp.equals(other.Resp_Timestamp))
			return false;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isVulnerable != other.isVulnerable)
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Context [id=" + id + ", URL=" + URL + ", method=" + method + ", Req_Timestamp=" + Req_Timestamp
				+ ", Req_Header=" + Req_Header + ", Req_Body=" + Req_Body + ", Resp_Timestamp=" + Resp_Timestamp
				+ ", Resp_Code=" + Resp_Code + ", Resp_Headers=" + Resp_Headers + ", Resp_Reason=" + Resp_Reason
				+ ", Resp_Body=" + Resp_Body + ", CWE_ID=" + CWE_ID + ", isVulnerable=" + isVulnerable + "]";
	}

	
}
