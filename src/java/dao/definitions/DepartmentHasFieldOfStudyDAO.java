package dao.definitions;

import java.util.List;
import model.FieldOfStudy;

import model.Department;

public interface DepartmentHasFieldOfStudyDAO {

    public List<FieldOfStudy> find1(Integer userId);
    
    public List<Department> find2(Integer userId);

    public void create(Integer departmentId, Integer fieldofstudyId);

    public boolean remove(Integer departmentId, Integer fieldofstudyId);   
    
}
