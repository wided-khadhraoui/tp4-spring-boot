package com.example.tp4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.tp4.Entity.Staff;
import com.example.tp4.service.StaffService;
@Controller
public class StaffController {
    @Autowired
    StaffService StaffService;
    @GetMapping("/")
    public String getAllSatffs(Model model) {
        List<Staff> staffList = StaffService.getAll();
        if(staffList.size()>0) {
            model.addAttribute("staffs", staffList);
        }
        return "list-staffs";
    }
    @GetMapping("/add-staff")
    public String addStaff(Model model) {
        model.addAttribute("staff", new Staff());
        return "add-edit-staff";
    }
    @PostMapping("/save-staff")
    public String saveStaff(Staff staff) {
        StaffService.save(staff);
        return "redirect:/";
    }
    @GetMapping("/staff-update/{id}")
    public String getStaff(Model model, @PathVariable("id")
    Integer id) {
        Staff staff = StaffService.getById(id);
        model.addAttribute("staff", staff);
        return "add-edit-staff";
    }
    @GetMapping("/staff-delete/{id}")
    public String deleteStaff(@PathVariable("id") Integer id)
    {
        Staff deleteStaff = StaffService.getById(id);
        StaffService.delete(deleteStaff);
        return "redirect:/";
    }
}