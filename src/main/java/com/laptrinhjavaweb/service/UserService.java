package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.exception.MyException;
import com.laptrinhjavaweb.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.response.StaffResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws MyException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(long[] ids);
    Map<Long, String> getStaffMaps();
    List<StaffResponseDTO> getStaffByBuilding(Long buildingId);
    List<StaffResponseDTO> getStaffByCustomer(Long customerId);
}
