/*
 * Copyright (C) 2017 Q2 Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.corepro.sdk.models;

import java.math.BigInteger;
import io.corepro.sdk.utils.Base64;

public class FileContent {
	private String content;
	private String contentType;
	private BigInteger contentLength;
	
	public byte[] getRawContent(){
		return Base64.decode(this.content);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public BigInteger getContentLength() {
		return contentLength;
	}
	public void setContentLength(BigInteger contentLength) {
		this.contentLength = contentLength;
	}
}
