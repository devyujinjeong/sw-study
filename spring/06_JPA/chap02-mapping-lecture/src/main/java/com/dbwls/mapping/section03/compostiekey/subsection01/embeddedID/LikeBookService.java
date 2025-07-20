package com.dbwls.mapping.section03.compostiekey.subsection01.embeddedID;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class LikeBookService {

    private LikeRepository likeRepository;

    public LikeBookService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void generateLikeBook(LikeDTO likeDTO) {

        Like like = new Like(
                new LikeCompositeKey(
                        likeDTO.getLikedMemberNo(),
                        likeDTO.getLikedBookNo()
                )
        );

        likeRepository.save(like);
    }
}

