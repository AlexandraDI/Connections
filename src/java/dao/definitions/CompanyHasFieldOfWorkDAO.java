package dao.definitions;

import java.util.List;
import model.Company;

import model.FieldOfWork;

public interface CompanyHasFieldOfWorkDAO {

    public List<FieldOfWork> findCompanyFieldOfWorks(Integer userId);
    
    public List<Company> findFieldOfWorkCompanies(Integer userId);

    public void create(Integer companyId, Integer fieldId);

    public boolean remove(Integer companyId, Integer fieldId);   
    
}