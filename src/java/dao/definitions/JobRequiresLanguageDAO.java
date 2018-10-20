package dao.definitions;

import java.util.List;
import model.Language;

import model.Job;

public interface JobRequiresLanguageDAO {

    public List<Job> findLanguageJobs(Integer userId);
    
    public List<Language> findJobLanguages(Integer userId);

    public void create(Integer languageId, Integer jobId);

    public boolean remove(Integer languageId, Integer jobId);   
    
}
