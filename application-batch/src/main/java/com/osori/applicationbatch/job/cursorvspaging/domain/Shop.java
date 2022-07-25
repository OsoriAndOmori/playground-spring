package com.osori.applicationbatch.job.cursorvspaging.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Shop {
    private int article;
    private String dealer;
    private long price;
}
