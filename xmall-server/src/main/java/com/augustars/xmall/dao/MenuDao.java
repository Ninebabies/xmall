package com.augustars.xmall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.augustars.xmall.dao.Base.BaseDao;
import com.augustars.xmall.entity.Menu;

public interface MenuDao extends BaseDao<Menu, Long>{
	//处理问题1：@Query注解，不能使用name，若使用name则由于解析JPA规则，无法完成
		//处理问题2：join fetch：关联表的意思，Menu与role不存在中间表
		//					     所以采用Join fetch，动态连接两表之间关系
		//					  Menu表中存在roleList，该roleList就相当于role表
		
		
		//如果方法通过 @Query 指定了查询语句，则使用该语句实现查询；
		//如果没有，则查找是否定义了符合条件的命名查询，如果找到，则使用该命名查询；
		//如果两者都没有找到，则通过解析方法名字来创建查询
		// query-lookup-strategy 属性的默认值
//	@Query("from Menu m join fetch m.roleList r where r.roleId=:roleId and m.parent is null order by m.sortOrder asc")
//	public List<Menu> findMenuListByRoleAndParentNull(@Param("roleId")Long roleId) throws Exception;
//	
//	@Query("from Menu m join fetch m.roleList r where r.roleId=:roleId and m.parent.menuId=:parentId order by m.sortOrder asc")
//	public List<Menu> findMenuListByRoleAndParentId(@Param("roleId")Long roleId, @Param("parentId")Long parentId) throws Exception;
//
//	@Query("from Menu m join fetch m.roleList r where r.roleId=:roleId")
//	public List<Menu> findMenuListByRole(@Param("roleId")Long roleId) throws Exception;
//
	@Query(value="from Menu m join fetch m.roleList r where r.roleId=:roleId and m.parent is null")
	public List<Menu> findFristMenuListByRole(@Param("roleId")Long roleId) throws Exception;
	
	@Query(value="from Menu m join fetch m.roleList r where r.roleId=:roleId and m.parent.menuId=:parentId")
	public List<Menu> findChildMenuListByRoleParent(@Param("roleId")Long roleId, @Param("parentId")Long parentId) throws Exception;
	
	@Query(value="from Menu m join fetch m.roleList r where r.roleId=:roleId")
	public List<Menu> findMenuListByRole(@Param("roleId")Long roleId)throws Exception;
	
	@Query(value="from Menu m where m.menuId=:menuId")
	public Menu findMenuById(@Param("menuId")Long menuId)throws Exception;
}
