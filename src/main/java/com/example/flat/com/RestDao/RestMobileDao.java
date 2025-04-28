package com.example.flat.com.RestDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.flat.com.DataTraveller;
import com.example.flat.com.MyCustomLogger;
import com.example.flat.com.RestModels.Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Repository("restMobileDao")
public class RestMobileDao extends MyCustomLogger implements IRestMobileDao {

	boolean isQueryPrint = true;

	@Autowired
	private SessionFactory sf;

	private String query;

	@Override
	@Transactional
	public DataTraveller<Users> login(Users rmrm) {
	//	boolean isFaculty = rmrm.getmUserType() == mUserType.Faculty;
		query = RMDQueries.loginQuery(
			rmrm.getName()
			);
		pp(query);
		log("before executing the query ");

    Session session = sf.openSession();
    List<Users> result = session.createNativeQuery(query, Users.class).getResultList();
    session.close();  		DataTraveller<Users> dt = new DataTraveller<Users>();
		if (result.size() > 0) {
			log("Record Found :: RestMobileDao:: login()");
			Users u = result.get(0);
			dt.setSuccess(true);
			dt.setData(u);
		//	dt.setData(new UserDetails(u.getUserId(), u.getUserName(), u.getHospitalCode(), u.getEmployeeNumber()));
			// if (u.getUserTypeId() != null && u.getUserTypeId() == 13 && isFaculty) {
			// 	dt.setSuccess(false);
			// 	dt.setError("Unauthorised Access");
			// }

		} else {
			log("No Record Found :: RestMobileDao:: login()");
			dt.setSuccess(false);
			dt.setError("No Record Found");
		}

		return dt;
	}
	private void pp(String query) {
		if (isQueryPrint)
			printQuery(query);
	}
	
}