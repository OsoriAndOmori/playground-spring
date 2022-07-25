package com.osori.applicationbatch.job.cursorvspaging.constants;

import com.osori.applicationbatch.job.cursorvspaging.domain.Shop;
import org.springframework.jdbc.core.RowMapper;

public class ShopRowMapper {
    public static final RowMapper<Shop> shopRowMapper = (rs, rowNum) ->
            Shop.builder()
                    .article(rs.getInt(1))
                    .dealer(rs.getString(2))
                    .price(rs.getLong(3))
                    .build();
}
