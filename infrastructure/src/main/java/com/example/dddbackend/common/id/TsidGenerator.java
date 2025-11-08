package com.example.dddbackend.common.id;

import com.example.domain.member.spi.IdGenerator;
import io.hypersistence.tsid.TSID;
import org.springframework.stereotype.Component;

@Component
public class TsidGenerator implements IdGenerator {

    @Override
    public long generateId() {
        return TSID.Factory.getTsid().toLong();
    }
}
