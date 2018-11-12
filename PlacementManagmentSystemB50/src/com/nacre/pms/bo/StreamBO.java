package com.nacre.pms.bo;

import java.io.Serializable;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class StreamBO implements Serializable {
	private Integer streamId;
	private String stream;
	private EducationTypeBO edu_type_id;
	@Override
	public String toString() {
		return "StreamBO [streamId=" + streamId + ", stream=" + stream + ", edu_type_id=" + edu_type_id + "]";
	}

	/**
	 * @return the streamId
	 */
	public Integer getStreamId() {
		return streamId;
	}
	/**
	 * @param streamId the streamId to set
	 */
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}

	public EducationTypeBO getEdu_type_id() {
		return edu_type_id;
	}

	public void setEdu_type_id(EducationTypeBO edu_type_id) {
		this.edu_type_id = edu_type_id;
	}
	
	

}
