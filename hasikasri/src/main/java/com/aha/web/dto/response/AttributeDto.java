package com.aha.web.dto.response;

import java.util.List;

public class AttributeDto {

	private Long id;

	private String value;

	private String refinerName;

	private List<Long> attributeIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Long> getAttributeIds() {
		return attributeIds;
	}

	public void setAttributeIds(List<Long> attributeIds) {
		this.attributeIds = attributeIds;
	}

	public String getRefinerName() {
		return refinerName;
	}

	public void setRefinerName(String refinerName) {
		this.refinerName = refinerName;
	}

	@Override
	public String toString() {

		String s = "";

		if (attributeIds != null) {
			for (Long l : attributeIds) {
				s = s + l + ",";
			}
		}

		return "AttributeDto [id=" + id + ", value=" + value + "]" + s;
	}

	// DO NOT CHANGE THIS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((refinerName == null) ? 0 : refinerName.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeDto other = (AttributeDto) obj;
		if (refinerName == null) {
			if (other.refinerName != null)
				return false;
		} else if (!refinerName.equals(other.refinerName))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
