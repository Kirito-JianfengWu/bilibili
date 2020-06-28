package com.se7en.bilibili.service;

import com.se7en.bilibili.entity.Authorities;

public class AuthoritiesService {

   //根据id查询
   public Authorities getOne(String id);

   //根据id删除
   public Authorities deleteOne(String id);

   //根据id保存
   public Authorities saveOne(Authorities entity);
}
