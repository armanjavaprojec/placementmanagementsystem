package com.nacre.pms.db_util;

import com.nacre.pms.util.StringConstants;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 This class contains declaration of all the sql query
 *         constants , which are going to be used in Data Access Object classes.
 */
public class SQLQueryConstants {

	public static final String ROOUND_ID_ROUND_NOTIFICATION = "select ir.job_posting_id from tbl_interview_round ir inner join tbl_eligible_student es where ir.job_posting_id=es.job_posting_id and es.user_id=?";

	public static final String Read_ALL_NOTIFICATION_ = "update tbl_interview_round set not_status_id=? where job_posting_id=?";

	public static final String GET_SINGLE_TRAINEE_ROUND_ID = "select es.interview_round_id from tbl_interview_round ir inner join tbl_eligible_student es where ir.job_posting_id=es.job_posting_id and ir.round_no=? and es.user_id=?";

	public static final String Read_Single_ROUND_NOTIFICATION = "update tbl_interview_round set not_status_id=? where interview_round_id=? and job_posting_id=?";

	public static final String SHOW_ROUND_NOTIFICATION_TO_TRAINEE = "select tbl_interview_round.round_no, tbl_job_posting.description,tbl_interview_round.date,\r\n"
			+ "tbl_address.location,tbl_address.pincode,tbl_city.city,tbl_user.first_name,tbl_user.last_name,tbl_client.client_name,\r\n"
			+ "tbl_job_posting.job_posting_id,tbl_not_status.not_status_id\r\n"
			+ "from tbl_eligible_student,tbl_job_posting,tbl_interview_round,tbl_address,tbl_city,tbl_user,tbl_client_address,tbl_client,tbl_not_status\r\n"
			+ "where \r\n" + "tbl_eligible_student.interview_round_id=tbl_interview_round.interview_round_id\r\n"
			+ "and tbl_interview_round.job_posting_id=tbl_job_posting.job_posting_id\r\n"
			+ "and tbl_interview_round.address_id=tbl_address.address_id\r\n"
			+ "and tbl_address.city_id=tbl_city.city_id\r\n" + "and tbl_eligible_student.user_id=tbl_user.user_id\r\n"
			+ "and tbl_job_posting.client_address_id=tbl_client_address.client_address_id\r\n"
			+ "and tbl_client_address.client_id=tbl_client.client_id\r\n"
			+ "and tbl_eligible_student.not_status_id=tbl_not_status.not_status_id\r\n"
			+ "and tbl_eligible_student.user_id=?\r\n" + "and tbl_eligible_student.status_id=?";

	/**
	 * @author Atul
	 */
	/*
	 * SHOW_CLIENT_INFO_TO_HR query is used to show Client data to HR
	 */
	public static final String SHOW_CLIENT_INFO_TO_HR = "select post.description,post.expected_date,post.posted_date,post.`no_of_vacancies`, \r\n"
			+ "cl.client_name,cl.client_image,cl.description,address.contact_person_name,\r\n"
			+ "address.contact_person_mobile,address.contact_person_email,ad.location,\r\n"
			+ "ct.city,st.state,cntry.country,post.job_posting_id,post.not_status_id from tbl_client cl inner join tbl_client_address address\r\n"
			+ "inner join tbl_job_posting post inner join tbl_address ad inner join tbl_city ct inner join\r\n"
			+ "tbl_state st inner join tbl_country cntry where post.client_address_id=address.client_address_id\r\n"
			+ "and cl.client_id=address.client_id and address.address_id=ad.address_id and ad.city_id=ct.city_id\r\n"
			+ "and ct.state_id=st.state_id and st.country_id=cntry.country_id and post.expected_date>?";

	/*
	 * SET_READ_NOTIFICATION_TO_HR query is used to set the notificaitions id
	 * that are viewed by HR.
	 */
	public static final String SET_READ_NOTIFICATION_TO_HR = "update tbl_job_posting set not_status_id=? where hr_id=?";

	/*
	 * SET_READ_SINGLE_NOTIFICATION_TO_HR query is used to set notification id
	 * for a single notificaition are viewed by HR .
	 */
	public static final String SET_READ_SINGLE_NOTIFICATION_TO_HR = "update tbl_job_posting set not_status_id=? where job_posting_id=?";

	// upto atul query============================================

	/**
	 * @author Sagar
	 * @version 1.0.0 2018
	 */
	// this query used to load all countries
	public final static String SQL_GET_COUNTRIES = "SELECT country_id,country FROM tbl_country";

	// this query used to load all states associated with the particular country
	public static final String SQL_GET_STATES = "SELECT state_id,state FROM tbl_state where country_id=?";

	// this query used to load all cities associated with the particular state
	public static final String SQL_GET_CITIES = "SELECT city_id,city FROM tbl_city where state_id=?";

	public static final String SQL_INSERT_ADDRESS_QUERY = "insert into tbl_address(location,city_id) values(?,?)";

