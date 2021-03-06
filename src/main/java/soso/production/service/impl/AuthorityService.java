package soso.production.service.impl;

import soso.production.model.Authority;
import soso.production.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soso.production.service.interfaces.IAuthorityService;
;

@Transactional
@Service("authorityService")
public class AuthorityService implements IAuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getByAuthority(String authority) {
        return authorityRepository.getByAuthority(authority);
    }

    @Override
    public Authority getById(Long id) {
        return authorityRepository.getOne(id);
    }
}
