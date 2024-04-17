package com.social_music.service.impl;

import com.social_music.RoleType;
import com.social_music.model.AppRole;
import com.social_music.model.AppUser;
import com.social_music.model.UserPrinciple;
import com.social_music.repository.AppRoleRepository;
import com.social_music.repository.AppUserRepository;
import com.social_music.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserServiceImpl implements UserDetailsService, GeneralService<AppUser> {

    @Autowired
    AppUserRepository appUserRepo;
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AppUser findByUsername(String name) {
        return appUserRepo.findByUsername(name);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserPrinciple.build(appUserRepo.findByUsername(username));
    }

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setPassword(passwordEncoder.encode(user.getPassword()));
        appUser.setConfirmPassword(user.getConfirmPassword());
        appUser.setPhoneNumber(user.getPhoneNumber());
        List<Long> rolesIDs = Arrays.asList(appRoleRepository.findOneByName(RoleType.ROLE_USER.getName()).getId());
        Set<AppRole> roles = appRoleRepository.findAllByIdIn(rolesIDs);
        appUser.setRoles(roles);
        appUserRepo.save(appUser);
        return appUserRepo.save(appUser);
    }

    @Override
    public void remove(Long id) {

    }
}

