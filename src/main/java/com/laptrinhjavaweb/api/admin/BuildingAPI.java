package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.response.ResponeDTO;
import com.laptrinhjavaweb.response.StaffResponseDTO;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;


    @PostMapping
    public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding){
        buildingService.save(newBuilding);
        return newBuilding;
    }

    @PutMapping("/{id}")
    public BuildingDTO updateBuilding(@PathVariable("id") long id, @RequestBody BuildingDTO buildingDTO) {
        buildingService.save(buildingDTO);
        return buildingDTO;
    }
    @GetMapping("/{id}/staffs")
    public ResponeDTO loadStaff(@PathVariable("id") Long buildingId) {
        ResponeDTO result = new ResponeDTO();
        List<StaffResponseDTO> staffs  = userService.getStaffByBuilding(buildingId);
        result.setMessage("success");
        result.setData(staffs);
        return result;
    }

    @DeleteMapping
    public ResponeDTO deleteBuilding(@RequestBody Long[] idList){
        ResponeDTO result = new ResponeDTO();
        if(idList.length > 0){
            buildingService.deleteBuilding(idList);
            result.setMessage("success");
            return result;
        }
        return null;
    }

    @PostMapping("/assignment")
    public ResponeDTO assignmentBuilding(@RequestBody AssignmentBuildingRequest assignmentBuildingRequest){
        ResponeDTO result = new ResponeDTO();
        buildingService.assignmentBuilding(assignmentBuildingRequest);
        result.setMessage("success");
        return result;
    }


}
