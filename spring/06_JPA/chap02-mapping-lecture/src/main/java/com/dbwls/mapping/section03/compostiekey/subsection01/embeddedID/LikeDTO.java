package com.dbwls.mapping.section03.compostiekey.subsection01.embeddedID;

public class LikeDTO {

    private int likedMemberNo;
    private int likedBookNo;

    public LikeDTO(int likedMemberNo, int likedBookNo) {
        this.likedMemberNo = likedMemberNo;
        this.likedBookNo = likedBookNo;
    }

    public int getLikedMemberNo() {
        return likedMemberNo;
    }

    public int getLikedBookNo() {
        return likedBookNo;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likedMemberNo=" + likedMemberNo +
                ", likedBookNo=" + likedBookNo +
                '}';
    }
}

