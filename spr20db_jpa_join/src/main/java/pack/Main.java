package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		try {
			// JPQL 사용
			String jpql = "select j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail "
					+ "from Jikwon j join j.buser b";

			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();

			for (Object[] r : results) {
				int year = getYearMy((Date)r[3]);
				System.out.println(r[0] + " " + r[1] + " " + r[2] + " " + year);
			}
			
			System.out.println("--------------------------------------------");
			// Native SQL 사용
			String sql = "select jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) "
					+ "from jikwon inner join buser on buser_num=buser_no";

			Query query2 = em.createNativeQuery(sql);

			List<Object[]> results2 = query2.getResultList();

			for (Object[] r : results2) {
				System.out.println(r[0] + " " + r[1] + " " + r[2] + " " + r[3]);
			}

		} catch (Exception e) {
			System.out.println("err: " + e);
		} finally {
			em.close();
			emf.close();
		}

	}
	private static int getYearMy(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(calendar.YEAR);
	}

}
