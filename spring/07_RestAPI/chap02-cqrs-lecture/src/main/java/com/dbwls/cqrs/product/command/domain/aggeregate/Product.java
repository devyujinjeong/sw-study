package com.dbwls.cqrs.product.command.domain.aggeregate;

import com.dbwls.cqrs.product.query.dto.response.CategoryDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE tbl_product SET status = 'DELETED' WHERE product_code = ?")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    private String productName;
    private Long productPrice;
    private String productDescription;
    private Long categoryCode;
    private String productImageUrl;
    private Long productStock;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Enumerated(value = EnumType.STRING)
    private ProductStatus status = ProductStatus.USABLE;

    // 이미지 변경 시 사용 될 메소드
    public void changeProductImageUrl(String replaceFileName){
        this.productImageUrl = replaceFileName;
    }

    public void updateProductDetails(
            String productName,
            Long productPrice,
            String productDescription,
            Long categoryCode,
            Long productStock,
            ProductStatus status
    ){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.categoryCode = categoryCode;
        this.productStock = productStock;
        this.status = status;
    }

}
