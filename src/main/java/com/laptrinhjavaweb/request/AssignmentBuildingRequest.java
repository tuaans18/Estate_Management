package com.laptrinhjavaweb.request;

import java.util.List;

public class AssignmentBuildingRequest {
    private List<Long> listStaffId;
    private Long buildingId;


    public List<Long> getListStaffId() {
        return listStaffId;
    }

    public void setListStaffId(List<Long> listStaffId) {
        this.listStaffId = listStaffId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}
