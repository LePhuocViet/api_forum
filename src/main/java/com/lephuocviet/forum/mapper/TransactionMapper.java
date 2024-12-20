package com.lephuocviet.forum.mapper;

import com.lephuocviet.forum.dto.responses.TransactionResponse;
import com.lephuocviet.forum.enity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionResponse toTransactionResponse(Transaction transaction);
}
