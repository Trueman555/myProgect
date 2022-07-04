package org.example10.dao;

import jakarta.validation.Valid;
import org.example10.models.DayBusiness;
import org.example10.models.OrgStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StaffDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired

    public StaffDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrgStaff> index() {
        return jdbcTemplate.query(
               "SELECT * FROM  staff",
  //              "SELECT staff_id, namesurname, experiance, id_work_shops, posts_name from  staff LEFT JOIN posts ON staff.id_posts = posts.id_posts",
                new BeanPropertyRowMapper<>(OrgStaff.class));
    }
    public List<DayBusiness> indexBusiness() {
        System.out.println();
        List<DayBusiness> query = jdbcTemplate.query( "SELECT * FROM  every_day_businesses", new BeanPropertyRowMapper<>( DayBusiness.class ) );
        System.out.println();
        return query;
    }
    @SuppressWarnings("deprecation")
    public OrgStaff show(int staff_id) {
        return jdbcTemplate.query( "SELECT * FROM staff WHERE staff_id=?", new Object[]{staff_id}, new BeanPropertyRowMapper<>( OrgStaff.class ) )
                .stream().findAny().orElse(null);
    }
    public DayBusiness showBusiness (int id_day) {
        return jdbcTemplate.query( "SELECT * FROM every_day_businesses WHERE id_day=?", new Object[]{id_day}, new BeanPropertyRowMapper<>( DayBusiness.class ) )
                .stream().findAny().orElse(null);
    }
    public void save(OrgStaff orgStaff) {
        jdbcTemplate.update("INSERT INTO staff (nameSurname, experiance, id_posts, id_work_shops) VALUES(?, ?, ?, ?)",
                orgStaff.getNameSurname(), orgStaff.getExperiance(),
                orgStaff.getId_work_shops(),orgStaff.getId_posts());
    }

    public void saveBusiness(DayBusiness dayBusiness) {
        jdbcTemplate.update("INSERT INTO every_day_businesses (products_per_day, average_time_day) VALUES(?,?)",
                dayBusiness.getProductsPerDay(), dayBusiness.getAverageTime());

    }

    public void update(int staff_id, @Valid OrgStaff updatedOrgStaff) {
        jdbcTemplate.update("UPDATE staff SET nameSurname=?, experiance=?, id_posts=?, id_work_shops=? WHERE staff_id=?",
                updatedOrgStaff.getNameSurname(),
                updatedOrgStaff.getExperiance(), updatedOrgStaff.getId_posts(), updatedOrgStaff.getId_work_shops(), staff_id);
    }
    public void updateBusiness(int id_day, @Valid DayBusiness updatedDayBusiness) {
        jdbcTemplate.update("UPDATE every_day_businesses SET products_per_day=?, average_time_day=?  WHERE id_day=?",
                updatedDayBusiness.getProductsPerDay(),
                updatedDayBusiness.getAverageTime(), id_day);
    }

    public void delete(int staff_id) {
        jdbcTemplate.update("DELETE FROM staff WHERE staff_id=?", staff_id);
    }

}