	public static final String SQL_ADD_ROUND_QUERY = "insert into tbl_interview_round(round_no,description,date,job_posting_id,status_id,address_id) values(?,?,?,?,?,?);";

	public static final String SQL_GET_ASSIGNED_BATCHES = "select tbl_batch.batch_id,tbl_batch.batch from tbl_batch_technology,tbl_batch where tbl_batch_technology.batch_id=tbl_batch.batch_id group by tbl_batch_technology.batch_id;";

	public static final String SQL_GET_TECHNOLOGIES_ASSIGNED_TO_BATCH = "select tbl_technology.technology_id,tbl_technology.technology from tbl_batch_technology,tbl_technology,tbl_batch where tbl_batch_technology.batch_id=tbl_batch.batch_id and tbl_batch_technology.technology_id=tbl_technology.technology_id and tbl_batch.batch_id=?;";

	public static final String SQL_GET_TRAINEES = "select tbl_user.user_id,tbl_user.first_name,tbl_user.last_name,tbl_user.mobileno,tbl_user.email,tbl_address.location,tbl_city.city,\r\n"
			+ "tbl_state.state,tbl_country.country \r\n"
			+ "from tbl_user,tbl_status,tbl_role,tbl_address,tbl_city,tbl_state,tbl_country,tbl_batch_technology\r\n"
			+ "where tbl_batch_technology.batch_id=? and tbl_batch_technology.technology_id=?\r\n"
			+ "and tbl_status.`status`='active' and tbl_role.role='trainee'\r\n"
			+ "and tbl_user.batch_technology_id=tbl_batch_technology.batch_technology_id \r\n"
			+ "and tbl_user.status_id=tbl_status.status_id \r\n" + "and tbl_user.role_id=tbl_role.role_id \r\n"
			+ "and tbl_user.address_id=tbl_address.address_id\r\n" + "and tbl_address.city_id=tbl_city.city_id \r\n"
			+ "and tbl_city.state_id=tbl_state.state_id \r\n" + "and tbl_state.country_id=tbl_country.country_id;";

	public static final String SQL_INAVCTIVATE_USER = "update tbl_user set tbl_user.status_id='2' where tbl_user.user_id=?;";

	public static final String SQL_GET_TRAINEE_BASIC_INFO = "select tbl_user.first_name,tbl_user.last_name,tbl_user.mobileno,tbl_user.email,tbl_address.location,tbl_city.city,tbl_state.state,tbl_country.country\r\n"
			+ "from tbl_user,tbl_address,tbl_city,tbl_state,tbl_country\r\n"
			+ "where tbl_user.address_id=tbl_address.address_id \r\n" + "and tbl_address.city_id=tbl_city.city_id\r\n"
			+ "and tbl_city.state_id=tbl_state.state_id\r\n" + "and tbl_state.country_id=tbl_country.country_id\r\n"
			+ "and tbl_user.user_id=?\r\n" + ";";

	public static final String SQL_GET_TRAINEE_EDU_INFO = "select tbl_edu_type.edu_type_id,tbl_edu_type.edu_type,tbl_stream.stream_id,tbl_stream.stream,tbl_specilization.specilization_id,tbl_specilization.specilization,tbl_edu_type_details.percentage,tbl_edu_type_details.yop \r\n"
			+ "from tbl_edu_type_details,tbl_user,tbl_edu_type,tbl_specilization,tbl_stream \r\n" + "where \r\n"
			+ "tbl_edu_type_details.user_id=tbl_user.user_id\r\n"
			+ "and tbl_edu_type_details.specilization_id=tbl_specilization.specilization_id\r\n"
			+ "and tbl_edu_type_details.edu_type_id=tbl_edu_type.edu_type_id\r\n"
			+ "and tbl_specilization.stream_id=tbl_stream.stream_id\r\n" + "and tbl_user.user_id=?;";

	public static final String SQL_GET_STREAMS = "select tbl_stream.stream_id,tbl_stream.stream\r\n"
			+ "from tbl_stream\r\n" + "where tbl_stream.edu_type_id=?;";

	public static final String SQL_GET_SPECIALIZATIONS = "select tbl_specilization.specilization_id,tbl_specilization.specilization\r\n"
			+ "from tbl_specilization;";

	public static final String SQL_GET_SELECTED_SPECIALIZATION = "select tbl_specilization.specilization_id,tbl_specilization.specilization\r\n"
			+ "from tbl_specilization\r\n" + "where tbl_specilization.stream_id=?;";

	/*
	 * public static final String
	 * SQL_UPDATE_EDUCATION="update tbl_edu_type_details \r\n" + "set \r\n" +
	 * "percentage=?,\r\n" + "yop=?,\r\n" + "specilization_id=?,\r\n" +
	 * "edu_type_id=?\r\n" + "where \r\n" + "tbl_edu_type_details.user_id=?";
	 */

