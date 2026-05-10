package org.example.Karat.GymProblem;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private long id;
    private String name;
    private MembershipStatus membershipStatus;
    private List<Workout> workoutList = new ArrayList<>();

    public Member(long id, String name, MembershipStatus membershipStatus) {
        this.id = id;
        this.name = name;
        this.membershipStatus = membershipStatus;
    }


    public List<Workout> getWorkoutList() {
        return workoutList;
    }

    public void setWorkoutList(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
