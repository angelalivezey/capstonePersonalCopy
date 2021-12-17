package com.techelevator.volunteerapplicationdao;

import com.techelevator.petmodel.Pet;
import com.techelevator.volunteerapplicationmodel.VolunteerApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcVolunteerApplicationDao implements VolunteerApplicationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVolunteerApplicationDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public VolunteerApplication getVolunteerApplicationById(int newId){
        String sql = "SELECT application_id, application_status_id, name, email, phone, description" +
                " FROM applications" +
                " WHERE application_id = ?;";
        VolunteerApplication application = null;
        SqlRowSet applicationResults =this.jdbcTemplate.queryForRowSet(sql, newId);
            if (applicationResults.next()) {
                application = mapRowToVolunteerApplication(applicationResults);
            }
            return application;

    }

    @Override
    public VolunteerApplication saveNewForm(VolunteerApplication newVolunteerApplication) {
        String sql = "INSERT INTO applications (application_status_id, name, email, phone, description) " +
                "VALUES(1, ?, ?, ?, ?) RETURNING application_id;";
        //TODO try catch?? want to keep from having null values
         Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newVolunteerApplication.getName(), newVolunteerApplication.getEmail(),
                 newVolunteerApplication.getPhone(), newVolunteerApplication.getDescription());

         return getVolunteerApplicationById(newId);
    }

    private VolunteerApplication mapRowToVolunteerApplication(SqlRowSet results) {
        VolunteerApplication volunteerApplication = new VolunteerApplication();
        volunteerApplication.setApplicationID(results.getInt("application_id"));
        volunteerApplication.setApplicationStatusID(results.getInt("application_status_id"));
        volunteerApplication.setName(results.getString("name"));
        volunteerApplication.setEmail(results.getString("email"));
        volunteerApplication.setPhone(results.getString("phone"));
        volunteerApplication.setDescription(results.getString("description"));
        return volunteerApplication;


    }

}
