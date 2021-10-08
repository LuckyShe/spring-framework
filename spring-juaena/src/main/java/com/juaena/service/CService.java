package com.juaena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CService {
	@Autowired
	private AService aService;
}
