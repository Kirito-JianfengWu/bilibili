package com.se7en.bilibili.service;

import com.se7en.bilibili.repository.AuthoritiesRepository;
import com.se7en.bilibili.base.Result;
import com.hhsj.base.BaseService;
import com.se7en.bilibili.entity.Authorities;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface AuthoritiesService extends BaseService<Authorities, String>  {

   //根据id查询
   public Result getOne(String id);

   //根据id删除
   public Result deleteOne(String id);

   //根据id保存
   public Result saveOne(Authorities entity);
}
