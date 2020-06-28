package com.se7en.bilibili.service;

import com.se7en.bilibili.entity.UserRole;

public class UserRoleService {

   //根据id查询
   public UserRole getOne(String id);

   //根据id删除
   public UserRole deleteOne(String id);

   //根据id保存
   public UserRole saveOne(UserRole entity);
}
