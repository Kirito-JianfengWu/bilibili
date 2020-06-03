package com.se7en.bilibili.service.impl;

import com.se7en.bilibili.entity.Result;
import com.se7en.bilibili.service.UserRoleService;
import org.springframework.stereotype.Service;
import com.se7en.bilibili.entity.UserRole;
import com.se7en.bilibili.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository rep;

	@Override
	public Result getOne(String id){
 		UserRole one = rep.getOne(id);
		return Result.builder().success().data(one).build();
	}

	@Override
	public Result deleteOne(String id){
 		rep.deleteById(id);
		return Result.builder().success().build();
	}

	@Override
	public Result saveOne(UserRole entity){
 		UserRole one = rep.save(entity);
		return Result.builder().success().data(one).build();
	}
}