	public static final String SQL_INSERT_EDUCATION = "insert into tbl_edu_type_details(user_id,percentage,yop,specilization_id,edu_type_id)\r\n"
			+ "values(?,?,?,?,?);";

	public static final String SQL_INSERT_EDUCATION_DETAILS = "INSERT INTO tbl_edu_details(tbl_edu_details.edu_type_details_id,tbl_edu_details.user_id)\r\n"
			+ "values(?,?);";

	public static final String SQL_DELETE_EDUCATION = "delete from tbl_edu_type_details\r\n"
			+ "where tbl_edu_type_details.user_id=?";

	public static final String SQL_DELETE_EDUCATION_DETAILS = "delete from tbl_edu_details\r\n"
			+ "where tbl_edu_details.user_id=?;";

	public static final String SQL_UPDATE_EDUCATION_NEW = "update tbl_edu_type_details \r\n"
			+ "set tbl_edu_type_details.percentage=?\r\n" + ",tbl_edu_type_details.yop=?\r\n"
			+ ",tbl_edu_type_details.specilization_id=?\r\n" + "where tbl_edu_type_details.user_id=?\r\n"
			+ "and tbl_edu_type_details.edu_type_id=?;";

	public static final String SQL_GET_INTERESTED_TRAINEES = "select tbl_user.user_id,tbl_user.first_name,tbl_user.last_name,tbl_user.email\r\n"
			+ "from tbl_user,tbl_eligible_student,tbl_status\r\n" + "where\r\n"
			+ "tbl_eligible_student.user_id=tbl_user.user_id\r\n"
			+ "and tbl_eligible_student.status_id=tbl_status.status_id\r\n"
			+ "and tbl_eligible_student.interview_round_id=?\r\n" + "and tbl_eligible_student.job_posting_id=?\r\n"
			+ "and tbl_status.`status`='interested'\r\n" + ";";

	public static final String SQL_GET_ALL_STATUS = "select tbl_status.status_id,tbl_status.`status` from tbl_status;";

	public static final String SQL_UPDATE_PREVIOUS_ROUND_STATUS = "update tbl_eligible_student\r\n"
			+ "set tbl_eligible_student.interview_round_id=?,\r\n" + "tbl_eligible_student.status_id=4\r\n"
			+ "where tbl_eligible_student.job_posting_id=?;";

	public static final String SQL_UPDATE_TRAINEE_ROUND_STATUS = "update tbl_eligible_student\r\n"
			+ "set tbl_eligible_student.status_id=?\r\n" + "where tbl_eligible_student.job_posting_id=?\r\n"
			+ "and tbl_eligible_student.user_id in (select tbl_user.user_id from tbl_user where tbl_user.email=?);";

	public static final String SQL_GET_PREVIOUS_ROUND_SHORTLISTED_TRAINEES = "SELECT tbl_user.user_id,tbl_user.first_name,tbl_user.last_name,tbl_user.email\r\n"
			+ "from tbl_user,tbl_eligible_student,tbl_status\r\n"
			+ "where tbl_eligible_student.user_id=tbl_user.user_id\r\n"
			+ "and tbl_eligible_student.status_id=tbl_status.status_id\r\n"
			+ "and tbl_eligible_student.job_posting_id=?\r\n" + "and status='shortlisted';";

	public static final String SQL_UPDATE_TRAINEE_PLACEMENT_STATUS = "update tbl_eligible_student\r\n"
			+ "set tbl_eligible_student.status_id=?\r\n" + "where tbl_eligible_student.user_id=?\r\n"
			+ "and tbl_eligible_student.job_posting_id=?;";

	public static final String SQL_GET_CLIENT_ADDEESS_ID_FROM_JOB_POSTING_ID = "select tbl_job_posting.client_address_id from tbl_job_posting\r\n"
			+ "where tbl_job_posting.job_posting_id=?;";

	public static final String SQL_PLACE_TRAINEE_QUERY = "insert into tbl_placement(selected_date,joining_date,package_per_anum,bond_aggrement,job_type_id,user_id,client_address_id)\r\n"
			+ "values(?,?,?,?,?,?,?);";

	public static final String SQL_GET_ALL_JOB_TYPES = "select tbl_job_type.job_type_id,tbl_job_type.job_type\r\n"
			+ "from tbl_job_type;";

	public static final String SQL_GET_CONPANY_INFO_BASED_ON_JOB_POSTING_ID = "select tbl_client.client_name\r\n"
			+ "from tbl_client,tbl_job_posting,tbl_client_address\r\n"
			+ "where tbl_job_posting.client_address_id=tbl_client_address.client_address_id\r\n"
			+ "and tbl_client_address.client_id=tbl_client.client_id\r\n" + "and tbl_job_posting.job_posting_id=?;";

	public static final String SQL_INACTIVE_PREVIOUS_ROUND = "update tbl_interview_round\r\n"
			+ "set tbl_interview_round.status_id=2\r\n" + "where tbl_interview_round.job_posting_id=?;";

