package com.chandradip.service;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.AddressResponse;

public interface AddressService {
    AddressResponse addAddress(Integer employeeId, AddressRequest request);

}
