package com.dbwls.jpql.section03.projection;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="tbl_menu")
public class EmbeddedMenu {
    @Id
    private int menuCode;
    @Embedded
    private MenuInfo menuInfo;
    private int categoryCode;
    private String orderableStatus;
}
