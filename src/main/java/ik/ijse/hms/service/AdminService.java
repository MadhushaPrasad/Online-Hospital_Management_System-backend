package ik.ijse.hms.service;

import ik.ijse.hms.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO admin);

    void updateAdmin(AdminDTO admin);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    List<AdminDTO> getAllAdmin();
}
