package berry.eva.project;

import java.util.ArrayList;
import java.util.List;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_projects;

public class ProjectManager {

	private Project currentProject;
	private List<Project> list_project;

	private static ProjectManager instance = new ProjectManager();

	private ProjectManager() {	
		
	}

	public static ProjectManager getInstance() {
		return instance;
	}

	
	public List<Project> getProjects() {
		CrudManager crud = new CrudManager();
		list_project = new ArrayList<Project>();
		List<DAO_projects> dao_list = crud.select_projects_all();
		
		
		return list_project;
	}
	
	public void createNewTables(Project project) {
		CrudManager crud = new CrudManager();
		DAO_projects dao = new DAO_projects(project.getName(), project.getCreatedTime());
		Integer result = crud.insert_project(dao);
		if(result == 1) {
			setCurrentProject(project);
		}
	}
	
	private void setCurrentProject(Project p) {
		this.currentProject = p;
	}
	
	public Project getCurrentProject() {
		return this.currentProject;
	}
}
