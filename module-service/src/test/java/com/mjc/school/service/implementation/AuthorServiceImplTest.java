package com.mjc.school.service.implementation;



import com.mjc.school.model.AuthorModel;
import com.mjc.school.repository.AuthorRepository;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import com.mjc.school.service.impl.AuthorServiceImpl;
import com.mjc.school.service.mapper.AuthorDtoRequestMapperToAuthorModel;
import com.mjc.school.service.mapper.AuthorModelMapperToAuthorDtoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {
		@InjectMocks
		private AuthorServiceImpl authorService;
		@Mock
		private AuthorRepository authorRepository;
		@Mock
		private AuthorModelMapperToAuthorDtoResponse authorMapperResponse;
		@Mock
		private AuthorDtoRequestMapperToAuthorModel authorMapperAuthorModel;



		@Test
		void shouldReadAllAuthors() {
				List<AuthorModel> authorModelList = List.of(new AuthorModel(), new AuthorModel());

				when(authorMapperResponse.map(any(AuthorModel.class))).thenReturn(new AuthorDtoResponse());
				when(authorRepository.findAll()).thenReturn(authorModelList);
				int lengthExpected = 2;
				assertEquals(lengthExpected, authorService.readAll().size());
		}

		@Test
		void shouldReturnEntityWithGivenId() {
				AuthorDtoResponse expected = new AuthorDtoResponse(1L, "test", LocalDateTime.now(), LocalDateTime.now());
				when(authorRepository.findById(anyLong())).thenReturn(Optional.of(new AuthorModel()));
				when (authorMapperResponse.map(any(AuthorModel.class))).thenReturn(expected);
				assertEquals(expected, authorService.readById(1L));
		}

		@Test
		void shouldReturnAddedObjectIfValuesAreCorrect() {
				AuthorDtoRequest authorModelToCreate = new AuthorDtoRequest(1L, "test");
				when(authorMapperAuthorModel.map(any(AuthorDtoRequest.class))).thenReturn(new AuthorModel());
				lenient().when(authorRepository.save(any(AuthorModel.class))).thenReturn(new AuthorModel());
				AuthorDtoResponse savedAuthorDto = new AuthorDtoResponse(1L, "test", LocalDateTime.now(), LocalDateTime.now());
				lenient().when(authorMapperResponse.map(any(AuthorModel.class))).thenReturn(savedAuthorDto);
				assertEquals(savedAuthorDto, authorService.create(authorModelToCreate));
		}

		@Test
		void shouldUpdateNewsWithGivenIdWhenValuesOfTitleAndContentAreCorrect() {
				AuthorDtoRequest authorModelToUpdate = new AuthorDtoRequest(1L, "test");
				AuthorDtoResponse updatedAuthorDto = new AuthorDtoResponse(1L, "test", LocalDateTime.now(), LocalDateTime.now());
				when(authorRepository.findById(anyLong())).thenReturn(Optional.of(new AuthorModel()));
				lenient().when(authorMapperAuthorModel.map(any(AuthorDtoRequest.class))).thenReturn(new AuthorModel());
				when(authorRepository.save(any(AuthorModel.class))).thenReturn(new AuthorModel());
				lenient().when(authorMapperResponse.map(any(AuthorModel.class))).thenReturn(updatedAuthorDto);
				assertEquals(updatedAuthorDto, authorService.update(authorModelToUpdate));
		}
}