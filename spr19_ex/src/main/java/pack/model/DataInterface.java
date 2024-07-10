package pack.model;

import java.util.List;

public interface DataInterface {
	List<JikDto> selectDataAll(); //전체직원정보
	List<Object[]> selectcntBuser(); //부서별인원
}
