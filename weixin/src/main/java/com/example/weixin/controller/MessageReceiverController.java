package com.example.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fkjava.weixin.domain.InMessage;
import com.fkjava.weixin.domain.text.TextInMessage;
import com.fkjava.weixin.service.MessageConvertHelper;

@RestController
@RequestMapping("/kemao_2/message/receiver")
public class MessageReceiverController {

	private static final Logger LOG = LoggerFactory.getLogger(MessageReceiverController.class);

	@GetMapping
	public String echo(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr

	) {
		return echostr;

	}

	@PostMapping
	public String onMessage(@RequestBody String xml) {

		LOG.trace("收到的消息原文:\n{}\n------------------*,xml");

		InMessage inMessage = MessageConvertHelper.convert(xml);

		LOG.debug("转换后的消息对象\n{}\n", inMessage);

		return "success";
	}

}
