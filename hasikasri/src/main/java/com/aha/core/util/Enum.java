package com.aha.core.util;

public class Enum {

	public enum Country {
		INDIA(1);

		int c;

		Country(int c) {
			this.c = c;
		}

		public static String getString(int s) {
			for (Country i : Country.values()) {
				if (i.getValue() == s) {
					return i.name();
				}
			}

			return null;
		}

		public int getValue() {
			return c;
		}
	}

	public enum OrderStatus {
		OPEN(0), DELIVERED(1), CANCELLED(2), RETURN_ORDER_REQUEST_PLACED(3), RETURN_ORDER_REQUEST_APPROVED(4);

		private int s;

		OrderStatus(int s) {
			this.s = s;
		}

		public int getValue() {
			return s;
		}

		public static String getString(int s) {
			for (OrderStatus i : OrderStatus.values()) {
				if (i.getValue() == s) {
					return i.name();
				}
			}

			return null;
		}
	}

	public enum SignupType {
		CHECKOUT(0), MANUAL(1);

		private int s;

		SignupType(int s) {
			this.s = s;
		}

		public int getValue() {
			return s;
		}
	}
}
