package dao.definitions;

import java.util.List;
import model.Company;

import model.Job;

public interface CompanyHasJobDAO {

    public List<Job> findCompanyJobs(Integer userId);
    
    public List<Company> findJobCompanies(Integer userId);

    public void create(Integer companyId, Integer jobId);

    public boolean remove(Integer companyId, Integer jobId);   
    
}
