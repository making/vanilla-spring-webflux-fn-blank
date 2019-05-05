package xxxxxx.yyyyyy.zzzzzz;

import java.io.Serializable;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.Validator;

public class Message implements Serializable {
	public static Validator<Message> validator = ValidatorBuilder.of(Message.class)
			.constraint(Message::getText, "text", c -> c.notBlank().lessThanOrEqual(8))
			.build();

	private String text;

	public Message(String text) {
		this.text = text;
	}

	Message() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return this.text;
	}
}
