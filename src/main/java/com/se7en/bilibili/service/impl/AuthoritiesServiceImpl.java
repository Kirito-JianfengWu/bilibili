package com.se7en.bilibili.service.impl;

import com.se7en.bilibili.entity.Result;
import com.se7en.bilibili.service.AuthoritiesService;
import org.springframework.stereotype.Service;
import com.se7en.bilibili.entity.Authorities;
import com.se7en.bilibili.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	private AuthoritiesRepository rep;

	@Override
	public Result getOne(String id){
 		Authorities one = rep.getOne(id);
		return Result.builder().success().data(one).build();
	}

	@Override
	public Result deleteOne(String id){
 		rep.deleteById(id);
		return Result.builder().success().build();
	}

	@Override
	public Result saveOne(Authorities entity){
 		Authorities one = rep.save(entity);
		return Result.builder().success().data(one).build();
	}
}
