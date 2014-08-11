package io.corepro.sdk.models;

import java.util.UUID;

public class ModelBase {
	private UUID requestId;

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}
}
