package com.kingland.eip;

import com.kingland.eip.domain.RecordModel;
import com.kingland.eip.mapper.RecordMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SimpleApplication.class)
public class DatabaseConnectionTest {

    @Autowired
    RecordMapper recordMapper;

    @Test
    public void shouldBeRecordByRanks(){
        RecordModel recordByRanks = recordMapper.findRecordByRanks(1);
        System.out.println(recordByRanks.toString());
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        List<RecordModel> allRecords = recordMapper.findAllRecords();
        System.out.println(allRecords.toString());
    }

}
