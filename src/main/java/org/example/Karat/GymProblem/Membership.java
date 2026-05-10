package org.example.Karat.GymProblem;

import java.util.*;

public class Membership {

    public List<Member> members;

    public Membership() {
        this.members = new ArrayList<>();
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void updateMembership(long memberId, MembershipStatus status){
        for(Member member: members){
            if(member.getId() == memberId){
                member.setMembershipStatus(status);
                break;
            }
        }
    }

    public void addWorkout(int memberId, Workout workout){
        for(Member member: members){
            if(member.getId() == memberId){
                member.getWorkoutList().add(workout);
            }
        }
    }

    public Map<Integer, Double> getAverageWorkoutDurations() {
        Map<Integer, Double> res = new HashMap<>();
        for(Member member: members){
            if(member.getWorkoutList().isEmpty()){
                continue;
            }
            double asDouble = member.getWorkoutList().stream().mapToLong(Workout::getWorkoutDuration).average().orElse(0.0);
            res.put((int) member.getId(), asDouble);
        }
        return res;
    }

    public MembershipStatistics getMembershipStatistics() {
        int totalMembers = members.size();
        int totalPaidMember = 0;
        for(Member member: members){
            if(member.getMembershipStatus().equals(MembershipStatus.GOLD) || member.getMembershipStatus().equals(MembershipStatus.SILVER)){
                totalPaidMember++;
            }
        }
        double conversionRate = (totalPaidMember / (double) totalMembers) * 100.0;
        return new MembershipStatistics(totalMembers, totalPaidMember, conversionRate);
    }
}
