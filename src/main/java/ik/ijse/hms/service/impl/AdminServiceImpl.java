package ik.ijse.hms.service.impl;

import ik.ijse.hms.dto.AdminDTO;
import ik.ijse.hms.entity.Admin;
import ik.ijse.hms.handler.AppException;
import ik.ijse.hms.repo.AdminRepo;
import ik.ijse.hms.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO admin) {

        if (adminRepo.existsById(admin.getId())) {
            throw new AppException("Admin Already Exist");
        }
        Admin adm = modelMapper.map(admin, Admin.class);
//        Admin adm = new Admin(admin.getId(), admin.getfName(), admin.getlName(), admin.getDob(), admin.getEmail(), admin.getPassword());
        adminRepo.save(adm);
    }

    @Override
    public void updateAdmin(AdminDTO admin) {
        if (adminRepo.existsById(admin.getId())) {
            throw new AppException("No Such Customer");
        }
        Admin adm = modelMapper.map(admin, Admin.class);
//        Admin adm = new Admin(admin.getId(), admin.getfName(), admin.getlName(), admin.getDob(), admin.getEmail(), admin.getPassword());
        adminRepo.save(adm);
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)) {
            throw new AppException("No Such Customer");
        }
        Optional<Admin> admin = adminRepo.findById(id);
        adminRepo.delete(admin.get());
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (!adminRepo.existsById(id)) {
            throw new AppException("No Such Customer");
        }
        Optional<Admin> admin = adminRepo.findById(id);
        return modelMapper.map(admin.get(), AdminDTO.class);
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> all = adminRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<AdminDTO>>() {
        }.getType());
    }
}
