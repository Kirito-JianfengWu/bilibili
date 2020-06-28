package com.se7en.bilibili.service;

import com.se7en.bilibili.entity.Role;

public class RoleService {

   //根据id查询
   public Role getOne(String id);

   //根据id删除
   public Role deleteOne(String id);

   //根据id保存
   public Role saveOne(Role entity);
}