	public static final String SQL_GET_PREVIOS_ROUND = "select tbl_interview_round.interview_round_id from tbl_interview_round where tbl_interview_round.job_posting_id=?;";

	public static final String VIEW_TRAINEE_CLIENT_INFO = "select tbl_client.client_name,tbl_client.description,tbl_job_posting.expected_date,tbl_job_posting.description,\r\n"
			+ "tbl_job_posting.no_of_vacancies,tbl_client_address.contact_person_name,tbl_client_address.contact_person_mobile,\r\n"
			+ "tbl_client_address.contact_person_email,tbl_user.first_name,tbl_user.last_name,tbl_address.location,\r\n"
			+ "tbl_address.pincode,tbl_city.city,tbl_job_posting.job_posting_id,tbl_state.state,tbl_country.country,tbl_not_status.not_status_id\r\n"
			+ "from\r\n"
			+ "tbl_user,tbl_job_posting,tbl_eligible_student,tbl_status,tbl_client_address,tbl_client,tbl_address,tbl_city,tbl_state,tbl_country,\r\n"
			+ "tbl_not_status\r\n" + "where tbl_eligible_student.interview_round_id=0\r\n"
			+ "and tbl_user.user_id=?\r\n" + "and tbl_status.`status`='eligible'\r\n"
			+ "and tbl_eligible_student.status_id=tbl_status.status_id\r\n"
			+ "and tbl_eligible_student.job_posting_id=tbl_job_posting.job_posting_id\r\n"
			+ "and tbl_eligible_student.user_id=tbl_user.user_id\r\n"
			+ "and tbl_job_posting.client_address_id=tbl_client_address.client_address_id\r\n"
			+ "and tbl_client_address.client_id=tbl_client.client_id\r\n"
			+ "and tbl_client_address.address_id=tbl_address.address_id\r\n"
			+ "and tbl_address.city_id=tbl_city.city_id\r\n" + "and tbl_city.state_id=tbl_state.state_id\r\n"
			+ "and tbl_state.country_id=tbl_country.country_id\r\n"
			+ "and tbl_eligible_student.not_status_id=tbl_not_status.not_status_id";
	// instead of static data, set session id of trainee

	public static final String SET_INTERESTED_TRAINEE_STATUS = "UPDATE tbl_eligible_student SET status_id=? WHERE user_id=? AND job_posting_id=?";

	public static final String SET_NOT_INTRESTED_TRAINEE_DESCRIPTION = "UPDATE tbl_eligible_student SET discription=?,status_id=? WHERE user_id=? AND job_posting_id=?";

	public static final String SET_READ_NOTIFICATION = "update tbl_eligible_student set not_status_id=? where user_id=?";
	public static final String SET_READ_SINGLE_NOTIFICATION = "update tbl_eligible_student set not_status_id=? where user_id=? and job_posting_id=?";

	public static final String INSERT_ADDRESS_QUERY = "INSERT INTO tbl_address (LOCATION,PINCODE,CITY_ID) VALUES(?,?,(SELECT CITY_ID FROM TBL_CITY WHERE CITY=?))";
	public static final String INSERT_TRAINEE_DATA = "INSERT INTO tbl_user (first_name,last_name,email,password,mobileno,gender,image,d_o_b,role_id,status_id,address_id,batch_technology_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,(SELECT batch_technology_id FROM tbl_batch_technology WHERE batch_id=(SELECT batch_id FROM TBL_BATCH WHERE batch=?) AND technology_id=(SELECT technology_id FROM tbl_technology WHERE technology=?)))";
	public static final String INSERT_SSC_HSC_EDUCATION_DETAILS = "INSERT INTO tbl_edu_type_details(user_id,percentage,yop,edu_type_id,specilization_id) values (?,?,?,?,(SELECT specilization_id FROM tbl_specilization WHERE stream_id=(select stream_id from tbl_stream where tbl_stream.edu_type_id=?)))";
	public static final String INSERT_G_PG_EDUCATION_DETAILS = "INSERT INTO tbl_edu_type_details(user_id,percentage,yop,edu_type_id,specilization_id) values (?,?,?,?,(SELECT specilization_id FROM tbl_specilization WHERE specilization=?))";

	public static final String GET_PREVIOUS_TRAINEE_DETAILS = "select u.user_id,u.first_name,u.last_name,u.mobileno,u.d_o_b,a.pincode,a.location,c.city,s.state,cty.country  from tbl_user u NATURAL join tbl_address a  NATURAL join tbl_city c NATURAL join tbl_state s  NATURAL join tbl_country cty where u.email=?";
	public static final String UPDATE_TRAINEE_DETAILS = "update tbl_user u NATURAL join tbl_address a  NATURAL join tbl_city c NATURAL join tbl_state s  NATURAL join tbl_country cty set u.first_name=?,u.last_name=?,u.mobileno=?,u.image=?,u.d_o_b=?,a.location=?,a.pincode=?,a.city_id=?,c.state_id=?,s.country_id=? where u.email=?";

