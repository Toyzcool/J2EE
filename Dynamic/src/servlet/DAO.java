package servlet;
import java.util.List;

/*
 * 数据库的增删改查方法名称
 */

public interface DAO {
	// 增加
	public void add(Hero hero);
	// 删除
	public void delete(int id);
	// 修改
	public void update(Hero hero);
	// 获取
	public Hero get(int id);
	// 查询
	public List<Hero> list(int start,int count);
}
