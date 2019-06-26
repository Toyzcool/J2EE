package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 数据库的增删改查方法具体实现
 */

public class HeroDAO{
	// 构造方法初始化驱动
	public HeroDAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("初始化驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//提供getConnection方法返回连接
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	// 获取数据总数
	public int getTotal() {
		int total = 0;
		try (
				Connection c = getConnection();
				Statement s = c.createStatement();
				)
		{
			String sql = "select count(*) from hero";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("Total："+total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
		
	// 增加
	public void add(Hero hero) {
		String sql = "insert into hero value(null,?,?,?)";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				) 
		{
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			// 获取数据库分配的id
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				hero.id = id;
			}
			c.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		};
	};
		
	// 删除
	public void delete(int id) {
		String sql = "delete from hero where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
		
	// 修改
	public void update(Hero hero) {
		String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql)
				)
		{
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
		
	// 获取
	public Hero get(int id) {
		String sql = "select * from hero where id = ?";
		Hero hero = null;
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)	 
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			c.commit();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 hero = new Hero();
				 String name = rs.getString("name");
				 float hp = rs.getFloat("hp");
				 int damage = rs.getInt("damage");
				 hero.name = name;
				 hero.hp = hp;
				 hero.damage = damage;
				 hero.id = id;
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hero;
	};
	
	public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

	// 查询
	public List<Hero> list(int start,int count){
		List<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero order by id desc limit ? , ?";
		try (
				Connection c =  getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, start);
			ps.setInt(2, count);
			c.commit();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hero hero = new Hero();
				int id = rs.getInt("id");
				String name = rs.getString(2);
				float hp = rs.getFloat(3);
				int damage = rs.getInt(4);
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				heros.add(hero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heros;
	};
}
