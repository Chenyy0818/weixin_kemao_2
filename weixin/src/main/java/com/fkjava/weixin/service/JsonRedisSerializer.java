package com.fkjava.weixin.service;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.hibernate.type.SerializationException;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fkjava.weixin.domain.InMessage;

public class JsonRedisSerializer<T> extends Jackson2JsonRedisSerializer<T> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	public JsonRedisSerializer() {
		super((Class<T>) InMessage.class);
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		DataInputStream in = new DataInputStream(bis);
		try {
			int len = in.readInt();
			byte[] classNameBytes = new byte[len];
			in.readFully(classNameBytes);
			String className = new String(classNameBytes, "UTF-8");


			@SuppressWarnings("unchecked")
			Class<T> cla = (Class<T>) Class.forName(className);

			T o = objectMapper.readValue(Arrays.copyOfRange(bytes, len + 4, bytes.length), cla);
			return o;

		} catch (IOException | ClassNotFoundException e) {
			throw new SerializationException(e.getLocalizedMessage(), e);
		}
	}

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bos);
		try {
			String className = t.getClass().getName();
			byte[] classNameBytes = className.getBytes();

			out.writeInt(classNameBytes.length);
			out.write(classNameBytes);

			out.write(super.serialize(t));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}
}
