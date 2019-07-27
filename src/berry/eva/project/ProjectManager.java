package berry.eva.project;

public class ProjectManager {

	private Project project;

	private static ProjectManager instance = new ProjectManager();

	private ProjectManager() {	}

	public static ProjectManager getInstance() {
		return instance;
	}

	public Project getProject() {
		return this.project;
	}
	
	public void setProjec(Project project) {
		this.project = project;
	}
}
