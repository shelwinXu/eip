package com.kingland.eip;

import com.kingland.eip.domain.RecordModel;
import com.kingland.eip.mapper.RecordMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SimpleApplication.class)
public class DatabaseConnectionTest {

    @Autowired
    RecordMapper recordMapper;

    @Test
    public void shouldBeConnectDatabase(){
        RecordModel recordByRanks = recordMapper.findRecordByRanks(1);
        assertNotNull(recordByRanks);
        List<RecordModel> allRecords = recordMapper.findAllRecords();
        assertNotNull(allRecords);
        assertNotEquals(0,allRecords.size());
    }

}
