package com.dbwls.mapping.section03.compostiekey.subsection01.embeddedID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeCompositeKey implements Serializable { // 반드시 Serializable 붙여야 함

    @Column(name = "liked_member_no")
    private int likedMemberNo;

    @Column(name = "liked_book_no")
    private int likedBookNo;

    protected LikeCompositeKey() {}

    public LikeCompositeKey(int likedMemberNo, int likedBookNo) {
        this.likedMemberNo = likedMemberNo;
        this.likedBookNo = likedBookNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LikeCompositeKey that = (LikeCompositeKey) o;
        return likedMemberNo == that.likedMemberNo && likedBookNo == that.likedBookNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likedMemberNo, likedBookNo);
    }

    @Override
    public String toString() {
        return "LikeCompositeKey{" +
                "likedMemberNo=" + likedMemberNo +
                ", likedBookNo=" + likedBookNo +
                '}';
    }
}
