package com.example.tp4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tp4.Entity.Staff;
import com.example.tp4.Repository.StaffRepository;
@Service
class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;
    @Override
    public void save(Staff staff) {
        if (staff.getId() == null) {
            staffRepository.save(staff);
        } else {
            Staff staffUpdate =
                    staffRepository.findById(staff.getId()).get();
            staffUpdate.setName(staff.getName());
            staffUpdate.setDesgn(staff.getDesgn());
            staffUpdate.setEmailId(staff.getEmailId());
            staffRepository.save(staffUpdate);
        }
    }
    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }
    @Override
    public Staff getById(Integer id) {
        return staffRepository.findById(id).get();
    }
    @Override
    public void delete(Staff staff) {
        staffRepository.delete(staff);
    }
}
