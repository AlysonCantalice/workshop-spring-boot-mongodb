package com.alysonca.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alysonca.workshopmongo.domain.Post;
import com.alysonca.workshopmongo.domain.User;
import com.alysonca.workshopmongo.dto.AuthorDTO;
import com.alysonca.workshopmongo.dto.CommentDTO;
import com.alysonca.workshopmongo.repository.PostRepository;
import com.alysonca.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, Instant.parse("2018-03-21T19:53:07Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.parse("2018-03-23T10:21:05Z"), "Bom dia", "Acordei feliz hoje!",
				new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", Instant.parse("2018-03-21T20:11:54Z"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", Instant.parse("2018-03-21T22:02:18Z"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2018-03-18T10:25:33Z"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}
}