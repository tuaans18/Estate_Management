package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.request.BuildingSearchRequest;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest buildingSearchRequest
                                     ) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch",buildingSearchRequest);
        mav.addObject("buildings", buildingService.findAll(buildingSearchRequest));
        mav.addObject("staffmaps",userService.getStaffMaps());
        mav.addObject("districtmaps",buildingService.getDistrictCode());
        mav.addObject("typemaps",buildingService.getType());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingDTO model = buildingService.findBuildingById(id);
        model.setDistrictMaps(buildingService.getDistrictCode());
        model.setTypeMaps(buildingService.getType());
        model.setRentArea(buildingService.getRentArea(id));
        mav.addObject(SystemConstant.MODEL,model);
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingAdd(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        model.setDistrictMaps(buildingService.getDistrictCode());
        model.setTypeMaps(buildingService.getType());
        mav.addObject(SystemConstant.MODEL,model);
        return mav;
    }

}