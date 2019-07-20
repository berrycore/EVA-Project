package berry.eva.core;

public final class Context {

	private String project_name;
	private String site_name;
	private Integer id;
	private String time_req;
	private String time_resp;
	private String method;
	private String target_url;
	private String resp_code;
	private String resp_reason;
	private String found_policy_name;

	public Context() {
	}

	public Context(String project_name, String site_name, Integer id, String time_req, String time_resp, String method,
			String target_url, String resp_code, String resp_reason, String found_policy_name) {
		super();
		this.project_name = project_name;
		this.site_name = site_name;
		this.id = id;
		this.time_req = time_req;
		this.time_resp = time_resp;
		this.method = method;
		this.target_url = target_url;
		this.resp_code = resp_code;
		this.resp_reason = resp_reason;
		this.found_policy_name = found_policy_name;
	}
	
	

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime_req() {
		return time_req;
	}

	public void setTime_req(String time_req) {
		this.time_req = time_req;
	}

	public String getTime_resp() {
		return time_resp;
	}

	public void setTime_resp(String time_resp) {
		this.time_resp = time_resp;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTarget_url() {
		return target_url;
	}

	public void setTarget_url(String target_url) {
		this.target_url = target_url;
	}

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public String getResp_reason() {
		return resp_reason;
	}

	public void setResp_reason(String resp_reason) {
		this.resp_reason = resp_reason;
	}

	public String getFound_policy_name() {
		return found_policy_name;
	}

	public void setFound_policy_name(String found_policy_name) {
		this.found_policy_name = found_policy_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((found_policy_name == null) ? 0 : found_policy_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((project_name == null) ? 0 : project_name.hashCode());
		result = prime * result + ((resp_code == null) ? 0 : resp_code.hashCode());
		result = prime * result + ((resp_reason == null) ? 0 : resp_reason.hashCode());
		result = prime * result + ((site_name == null) ? 0 : site_name.hashCode());
		result = prime * result + ((target_url == null) ? 0 : target_url.hashCode());
		result = prime * result + ((time_req == null) ? 0 : time_req.hashCode());
		result = prime * result + ((time_resp == null) ? 0 : time_resp.hashCode());
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
		if (found_policy_name == null) {
			if (other.found_policy_name != null)
				return false;
		} else if (!found_policy_name.equals(other.found_policy_name))
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
		if (project_name == null) {
			if (other.project_name != null)
				return false;
		} else if (!project_name.equals(other.project_name))
			return false;
		if (resp_code == null) {
			if (other.resp_code != null)
				return false;
		} else if (!resp_code.equals(other.resp_code))
			return false;
		if (resp_reason == null) {
			if (other.resp_reason != null)
				return false;
		} else if (!resp_reason.equals(other.resp_reason))
			return false;
		if (site_name == null) {
			if (other.site_name != null)
				return false;
		} else if (!site_name.equals(other.site_name))
			return false;
		if (target_url == null) {
			if (other.target_url != null)
				return false;
		} else if (!target_url.equals(other.target_url))
			return false;
		if (time_req == null) {
			if (other.time_req != null)
				return false;
		} else if (!time_req.equals(other.time_req))
			return false;
		if (time_resp == null) {
			if (other.time_resp != null)
				return false;
		} else if (!time_resp.equals(other.time_resp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Context [project_name=" + project_name + ", site_name=" + site_name + ", id=" + id + ", time_req="
				+ time_req + ", time_resp=" + time_resp + ", method=" + method + ", target_url=" + target_url
				+ ", resp_code=" + resp_code + ", resp_reason=" + resp_reason + ", found_policy_name="
				+ found_policy_name + "]";
	}

}
