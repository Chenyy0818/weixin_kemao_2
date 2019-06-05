package com.fkjava.weixin.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class InMessage implements Serializable {

	public String getToUserNmae() {
		return toUserNmae;
	}

	public void setToUserNmae(String toUserNmae) {
		this.toUserNmae = toUserNmae;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setmsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
	abstract public String toString();
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ToUserName")
	@JsonProperty("ToUserName")
	private String toUserNmae;
	
	@XmlElement(name="FromUserName")
	@JsonProperty("FromUserName")
	private String fromUserName;
	
	@XmlElement(name="CreateTime")
	@JsonProperty("CreateTime")
	private long createTime;
	
	@XmlElement(name="MsgType")
	@JsonProperty("MsgType")
	private String msgType;
	
	@XmlElement(name="MsgId")
	@JsonProperty("MsgId")
	private Long msgId;
	}

