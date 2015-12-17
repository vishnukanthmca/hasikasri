package com.aha.core.util;

public class Enum {

	public enum OrderStatus {
		OPEN(0), DELIVERED(1), CANCELLED(2), RETURN_ORDER_REQUEST_PLACED(3), RETURN_ORDER_REQUEST_APPROVED(
				4);

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

}
