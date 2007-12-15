package travel.data.managers.common;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public abstract class CommonManager extends DaoSupport {

	HibernateDaoSupport hibernateDao=new HibernateDaoSupport(){};
	SqlMapClientDaoSupport sqlMapClientDao=new SqlMapClientDaoSupport(){};
	SimpleJdbcDaoSupport jdbcDao=new SimpleJdbcDaoSupport(){};
	//JpaDaoSupport jpaDao=new JpaDaoSupport(){};
	
	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		// TODO Auto-generated method stub
	}
	
	/* 
	 * Factories
	 */	
	
	public final SessionFactory getSessionFactory() {
		return hibernateDao.getSessionFactory();
	}
	
	public final void setSessionFactory(SessionFactory sessionFactory) {
		hibernateDao.setSessionFactory(sessionFactory);
	}
	
	public final SqlMapClient getSqlMapClient() {
		return sqlMapClientDao.getSqlMapClient();
	}

	public final void setSqlMapClient(SqlMapClient sqlMapClient) {
		sqlMapClientDao.setSqlMapClient(sqlMapClient);
	}
	/*
	public final void setEntityManagerFactory(EntityManagerFactory em) {
		jpaDao.setEntityManagerFactory(em);
	}*/
	
	public final DataSource getDataSource() {
		return jdbcDao.getDataSource();
	}
	
	public final void setDataSource(DataSource dataSource) {
		jdbcDao.setDataSource(dataSource);
	}
	
	
	/*
	 * Templates
	 */
	
	/*
	public final JpaTemplate getJpaTemplate() {
		return jpaDao.getJpaTemplate();
	}*/
	
	public final HibernateTemplate getHibernateTemplate() {
		return hibernateDao.getHibernateTemplate();
	}
	
	public final JdbcTemplate getJdbcTemplate() {
		return jdbcDao.getJdbcTemplate();
	}
	
	public final SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return jdbcDao.getSimpleJdbcTemplate();
	}
	
	public final SqlMapClientTemplate getSqlMapTemplate() {
		return sqlMapClientDao.getSqlMapClientTemplate();
	}
	
}
