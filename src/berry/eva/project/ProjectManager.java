package berry.eva.project;

import java.util.ArrayList;
import java.util.List;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_projects;

public class ProjectManager {

	private List<Project> list_project;

	private static ProjectManager instance = new ProjectManager();

	private ProjectManager() {	
		this.list_project = new ArrayList<Project>();
	}

	public static ProjectManager getInstance() {
		return instance;
	}

	public Project getProject(String projectName) {
		Project project = null;
		for(Project p : list_project) {
			if( p.getName().equals(projectName)) {
				return p;
			}
		}
		return project;
	}
	
	public Project[] getProjects() {
		return (Project[]) list_project.toArray();
	}
	
	public boolean add(Project project) {
		return list_project.add(project);
	}
	
	public void createNewTables(Project project) {
		CrudManager crud = new CrudManager();
		DAO_projects dao = new DAO_projects(project.getName(), project.getCreatedTime());
		Integer result = crud.insert_project(dao);
	}
}
