package ex3;

public class College {
    private String collegeName;
    private Department department;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "College [collegeName=" + collegeName + ", department=" + department + "]";
    }
}
