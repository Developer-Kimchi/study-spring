package com.example.threetier.domain.service;

import com.example.threetier.domain.dao.PostDAO;
import com.example.threetier.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("freePost") @Primary
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public List<PostVO> getList() {
        return postDAO.findAll();
    }

    @Override
    public Optional<PostVO> getPost(Long id) {
        return postDAO.findById(id);
    }

    @Override
    public void modify(PostVO postVO) {
        postDAO.setPostVO(postVO);
    }

    @Override
    public void remove(Long id) {
        postDAO.delete(id);
    }
}
