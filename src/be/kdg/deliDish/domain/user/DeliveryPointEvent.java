package be.kdg.deliDish.domain.user;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DeliveryPointEvent implements Serializable {
	private final LocalDateTime eventTime;
	private final DeliveryPointEventType eventType;

	public DeliveryPointEvent(DeliveryPointEventType eventType) {
		this.eventType = eventType;
		eventTime = LocalDateTime.now();
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public int getPoints() {
		return eventType.getPoints();
	}

	public enum DeliveryPointEventType {
		ORDER_ACCEPTED(5),
		ORDER_PICKUP_ONTIME(5),
		ORDER_PICKUP_LATE(-5),
		ORDER_DELIVERY_ONTIME(5),
		ORDER_DELIVERY_LATE(-5),
		START_EVENT(501);
		private int points;

		private DeliveryPointEventType(int points) {
			this.points = points;
		}

		public int getPoints() {
			return points;
		}
	}

}
