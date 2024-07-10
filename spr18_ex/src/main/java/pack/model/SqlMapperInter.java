package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("SELECT jikwon_no, jikwon_name, ifNull(buser_name, '무소속') as buser_name, year(jikwon_ibsail) as jikwon_ibsail "
			+ "FROM jikwon LEFT JOIN buser ON buser_num= buser_no")
	public List<JikwonDto> selectDataAll();
	
	@Select("select buser_name, count(*) as cc from jikwon inner join buser on buser_num=buser_no group by buser_num")
	public List<JikwonDto> selectDataBuser();
	
	@Select("select buser_name, jikwon_name, jikwon_pay from jikwon "
			+ "inner join buser on buser_num=buser_no "
			+ "where (buser_num, jikwon_pay) in (select buser_num, max(jikwon_pay) from jikwon group by buser_num)")
	public List<JikwonDto> selectDataBuserMax();
	
}