	public static final String DATA_RETREIVAL_QRY_LOGIN = "select tbl_user.*,tbl_role.role  from tbl_user join tbl_role on tbl_user.role_id=tbl_role.role_id where email=? and password=? and status_id="
			+ StringConstants._ACTIVE_STATUS_ID;
	public static final String DATA_RETREIVAL_QRY_LOGIN_USING_MOBILE = "select tbl_user.*,tbl_role.role  from tbl_user join tbl_role on tbl_user.role_id=tbl_role.role_id where mobileno=? and password=?";
	public static final String QRY_TO_RETREIVE_FIRSTNAME__PASSWORD = "select first_name,password from tbl_user where email=?";
	public static final String QRY_TO_UPDATE_PASSWORD = "update tbl_user set password=? where email=? and password=?";
	public static final String QRY_TO_UPDATE_PASSWORD_USING_MOBILE = "update tbl_user set password=? where mobileno=? and password=?";
	public static final String INFORMATION_RETREIVAL = "select * from tbl_user where user_id=?";

	public static final String GET_BATCH = "SELECT BATCH_ID,BATCH FROM TBL_BATCH B, TBL_STATUS S WHERE B.STATUS_ID=S.STATUS_ID AND B.STATUS_ID=?";
	public static final String GET_TECHNOLOGY = "SELECT BT.TECHNOLOGY_ID, TECHNOLOGY FROM TBL_TECHNOLOGY T, TBL_BATCH B, TBL_BATCH_TECHNOLOGY BT, TBL_STATUS S WHERE B.BATCH_ID=BT.BATCH_ID AND T.TECHNOLOGY_ID=BT.TECHNOLOGY_ID AND B.STATUS_ID=S.STATUS_ID AND T.STATUS_ID=? AND BT.BATCH_ID=?";
	public static final String GET_COUNTRY = "SELECT COUNTRY_ID,COUNTRY FROM TBL_COUNTRY";
	public static final String GET_STATE = "SELECT S.STATE_ID,S.STATE FROM TBL_STATE S,TBL_COUNTRY C WHERE C.COUNTRY_ID=S.COUNTRY_ID AND S.COUNTRY_ID=?";
	public static final String GET_CITY = "SELECT C.CITY_ID,C.CITY FROM TBL_STATE S,TBL_CITY C WHERE S.STATE_ID=C.STATE_ID AND S.STATE_ID=?";
	public static final String GET_STREAM = "SELECT STREAM_ID, STREAM FROM TBL_STREAM S,TBL_EDU_TYPE E WHERE S.EDU_TYPE_ID=E.EDU_TYPE_ID AND S.EDU_TYPE_ID=?";
	public static final String GET_SPECILIZATION = "SELECT SPECILIZATION_ID,SPECILIZATION FROM TBL_SPECILIZATION SP,TBL_STREAM S WHERE SP.STREAM_ID=S.STREAM_ID AND SP.STREAM_ID=?";
	public static final String SELECT_BATCH_TECHNOLOGY = "SELECT BATCH_TECHNOLOGY_ID FROM TBL_BATCH_TECHNOLOGY BT, TBL_BATCH B, TBL_TECHNOLOGY T WHERE BT.BATCH_ID=B.BATCH_ID AND BT.TECHNOLOGY_ID=T.TECHNOLOGY_ID AND BT.BATCH_ID=? AND BT.TECHNOLOGY_ID=? ";
	public static final String INSERT_ADDRESS = "INSERT INTO TBL_ADDRESS(LOCATION,PINCODE,CITY_ID) VALUES(?,?,?)";
	public static final String INSERT_TRAINEE = "INSERT INTO TBL_USER(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,MOBILENO,GENDER,IMAGE,D_O_B,ROLE_ID,STATUS_ID,BATCH_TECHNOLOGY_ID,ADDRESS_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_EDUCATION_TYPE_DETAILS = "INSERT INTO TBL_EDU_TYPE_DETAILS(USER_ID,PERCENTAGE,YOP,EDU_TYPE_ID,SPECILIZATION_ID) VALUES(?,?,?,?,?)";
	public static final String INSERT_EDUCATION_DETAILS = "INSERT INTO TBL_EDU_DETAILS(EDU_TYPE_DETAILS_ID,USER_ID) VALUES(?,?)";

	public static final String GET_BATCH_DETAILS = "SELECT BATCH_ID,BATCH,BATCH_START_DATE,BATCH_END_DATE,STATUS_ID FROM TBL_BATCH WHERE STATUS_ID=1";
	public static final String DELETE_Batch_DETAILS = "UPDATE TBL_BATCH SET STATUS_ID=2 WHERE BATCH_ID=?";
	public static final String BATCH_UPDATE = " UPDATE TBL_BATCH SET BATCH=?,BATCH_START_DATE=?,BATCH_END_DATE=? where batch_id=?";
	public static final String GET_BATCH_DETAILS_BY_BID = "SELECT BATCH_ID,BATCH,BATCH_START_DATE,BATCH_END_DATE FROM TBL_BATCH WHERE BATCH_ID=?";

