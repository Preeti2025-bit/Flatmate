// package com.example.flat.com.RestDao;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;

// import com.example.flat.com.DataTraveller;
// import com.example.flat.com.MyCustomLogger;
// import com.example.flat.com.model.User;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// @Repository("restMobileDao")
// public class RestMobileDao extends MyCustomLogger implements IRestMobileDao {

// 	boolean isQueryPrint = true;

// 	@Autowired
// 	private SessionFactory sf;

// 	private String query;

// 	@Override
// //	@Transactional
// 	public DataTraveller<User> login(User rmrm) {
// 	//	boolean isFaculty = rmrm.getmUserType() == mUserType.Faculty;
// 	//	query = RMDQueries.loginQuery(rmrm.getUserName(), rmrm.getPassword(), isFaculty);
// 	//	pp(query);
// 		log("before executing the query ");

// 		List<User> result = sf.getCurrentSession().createNativeQuery(query, UserDetails.class).getResultList();
// 		DataTraveller<User> dt = new DataTraveller<User>();
// 		if (result.size() > 0) {
// 			log("Record Found :: RestMobileDao:: login()");
// 			User u = result.get(0);
// 			dt.setSuccess(true);
// 		//	dt.setData(new UserDetails(u.getUserId(), u.getUserName(), u.getHospitalCode(), u.getEmployeeNumber()));
// 			// if (u.getUserTypeId() != null && u.getUserTypeId() == 13 && isFaculty) {
// 			// 	dt.setSuccess(false);
// 			// 	dt.setError("Unauthorised Access");
// 			// }

// 		} else {
// 			log("No Record Found :: RestMobileDao:: login()");
// 			dt.setSuccess(false);
// 			dt.setError("No Record Found");
// 		}

// 		return dt;
// 	}
// }