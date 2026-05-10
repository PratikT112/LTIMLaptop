package org.example.Karat.courseEnrollmentProblem;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentList {
    public List<Enrollment> enrollmentList;

    public EnrollmentList() {
        this.enrollmentList = new ArrayList<>();
    }

    public void addEnrollment(Enrollment enrollment){
        enrollmentList.add(enrollment);
    }
}
