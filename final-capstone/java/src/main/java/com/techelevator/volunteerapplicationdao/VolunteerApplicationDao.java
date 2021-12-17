package com.techelevator.volunteerapplicationdao;

import com.techelevator.volunteerapplicationmodel.VolunteerApplication;

public interface VolunteerApplicationDao {

    public VolunteerApplication saveNewForm(VolunteerApplication volunteerApplication);
//TODO why is this not used/greyed out? matches "create project" from dao hw
    public VolunteerApplication getVolunteerApplicationById(int newId);

}