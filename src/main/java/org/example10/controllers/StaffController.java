package org.example10.controllers;
import jakarta.validation.Valid;
import org.example10.models.DayBusiness;
import org.example10.models.OrgStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.example10.dao.StaffDao;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffDao staffDao;

    @Autowired
    public StaffController(StaffDao staffDao) {

        this.staffDao = staffDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("staff", staffDao.index());
        return "staff/index1";
    }
    @GetMapping("/indexBusiness")
    public String indexBusiness(Model model) {
        List<DayBusiness> dayBusiness = staffDao.indexBusiness();
        System.out.println();
        model.addAttribute("every_day_businesses", dayBusiness);
        return "staff/indexBusiness";
    }
    @GetMapping("/{staff_id}")
    public String show(@PathVariable("staff_id") int staff_id, Model model) {
        model.addAttribute("orgStaff", staffDao.show(staff_id));
        return "staff/show";
    }
    @GetMapping("/indexBusiness/{id_day}")
    public String showBusiness(@PathVariable("id_day") int id_day, Model model) {
        model.addAttribute("dayBusiness", staffDao.showBusiness(id_day));
        return "staff/showBusiness";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("orgStaff") OrgStaff orgStaff) {
        return "staff/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("orgStaff") @Valid OrgStaff orgStaff,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "staff/new";

        staffDao.save(orgStaff);
        return "redirect:/staff";
    }

    @GetMapping("/{staff_id}/edit")
    public String edit(Model model, @PathVariable("staff_id") int staff_id) {
        model.addAttribute("orgStaff", staffDao.show(staff_id));
        return "staff/edit";
    }
    @GetMapping("/indexBusiness/{id_day}/editBusiness")
    public String editBusiness(Model model, @PathVariable("id_day") int id_day) {
        model.addAttribute("dayBusiness", staffDao.showBusiness(id_day));
        return "staff/editBusiness";
    }
    @PatchMapping("/indexBusiness/{id_day}")
    public String updateBusiness(@ModelAttribute("dayBusiness") @Valid DayBusiness dayBusiness, BindingResult bindingResult,
                                 @PathVariable("id_day") int id_day) {
        if (bindingResult.hasErrors())
            return "staff/editBusiness";

        staffDao.updateBusiness(id_day, dayBusiness);
        return "redirect:/staff";
    }
    @PatchMapping("/{staff_id}")
    public String update(@ModelAttribute("orgStaff") @Valid OrgStaff orgStaff, BindingResult bindingResult,
                         @PathVariable("staff_id") int staff_id) {
        if (bindingResult.hasErrors())
            return "staff/edit";

        staffDao.update(staff_id, orgStaff);
        return "redirect:/staff";
    }

    @DeleteMapping("/{staff_id}")
    public String delete(@PathVariable("staff_id") int staff_id) {
        staffDao.delete(staff_id);
        return "redirect:/staff";
    }

}
