import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return candidateName + " - " + jobRole.getRoleName();
    }
}

class ResumeScreening {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public List<Resume<? extends JobRole>> getResumes() {
        return resumes;
    }

    public static void processResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            System.out.println("Processing resumes for: " + jobRole.getRoleName());
        }
    }
}

class AIResumeScreeningSystem {
    public static void main(String[] args) {
        ResumeScreening screening = new ResumeScreening();
        
        Resume<SoftwareEngineer> johnResume = new Resume<>("John Doe", new SoftwareEngineer());
        Resume<DataScientist> aliceResume = new Resume<>("Alice Smith", new DataScientist());
        Resume<ProductManager> bobResume = new Resume<>("Bob Johnson", new ProductManager());

        screening.addResume(johnResume);
        screening.addResume(aliceResume);
        screening.addResume(bobResume);

        System.out.println("Screened Resumes:");
        for (Resume<? extends JobRole> resume : screening.getResumes()) {
            System.out.println(resume);
        }
    }
}

