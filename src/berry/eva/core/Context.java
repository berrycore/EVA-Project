package berry.eva.core;

import java.util.HashMap;
import java.util.List;
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
	private Map<String, List<String>> Resp_Headers = new HashMap<String, List<String>>();
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
		req_Header.putAll(Req_Header);
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
	
	public Context setResp_Headers(Map<String, List<String>> resp_Headers) {
		resp_Headers.putAll(Resp_Headers);
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

	public Map<String, List<String>> getResp_Headers(){
		return this.Resp_Headers;
	}

	public boolean getIsVulnerable() {
		return isVulnerable;
	}
}
