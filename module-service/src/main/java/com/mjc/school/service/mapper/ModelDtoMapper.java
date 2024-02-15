package com.mjc.school.service.mapper;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.model.CommentModel;
import com.mjc.school.model.NewsModel;
import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import com.mjc.school.service.dto.comment.CommentDtoRequest;
import com.mjc.school.service.dto.comment.CommentDtoResponse;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import org.springframework.stereotype.Component;

import java.util.List;


public class ModelDtoMapper {

    private ModelDtoMapper() {
    }

    @Component
    public static class MapAuthorDtoRequestToAuthorModel implements AuthorDtoRequestMapperToAuthorModel {

        @Override
        public AuthorModel map(AuthorDtoRequest request) {
            AuthorModel authorModel = new AuthorModel();
            authorModel.setId(request.getId());
            authorModel.setName(request.getName());
            return authorModel;
        }
    }

    @Component
    public static class MapAuthorModelToAuthorDtoResponse implements AuthorModelMapperToAuthorDtoResponse {

        @Override
        public AuthorDtoResponse map(AuthorModel authorModel) {
            AuthorDtoResponse authorDtoResponse = new AuthorDtoResponse();
            authorDtoResponse.setId(authorModel.getId());
            authorDtoResponse.setName(authorModel.getName());
            authorDtoResponse.setCreateDate(authorModel.getCreateDate());
            authorDtoResponse.setLastUpdateTime((authorModel.getLastUpdateTime()));
            return authorDtoResponse;
        }
    }

    @Component
    public static class MapNewsDtoRequestToNewsModel implements NewsDtoRequestMapperToNewsModel {

        @Override
        public NewsModel map(NewsDtoRequest request) {
            NewsModel newsModel = new NewsModel();
            newsModel.setTitle(request.getTitle());
            newsModel.setContent(request.getContent());
            newsModel.setAuthorId(request.getAuthorId());
            return newsModel;
        }

        @Override
        public NewsModel mapUpdate(NewsDtoRequest request) {
            NewsModel newsModel = new NewsModel();
            newsModel.setId(request.getId());
            newsModel.setTitle(request.getTitle());
            newsModel.setContent(request.getContent());
            newsModel.setAuthorId(request.getAuthorId());
            return newsModel;
        }
    }

    @Component
    public static class MapNewsModelToDtoResponse implements NewsModelMapperToDtoResponse {

        @Override
        public NewsDtoResponse map(NewsModel model) {
            NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
            newsDtoResponse.setId(model.getId());
            newsDtoResponse.setContent(model.getContent());
            newsDtoResponse.setTitle(model.getTitle());
            newsDtoResponse.setAuthorId(model.getAuthorId());
            return newsDtoResponse;
        }
    }

    @Component
    public static class MapCommentModelToDtoResponse implements CommentModelMapperToCommentDtoResponse {

        @Override
        public CommentDtoResponse map(CommentModel model) {
            CommentDtoResponse commentDtoResponse = new CommentDtoResponse();
            commentDtoResponse.setId(model.getId());
            commentDtoResponse.setContent(model.getContent());
            commentDtoResponse.setCreated(model.getCreated());
            commentDtoResponse.setModified(model.getModified());
            return commentDtoResponse;
        }

    }

    @Component
    public static class MapCommentDtoRequestToCommentModel implements CommentDtoRequestMapperToCommentModel {

        @Override
        public CommentModel map(CommentDtoRequest commentDtoRequest) {
            return null;
        }

        @Override
        public CommentModel mapUpdate(CommentDtoRequest commentDtoRequest) {
            CommentModel commentModel = new CommentModel();
            commentModel.setId(commentModel.getId());
            commentModel.setContent(commentModel.getContent());
            commentModel.setCreated(commentDtoRequest.getCreated());
            commentModel.setModified(commentDtoRequest.getModified());
            return null;
        }
    }

    @Component
    public static class TagMapper implements com.mjc.school.service.mapper.TagMapper{

        @Override
        public TagDtoResponse tagModelToDto(TagModel tagModel) {
            TagDtoResponse tagDtoResponse=new TagDtoResponse();
            tagDtoResponse.setId(tagDtoResponse.getId());
            tagDtoResponse.setName(tagModel.getName());
            return tagDtoResponse;
        }

        @Override
        public TagModel tagDtoToModel(TagDtoRequest tagDtoRequest) {
            TagModel tagModel=new TagModel();
            tagModel.setId(tagModel.getId());
            tagModel.setName(tagModel.getName());
            return tagModel;
        }
    }
}