	/*
	 * VIEW_TECHNOLOGY query is used to get the data from technology table.
	 */
	public static final String VIEW_TECHNOLOGY = "select tech.technology_id,tech.technology,st.status_id,st.status from tbl_technology tech,tbl_status st where tech.status_id=st.status_id and st.status='active'";

	/*
	 * EDIT_TECHNOLOGY query is used to get the data from technology table.
	 */
	public static final String EDIT_TECHNOLOGY = "select tech.technology_id,tech.technology from tbl_technology tech,tbl_status st where st.status_id=tech.status_id and tech.technology_id=? and st.status='active'";

	/*
	 * UPDATE_TECHNOLOGY query is used to get the data from technology table.
	 */
	public static final String UPDATE_TECHNOLOGY = "update tbl_technology t set t.technology=? where t.technology_id=?;";

	/*
	 * ADD_TECHNOLOGY query is used to insert the data into Technology table.
	 */
	public static final String ADD_TECHONOLGY = "insert into tbl_technology(technology,status_id) values(?,?)";

	/*
	 * DELETE_TECHNOLOGY query is used to delete the data from Technology table.
	 */
	public static final String DELETE_TECHNOLOGY = "update tbl_technology set status_id=? where technology_id=?";

	/*
	 * CHECK_TECHNOLOGY_NAME query is used to check whether duplicate technology
	 * name present Technology table or not.
	 */
	public static final String CHECK_TECHNOLOGY_NAME = "select technology from tbl_technology where status_id="
			+ StringConstants._ACTIVE_STATUS_ID;
	public static final String CHECK_BATCH_NAME = "select batch from tbl_batch where status_id="
			+ StringConstants._ACTIVE_STATUS_ID;

	/*
	 * UPDATE_TECHNOLOGY_STATUS query is used to delete the data from Technology
	 * table.
	 */
	public static final String UPDATE_TECHNOLOGY_STATUS = "update tbl_technology set status_id=? where technology=?";

	public static final String Batch_Query = "SELECT BATCH_ID,BATCH FROM TBL_BATCH B,TBL_STATUS ST WHERE B.STATUS_ID=ST.STATUS_ID AND ST.STATUS='ACTIVE' ";

	public static final String Tech_Query = "select technology_id,technology from tbl_technology,tbl_status where tbl_technology.status_id=tbl_status.status_id and tbl_status.`status`='active' and technology_id NOT IN (select technology_id from tbl_batch_technology where  batch_id=?)";

	public static final String Tech_Batch_Query = "INSERT INTO TBL_BATCH_TECHNOLOGY(BATCH_ID,TECHNOLOGY_ID)VALUES(?,?)";

	public static final String Ret_Batch_Tech = "SELECT b.batch,t.technology,tbt.batch_technology_id from tbl_batch_technology tbt,tbl_batch b,tbl_technology t WHERE t.technology_id=tbt.technology_id and b.batch_id=tbt.batch_id ";

	public static final String JOB_POSTING_NOTIFICATION = "select tbl_job_posting.job_posting_id,tbl_job_posting.description, tbl_job_posting.expected_date, tbl_job_posting.posted_date, tbl_job_posting.`no.of_vacancies`,tbl_client_address.contact_person_name,tbl_client_address.contact_person_mobile,tbl_client_address.contact_person_email,tbl_client.client_name,tbl_client.description,tbl_level.`level`,tbl_address.location,tbl_address.pincode from tbl_job_posting,tbl_client_address,tbl_client,tbl_address,tbl_level where tbl_job_posting.client_address_id=tbl_client_address.client_address_id and tbl_client_address.address_id=tbl_address.address_id and tbl_client_address.client_id=tbl_client.client_id and tbl_client.level_id=tbl_level.level_id";

	/**
	 * @author Anju Karmakar GET_FEEDBACK_TYPE IS USED TO GET ALL FEEDBACK TYPE
	 */
	public static final String GET_FEEDBACK_TYPE = "select tbl_feedback_type.feedback_type_id,tbl_feedback_type.feedback_type from tbl_feedback_type";

	/**
	 * @author Anju Karmakar GET_CLIENT_NAME IS USED TO GET ALL FEEDBACK
	 */

	public static final String INSERT_FEEDBACK = "INSERT INTO  tbl_feedback (FEEDBACK_DESCRIPTION,FEEDBACK_DATE,FEEDBACK_TYPE_ID,CLIENT_ADDRESS_ID,USER_ID) VALUES(?,?,?,?,?)";

	public static final String GET_CLIENT_NAME = "select tbl_client.client_name,tbl_feedback.client_address_id from  tbl_client,tbl_feedback,tbl_client_address where tbl_feedback.client_address_id=tbl_client_address.client_address_id and tbl_client_address.client_address_id=tbl_client.client_id";

