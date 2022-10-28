package com.einsurance.insurence.service;

import com.einsurance.insurence.model.Documents;

public interface DocumentService {

	Documents addDocumentByuserId(long userId, Documents document);

	
}
