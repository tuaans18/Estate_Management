package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RoleDTO;

import java.util.List;
import java.util.Map;

public interface RoleService {
	List<RoleDTO> findAll();
	Map<String,String> getRoles();
}