	public static final String Country_Get_Data = "select country_id,country from tbl_country";
	public static final String STATE_Get_Data = "select state_id,state from tbl_state where country_id=?";
	public static final String CITY_Get_Data = "select city_id,city from tbl_city where state_id=?";
	public static final String LEVEL_Get_Data = "select level_id,level from tbl_level";

	public static final String CLIENT_REGISTER_DETAILS = "insert into tbl_client(client_name,client_image,description,level_id,status_id) VALUES(?,?,?,?,?)";
	public static final String ADDRESS_REGISTER_DETAILS = "insert into tbl_address(location,pincode,city_id) values (?,?,?)";
	public static final String CLIENT_ADDRESS_REGISTER_DETAILS = "insert into tbl_client_address(contact_person_name,contact_person_mobile,contact_person_email,client_id,address_id) VALUES(?,?,?,?,?);";

	public static final String DELETE_CLIENT_DATA_QUERY = "update tbl_client set tbl_client.status_id=2 where tbl_client.client_id=?";
	public static final String SHOW_CLIENT_DETAILS = "select ct.client_id,ct.client_name,ct.description,l.level from tbl_client ct NATURAL JOIN tbl_level l  where ct.client_id=?";
	public static final String UPDATE_CLIENT = "update   tbl_client c NATURAL JOIN tbl_level l  set c.client_name=?,c.client_image=?,c.description=?,c.level_id=?  where c.client_id=?";
	public static final String SHOW_CLIENT_ADDRS_DETAILS = "select cd.client_address_id,cd.contact_person_name,cd.contact_person_mobile,cd.contact_person_email,ad.location,ad.pincode,c.city,s.state,co.country,cd.client_id from  tbl_client_address cd natural join tbl_address ad natural join tbl_city c natural join tbl_state s natural join tbl_country co   where  cd.client_address_id=?";
	public static final String UPDATE_CLIENT_ADDRS = "update tbl_client_address cd NATURAL JOIN tbl_address a NATURAL JOIN tbl_city city NATURAL JOIN  tbl_state s NATURAL JOIN  tbl_country cty  set  cd.contact_person_name=?,cd.contact_person_mobile=?,cd.contact_person_email=?,a.location=?,a.pincode=?,a.city_id=?,city.state_id=?,s.country_id=? where cd.client_address_id=?";
	public static final String DELETE_CLIENT_ADDRS_QUERY = "update tbl_client_address set tbl_client_address.status_id=2 where tbl_client_address.client_address_id=?";

	public static final String GET_LIST_CLINET_ADDRS = "select cd.client_id, cd.client_address_id,cd.contact_person_name,cd.contact_person_mobile,cd.contact_person_email,ad.location,ad.pincode,c.city,s.state,co.country from tbl_client ct natural join tbl_client_address cd natural join tbl_address ad natural join tbl_city c natural join tbl_state s natural join tbl_country co natural join tbl_level l where ct.status_id=1 and ct.client_id=?";
	public static final String RETRIEVE_CLIENT_DETAILS = "select ct.client_id,ct.client_name,ct.description,l.level from tbl_client ct NATURAL JOIN tbl_level l  where ct.status_id=1 order by ct.client_id";

	public static final String INSERT_TRAINEE_ADDRESS_QUERY = "INSERT INTO tbl_address (LOCATION,PINCODE,CITY_ID) VALUES(?,?,(SELECT CITY_ID FROM TBL_CITY WHERE CITY=?))";

	public static final String SQL_GET_PLACEMENT_INFO_OF_USER_FOR_FEEDBACK = "select tbl_client_address.client_address_id,tbl_client.client_name\r\n"
			+ "from tbl_client,tbl_client_address,tbl_placement\r\n"
			+ "where tbl_placement.client_address_id=tbl_client_address.client_address_id\r\n"
			+ "and tbl_client_address.client_id=tbl_client.client_id\r\n" + "and tbl_placement.user_id=?;";

	public static final String SQL_ADD_FEEDBACK_FOR_NACRE = "insert into tbl_feedback(feedback_description,feedback_date,feedback_type_id,user_id)\r\n"
			+ "values(?,?,?,?);";

	public static final String SQL_ADD_FEEDBACK_FOR_COMPANY = "insert into tbl_feedback(feedback_description,feedback_date,feedback_type_id,client_address_id,user_id)\r\n"
			+ "values(?,?,?,?,?);";

	public static final String BATCH_ADD = "insert into tbl_batch(tbl_batch.batch,tbl_batch.batch_start_date,tbl_batch.batch_end_date,tbl_batch.status_id)\r\n"
			+ "values (?,?,?,1)";

