package edu.ada.micronaunt.service

import edu.ada.micronaunt.dto.UserState
import edu.ada.micronaunt.fetchers.UserFetcher
import edu.umd.cs.findbugs.annotations.NonNull
import groovy.transform.CompileStatic

import javax.inject.Singleton
import javax.validation.constraints.NotBlank

@CompileStatic
@Singleton
class UserFetcherService implements UserFetcher {

    protected final UserGormService userGormService

    UserFetcherService(UserGormService userGormService) {
        this.userGormService = userGormService
    }

    @Override
    UserState findByUsername(@NotBlank @NonNull String username) {
        userGormService.findByUsername(username) as UserState
    }
}
