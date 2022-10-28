package com.einsurance.insurence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.model.Documents;
import com.einsurance.insurence.repo.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	@Override
	public Documents addDocumentByuserId(long userId, Documents document) {
		document.setCustomerId(userId);
		Documents newDocument = documentRepository.save(document);
		return newDocument;
	}

}
