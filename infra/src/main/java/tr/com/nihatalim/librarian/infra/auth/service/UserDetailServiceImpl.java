package tr.com.nihatalim.librarian.infra.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.infra.auth.persistence.entity.LibraryUserEntity;
import tr.com.nihatalim.librarian.infra.auth.persistence.repository.LibraryUserRepository;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final LibraryUserRepository libraryUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final LibraryUserEntity userEntity = libraryUserRepository.getLibraryUserEntityByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
}
