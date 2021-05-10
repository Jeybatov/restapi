package edu.ada.micronaunt.service

import edu.ada.micronaunt.dto.User
import grails.gorm.services.Service

@Service(User)
interface UserGormService {

    User save(String email, String username, String password)

    User findByUsername(String username)

    User findById(Serializable id)

    void delete(Serializable id)

    int count()
}
