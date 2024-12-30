
package main.java.com.example.model;
import main.java.com.example.model.WorkExperience;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Resume {
    String employeeId;
    public String title;
    public String address;
    public String phoneNumber;
    public String instagram;
    Date updatedAt;
    public ArrayList<WorkExperience> workExperience;

    public Resume(String employeeId, String title, String address, String phoneNumber, String instagram) {
        this.employeeId = employeeId;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instagram = instagram;
        this.updatedAt = new Date();
        this.workExperience = new ArrayList<>();
    }

    @Override
    public String toString() {
        return title + " - " + phoneNumber + " - " + instagram;
    }

    public String toDetailString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder details = new StringBuilder();
        details.append("Employee ID: ").append(employeeId).append("\n");
        details.append("Title: ").append(title).append("\n");
        details.append("Updated At: ").append(sdf.format(updatedAt)).append("\n");
        details.append("Address: ").append(address).append("\n");
        details.append("Phone Number: ").append(phoneNumber).append("\n");
        details.append("Instagram: ").append(instagram).append("\n\n");

        details.append("Work Experience:\n");
        for (WorkExperience exp : workExperience) {
            details.append("- ").append(exp.workplaceName).append(" (")
                    .append(sdf.format(exp.startDate)).append(" ~ ")
                    .append(sdf.format(exp.endDate)).append(")\n");
            details.append("  Content: ").append(exp.workContent).append("\n\n");
        }
        return details.toString();
    }

    // ResumeService (내부 클래스)
//     public static class ResumeService {
//         private ArrayList<Resume> resumes = new ArrayList<>();

//         public void addResume(Resume resume) {
//             resumes.add(resume);
//         }

//         public void deleteResume(int index) {
//             resumes.remove(index);
//         }

//         public ArrayList<Resume> getResumes() {
//             return resumes;
//         }
//     }
}
