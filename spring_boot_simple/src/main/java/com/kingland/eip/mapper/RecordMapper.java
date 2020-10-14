package com.kingland.eip.mapper;

import com.kingland.eip.domain.RecordModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecordMapper {

    RecordModel findRecordByRanks(int ranks);

    List<RecordModel> findAllRecords();


}
