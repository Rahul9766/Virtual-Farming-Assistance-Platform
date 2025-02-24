package com.developer.virtualFarming.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface PestService {
    String identifyPest(MultipartFile image) throws IOException;
}
