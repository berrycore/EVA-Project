package berry.eva.core;

public final class Context {
	private Integer id;
	private String URL;
	private String method;
	private String Req_Timestamp;
	private String Req_Header;
	private String Resp_Timestamp;
	private String Resp_Code;
	private String Resp_Reason;
	private String Resp_Body;
	private String CWE_ID;

	public Context() {

	}

	public Context(Integer id, String uRL, String method, String req_Timestamp, String req_Header,
			String resp_Timestamp, String resp_Code, String resp_Reason, String resp_Body, String cWE_ID) {
		super();
		this.id = id;
		URL = uRL;
		this.method = method;
		Req_Timestamp = req_Timestamp;
		Req_Header = req_Header;
		Resp_Timestamp = resp_Timestamp;
		Resp_Code = resp_Code;
		Resp_Reason = resp_Reason;
		Resp_Body = resp_Body;
		CWE_ID = cWE_ID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getReq_Timestamp() {
		return Req_Timestamp;
	}

	public void setReq_Timestamp(String req_Timestamp) {
		Req_Timestamp = req_Timestamp;
	}

	public String getReq_Header() {
		return Req_Header;
	}

	public void setReq_Header(String req_Header) {
		Req_Header = req_Header;
	}

	public String getResp_Timestamp() {
		return Resp_Timestamp;
	}

	public void setResp_Timestamp(String resp_Timestamp) {
		Resp_Timestamp = resp_Timestamp;
	}

	public String getResp_Code() {
		return Resp_Code;
	}

	public void setResp_Code(String resp_Code) {
		Resp_Code = resp_Code;
	}

	public String getResp_Reason() {
		return Resp_Reason;
	}

	public void setResp_Reason(String resp_Reason) {
		Resp_Reason = resp_Reason;
	}

	public String getResp_Body() {
		return Resp_Body;
	}

	public void setResp_Body(String resp_Body) {
		Resp_Body = resp_Body;
	}

	public String getCWE_ID() {
		return CWE_ID;
	}

	public void setCWE_ID(String cWE_ID) {
		CWE_ID = cWE_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CWE_ID == null) ? 0 : CWE_ID.hashCode());
		result = prime * result + ((Req_Header == null) ? 0 : Req_Header.hashCode());
		result = prime * result + ((Req_Timestamp == null) ? 0 : Req_Timestamp.hashCode());
		result = prime * result + ((Resp_Body == null) ? 0 : Resp_Body.hashCode());
		result = prime * result + ((Resp_Code == null) ? 0 : Resp_Code.hashCode());
		result = prime * result + ((Resp_Reason == null) ? 0 : Resp_Reason.hashCode());
		result = prime * result + ((Resp_Timestamp == null) ? 0 : Resp_Timestamp.hashCode());
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
				+ ", Req_Header=" + Req_Header + ", Resp_Timestamp=" + Resp_Timestamp + ", Resp_Code=" + Resp_Code
				+ ", Resp_Reason=" + Resp_Reason + ", Resp_Body=" + Resp_Body + ", CWE_ID=" + CWE_ID + "]";
	}

}