	public static String getbatchquery = "SELECT batch_id,batch FROM tbl_batch WHERE status_id=1";
	public static String gettechquery = "SELECT technology_id,technology FROM tbl_technology WHERE status_id=1";
	public static String viewtraineequery = "select  u.user_id ,u.first_name,u.email,et.edu_type,sp.specilization,s.stream,etd.percentage,etd.yop from tbl_user u , tbl_edu_type_details etd ,tbl_edu_type et,tbl_specilization sp,tbl_stream s,tbl_batch b,tbl_technology t, tbl_batch_technology bt,tbl_status st where u.user_id=etd.user_id and etd.edu_type_id=et.edu_type_id and etd.specilization_id=sp.specilization_id and sp.stream_id=s.stream_id and b.batch_id=bt.batch_id and t.technology_id=bt.technology_id and st.status_id=1 and st.status_id=u.status_id and bt.batch_technology_id=u.batch_technology_id and b.batch_id=(?) and t.technology_id=(?)";
	public static String companydetails = "select c.client_name,l.`level`,c.description, ad.location,cit.city,st.state,ad.pincode,cou.country,jp.job_posting_id,jp.expected_date,jp.description,jp.`no_of_vacancies`  from tbl_client c,tbl_level l,tbl_client_address cadd,tbl_address ad,tbl_state st,tbl_city cit,tbl_country cou,tbl_job_posting jp where cadd.client_id=c.client_id and jp.expected_date >CURDATE() and c.level_id=l.level_id and  cadd.address_id=ad.address_id and ad.city_id=cit.city_id and cit.state_id=st.state_id and st.country_id=cou.country_id and  jp.client_address_id=cadd.client_address_id and jp.job_posting_id=?";
	public static String interviewdetails = "select c.client_name ,ir.round_no,ir.interview_round_id,ir.description,ir.date from tbl_client c,tbl_interview_round ir,tbl_job_posting jp,tbl_status s,tbl_address a ,tbl_client_address caddr where ir.job_posting_id=jp.job_posting_id and caddr.address_id=a.address_id and jp.client_address_id=caddr.client_address_id and jp.expected_date >CURDATE() and caddr.client_id=c.client_id and s.status_id=3 and jp.job_posting_id=(?) ";
	public static String getintrestedtrainees = "select user_id,status_id from tbl_user where email=(?)";
	public static String inserteligibletraieens = "insert into tbl_eligible_student(status_id,user_id,interview_round_id,job_posting_id) values(?,?,?,?)";
	// public static String getselectedtrainees="select
	// es.user_id,ir.interview_round_id from tbl_eligible_student
	// es,tbl_interview_round ir,tbl_user u,tbl_status st ,tbl_job_posting jp
	// where
	// st.status_id=6 and ir.interview_round_id=es.interview_round_id and
	// u.user_id=es.user_id and st.status_id=es.status_id and
	// jp.job_posting_id=es.job_posting_id";
	public static String getselectedtrainees = "select tbl_user.user_id,tbl_interview_round.interview_round_id from tbl_user,tbl_interview_round,tbl_eligible_student,tbl_status where tbl_status.`status`='shortlisted'and tbl_eligible_student.user_id=tbl_user.user_id and tbl_eligible_student.interview_round_id=tbl_interview_round.interview_round_id and tbl_eligible_student.status_id=tbl_status.status_id";
	public static String shortlistedmail = "select email from tbl_user where user_id=(?)";
	public static String yop = "select yop from tbl_edu_type_details";
	public static String specialization = "select specilization from tbl_specilization";
	public static String stream = "select stream from tbl_stream";

	public static final String VIEW_HR_FEEDBACKS = "select  u.first_name,u.mobileno,u.email, f.feedback_description,f.feedback_date,ft.feedback_type,c.client_name ,ct.city,a.location\r\n"
			+ " from tbl_user u,tbl_feedback f,tbl_feedback_type ft,tbl_client_address cd,tbl_client c,tbl_address a,tbl_city ct\r\n"
			+ "where u.user_id=f.user_id and \r\n" + "f.client_address_id=cd.client_address_id and \r\n"
			+ "cd.client_id=c.client_id and\r\n" + " ft.feedback_type_id=f.feedback_type_id and \r\n"
			+ " cd.address_id=a.address_id and a.city_id=ct.city_id";

	public static final String SQL_GET_USER_MAIL = "select tbl_user.email from tbl_user where tbl_user.user_id=?;";
	public static final String SQL_GET_CLIENT_NAME = "select tbl_client.client_name\r\n"
			+ "from tbl_client,tbl_client_address,tbl_job_posting\r\n"
			+ "where tbl_job_posting.client_address_id=tbl_client_address.client_address_id\r\n"
			+ "and tbl_client_address.client_id=tbl_client.client_id\r\n" + "and tbl_job_posting.job_posting_id=?;";

	public static String User_Profile = "select tbl_user.first_name,tbl_user.last_name,tbl_user.email,tbl_user.mobileno,tbl_user.image,tbl_address.location,tbl_address.pincode,tbl_city.city,tbl_state.state,tbl_country.country from tbl_user natural join tbl_address natural join tbl_city natural join tbl_state natural join tbl_country where tbl_user.email=?";

}