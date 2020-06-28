package com.se7en.bilibili.service;

import com.se7en.bilibili.entity.AuthoritiesRole;

public class AuthoritiesRoleService {

   //根据id查询
   public AuthoritiesRole getOne(String id);

   //根据id删除
   public AuthoritiesRole deleteOne(String id);

   //根据id保存
   public AuthoritiesRole saveOne(AuthoritiesRole entity);
}
