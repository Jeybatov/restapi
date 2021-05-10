package edu.ada.micronaunt.service

import edu.ada.micronaunt.dto.User
import edu.ada.micronaunt.encoders.PasswordEncoder
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

import javax.inject.Singleton
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@CompileStatic
@Singleton
class RegisterService {

    protected final UserGormService userGormService
    protected final PasswordEncoder passwordEncoder

    RegisterService(UserGormService userGormService,
                    PasswordEncoder passwordEncoder) {
        this.userGormService = userGormService
        this.passwordEncoder = passwordEncoder
    }

    @Transactional
    void register(@Email String email, @NotBlank String username, @NotBlank String rawPassword) {

        User user = userGormService.findByUsername(username)
        if ( !user ) {
            final String encodedPassword = passwordEncoder.encode(rawPassword)
            user = userGormService.save(email, username, encodedPassword)
        }
    }
}
