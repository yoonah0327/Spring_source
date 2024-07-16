package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource); //db연결정보 다 들어감. 
		
	}
	
	//전체자료 읽기
	/*
	 * public List<SangpumDto> getDataAll(){
		String sql="select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	class ItemRowMapper implements RowMapper<Object>{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
	 */
	public List<MemberDto> getMemberList(){
		String sql = "select * from memberteb";
		/*
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		*/
		//람다표현식 
		//인터페이스의 추상메소드가 한개여야만 가능!
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
		
		return list;
	}
	
	//자료 추가하기
	public void insData(MemberBean bean) { //bean이든 string이든, object으로 받아서 param으로 넣어줘야한다.
		String sql = "insert into memberteb values(?,?,?,now())";
		
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()};
		getJdbcTemplate().update(sql, params);
	}
	
	//수정
	
	
	//삭제
}
