package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class RadiologyRecord implements Table {

	Integer recordId = null;
	Integer patientId = null;
	Integer doctorId = null;
	Integer radiologistId = null;
	String testType = null;
	Date prescribingDate = null;
	Date testDate = null;
	String diagnosis = null;
	String description = null;
	Boolean isValid = null;
	
	public RadiologyRecord (Integer recordId, HttpServletRequest request) {
		try {
			this.recordId = recordId;
			this.patientId = Integer.parseInt(request.getParameter("r_patient_id"));
			this.doctorId = Integer.parseInt(request.getParameter("r_doctor_id"));
			this.radiologistId = Integer.parseInt(request.getParameter("r_radiologist_id"));
			this.testType = request.getParameter("r_test_type");
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			this.prescribingDate = format.parse(request.getParameter("r_prescribing_date"));
			this.testDate = format.parse(request.getParameter("r_test_date"));
			
			this.diagnosis = request.getParameter("r_diagnosis");
			this.description = request.getParameter("r_description");
		} catch (Exception e) {
			e.printStackTrace();
			isValid = false;
		}
		
	}
	
	public RadiologyRecord(ResultSet rs) throws SQLException {
		this.recordId = rs.getInt("RECORD_ID");
		this.patientId = rs.getInt("PATIENT_ID");
		this.doctorId = rs.getInt("DOCTOR_ID");
		this.radiologistId = rs.getInt("RADIOLOGIST_ID");
		this.testType = rs.getString("TEST_TYPE");
		this.prescribingDate = rs.getDate("PRESCRIBING_DATE");
		this.testDate = rs.getDate("TEST_DATE");
		this.diagnosis = rs.getString("DIAGNOSIS");
		this.description = rs.getString("DESCRIPTION");
	}

	@Override
	public boolean isValid() {
		if (this.recordId != null
				&& this.patientId != null
				&& this.doctorId != null
				&& this.radiologistId != null
				&& this.testType != null
				&& this.prescribingDate != null
				&& this.testDate != null
				&& this.diagnosis != null
				&& this.description != null) {
			return true;
		}
		
		return isValid;
	}

	@Override
	public String generateInsertSql() {
		return "INSERT INTO radiology_record VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	public String generateUpdateSql() {
		return "UPDATE radiology_record"
				+ " SET patient_id = ?,"
					+ " doctor_id = ?,"
					+ " radiologist_id = ?,"
					+ " test_type = ?,"
					+ " prescribing_date = ?,"
					+ " test_date = ?,"
					+ " diagnosis = ?,"
					+ " description = ?"
				+ "WHERE record_id = ?";
	}

	public Integer getRecordId() {
		return recordId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public Integer getRadiologistId() {
		return radiologistId;
	}

	public String getTestType() {
		return testType;
	}

	public Date getPrescribingDate() {
		return prescribingDate;
	}

	public Date getTestDate() {
		return testDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsValid() {
		return isValid;
	}

}
