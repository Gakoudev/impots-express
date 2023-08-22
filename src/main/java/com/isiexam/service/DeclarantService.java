package com.isiexam.service;

import com.isiexam.dao.IDeclarantRepository;
import com.isiexam.dto.Declarant;
import com.isiexam.entities.DeclarantEntity;
import com.isiexam.exception.EntityNotFoundException;
import com.isiexam.exception.RequestException;
import com.isiexam.mapping.DeclarantMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeclarantService {

    private IDeclarantRepository iDeclarantRepository;

   private DeclarantMapper declarantMapper;
    MessageSource messageSource;

    public DeclarantService(IDeclarantRepository iDeclarantRepository, DeclarantMapper declarantMapper,MessageSource messageSource) {
        this.iDeclarantRepository = iDeclarantRepository;
        this.declarantMapper = declarantMapper;
        this.messageSource = messageSource;
    }



    @Transactional
    public Declarant createDeclarant(Declarant declarant) {
        return declarantMapper.toDeclarant(iDeclarantRepository.save(declarantMapper.fromDeclarant(declarant)));
    }
    @Transactional(readOnly = true)
    public List<Declarant> getDeclarants() {
        return StreamSupport.stream(iDeclarantRepository.findAll().spliterator(), false)
                .map(declarantMapper::toDeclarant)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Declarant getDeclarant(Long id) {
        return declarantMapper.toDeclarant(iDeclarantRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("declarant.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional
    public Declarant updateDeclarant(Long id, Declarant declarant) {
        return iDeclarantRepository.findById(id)
                .map(entity -> {
                    declarant.setId(id);
                    return declarantMapper.toDeclarant(
                            iDeclarantRepository.save(declarantMapper.fromDeclarant(declarant)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("declarant.notfound", new Object[]{id},
                        Locale.getDefault())));
    }
    @Transactional
    public void deleteDeclarant(Long id) {
        try {
            iDeclarantRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("declarant.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
