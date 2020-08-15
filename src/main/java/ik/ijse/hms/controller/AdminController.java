package ik.ijse.hms.controller;


import ik.ijse.hms.dto.AdminDTO;
import ik.ijse.hms.service.AdminService;
import ik.ijse.hms.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseEntity<StanderdResponse> getAdmin() {
        List<AdminDTO> allAdmin = adminService.getAllAdmin();
        return new ResponseEntity(new StanderdResponse(200, "Madhusha", allAdmin), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchAdmin(@RequestParam String id) {
        AdminDTO adminDTO = adminService.searchAdmin(id);
        return new ResponseEntity(new StanderdResponse(200, "Madhusha", adminDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveAdmin(@RequestBody AdminDTO admin) {
        adminService.saveAdmin(admin);
        return new ResponseEntity(new StanderdResponse(200, "Silva", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id*"})
    public ResponseEntity deleteAdmin(@RequestParam String id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity(new StanderdResponse(200, "Madhusha", null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateAdmin(@RequestBody AdminDTO admin) {
        adminService.updateAdmin(admin);
        return new ResponseEntity(new StanderdResponse(200, "Madhusha", null), HttpStatus.OK);
    }
}
