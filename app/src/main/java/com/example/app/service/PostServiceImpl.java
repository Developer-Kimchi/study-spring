package com.example.app.service;

import com.example.app.dao.FileDAO;
import com.example.app.dao.PostDAO;
import com.example.app.dao.ReplyDAO;
import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.PostDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.type.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final ReplyDAO replyDAO;
    private final FileDAO fileDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PostDTO> getList(Pagination pagination, Search search) {
//        게시글 전체 목록
        final List<PostDTO> posts = postDAO.findAll(pagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        posts.forEach(post -> post.setFiles(fileDAO.findAll(post.getId())));
        return posts;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(PostDTO postDTO) {
        postDAO.save(postDTO);
        for(int i=0; i<postDTO.getFiles().size(); i++){
            postDTO.getFiles().get(i).setPostId(postDTO.getId());
            if(postDTO.getFiles().get(i).getFileType() == null){
                postDTO.getFiles().get(i).setFileType(FileType.NON_REPRESENTATIVE.name());
            }
            fileDAO.save(postDTO.getFiles().get(i));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<PostDTO> read(Long id) {
        final Optional<PostDTO> foundPost = postDAO.findById(id);
        if(foundPost.isPresent()){
            foundPost.get().setFiles(fileDAO.findAll(foundPost.get().getId()));
        }
        postDAO.updateReadCount(id);
        return foundPost;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PostDTO postDTO) {
        postDAO.setPostDTO(postDTO);
//        추가
        postDTO.getFiles().forEach(file -> {
            if(file.getFileType() == null) {
                file.setFileType(FileType.NON_REPRESENTATIVE.name());
            }
            file.setPostId(postDTO.getId());
            fileDAO.save(file);
        });
//        삭제
        postDTO.getFileIdsForDelete().forEach(fileDAO::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        replyDAO.deleteAll(id);
        fileDAO.deleteAll(id);
        postDAO.delete(id);
    }

    @Override
    public int getTotal(Search search) {
        return postDAO.findCountOfPost(search);
    }
}

















