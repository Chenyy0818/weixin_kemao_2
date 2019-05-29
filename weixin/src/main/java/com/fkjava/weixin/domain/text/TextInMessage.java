package com.fkjava.weixin.domain.text;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fkjava.weixin.domain.InMessage;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextInMessage extends InMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String toString() {
		return "TextInMessage [Content=" + Content + ", getToUserNmae()=" + getToUserNmae() + ", getFromUserName()="
				+ getFromUserName() + ", getCreateTime()=" + getCreateTime() + ", getMsqType()=" + getMsqType()
				+ ", getMsgId()=" + getMsgId() + "]";
	}


	@XmlElement(name="Content")
	@JsonProperty("Content")
	private String Content;


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}
	

}
