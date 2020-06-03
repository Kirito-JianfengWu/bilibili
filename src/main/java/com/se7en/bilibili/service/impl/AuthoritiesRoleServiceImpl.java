package com.se7en.bilibili.service.impl;

import com.se7en.bilibili.entity.Result;
import com.se7en.bilibili.service.AuthoritiesRoleService;
import org.springframework.stereotype.Service;
import com.se7en.bilibili.entity.AuthoritiesRole;
import com.se7en.bilibili.repository.AuthoritiesRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AuthoritiesRoleServiceImpl implements AuthoritiesRoleService {

	@Autowired
	private AuthoritiesRoleRepository rep;

	@Override
	public Result getOne(String id){
 		AuthoritiesRole one = rep.getOne(id);
		return Result.builder().success().data(one).build();
	}

	@Override
	public Result deleteOne(String id){
 		rep.deleteById(id);
		return Result.builder().success().build();
	}

	@Override
	public Result saveOne(AuthoritiesRole entity){
 		AuthoritiesRole one = rep.save(entity);
		return Result.builder().success().data(one).build();
	}
}
