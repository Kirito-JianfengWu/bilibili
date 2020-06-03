package com.se7en.bilibili.service.impl;

import com.se7en.bilibili.entity.Result;
import com.se7en.bilibili.service.RoleService;
import org.springframework.stereotype.Service;
import com.se7en.bilibili.entity.Role;
import com.se7en.bilibili.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository rep;

	@Override
	public Result getOne(String id){
 		Role one = rep.getOne(id);
		return Result.builder().success().data(one).build();
	}

	@Override
	public Result deleteOne(String id){
 		rep.deleteById(id);
		return Result.builder().success().build();
	}

	@Override
	public Result saveOne(Role entity){
 		Role one = rep.save(entity);
		return Result.builder().success().data(one).build();
	}
}
