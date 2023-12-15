package com.example.tp4.service;

import java.util.List;
import com.example.tp4.Entity.Staff;
public interface StaffService {
    void save(Staff staff);
    List<Staff> getAll();
    Staff getById(Integer id);
    void delete(Staff staff);
}

